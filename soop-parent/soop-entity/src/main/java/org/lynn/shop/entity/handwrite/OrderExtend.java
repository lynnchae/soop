package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OrderOriginBuilder;

public class OrderExtend extends Order {

    public static OrderExtend generateFromOriginEntity(Order origin) {
        return OrderOriginBuilder.buildOrigin(origin);
    }
}