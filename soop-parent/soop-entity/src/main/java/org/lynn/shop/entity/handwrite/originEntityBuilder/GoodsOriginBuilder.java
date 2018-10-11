package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.Goods;
import org.lynn.soop.entity.handwrite.GoodsExtend;

public class GoodsOriginBuilder extends Goods {

    public static GoodsExtend buildOrigin(Goods origin) {
        GoodsExtend returnValue=new GoodsExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setName(origin.getName());
        return returnValue;
    }
}