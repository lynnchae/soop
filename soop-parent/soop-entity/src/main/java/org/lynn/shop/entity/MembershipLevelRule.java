package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class MembershipLevelRule implements Serializable {
    private Long id;

    private String name;

    private String level;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Integer point_floor;

    private Integer point_ceiling;

    private Integer discount_percentage;

    private String user_group;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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

    public Integer getPoint_floor() {
        return point_floor;
    }

    public void setPoint_floor(Integer point_floor) {
        this.point_floor = point_floor;
    }

    public Integer getPoint_ceiling() {
        return point_ceiling;
    }

    public void setPoint_ceiling(Integer point_ceiling) {
        this.point_ceiling = point_ceiling;
    }

    public Integer getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(Integer discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public String getUser_group() {
        return user_group;
    }

    public void setUser_group(String user_group) {
        this.user_group = user_group == null ? null : user_group.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", date_created=").append(date_created);
        sb.append(", created_by=").append(created_by);
        sb.append(", date_updated=").append(date_updated);
        sb.append(", updated_by=").append(updated_by);
        sb.append(", point_floor=").append(point_floor);
        sb.append(", point_ceiling=").append(point_ceiling);
        sb.append(", discount_percentage=").append(discount_percentage);
        sb.append(", user_group=").append(user_group);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}