package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.Stock;
import org.lynn.soop.entity.handwrite.originEntityBuilder.StockOriginBuilder;

public class StockExtend extends Stock {

    public static StockExtend generateFromOriginEntity(Stock origin) {
        return StockOriginBuilder.buildOrigin(origin);
    }
}