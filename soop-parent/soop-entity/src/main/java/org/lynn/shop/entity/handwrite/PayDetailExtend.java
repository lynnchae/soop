package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.PayDetail;
import org.lynn.soop.entity.handwrite.originEntityBuilder.PayDetailOriginBuilder;

public class PayDetailExtend extends PayDetail {

    public static PayDetailExtend generateFromOriginEntity(PayDetail origin) {
        return PayDetailOriginBuilder.buildOrigin(origin);
    }
}