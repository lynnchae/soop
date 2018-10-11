package org.lynn.soop.contract.order.dto;

import org.lynn.soop.entity.OrderDelivery;
import org.lynn.soop.util.DisplayResourceKey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BatchDeliveryExportDTO {
    @DisplayResourceKey("id")
    private String id;
    @DisplayResourceKey("delivery route")
    private String source_delivery_route;
    @DisplayResourceKey("delivery address")
    private String delivery_address;
    @DisplayResourceKey("post code")
    private String delivery_post_code;
    @DisplayResourceKey("contact name")
    private String delivery_contact_name;
    @DisplayResourceKey("phone")
    private String delivery_contact_phone;
    @DisplayResourceKey("product info")
    private String product_info;
    @DisplayResourceKey("delivery fee")
    private String delivery_fee;
    @DisplayResourceKey("delivery order no")
    private String delivery_order_no;
    @DisplayResourceKey("delivery company")
    private String delivery_company;


    public static List<BatchDeliveryExportDTO> fromList(List<OrderDelivery> orderDeliveries) {
        List<BatchDeliveryExportDTO> toReturn = new ArrayList<BatchDeliveryExportDTO>();
        for (OrderDelivery orderDelivery : orderDeliveries) {
            toReturn.add(from(orderDelivery));
        }
        return toReturn;
    }

    public static BatchDeliveryExportDTO from(OrderDelivery orderDelivery) {
        BatchDeliveryExportDTO toReturn = new BatchDeliveryExportDTO();
        toReturn.id = String.valueOf(orderDelivery.getId());
        toReturn.source_delivery_route = orderDelivery.getSource_delivery_route();
        toReturn.delivery_address = orderDelivery.getDelivery_address();
        toReturn.delivery_post_code = orderDelivery.getDelivery_post_code();
        toReturn.delivery_contact_name = orderDelivery.getDelivery_contact_name();
        toReturn.delivery_contact_phone = orderDelivery.getDelivery_contact_phone();
        toReturn.product_info = orderDelivery.getProduct_info();
        toReturn.delivery_order_no = orderDelivery.getDelivery_order_no();
        toReturn.delivery_company = "千喜速运";
        return toReturn;
    }


    public static OrderDelivery to(BatchDeliveryExportDTO dto) {
        OrderDelivery toReturn = new OrderDelivery();
        toReturn.setId(Long.valueOf(dto.id));
        toReturn.setDelivery_fee(new BigDecimal(dto.delivery_fee).intValue());
//        toReturn.setDelivery_order_no(dto.delivery_order_no);
//        toReturn.setDelivery_company(dto.delivery_company);
        return toReturn;
    }


    public String getProduct_info() {
        return product_info;
    }

    public void setProduct_info(String product_info) {
        this.product_info = product_info;
    }

    public String getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(String delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource_delivery_route() {
        return source_delivery_route;
    }

    public void setSource_delivery_route(String source_delivery_route) {
        this.source_delivery_route = source_delivery_route;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getDelivery_post_code() {
        return delivery_post_code;
    }

    public void setDelivery_post_code(String delivery_post_code) {
        this.delivery_post_code = delivery_post_code;
    }

    public String getDelivery_contact_name() {
        return delivery_contact_name;
    }

    public void setDelivery_contact_name(String delivery_contact_name) {
        this.delivery_contact_name = delivery_contact_name;
    }

    public String getDelivery_contact_phone() {
        return delivery_contact_phone;
    }

    public void setDelivery_contact_phone(String delivery_contact_phone) {
        this.delivery_contact_phone = delivery_contact_phone;
    }

    public String getDelivery_order_no() {
        return delivery_order_no;
    }

    public void setDelivery_order_no(String delivery_order_no) {
        this.delivery_order_no = delivery_order_no;
    }

    public String getDelivery_company() {
        return delivery_company;
    }

    public void setDelivery_company(String delivery_company) {
        this.delivery_company = delivery_company;
    }


}
