package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.UsersooppingCart;
import org.lynn.soop.entity.handwrite.UsersooppingCartExtend;

public class UsersooppingCartOriginBuilder extends UsersooppingCart {

    public static UsersooppingCartExtend buildOrigin(UsersooppingCart origin) {
        UsersooppingCartExtend returnValue=new UsersooppingCartExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setUser_id(origin.getUser_id());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setProduct_price(origin.getProduct_price());
        returnValue.setQuantity(origin.getQuantity());
        returnValue.setDate_expired(origin.getDate_expired());
        return returnValue;
    }
}