package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.ProductSalesProperty;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductSalesPropertyOriginBuilder;

public class ProductSalesPropertyExtend extends ProductSalesProperty {

    public static ProductSalesPropertyExtend generateFromOriginEntity(ProductSalesProperty origin) {
        return ProductSalesPropertyOriginBuilder.buildOrigin(origin);
    }
}