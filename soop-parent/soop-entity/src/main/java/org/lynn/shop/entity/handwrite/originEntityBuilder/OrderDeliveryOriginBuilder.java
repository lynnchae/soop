package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.OrderDelivery;
import org.lynn.soop.entity.handwrite.OrderDeliveryExtend;

public class OrderDeliveryOriginBuilder extends OrderDelivery {

    public static OrderDeliveryExtend buildOrigin(OrderDelivery origin) {
        OrderDeliveryExtend returnValue=new OrderDeliveryExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setSource_delivery_route(origin.getSource_delivery_route());
        returnValue.setOrder_id(origin.getOrder_id());
        returnValue.setDelivery_address(origin.getDelivery_address());
        returnValue.setDelivery_post_code(origin.getDelivery_post_code());
        returnValue.setDelivery_contact_name(origin.getDelivery_contact_name());
        returnValue.setDelivery_contact_phone(origin.getDelivery_contact_phone());
        returnValue.setStatus(origin.getStatus());
        returnValue.setDelivery_order_no(origin.getDelivery_order_no());
        returnValue.setDelivery_company(origin.getDelivery_company());
        returnValue.setBatch_id(origin.getBatch_id());
        returnValue.setProduct_info(origin.getProduct_info());
        returnValue.setDelivery_fee(origin.getDelivery_fee());
        returnValue.setBatch_no(origin.getBatch_no());
        returnValue.setDelivery_detail_status_list(origin.getDelivery_detail_status_list());
        return returnValue;
    }
}