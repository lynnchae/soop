package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.OrderDelivery;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OrderDeliveryOriginBuilder;

public class OrderDeliveryExtend extends OrderDelivery {

    public static OrderDeliveryExtend generateFromOriginEntity(OrderDelivery origin) {
        return OrderDeliveryOriginBuilder.buildOrigin(origin);
    }
}