package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductOriginBuilder;

public class ProductExtend extends Product {

    public static ProductExtend generateFromOriginEntity(Product origin) {
        return ProductOriginBuilder.buildOrigin(origin);
    }
}