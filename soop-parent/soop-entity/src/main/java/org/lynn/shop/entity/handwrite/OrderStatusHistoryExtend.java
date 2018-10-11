package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.OrderStatusHistory;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OrderStatusHistoryOriginBuilder;

public class OrderStatusHistoryExtend extends OrderStatusHistory {

    public static OrderStatusHistoryExtend generateFromOriginEntity(OrderStatusHistory origin) {
        return OrderStatusHistoryOriginBuilder.buildOrigin(origin);
    }
}