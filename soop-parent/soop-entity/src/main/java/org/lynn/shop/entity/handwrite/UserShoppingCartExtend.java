package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.UsersooppingCart;
import org.lynn.soop.entity.handwrite.originEntityBuilder.UsersooppingCartOriginBuilder;

public class UsersooppingCartExtend extends UsersooppingCart {

    public static UsersooppingCartExtend generateFromOriginEntity(UsersooppingCart origin) {
        return UsersooppingCartOriginBuilder.buildOrigin(origin);
    }
}