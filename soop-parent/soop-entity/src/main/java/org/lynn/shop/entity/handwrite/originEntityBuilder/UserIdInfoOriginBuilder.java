package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.UserIdInfo;
import org.lynn.soop.entity.handwrite.UserIdInfoExtend;

public class UserIdInfoOriginBuilder extends UserIdInfo {

    public static UserIdInfoExtend buildOrigin(UserIdInfo origin) {
        UserIdInfoExtend returnValue=new UserIdInfoExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setUser_id(origin.getUser_id());
        returnValue.setId_front_image(origin.getId_front_image());
        returnValue.setId_back_image(origin.getId_back_image());
        return returnValue;
    }
}