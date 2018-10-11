package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.AdminUser;
import org.lynn.soop.entity.handwrite.originEntityBuilder.AdminUserOriginBuilder;

public class AdminUserExtend extends AdminUser {

    public static AdminUserExtend generateFromOriginEntity(AdminUser origin) {
        return AdminUserOriginBuilder.buildOrigin(origin);
    }
}