package org.lynn.soop.business.common;

import com.google.gson.Gson;
import org.lynn.soop.business.common.dto.ExchangeRateDto;
import org.lynn.soop.business.order.OrderBuisness;
import com.sun.jersey.api.client.Client;
import org.lynn.soop.business.product.ProductTrxBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.SysParameter;
import org.lynn.soop.entity.SysParameterExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.SysParameterReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.SysParameterWriteMapper;
import org.lynn.soop.util.Contants;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lynn.soop.util.DataHelper.startOfToday;

@Component
public class SysConfigBusiness {

    @Autowired
    SysParameterReadMapper sysParameterReadMapper;

    @Autowired
    SysParameterWriteMapper sysParameterWriteMapper;


    @Autowired
    ProductTrxBusiness productTrxBusiness;


    public static final String SYS_EXCHANGE_RATE = "sys.exchange.rate";//汇率键值
    public static final String SYS_PROFIT_RATE = "sys.profit.rate";//毛利率
    
    public static final String AHS_MERCHANTS_DELIVERY = "ahs.merchants.delivery";//爱回收配送方式
    public static final String AHS_MERCHANTS_TIP = "ahs.merchants.tip";//爱回收提示
    
    public static final String DXT_MERCHANTS_DELIVERY = "dxt.merchants.delivery";//迪信通配送方式
    public static final String DXT_MERCHANTS_TIP = "dxt.merchants.tip";//迪信通提示

    public static final String LK_MERCHANTS_DELIVERY = "lk.merchants.delivery";//联科通配送方式
    public static final String LK_MERCHANTS_TIP = "lk.merchants.tip";//联科提示
    
    public static Map<String,String> configMap = new HashMap<String,String>();

    /**
     * 当系统配置变化的时候触发
     *
     * @param key
     */
    private void onConfigChanged(final String key) {
        if (SYS_PROFIT_RATE.equals(key)) {
            productTrxBusiness.updateSalePrice(getProfileRate());
        }
    }

    public BigDecimal getProfileRate() {
        return new BigDecimal(getConfig(SYS_PROFIT_RATE, Contants.product.DEFAULT_PROFIT_RATE.toString()));
    }

	public String getConfig(String key, String defaultValue) {
		if (configMap.get(key) != null) {
			return configMap.get(key);
		}
		String exchangeRate = defaultValue;
		SysParameterExample example = new SysParameterExample();
		example.createCriteria().andParam_keyEqualTo(key);
		List<SysParameter> sysParameters = sysParameterReadMapper.selectByExample(example);
		if (sysParameters.size() == 1) {
			exchangeRate = sysParameters.get(0).getParam_value();
		}
		configMap.put(key, exchangeRate);
		return exchangeRate;
	}

    public BaseResponse<String> getConfig(BaseAPIRequest<String> request) {
        String paramKey = request.getData();
        SysParameterExample sysParameterExample = new SysParameterExample();
        sysParameterExample.createCriteria().andParam_keyEqualTo(paramKey);
        List<SysParameter> sysParameters = sysParameterReadMapper.selectByExample(sysParameterExample);
        if (sysParameters.size() == 1) {
            return BaseResponse.buildSuccessResponse(sysParameters.get(0).getParam_value());
        }
        throw new RuntimeException("error in get sys config value:" + paramKey);
    }

    public PageViewDto<SysParameter> getConfigList(QueryCondition queryCondition) {
        SysParameterExample sysParameterExample = new SysParameterExample();

        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch())) {
            sysParameterExample.createCriteria().andParam_keyLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        }

        int totalCount = sysParameterReadMapper.countByExample(sysParameterExample);

        PageRequest pageRequest = queryCondition.getPageRequest();
        sysParameterExample.setPageCount(pageRequest.getLimit());
        sysParameterExample.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<SysParameter> sysParameters = sysParameterReadMapper.selectByExample(sysParameterExample);
        PageViewDto<SysParameter> toReturn = new PageViewDto<SysParameter>();
        toReturn.setDataList(sysParameters);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    public BaseResponse saveConfig(BaseRequest<SysParameter> request) {
        SysParameter sysParameter = request.getData();
        int effectedRow;
        if (sysParameter.getId() == null) {
            effectedRow = sysParameterWriteMapper.insertSelective(sysParameter);
        } else {
            sysParameter.setDate_updated(new Date());
            effectedRow = sysParameterWriteMapper.updateByPrimaryKeySelective(sysParameter);
        }
        if (effectedRow != 1) {
            throw new RuntimeException("保存配置失败");
        }

        onConfigChanged(sysParameter.getParam_key());

        return BaseResponse.buildSuccessResponse(sysParameter.getId());
    }

    public BaseResponse syncExchangeRate() {
        SysParameterExample example = new SysParameterExample();
        SysParameterExample.Criteria criteria = example.createCriteria().andParam_keyEqualTo(OrderBuisness.SYS_EXCHANGE_RATE);
        criteria.andDate_updatedGreaterThan(startOfToday());
        int count = sysParameterReadMapper.countByExample(example);
        if (count > 0) {
            return BaseResponse.buildSuccessResponse("already done");
        }

        String response = Client.create().resource("http://api.k780.com:88/?app=finance.rate&scur=USD&tcur=CNY&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&jsoncallback=").get(String.class);
        ExchangeRateDto exchangeRateDto = new Gson().fromJson(response, ExchangeRateDto.class);
        if (exchangeRateDto != null && exchangeRateDto.isSuccess()) {
            example = new SysParameterExample();
            example.createCriteria().andParam_keyEqualTo(OrderBuisness.SYS_EXCHANGE_RATE);

            SysParameter sysParameter = new SysParameter();
            sysParameter.setParam_key(OrderBuisness.SYS_EXCHANGE_RATE);
            sysParameter.setParam_value(exchangeRateDto.getResult().getRate());
            sysParameter.setDate_updated(new Date());

            int effectedRow = sysParameterWriteMapper.updateByExampleSelective(sysParameter, example);
            if (effectedRow != 1) {
                throw new RuntimeException("更新入库失败，等待下次重试");
            }

            return BaseResponse.buildSuccessResponse("ok");

        }
        throw new RuntimeException("汇率同步失败，等待下次job继续重试");
    }

    public BigDecimal getExchangeRate() {
        String exchangeRate = getConfig(SYS_EXCHANGE_RATE, "6.5");
        return new BigDecimal(exchangeRate);
    }
}
