package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.OrderDeliverBatch;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OrderDeliverBatchOriginBuilder;

public class OrderDeliverBatchExtend extends OrderDeliverBatch {

    public static OrderDeliverBatchExtend generateFromOriginEntity(OrderDeliverBatch origin) {
        return OrderDeliverBatchOriginBuilder.buildOrigin(origin);
    }
}