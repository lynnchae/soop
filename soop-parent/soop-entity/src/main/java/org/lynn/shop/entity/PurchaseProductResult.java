package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class PurchaseProductResult implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Long purchase_product_batch_id;

    private Long purchase_product_request;

    private Long product_id;

    private Integer plan_quantity;

    private Integer actual_quantity;

    private Integer purchase_price;

    private Integer exchange_rate;

    private Integer purchase_price_in_usd;

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

    public Long getPurchase_product_request() {
        return purchase_product_request;
    }

    public void setPurchase_product_request(Long purchase_product_request) {
        this.purchase_product_request = purchase_product_request;
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

    public Integer getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Integer purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Integer getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(Integer exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public Integer getPurchase_price_in_usd() {
        return purchase_price_in_usd;
    }

    public void setPurchase_price_in_usd(Integer purchase_price_in_usd) {
        this.purchase_price_in_usd = purchase_price_in_usd;
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
        sb.append(", purchase_product_request=").append(purchase_product_request);
        sb.append(", product_id=").append(product_id);
        sb.append(", plan_quantity=").append(plan_quantity);
        sb.append(", actual_quantity=").append(actual_quantity);
        sb.append(", purchase_price=").append(purchase_price);
        sb.append(", exchange_rate=").append(exchange_rate);
        sb.append(", purchase_price_in_usd=").append(purchase_price_in_usd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}