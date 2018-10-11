package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.ProductAttribute;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductAttributeOriginBuilder;

public class ProductAttributeExtend extends ProductAttribute {

    public static ProductAttributeExtend generateFromOriginEntity(ProductAttribute origin) {
        return ProductAttributeOriginBuilder.buildOrigin(origin);
    }
}