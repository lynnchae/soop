package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String status;

    private Integer total_product_amount;

    private Integer total_order_amount;

    private Integer post_delivery_factor;

    private String post_delivery_order_no;

    private String delivery_address;

    private String delivery_post_code;

    private String delivery_contact_name;

    private String delivery_contact_phone;

    private String order_description;

    private Integer total_product_number;

    private Integer total_weight;

    private Long address_id;

    private Integer freight;

    private Integer discount_amount;

    private Integer delivery_freight;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by == null ? null : created_by.trim();
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by == null ? null : updated_by.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTotal_product_amount() {
        return total_product_amount;
    }

    public void setTotal_product_amount(Integer total_product_amount) {
        this.total_product_amount = total_product_amount;
    }

    public Integer getTotal_order_amount() {
        return total_order_amount;
    }

    public void setTotal_order_amount(Integer total_order_amount) {
        this.total_order_amount = total_order_amount;
    }

    public Integer getPost_delivery_factor() {
        return post_delivery_factor;
    }

    public void setPost_delivery_factor(Integer post_delivery_factor) {
        this.post_delivery_factor = post_delivery_factor;
    }

    public String getPost_delivery_order_no() {
        return post_delivery_order_no;
    }

    public void setPost_delivery_order_no(String post_delivery_order_no) {
        this.post_delivery_order_no = post_delivery_order_no == null ? null : post_delivery_order_no.trim();
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address == null ? null : delivery_address.trim();
    }

    public String getDelivery_post_code() {
        return delivery_post_code;
    }

    public void setDelivery_post_code(String delivery_post_code) {
        this.delivery_post_code = delivery_post_code == null ? null : delivery_post_code.trim();
    }

    public String getDelivery_contact_name() {
        return delivery_contact_name;
    }

    public void setDelivery_contact_name(String delivery_contact_name) {
        this.delivery_contact_name = delivery_contact_name == null ? null : delivery_contact_name.trim();
    }

    public String getDelivery_contact_phone() {
        return delivery_contact_phone;
    }

    public void setDelivery_contact_phone(String delivery_contact_phone) {
        this.delivery_contact_phone = delivery_contact_phone == null ? null : delivery_contact_phone.trim();
    }

    public String getOrder_description() {
        return order_description;
    }

    public void setOrder_description(String order_description) {
        this.order_description = order_description == null ? null : order_description.trim();
    }

    public Integer getTotal_product_number() {
        return total_product_number;
    }

    public void setTotal_product_number(Integer total_product_number) {
        this.total_product_number = total_product_number;
    }

    public Integer getTotal_weight() {
        return total_weight;
    }

    public void setTotal_weight(Integer total_weight) {
        this.total_weight = total_weight;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(Integer discount_amount) {
        this.discount_amount = discount_amount;
    }

    public Integer getDelivery_freight() {
        return delivery_freight;
    }

    public void setDelivery_freight(Integer delivery_freight) {
        this.delivery_freight = delivery_freight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", date_created=").append(date_created);
        sb.append(", created_by=").append(created_by);
        sb.append(", date_updated=").append(date_updated);
        sb.append(", updated_by=").append(updated_by);
        sb.append(", status=").append(status);
        sb.append(", total_product_amount=").append(total_product_amount);
        sb.append(", total_order_amount=").append(total_order_amount);
        sb.append(", post_delivery_factor=").append(post_delivery_factor);
        sb.append(", post_delivery_order_no=").append(post_delivery_order_no);
        sb.append(", delivery_address=").append(delivery_address);
        sb.append(", delivery_post_code=").append(delivery_post_code);
        sb.append(", delivery_contact_name=").append(delivery_contact_name);
        sb.append(", delivery_contact_phone=").append(delivery_contact_phone);
        sb.append(", order_description=").append(order_description);
        sb.append(", total_product_number=").append(total_product_number);
        sb.append(", total_weight=").append(total_weight);
        sb.append(", address_id=").append(address_id);
        sb.append(", freight=").append(freight);
        sb.append(", discount_amount=").append(discount_amount);
        sb.append(", delivery_freight=").append(delivery_freight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}