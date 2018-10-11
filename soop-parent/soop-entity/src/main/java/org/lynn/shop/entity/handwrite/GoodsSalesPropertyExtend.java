package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.GoodsSalesProperty;
import org.lynn.soop.entity.handwrite.originEntityBuilder.GoodsSalesPropertyOriginBuilder;

public class GoodsSalesPropertyExtend extends GoodsSalesProperty {

    public static GoodsSalesPropertyExtend generateFromOriginEntity(GoodsSalesProperty origin) {
        return GoodsSalesPropertyOriginBuilder.buildOrigin(origin);
    }
}