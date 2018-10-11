package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.AdminStatistic;
import org.lynn.soop.entity.handwrite.originEntityBuilder.AdminStatisticOriginBuilder;

public class AdminStatisticExtend extends AdminStatistic {

    public static AdminStatisticExtend generateFromOriginEntity(AdminStatistic origin) {
        return AdminStatisticOriginBuilder.buildOrigin(origin);
    }
}