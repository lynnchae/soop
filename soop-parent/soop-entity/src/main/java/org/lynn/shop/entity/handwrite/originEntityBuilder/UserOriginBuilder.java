package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.User;
import org.lynn.soop.entity.handwrite.UserExtend;

public class UserOriginBuilder extends User {

    public static UserExtend buildOrigin(User origin) {
        UserExtend returnValue=new UserExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setLogin_name(origin.getLogin_name());
        returnValue.setUnique_token(origin.getUnique_token());
        returnValue.setPassword(origin.getPassword());
        returnValue.setUser_name(origin.getUser_name());
        returnValue.setUser_group(origin.getUser_group());
        returnValue.setCurrent_membership_level(origin.getCurrent_membership_level());
        returnValue.setMobile_no(origin.getMobile_no());
        returnValue.setEmail(origin.getEmail());
        returnValue.setCurrent_status(origin.getCurrent_status());
        returnValue.setAvatar(origin.getAvatar());
        returnValue.setId_type(origin.getId_type());
        returnValue.setId_no(origin.getId_no());
        returnValue.setOnline_status(origin.getOnline_status());
        returnValue.setLast_login_time(origin.getLast_login_time());
        returnValue.setOpenid(origin.getOpenid());
        return returnValue;
    }
}