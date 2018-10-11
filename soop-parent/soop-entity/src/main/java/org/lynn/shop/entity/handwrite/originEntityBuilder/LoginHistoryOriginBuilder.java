package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.LoginHistory;
import org.lynn.soop.entity.handwrite.LoginHistoryExtend;

public class LoginHistoryOriginBuilder extends LoginHistory {

    public static LoginHistoryExtend buildOrigin(LoginHistory origin) {
        LoginHistoryExtend returnValue=new LoginHistoryExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setUser_id(origin.getUser_id());
        returnValue.setLogin_name(origin.getLogin_name());
        returnValue.setLogin_ip(origin.getLogin_ip());
        returnValue.setIs_success(origin.getIs_success());
        returnValue.setError_message(origin.getError_message());
        return returnValue;
    }
}