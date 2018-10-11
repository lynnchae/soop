package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.handwrite.originEntityBuilder.SalesPropertyValuesOriginBuilder;

public class SalesPropertyValuesExtend extends SalesPropertyValues {

    public static SalesPropertyValuesExtend generateFromOriginEntity(SalesPropertyValues origin) {
        return SalesPropertyValuesOriginBuilder.buildOrigin(origin);
    }
}