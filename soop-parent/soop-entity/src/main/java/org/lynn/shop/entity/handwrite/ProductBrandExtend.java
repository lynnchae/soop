package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.ProductBrand;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductBrandOriginBuilder;

public class ProductBrandExtend extends ProductBrand {

    public static ProductBrandExtend generateFromOriginEntity(ProductBrand origin) {
        return ProductBrandOriginBuilder.buildOrigin(origin);
    }
}