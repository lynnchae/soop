package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.OrderProductList;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OrderProductListOriginBuilder;

public class OrderProductListExtend extends OrderProductList {

    public static OrderProductListExtend generateFromOriginEntity(OrderProductList origin) {
        return OrderProductListOriginBuilder.buildOrigin(origin);
    }
}