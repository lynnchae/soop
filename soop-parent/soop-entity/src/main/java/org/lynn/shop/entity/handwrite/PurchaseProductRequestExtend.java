package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.PurchaseProductRequest;
import org.lynn.soop.entity.handwrite.originEntityBuilder.PurchaseProductRequestOriginBuilder;

public class PurchaseProductRequestExtend extends PurchaseProductRequest {

    public static PurchaseProductRequestExtend generateFromOriginEntity(PurchaseProductRequest origin) {
        return PurchaseProductRequestOriginBuilder.buildOrigin(origin);
    }
}