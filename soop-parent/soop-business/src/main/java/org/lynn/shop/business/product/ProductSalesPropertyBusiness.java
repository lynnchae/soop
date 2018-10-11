package org.lynn.soop.business.product;

import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductSalesProperty;
import org.lynn.soop.entity.ProductSalesPropertyExample;
import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.dto.ProductSalesPropertyAndValuesDto;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.ProductSalesPropertyReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.SalesPropertyValuesReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.ProductSalesPropertyWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.ProductWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.business.product
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/14
 */
@Component
public class ProductSalesPropertyBusiness extends BaseBusiness {

    @Autowired
    private ProductSalesPropertyReadMapper productSalesPropertyReadMapper;

    @Autowired
    private SalesPropertyValuesReadMapper salesPropertyValuesReadMapper;

    @Autowired
    private ProductSalesPropertyWriteMapper productSalesPropertyWriteMapper;

    @Autowired
    private ProductWriteMapper productWriteMapper;


    public PageViewDto<ProductSalesPropertyAndValuesDto> listProductSalesProperty(Long productId) {

        ProductSalesPropertyExample example = new ProductSalesPropertyExample();
        example.createCriteria().andProduct_idEqualTo(productId);
        List<ProductSalesProperty> attributeList = productSalesPropertyReadMapper.selectByExample(example);
        List<ProductSalesPropertyAndValuesDto> productSalesPropertyAndValuesDtos = new ArrayList<>();
        //获取商品属性值id
        for (ProductSalesProperty p : attributeList) {
            SalesPropertyValues salesPropertyValues = salesPropertyValuesReadMapper.selectByPrimaryKey(p.getSpv_id());
            ProductSalesPropertyAndValuesDto dto = new ProductSalesPropertyAndValuesDto();
            dto.setId(p.getId());
            dto.setDate_created(p.getDate_created());
            dto.setCreated_by(p.getCreated_by());
            dto.setDate_updated(p.getDate_updated());
            dto.setUpdated_by(p.getUpdated_by());
            dto.setProduct_id(p.getProduct_id());
            dto.setSpv_id(p.getSpv_id());
            if (salesPropertyValues != null) {
                dto.setSp_id(salesPropertyValues.getSp_id());
                dto.setSp_value(salesPropertyValues.getSp_value());
            }
            productSalesPropertyAndValuesDtos.add(dto);
        }
        PageViewDto<ProductSalesPropertyAndValuesDto> toReturn = new PageViewDto<ProductSalesPropertyAndValuesDto>();
        toReturn.setDataList(productSalesPropertyAndValuesDtos);
        toReturn.setTotalNumber(productSalesPropertyAndValuesDtos.size());
        return toReturn;
    }

    @Transactional
    public BaseResponse updateProductAndSp(BaseRequest<Product> request, Map<Long, String> spList) {
        BaseResponse toReturn = null;
        Product product = request.getData();
        product.setDate_updated(new Date());
        //1、更新产品
        if(productWriteMapper.updateByPrimaryKeySelective(product) > 0){
            //如果spList不为空，则更新商品销售属性值
            if( spList != null && spList.size() > 0){
                ProductSalesProperty productSp = new ProductSalesProperty();
                ProductSalesPropertyExample productSpExmple = new ProductSalesPropertyExample();
                ProductSalesPropertyExample.Criteria criteria = productSpExmple.createCriteria();
                criteria.andProduct_idEqualTo(product.getId());
                Iterator<Long> keyIterator = spList.keySet().iterator();
                //删除现有属性
                productSalesPropertyWriteMapper.deleteByExample(productSpExmple);
                while (keyIterator.hasNext()){
                    Long spvId = keyIterator.next();
                    ProductSalesProperty p = new ProductSalesProperty();
                    p.setProduct_id(product.getId());
                    p.setSpv_id(spvId);
                    if( productSalesPropertyWriteMapper.insert(p) > 0){
                        toReturn = BaseResponse.buildSuccessResponse("ok");
                    }else{
                        logger.error(String.format("error in update product: [%s]", toJSON(request)));
                        toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
                    }
                }
            }
        }
        return toReturn;
    }
}
