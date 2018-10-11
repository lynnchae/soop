package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.ProductBrand;
import org.lynn.soop.entity.handwrite.ProductBrandExtend;

public class ProductBrandOriginBuilder extends ProductBrand {

    public static ProductBrandExtend buildOrigin(ProductBrand origin) {
        ProductBrandExtend returnValue=new ProductBrandExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setBrand_name_cn(origin.getBrand_name_cn());
        returnValue.setBrand_name_en(origin.getBrand_name_en());
        return returnValue;
    }
}