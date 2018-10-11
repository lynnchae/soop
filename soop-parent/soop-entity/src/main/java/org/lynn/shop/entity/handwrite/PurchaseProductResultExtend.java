package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.PurchaseProductResult;
import org.lynn.soop.entity.handwrite.originEntityBuilder.PurchaseProductResultOriginBuilder;

public class PurchaseProductResultExtend extends PurchaseProductResult {

    public static PurchaseProductResultExtend generateFromOriginEntity(PurchaseProductResult origin) {
        return PurchaseProductResultOriginBuilder.buildOrigin(origin);
    }
}