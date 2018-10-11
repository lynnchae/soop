package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.OrderDeliverRoutine;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OrderDeliverRoutineOriginBuilder;

public class OrderDeliverRoutineExtend extends OrderDeliverRoutine {

    public static OrderDeliverRoutineExtend generateFromOriginEntity(OrderDeliverRoutine origin) {
        return OrderDeliverRoutineOriginBuilder.buildOrigin(origin);
    }
}