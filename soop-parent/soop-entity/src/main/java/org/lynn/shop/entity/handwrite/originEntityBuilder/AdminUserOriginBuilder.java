package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.AdminUser;
import org.lynn.soop.entity.handwrite.AdminUserExtend;

public class AdminUserOriginBuilder extends AdminUser {

    public static AdminUserExtend buildOrigin(AdminUser origin) {
        AdminUserExtend returnValue=new AdminUserExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setLogin_account(origin.getLogin_account());
        returnValue.setPassword(origin.getPassword());
        returnValue.setRole(origin.getRole());
        returnValue.setSession_id(origin.getSession_id());
        returnValue.setSession_expired(origin.getSession_expired());
        return returnValue;
    }
}