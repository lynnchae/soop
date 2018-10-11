package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.LoginHistory;
import org.lynn.soop.entity.handwrite.originEntityBuilder.LoginHistoryOriginBuilder;

public class LoginHistoryExtend extends LoginHistory {

    public static LoginHistoryExtend generateFromOriginEntity(LoginHistory origin) {
        return LoginHistoryOriginBuilder.buildOrigin(origin);
    }
}