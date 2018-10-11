package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.PayConfig;
import org.lynn.soop.entity.handwrite.originEntityBuilder.PayConfigOriginBuilder;

public class PayConfigExtend extends PayConfig {

    public static PayConfigExtend generateFromOriginEntity(PayConfig origin) {
        return PayConfigOriginBuilder.buildOrigin(origin);
    }
}