package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.InStockHistory;
import org.lynn.soop.entity.handwrite.originEntityBuilder.InStockHistoryOriginBuilder;

public class InStockHistoryExtend extends InStockHistory {

    public static InStockHistoryExtend generateFromOriginEntity(InStockHistory origin) {
        return InStockHistoryOriginBuilder.buildOrigin(origin);
    }
}