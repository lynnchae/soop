package org.lynn.soop.contract.member.dto;

import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.entity.User;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by chenwen on 5/09/16.
 */
public class UserDto extends BaseDto {

    @JsonProperty("userId")
    private String loginName;

    private String uniqueToken;

    private String password;

    private String userName;

    private String userGroup;

    private String currentMembershipLevel;

    private String mobileNo;

    private String email;

    private String currentStatus;

    private String avatar;

    private String idType;

    private String idNo;

    private Boolean onlineStatus;

    private Date lastLoginTime;


    public static void fromDTO2PO(UserDto dto, User po) {
        po.setLogin_name(dto.getLoginName());
        po.setUnique_token(dto.getUniqueToken());
        po.setPassword(dto.getPassword());
        po.setUser_name(dto.getUserName());
        po.setUser_group(dto.getUserGroup());
        po.setCurrent_membership_level(dto.getCurrentMembershipLevel());
        po.setMobile_no(dto.getMobileNo());
        po.setEmail(dto.getEmail());
        po.setCurrent_status(dto.getCurrentStatus());
        po.setAvatar(dto.getAvatar());
        po.setId_type(dto.getIdType());
        po.setId_no(dto.getIdNo());
        po.setOnline_status(dto.getOnlineStatus());
        po.setLast_login_time(dto.getLastLoginTime());
    }

    public static void fromPO2DTO(User po, UserDto dto) {
        dto.setLoginName(po.getLogin_name());
        dto.setUniqueToken(po.getUnique_token());
        dto.setPassword(po.getPassword());
        dto.setUserName(po.getUser_name());
        dto.setUserGroup(po.getUser_group());
        dto.setCurrentMembershipLevel(po.getCurrent_membership_level());
        dto.setMobileNo(po.getMobile_no());
        dto.setEmail(po.getEmail());
        dto.setCurrentStatus(po.getCurrent_status());
        dto.setAvatar(po.getAvatar());
        dto.setIdType(po.getId_type());
        dto.setIdNo(po.getId_no());
        dto.setOnlineStatus(po.getOnline_status());
        dto.setLastLoginTime(po.getLast_login_time());
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUniqueToken() {
        return uniqueToken;
    }

    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getCurrentMembershipLevel() {
        return currentMembershipLevel;
    }

    public void setCurrentMembershipLevel(String currentMembershipLevel) {
        this.currentMembershipLevel = currentMembershipLevel;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
