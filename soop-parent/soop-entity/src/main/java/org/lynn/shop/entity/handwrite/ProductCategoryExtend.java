package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.ProductCategory;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductCategoryOriginBuilder;

public class ProductCategoryExtend extends ProductCategory {

    public static ProductCategoryExtend generateFromOriginEntity(ProductCategory origin) {
        return ProductCategoryOriginBuilder.buildOrigin(origin);
    }
}