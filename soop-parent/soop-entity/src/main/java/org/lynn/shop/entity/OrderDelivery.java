package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderDelivery implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String source_delivery_route;

    private String order_id;

    private String delivery_address;

    private String delivery_post_code;

    private String delivery_contact_name;

    private String delivery_contact_phone;

    private String status;

    private String delivery_order_no;

    private String delivery_company;

    private String batch_id;

    private String product_info;

    private Integer delivery_fee;

    private String batch_no;

    private String delivery_detail_status_list;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSource_delivery_route() {
        return source_delivery_route;
    }

    public void setSource_delivery_route(String source_delivery_route) {
        this.source_delivery_route = source_delivery_route == null ? null : source_delivery_route.trim();
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDelivery_order_no() {
        return delivery_order_no;
    }

    public void setDelivery_order_no(String delivery_order_no) {
        this.delivery_order_no = delivery_order_no == null ? null : delivery_order_no.trim();
    }

    public String getDelivery_company() {
        return delivery_company;
    }

    public void setDelivery_company(String delivery_company) {
        this.delivery_company = delivery_company == null ? null : delivery_company.trim();
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id == null ? null : batch_id.trim();
    }

    public String getProduct_info() {
        return product_info;
    }

    public void setProduct_info(String product_info) {
        this.product_info = product_info == null ? null : product_info.trim();
    }

    public Integer getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(Integer delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no == null ? null : batch_no.trim();
    }

    public String getDelivery_detail_status_list() {
        return delivery_detail_status_list;
    }

    public void setDelivery_detail_status_list(String delivery_detail_status_list) {
        this.delivery_detail_status_list = delivery_detail_status_list == null ? null : delivery_detail_status_list.trim();
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
        sb.append(", source_delivery_route=").append(source_delivery_route);
        sb.append(", order_id=").append(order_id);
        sb.append(", delivery_address=").append(delivery_address);
        sb.append(", delivery_post_code=").append(delivery_post_code);
        sb.append(", delivery_contact_name=").append(delivery_contact_name);
        sb.append(", delivery_contact_phone=").append(delivery_contact_phone);
        sb.append(", status=").append(status);
        sb.append(", delivery_order_no=").append(delivery_order_no);
        sb.append(", delivery_company=").append(delivery_company);
        sb.append(", batch_id=").append(batch_id);
        sb.append(", product_info=").append(product_info);
        sb.append(", delivery_fee=").append(delivery_fee);
        sb.append(", batch_no=").append(batch_no);
        sb.append(", delivery_detail_status_list=").append(delivery_detail_status_list);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}