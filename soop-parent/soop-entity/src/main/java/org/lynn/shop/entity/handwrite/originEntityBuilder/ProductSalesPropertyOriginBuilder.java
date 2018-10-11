package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.ProductSalesProperty;
import org.lynn.soop.entity.handwrite.ProductSalesPropertyExtend;

public class ProductSalesPropertyOriginBuilder extends ProductSalesProperty {

    public static ProductSalesPropertyExtend buildOrigin(ProductSalesProperty origin) {
        ProductSalesPropertyExtend returnValue=new ProductSalesPropertyExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setSpv_id(origin.getSpv_id());
        returnValue.setSp_name(origin.getSp_name());
        returnValue.setSp_value(origin.getSp_value());
        return returnValue;
    }
}