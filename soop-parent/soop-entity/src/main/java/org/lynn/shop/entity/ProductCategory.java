package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductCategory implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String category_name;

    private String description;

    private Long parent_category_id;

    private Integer duties;

    private String parent_category_name;

    private Integer discount_standard_amount;

    private Integer discount_percentage;

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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name == null ? null : category_name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getParent_category_id() {
        return parent_category_id;
    }

    public void setParent_category_id(Long parent_category_id) {
        this.parent_category_id = parent_category_id;
    }

    public Integer getDuties() {
        return duties;
    }

    public void setDuties(Integer duties) {
        this.duties = duties;
    }

    public String getParent_category_name() {
        return parent_category_name;
    }

    public void setParent_category_name(String parent_category_name) {
        this.parent_category_name = parent_category_name == null ? null : parent_category_name.trim();
    }

    public Integer getDiscount_standard_amount() {
        return discount_standard_amount;
    }

    public void setDiscount_standard_amount(Integer discount_standard_amount) {
        this.discount_standard_amount = discount_standard_amount;
    }

    public Integer getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(Integer discount_percentage) {
        this.discount_percentage = discount_percentage;
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
        sb.append(", category_name=").append(category_name);
        sb.append(", description=").append(description);
        sb.append(", parent_category_id=").append(parent_category_id);
        sb.append(", duties=").append(duties);
        sb.append(", parent_category_name=").append(parent_category_name);
        sb.append(", discount_standard_amount=").append(discount_standard_amount);
        sb.append(", discount_percentage=").append(discount_percentage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}