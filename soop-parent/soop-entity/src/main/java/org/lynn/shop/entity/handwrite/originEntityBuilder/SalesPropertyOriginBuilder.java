package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.SalesProperty;
import org.lynn.soop.entity.handwrite.SalesPropertyExtend;

public class SalesPropertyOriginBuilder extends SalesProperty {

    public static SalesPropertyExtend buildOrigin(SalesProperty origin) {
        SalesPropertyExtend returnValue=new SalesPropertyExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setSp_name(origin.getSp_name());
        returnValue.setGoods_id(origin.getGoods_id());
        return returnValue;
    }
}