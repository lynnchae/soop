package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class AdminStatistic implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Integer total_product_count;

    private Integer total_product_count_in_stock;

    private Integer total_hot_product_count;

    private Integer total_new_product_count;

    private Integer total_promo_product_count;

    private Integer total_order_count;

    private Integer pending_delivery_order_count;

    private Integer pending_pay_order_count;

    private Integer done_order_count;

    private Integer refund_order_count;

    private Integer total_user_online;

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

    public Integer getTotal_product_count() {
        return total_product_count;
    }

    public void setTotal_product_count(Integer total_product_count) {
        this.total_product_count = total_product_count;
    }

    public Integer getTotal_product_count_in_stock() {
        return total_product_count_in_stock;
    }

    public void setTotal_product_count_in_stock(Integer total_product_count_in_stock) {
        this.total_product_count_in_stock = total_product_count_in_stock;
    }

    public Integer getTotal_hot_product_count() {
        return total_hot_product_count;
    }

    public void setTotal_hot_product_count(Integer total_hot_product_count) {
        this.total_hot_product_count = total_hot_product_count;
    }

    public Integer getTotal_new_product_count() {
        return total_new_product_count;
    }

    public void setTotal_new_product_count(Integer total_new_product_count) {
        this.total_new_product_count = total_new_product_count;
    }

    public Integer getTotal_promo_product_count() {
        return total_promo_product_count;
    }

    public void setTotal_promo_product_count(Integer total_promo_product_count) {
        this.total_promo_product_count = total_promo_product_count;
    }

    public Integer getTotal_order_count() {
        return total_order_count;
    }

    public void setTotal_order_count(Integer total_order_count) {
        this.total_order_count = total_order_count;
    }

    public Integer getPending_delivery_order_count() {
        return pending_delivery_order_count;
    }

    public void setPending_delivery_order_count(Integer pending_delivery_order_count) {
        this.pending_delivery_order_count = pending_delivery_order_count;
    }

    public Integer getPending_pay_order_count() {
        return pending_pay_order_count;
    }

    public void setPending_pay_order_count(Integer pending_pay_order_count) {
        this.pending_pay_order_count = pending_pay_order_count;
    }

    public Integer getDone_order_count() {
        return done_order_count;
    }

    public void setDone_order_count(Integer done_order_count) {
        this.done_order_count = done_order_count;
    }

    public Integer getRefund_order_count() {
        return refund_order_count;
    }

    public void setRefund_order_count(Integer refund_order_count) {
        this.refund_order_count = refund_order_count;
    }

    public Integer getTotal_user_online() {
        return total_user_online;
    }

    public void setTotal_user_online(Integer total_user_online) {
        this.total_user_online = total_user_online;
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
        sb.append(", total_product_count=").append(total_product_count);
        sb.append(", total_product_count_in_stock=").append(total_product_count_in_stock);
        sb.append(", total_hot_product_count=").append(total_hot_product_count);
        sb.append(", total_new_product_count=").append(total_new_product_count);
        sb.append(", total_promo_product_count=").append(total_promo_product_count);
        sb.append(", total_order_count=").append(total_order_count);
        sb.append(", pending_delivery_order_count=").append(pending_delivery_order_count);
        sb.append(", pending_pay_order_count=").append(pending_pay_order_count);
        sb.append(", done_order_count=").append(done_order_count);
        sb.append(", refund_order_count=").append(refund_order_count);
        sb.append(", total_user_online=").append(total_user_online);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}