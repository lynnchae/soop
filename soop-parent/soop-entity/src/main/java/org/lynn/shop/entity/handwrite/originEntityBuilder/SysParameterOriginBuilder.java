package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.SysParameter;
import org.lynn.soop.entity.handwrite.SysParameterExtend;

public class SysParameterOriginBuilder extends SysParameter {

    public static SysParameterExtend buildOrigin(SysParameter origin) {
        SysParameterExtend returnValue=new SysParameterExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setParam_key(origin.getParam_key());
        returnValue.setParam_value(origin.getParam_value());
        returnValue.setDescription(origin.getDescription());
        return returnValue;
    }
}