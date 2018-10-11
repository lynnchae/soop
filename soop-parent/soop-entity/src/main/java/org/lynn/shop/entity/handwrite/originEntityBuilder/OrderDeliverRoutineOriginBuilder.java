package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.OrderDeliverRoutine;
import org.lynn.soop.entity.handwrite.OrderDeliverRoutineExtend;

public class OrderDeliverRoutineOriginBuilder extends OrderDeliverRoutine {

    public static OrderDeliverRoutineExtend buildOrigin(OrderDeliverRoutine origin) {
        OrderDeliverRoutineExtend returnValue=new OrderDeliverRoutineExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setCategory_id(origin.getCategory_id());
        returnValue.setRoutine_name(origin.getRoutine_name());
        returnValue.setRoutine_detail(origin.getRoutine_detail());
        returnValue.setPriority(origin.getPriority());
        return returnValue;
    }
}