package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.PurchaseProductBatch;
import org.lynn.soop.entity.handwrite.originEntityBuilder.PurchaseProductBatchOriginBuilder;

public class PurchaseProductBatchExtend extends PurchaseProductBatch {

    public static PurchaseProductBatchExtend generateFromOriginEntity(PurchaseProductBatch origin) {
        return PurchaseProductBatchOriginBuilder.buildOrigin(origin);
    }
}