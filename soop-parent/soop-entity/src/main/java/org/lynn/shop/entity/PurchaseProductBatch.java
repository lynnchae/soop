package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class PurchaseProductBatch implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Long purchase_product_batch_id;

    private Integer plan_product_count;

    private Integer actual_product_count;

    private Integer plan_total_item_count;

    private Integer actual_total_item_count;

    private Integer progress_percentage;

    private Integer purchase_time;

    private Date start_time;

    private Date end_time;

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

    public Long getPurchase_product_batch_id() {
        return purchase_product_batch_id;
    }

    public void setPurchase_product_batch_id(Long purchase_product_batch_id) {
        this.purchase_product_batch_id = purchase_product_batch_id;
    }

    public Integer getPlan_product_count() {
        return plan_product_count;
    }

    public void setPlan_product_count(Integer plan_product_count) {
        this.plan_product_count = plan_product_count;
    }

    public Integer getActual_product_count() {
        return actual_product_count;
    }

    public void setActual_product_count(Integer actual_product_count) {
        this.actual_product_count = actual_product_count;
    }

    public Integer getPlan_total_item_count() {
        return plan_total_item_count;
    }

    public void setPlan_total_item_count(Integer plan_total_item_count) {
        this.plan_total_item_count = plan_total_item_count;
    }

    public Integer getActual_total_item_count() {
        return actual_total_item_count;
    }

    public void setActual_total_item_count(Integer actual_total_item_count) {
        this.actual_total_item_count = actual_total_item_count;
    }

    public Integer getProgress_percentage() {
        return progress_percentage;
    }

    public void setProgress_percentage(Integer progress_percentage) {
        this.progress_percentage = progress_percentage;
    }

    public Integer getPurchase_time() {
        return purchase_time;
    }

    public void setPurchase_time(Integer purchase_time) {
        this.purchase_time = purchase_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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
        sb.append(", purchase_product_batch_id=").append(purchase_product_batch_id);
        sb.append(", plan_product_count=").append(plan_product_count);
        sb.append(", actual_product_count=").append(actual_product_count);
        sb.append(", plan_total_item_count=").append(plan_total_item_count);
        sb.append(", actual_total_item_count=").append(actual_total_item_count);
        sb.append(", progress_percentage=").append(progress_percentage);
        sb.append(", purchase_time=").append(purchase_time);
        sb.append(", start_time=").append(start_time);
        sb.append(", end_time=").append(end_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}