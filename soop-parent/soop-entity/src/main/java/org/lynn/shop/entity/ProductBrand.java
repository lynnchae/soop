package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductBrand implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String brand_name_cn;

    private String brand_name_en;

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

    public String getBrand_name_cn() {
        return brand_name_cn;
    }

    public void setBrand_name_cn(String brand_name_cn) {
        this.brand_name_cn = brand_name_cn == null ? null : brand_name_cn.trim();
    }

    public String getBrand_name_en() {
        return brand_name_en;
    }

    public void setBrand_name_en(String brand_name_en) {
        this.brand_name_en = brand_name_en == null ? null : brand_name_en.trim();
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
        sb.append(", brand_name_cn=").append(brand_name_cn);
        sb.append(", brand_name_en=").append(brand_name_en);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}