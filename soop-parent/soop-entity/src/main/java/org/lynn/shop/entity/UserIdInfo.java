package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class UserIdInfo implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Long user_id;

    private String id_front_image;

    private String id_back_image;

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getId_front_image() {
        return id_front_image;
    }

    public void setId_front_image(String id_front_image) {
        this.id_front_image = id_front_image == null ? null : id_front_image.trim();
    }

    public String getId_back_image() {
        return id_back_image;
    }

    public void setId_back_image(String id_back_image) {
        this.id_back_image = id_back_image == null ? null : id_back_image.trim();
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
        sb.append(", user_id=").append(user_id);
        sb.append(", id_front_image=").append(id_front_image);
        sb.append(", id_back_image=").append(id_back_image);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}