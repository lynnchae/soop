package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.SysParameter;
import org.lynn.soop.entity.handwrite.originEntityBuilder.SysParameterOriginBuilder;

public class SysParameterExtend extends SysParameter {

    public static SysParameterExtend generateFromOriginEntity(SysParameter origin) {
        return SysParameterOriginBuilder.buildOrigin(origin);
    }
}