package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.GoodsSalesProperty;
import org.lynn.soop.entity.handwrite.GoodsSalesPropertyExtend;

public class GoodsSalesPropertyOriginBuilder extends GoodsSalesProperty {

    public static GoodsSalesPropertyExtend buildOrigin(GoodsSalesProperty origin) {
        GoodsSalesPropertyExtend returnValue=new GoodsSalesPropertyExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setGoods_id(origin.getGoods_id());
        returnValue.setSp_id(origin.getSp_id());
        return returnValue;
    }
}