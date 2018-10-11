package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.OrderDeliverBatch;
import org.lynn.soop.entity.handwrite.OrderDeliverBatchExtend;

public class OrderDeliverBatchOriginBuilder extends OrderDeliverBatch {

    public static OrderDeliverBatchExtend buildOrigin(OrderDeliverBatch origin) {
        OrderDeliverBatchExtend returnValue=new OrderDeliverBatchExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setBatch_id(origin.getBatch_id());
        returnValue.setRoutine_name(origin.getRoutine_name());
        returnValue.setAlready_import(origin.getAlready_import());
        return returnValue;
    }
}