package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class AdminUser implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String login_account;

    private String password;

    private String role;

    private String session_id;

    private Date session_expired;

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

    public String getLogin_account() {
        return login_account;
    }

    public void setLogin_account(String login_account) {
        this.login_account = login_account == null ? null : login_account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id == null ? null : session_id.trim();
    }

    public Date getSession_expired() {
        return session_expired;
    }

    public void setSession_expired(Date session_expired) {
        this.session_expired = session_expired;
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
        sb.append(", login_account=").append(login_account);
        sb.append(", password=").append(password);
        sb.append(", role=").append(role);
        sb.append(", session_id=").append(session_id);
        sb.append(", session_expired=").append(session_expired);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}