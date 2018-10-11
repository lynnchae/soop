package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String login_name;

    private String unique_token;

    private String password;

    private String user_name;

    private String user_group;

    private String current_membership_level;

    private String mobile_no;

    private String email;

    private String current_status;

    private String avatar;

    private String id_type;

    private String id_no;

    private Boolean online_status;

    private Date last_login_time;

    private String openid;

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

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? null : login_name.trim();
    }

    public String getUnique_token() {
        return unique_token;
    }

    public void setUnique_token(String unique_token) {
        this.unique_token = unique_token == null ? null : unique_token.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_group() {
        return user_group;
    }

    public void setUser_group(String user_group) {
        this.user_group = user_group == null ? null : user_group.trim();
    }

    public String getCurrent_membership_level() {
        return current_membership_level;
    }

    public void setCurrent_membership_level(String current_membership_level) {
        this.current_membership_level = current_membership_level == null ? null : current_membership_level.trim();
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no == null ? null : mobile_no.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status == null ? null : current_status.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type == null ? null : id_type.trim();
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no == null ? null : id_no.trim();
    }

    public Boolean getOnline_status() {
        return online_status;
    }

    public void setOnline_status(Boolean online_status) {
        this.online_status = online_status;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
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
        sb.append(", login_name=").append(login_name);
        sb.append(", unique_token=").append(unique_token);
        sb.append(", password=").append(password);
        sb.append(", user_name=").append(user_name);
        sb.append(", user_group=").append(user_group);
        sb.append(", current_membership_level=").append(current_membership_level);
        sb.append(", mobile_no=").append(mobile_no);
        sb.append(", email=").append(email);
        sb.append(", current_status=").append(current_status);
        sb.append(", avatar=").append(avatar);
        sb.append(", id_type=").append(id_type);
        sb.append(", id_no=").append(id_no);
        sb.append(", online_status=").append(online_status);
        sb.append(", last_login_time=").append(last_login_time);
        sb.append(", openid=").append(openid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}