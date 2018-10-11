package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.ProductAttribute;
import org.lynn.soop.entity.handwrite.ProductAttributeExtend;

public class ProductAttributeOriginBuilder extends ProductAttribute {

    public static ProductAttributeExtend buildOrigin(ProductAttribute origin) {
        ProductAttributeExtend returnValue=new ProductAttributeExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setAttr_name(origin.getAttr_name());
        returnValue.setAttr_value(origin.getAttr_value());
        returnValue.setAttr_type(origin.getAttr_type());
        returnValue.setProduct_category_id(origin.getProduct_category_id());
        return returnValue;
    }
}