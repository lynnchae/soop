package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderProductList implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String order_id;

    private Long product_id;

    private Integer product_price;

    private String product_name;

    private Integer quantity;

    private String purchase_status;

    private String order_status;

    private Date pay_complete_time;

    private Date purchase_complete_time;

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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPurchase_status() {
        return purchase_status;
    }

    public void setPurchase_status(String purchase_status) {
        this.purchase_status = purchase_status == null ? null : purchase_status.trim();
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status == null ? null : order_status.trim();
    }

    public Date getPay_complete_time() {
        return pay_complete_time;
    }

    public void setPay_complete_time(Date pay_complete_time) {
        this.pay_complete_time = pay_complete_time;
    }

    public Date getPurchase_complete_time() {
        return purchase_complete_time;
    }

    public void setPurchase_complete_time(Date purchase_complete_time) {
        this.purchase_complete_time = purchase_complete_time;
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
        sb.append(", order_id=").append(order_id);
        sb.append(", product_id=").append(product_id);
        sb.append(", product_price=").append(product_price);
        sb.append(", product_name=").append(product_name);
        sb.append(", quantity=").append(quantity);
        sb.append(", purchase_status=").append(purchase_status);
        sb.append(", order_status=").append(order_status);
        sb.append(", pay_complete_time=").append(pay_complete_time);
        sb.append(", purchase_complete_time=").append(purchase_complete_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}