package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.OrderStatusHistory;
import org.lynn.soop.entity.handwrite.OrderStatusHistoryExtend;

public class OrderStatusHistoryOriginBuilder extends OrderStatusHistory {

    public static OrderStatusHistoryExtend buildOrigin(OrderStatusHistory origin) {
        OrderStatusHistoryExtend returnValue=new OrderStatusHistoryExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setOrder_id(origin.getOrder_id());
        returnValue.setTo_status(origin.getTo_status());
        returnValue.setFrom_status(origin.getFrom_status());
        returnValue.setOperation(origin.getOperation());
        returnValue.setRecord_id(origin.getRecord_id());
        return returnValue;
    }
}