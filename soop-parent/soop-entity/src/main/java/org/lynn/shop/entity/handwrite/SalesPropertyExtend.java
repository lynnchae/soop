package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.SalesProperty;
import org.lynn.soop.entity.handwrite.originEntityBuilder.SalesPropertyOriginBuilder;

public class SalesPropertyExtend extends SalesProperty {

    public static SalesPropertyExtend generateFromOriginEntity(SalesProperty origin) {
        return SalesPropertyOriginBuilder.buildOrigin(origin);
    }
}