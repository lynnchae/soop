package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.UserIdInfo;
import org.lynn.soop.entity.handwrite.originEntityBuilder.UserIdInfoOriginBuilder;

public class UserIdInfoExtend extends UserIdInfo {

    public static UserIdInfoExtend generateFromOriginEntity(UserIdInfo origin) {
        return UserIdInfoOriginBuilder.buildOrigin(origin);
    }
}