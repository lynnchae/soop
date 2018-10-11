package org.lynn.soop.business.goods;

import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.SalesProperty;
import org.lynn.soop.entity.SalesPropertyExample;
import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.SalesPropertyValuesExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.SalesPropertyReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.SalesPropertyValuesReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.SalesPropertyValuesWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.SalesPropertyWriteMapper;
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
public class SalesPropertyBusiness extends BaseBusiness {
    @Autowired
    private SalesPropertyReadMapper salesPropertyReadMapper;
    @Autowired
    private SalesPropertyWriteMapper salesPropertyWriteMapper;
    @Autowired
    private SalesPropertyValuesWriteMapper salesPropertyValuesWriteMapper;
    @Autowired
    private SalesPropertyValuesReadMapper salesPropertyValuesReadMapper;

    @Transactional
    public BaseResponse updateSalesProperty(BaseRequest<SalesProperty> request) {
        SalesProperty salesProperty = request.getData();
        boolean createNew = salesProperty.getId() == null;
        int result;
        if (createNew) {
            result = salesPropertyWriteMapper.insertSelective(salesProperty);
        } else {
            salesProperty.setDate_updated(new Date());
            result = salesPropertyWriteMapper.updateByPrimaryKeySelective(salesProperty);
        }
        BaseResponse toReturn;
        if (result > 0) {
            toReturn = BaseResponse.buildSuccessResponse("ok");
        } else {
            logger.error(String.format("error in update salesProperty: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        return toReturn;
    }

    public PageViewDto<SalesProperty> listSalesProperty(Long goodsId) {
        SalesPropertyExample example = new SalesPropertyExample();
        example.createCriteria().andGoods_idEqualTo(goodsId);
        List<SalesProperty> salesPropertyList = salesPropertyReadMapper.selectByExample(example);
        PageViewDto<SalesProperty> toReturn = new PageViewDto<SalesProperty>();
        toReturn.setDataList(salesPropertyList);
        toReturn.setTotalNumber(salesPropertyList.size());
        return toReturn;
    }

    public BaseResponse removeSalesProperty(BaseRequest<Long> request) {
        BaseResponse toReturn = null;
        Long salesPropertyId = request.getData();
        //判断sales_property_values表有没有相关数据
        SalesPropertyValuesExample salesPropertyValuesExample = new SalesPropertyValuesExample();
        salesPropertyValuesExample.createCriteria().andSp_idEqualTo(salesPropertyId);
        List<SalesPropertyValues> salesPropertyValues = salesPropertyValuesReadMapper.selectByExample(salesPropertyValuesExample);

        //如果values表没有关联数据则可以删除
        if (CollectionUtils.isEmpty(salesPropertyValues)) {
            int effectedRows = salesPropertyWriteMapper.deleteByPrimaryKey(salesPropertyId);
            SalesPropertyValuesExample example= new SalesPropertyValuesExample();
            example.createCriteria().andSp_idEqualTo(salesPropertyId);
            salesPropertyValuesWriteMapper.deleteByExample(example);

            toReturn = BaseResponse.buildSuccessResponse("ok");
            if (effectedRows == 0) {
                logger.error(String.format("error in remove salesProperty: [%s]", salesPropertyId));
                toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
            }
        } else {
            logger.debug(String.format("debug in remove salesProperty: [%s]", salesPropertyId));
            toReturn = BaseResponse.buildClientErrorResponse("该属性有对应的值 请先删除属性值!");
        }
        return toReturn;
    }
}
