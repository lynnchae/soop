package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class UserAddress implements Serializable {

    private String flag;

    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private Long user_id;

    private String contact_name;

    private String contact_phone;

    private String province;

    private String city;

    private String district;

    private String detail_address;

    private String post_code;

    private String id_no_no;

    private String id_no_scan_front;

    private String id_no_scan_back;

    private Boolean is_default;

    private Long user_identify_image_id;

    private Integer province_id;

    private static final long serialVersionUID = 1L;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

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

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone == null ? null : contact_phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address == null ? null : detail_address.trim();
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code == null ? null : post_code.trim();
    }

    public String getId_no_no() {
        return id_no_no;
    }

    public void setId_no_no(String id_no_no) {
        this.id_no_no = id_no_no == null ? null : id_no_no.trim();
    }

    public String getId_no_scan_front() {
        return id_no_scan_front;
    }

    public void setId_no_scan_front(String id_no_scan_front) {
        this.id_no_scan_front = id_no_scan_front == null ? null : id_no_scan_front.trim();
    }

    public String getId_no_scan_back() {
        return id_no_scan_back;
    }

    public void setId_no_scan_back(String id_no_scan_back) {
        this.id_no_scan_back = id_no_scan_back == null ? null : id_no_scan_back.trim();
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    public Long getUser_identify_image_id() {
        return user_identify_image_id;
    }

    public void setUser_identify_image_id(Long user_identify_image_id) {
        this.user_identify_image_id = user_identify_image_id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
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
        sb.append(", contact_name=").append(contact_name);
        sb.append(", contact_phone=").append(contact_phone);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", detail_address=").append(detail_address);
        sb.append(", post_code=").append(post_code);
        sb.append(", id_no_no=").append(id_no_no);
        sb.append(", id_no_scan_front=").append(id_no_scan_front);
        sb.append(", id_no_scan_back=").append(id_no_scan_back);
        sb.append(", is_default=").append(is_default);
        sb.append(", user_identify_image_id=").append(user_identify_image_id);
        sb.append(", province_id=").append(province_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}