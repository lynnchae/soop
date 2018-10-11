package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.InStockHistory;
import org.lynn.soop.entity.handwrite.InStockHistoryExtend;

public class InStockHistoryOriginBuilder extends InStockHistory {

    public static InStockHistoryExtend buildOrigin(InStockHistory origin) {
        InStockHistoryExtend returnValue=new InStockHistoryExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setQuantity(origin.getQuantity());
        returnValue.setPurchase_time(origin.getPurchase_time());
        returnValue.setPurchase_price(origin.getPurchase_price());
        return returnValue;
    }
}