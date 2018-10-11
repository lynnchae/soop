package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.PayConfig;
import org.lynn.soop.entity.handwrite.PayConfigExtend;

public class PayConfigOriginBuilder extends PayConfig {

    public static PayConfigExtend buildOrigin(PayConfig origin) {
        PayConfigExtend returnValue=new PayConfigExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setPay_channel(origin.getPay_channel());
        returnValue.setDescription(origin.getDescription());
        returnValue.setIs_valid(origin.getIs_valid());
        return returnValue;
    }
}