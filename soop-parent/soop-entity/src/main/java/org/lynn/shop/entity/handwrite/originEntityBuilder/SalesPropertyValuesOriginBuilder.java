package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.handwrite.SalesPropertyValuesExtend;

public class SalesPropertyValuesOriginBuilder extends SalesPropertyValues {

    public static SalesPropertyValuesExtend buildOrigin(SalesPropertyValues origin) {
        SalesPropertyValuesExtend returnValue=new SalesPropertyValuesExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setSp_id(origin.getSp_id());
        returnValue.setSp_value(origin.getSp_value());
        return returnValue;
    }
}