package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class PurchaseProductRequest implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Long product_id;

    private Integer plan_quantity;

    private Integer actual_quantity;

    private Long purchase_product_batch_id;

    private Integer purchase_time;

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

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getPlan_quantity() {
        return plan_quantity;
    }

    public void setPlan_quantity(Integer plan_quantity) {
        this.plan_quantity = plan_quantity;
    }

    public Integer getActual_quantity() {
        return actual_quantity;
    }

    public void setActual_quantity(Integer actual_quantity) {
        this.actual_quantity = actual_quantity;
    }

    public Long getPurchase_product_batch_id() {
        return purchase_product_batch_id;
    }

    public void setPurchase_product_batch_id(Long purchase_product_batch_id) {
        this.purchase_product_batch_id = purchase_product_batch_id;
    }

    public Integer getPurchase_time() {
        return purchase_time;
    }

    public void setPurchase_time(Integer purchase_time) {
        this.purchase_time = purchase_time;
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
        sb.append(", product_id=").append(product_id);
        sb.append(", plan_quantity=").append(plan_quantity);
        sb.append(", actual_quantity=").append(actual_quantity);
        sb.append(", purchase_product_batch_id=").append(purchase_product_batch_id);
        sb.append(", purchase_time=").append(purchase_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}