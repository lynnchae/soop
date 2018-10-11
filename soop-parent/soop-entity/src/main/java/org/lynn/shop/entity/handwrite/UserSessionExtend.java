package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.UserSession;
import org.lynn.soop.entity.handwrite.originEntityBuilder.UserSessionOriginBuilder;

public class UserSessionExtend extends UserSession {

    public static UserSessionExtend generateFromOriginEntity(UserSession origin) {
        return UserSessionOriginBuilder.buildOrigin(origin);
    }
}