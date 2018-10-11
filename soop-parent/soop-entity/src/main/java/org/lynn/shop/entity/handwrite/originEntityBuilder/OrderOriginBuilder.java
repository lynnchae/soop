package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.handwrite.OrderExtend;

public class OrderOriginBuilder extends Order {

    public static OrderExtend buildOrigin(Order origin) {
        OrderExtend returnValue=new OrderExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setStatus(origin.getStatus());
        returnValue.setTotal_product_amount(origin.getTotal_product_amount());
        returnValue.setTotal_order_amount(origin.getTotal_order_amount());
        returnValue.setPost_delivery_factor(origin.getPost_delivery_factor());
        returnValue.setPost_delivery_order_no(origin.getPost_delivery_order_no());
        returnValue.setDelivery_address(origin.getDelivery_address());
        returnValue.setDelivery_post_code(origin.getDelivery_post_code());
        returnValue.setDelivery_contact_name(origin.getDelivery_contact_name());
        returnValue.setDelivery_contact_phone(origin.getDelivery_contact_phone());
        returnValue.setOrder_description(origin.getOrder_description());
        returnValue.setTotal_product_number(origin.getTotal_product_number());
        returnValue.setTotal_weight(origin.getTotal_weight());
        returnValue.setAddress_id(origin.getAddress_id());
        returnValue.setFreight(origin.getFreight());
        returnValue.setDiscount_amount(origin.getDiscount_amount());
        returnValue.setDelivery_freight(origin.getDelivery_freight());
        return returnValue;
    }
}