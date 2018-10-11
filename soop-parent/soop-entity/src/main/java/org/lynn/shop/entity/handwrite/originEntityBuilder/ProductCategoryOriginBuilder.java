package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.ProductCategory;
import org.lynn.soop.entity.handwrite.ProductCategoryExtend;

public class ProductCategoryOriginBuilder extends ProductCategory {

    public static ProductCategoryExtend buildOrigin(ProductCategory origin) {
        ProductCategoryExtend returnValue=new ProductCategoryExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setCategory_name(origin.getCategory_name());
        returnValue.setDescription(origin.getDescription());
        returnValue.setParent_category_id(origin.getParent_category_id());
        returnValue.setDuties(origin.getDuties());
        returnValue.setParent_category_name(origin.getParent_category_name());
        returnValue.setDiscount_standard_amount(origin.getDiscount_standard_amount());
        returnValue.setDiscount_percentage(origin.getDiscount_percentage());
        return returnValue;
    }
}