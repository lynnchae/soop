package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.ProductPrice;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductPriceOriginBuilder;

public class ProductPriceExtend extends ProductPrice {

    public static ProductPriceExtend generateFromOriginEntity(ProductPrice origin) {
        return ProductPriceOriginBuilder.buildOrigin(origin);
    }
}