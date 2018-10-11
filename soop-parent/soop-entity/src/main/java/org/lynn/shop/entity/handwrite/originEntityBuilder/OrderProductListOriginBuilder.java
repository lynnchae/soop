package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.OrderProductList;
import org.lynn.soop.entity.handwrite.OrderProductListExtend;

public class OrderProductListOriginBuilder extends OrderProductList {

    public static OrderProductListExtend buildOrigin(OrderProductList origin) {
        OrderProductListExtend returnValue=new OrderProductListExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setOrder_id(origin.getOrder_id());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setProduct_price(origin.getProduct_price());
        returnValue.setProduct_name(origin.getProduct_name());
        returnValue.setQuantity(origin.getQuantity());
        returnValue.setPurchase_status(origin.getPurchase_status());
        returnValue.setOrder_status(origin.getOrder_status());
        returnValue.setPay_complete_time(origin.getPay_complete_time());
        returnValue.setPurchase_complete_time(origin.getPurchase_complete_time());
        return returnValue;
    }
}