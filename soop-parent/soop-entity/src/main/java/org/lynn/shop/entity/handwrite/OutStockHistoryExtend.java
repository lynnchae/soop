package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.OutStockHistory;
import org.lynn.soop.entity.handwrite.originEntityBuilder.OutStockHistoryOriginBuilder;

public class OutStockHistoryExtend extends OutStockHistory {

    public static OutStockHistoryExtend generateFromOriginEntity(OutStockHistory origin) {
        return OutStockHistoryOriginBuilder.buildOrigin(origin);
    }
}