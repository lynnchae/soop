package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.UserSession;
import org.lynn.soop.entity.handwrite.UserSessionExtend;

public class UserSessionOriginBuilder extends UserSession {

    public static UserSessionExtend buildOrigin(UserSession origin) {
        UserSessionExtend returnValue=new UserSessionExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setSession_id(origin.getSession_id());
        returnValue.setUser_id(origin.getUser_id());
        returnValue.setIs_valid(origin.getIs_valid());
        returnValue.setExpired_at(origin.getExpired_at());
        return returnValue;
    }
}