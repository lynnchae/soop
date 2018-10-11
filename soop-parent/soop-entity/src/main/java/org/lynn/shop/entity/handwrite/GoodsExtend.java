package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.Goods;
import org.lynn.soop.entity.handwrite.originEntityBuilder.GoodsOriginBuilder;

public class GoodsExtend extends Goods {

    public static GoodsExtend generateFromOriginEntity(Goods origin) {
        return GoodsOriginBuilder.buildOrigin(origin);
    }
}