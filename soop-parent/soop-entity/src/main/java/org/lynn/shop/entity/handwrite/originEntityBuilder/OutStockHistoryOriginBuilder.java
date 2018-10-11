package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.OutStockHistory;
import org.lynn.soop.entity.handwrite.OutStockHistoryExtend;

public class OutStockHistoryOriginBuilder extends OutStockHistory {

    public static OutStockHistoryExtend buildOrigin(OutStockHistory origin) {
        OutStockHistoryExtend returnValue=new OutStockHistoryExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setQuantity(origin.getQuantity());
        returnValue.setProduct_price(origin.getProduct_price());
        return returnValue;
    }
}