package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductPrice implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Long product_id;

    private String product_name_cn;

    private String source;

    private Integer overseas_price;

    private Integer domestic_price;

    private Integer product_price;

    private Long source_id;

    private Integer price_on_sale;

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

    public String getProduct_name_cn() {
        return product_name_cn;
    }

    public void setProduct_name_cn(String product_name_cn) {
        this.product_name_cn = product_name_cn == null ? null : product_name_cn.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getOverseas_price() {
        return overseas_price;
    }

    public void setOverseas_price(Integer overseas_price) {
        this.overseas_price = overseas_price;
    }

    public Integer getDomestic_price() {
        return domestic_price;
    }

    public void setDomestic_price(Integer domestic_price) {
        this.domestic_price = domestic_price;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public Long getSource_id() {
        return source_id;
    }

    public void setSource_id(Long source_id) {
        this.source_id = source_id;
    }

    public Integer getPrice_on_sale() {
        return price_on_sale;
    }

    public void setPrice_on_sale(Integer price_on_sale) {
        this.price_on_sale = price_on_sale;
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
        sb.append(", product_name_cn=").append(product_name_cn);
        sb.append(", source=").append(source);
        sb.append(", overseas_price=").append(overseas_price);
        sb.append(", domestic_price=").append(domestic_price);
        sb.append(", product_price=").append(product_price);
        sb.append(", source_id=").append(source_id);
        sb.append(", price_on_sale=").append(price_on_sale);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}