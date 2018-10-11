package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.User;
import org.lynn.soop.entity.handwrite.originEntityBuilder.UserOriginBuilder;

public class UserExtend extends User {

    public static UserExtend generateFromOriginEntity(User origin) {
        return UserOriginBuilder.buildOrigin(origin);
    }
}