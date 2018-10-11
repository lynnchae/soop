package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.Stock;
import org.lynn.soop.entity.handwrite.StockExtend;

public class StockOriginBuilder extends Stock {

    public static StockExtend buildOrigin(Stock origin) {
        StockExtend returnValue=new StockExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setQuantity(origin.getQuantity());
        return returnValue;
    }
}