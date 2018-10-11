package org.lynn.soop.contract.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.entity.UserAddress;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by chenwen on 5/08/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddressDto extends BaseDto {

    private Long userId;

    @JsonProperty("name")
    @SerializedName("name")
    private String contactName;

    @JsonProperty("telephone")
    @SerializedName("telephone")
    private String contactPhone;

    private String province;

    private String city;

    @JsonProperty("block")
    @SerializedName("block")
    private String district;

    @JsonProperty("address")
    @SerializedName("address")
    private String detailAddress;

    private String postCode;

    private Boolean isDefault;

    private String frontIdImage;
    private String backIdImage;
    private String idNo;

    private Long user_identify_image_id;
    private Integer province_id;

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Long getUser_identify_image_id() {
        return user_identify_image_id;
    }

    public void setUser_identify_image_id(Long user_identify_image_id) {
        this.user_identify_image_id = user_identify_image_id;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFrontIdImage() {
        return frontIdImage;
    }

    public void setFrontIdImage(String frontIdImage) {
        this.frontIdImage = frontIdImage;
    }

    public String getBackIdImage() {
        return backIdImage;
    }

    public void setBackIdImage(String backIdImage) {
        this.backIdImage = backIdImage;
    }

    public static void fromDTO2PO(UserAddressDto dto, UserAddress po) {
        po.setUser_id(dto.getUserId());
        po.setContact_name(dto.getContactName());
        po.setContact_phone(dto.getContactPhone());
        po.setProvince(dto.getProvince());
        po.setCity(dto.getCity());
        po.setDistrict(dto.getDistrict());
        po.setDetail_address(dto.getDetailAddress());
        po.setPost_code(dto.getPostCode());
        po.setIs_default(dto.getIsDefault());
        po.setId_no_scan_front(dto.getFrontIdImage());
        po.setId_no_scan_back(dto.getBackIdImage());
        po.setId_no_no(dto.getIdNo());
        po.setId(dto.getId());
        po.setUser_identify_image_id(dto.getUser_identify_image_id());
        po.setProvince_id(dto.getProvince_id());
    }

    public static void fromPO2DTO(UserAddress po, UserAddressDto dto) {
        dto.setId(po.getId());
        dto.setUserId(po.getUser_id());
        dto.setContactName(po.getContact_name());
        dto.setContactPhone(po.getContact_phone());
        dto.setProvince(po.getProvince());
        dto.setCity(po.getCity());
        dto.setDistrict(po.getDistrict());
        dto.setDetailAddress(po.getDetail_address());
        dto.setPostCode(po.getPost_code());
        dto.setIsDefault(po.getIs_default());
        dto.setFrontIdImage(po.getId_no_scan_front());
        dto.setBackIdImage(po.getId_no_scan_back());
        dto.setIdNo(po.getId_no_no());
        dto.setId(po.getId());
        dto.setUser_identify_image_id(po.getUser_identify_image_id());
        dto.setProvince_id(po.getProvince_id());
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonProperty("name")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
