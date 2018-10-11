package org.lynn.soop.business.goods;

import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.ProductSalesProperty;
import org.lynn.soop.entity.ProductSalesPropertyExample;
import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.SalesPropertyValuesExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.ProductSalesPropertyReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.SalesPropertyValuesReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.ProductSalesPropertyWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.SalesPropertyValuesWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Created by gaoguoxiang on 2016/7/13
 */
@Component
public class SalesPropertyValuesBusiness extends BaseBusiness {

    @Autowired
    private SalesPropertyValuesReadMapper salesPropertyValuesReadMapper;

    @Autowired
    private SalesPropertyValuesWriteMapper salesPropertyValuesWriteMapper;
    @Autowired
    private ProductSalesPropertyWriteMapper productSalesPropertyWriteMapper;

    @Autowired
    private ProductSalesPropertyReadMapper productSalesPropertyReadMapper;

    @Transactional
    public BaseResponse updateSalesPropertyValues(BaseRequest<SalesPropertyValues> request) {
        SalesPropertyValues salesPropertyValues = request.getData();
        boolean createNew = salesPropertyValues.getId() == null;
        int result;
        if (createNew) {
            result = salesPropertyValuesWriteMapper.insertSelective(salesPropertyValues);
        } else {
            salesPropertyValues.setDate_updated(new Date());
            result = salesPropertyValuesWriteMapper.updateByPrimaryKeySelective(salesPropertyValues);
        }
        BaseResponse toReturn;
        if (result > 0) {
            toReturn = BaseResponse.buildSuccessResponse("ok");
        } else {
            logger.error(String.format("error in update salesPropertyValues: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        return toReturn;
    }

    public PageViewDto<SalesPropertyValues> listSalesPropertyValues(Long spId) {
        SalesPropertyValuesExample example = new SalesPropertyValuesExample();
        example.createCriteria().andSp_idEqualTo(spId);
        example.setOrderByClause(" id asc");
        List<SalesPropertyValues> salesPropertyValuesList = salesPropertyValuesReadMapper.selectByExample(example);
        PageViewDto<SalesPropertyValues> toReturn = new PageViewDto<SalesPropertyValues>();
        toReturn.setDataList(salesPropertyValuesList);
        toReturn.setTotalNumber(salesPropertyValuesList.size());
        return toReturn;
    }

    public BaseResponse removeSalesPropertyValues(BaseRequest<Long> request) {
        Long salesPropertyValuesId = request.getData();
        BaseResponse toReturn = null;
        //根据salePropertyValuesId判断product_sales_property表中有没有相关数据
        ProductSalesPropertyExample example = new ProductSalesPropertyExample();
        example.createCriteria().andSpv_idEqualTo(salesPropertyValuesId);
        List<ProductSalesProperty> productSalesProperties = productSalesPropertyReadMapper.selectByExample(example);
        //如果不存在相关数据 则可以删除
        if (CollectionUtils.isEmpty(productSalesProperties)) {
            int effectedRows = salesPropertyValuesWriteMapper.deleteByPrimaryKey(salesPropertyValuesId);
            toReturn = BaseResponse.buildSuccessResponse("ok");
            if (effectedRows == 0) {
                logger.error(String.format("error in remove salesProperty: [%s]", salesPropertyValuesId));
                toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
            }
        } else {
            logger.debug(String.format("debug in remove salesProperty: [%s]", salesPropertyValuesId));
            toReturn = BaseResponse.buildClientErrorResponse("该属性值和商品有关联不可删除！");
        }
        return toReturn;
    }
}
