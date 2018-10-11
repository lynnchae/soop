package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.PurchaseProductResult;
import org.lynn.soop.entity.handwrite.PurchaseProductResultExtend;

public class PurchaseProductResultOriginBuilder extends PurchaseProductResult {

    public static PurchaseProductResultExtend buildOrigin(PurchaseProductResult origin) {
        PurchaseProductResultExtend returnValue=new PurchaseProductResultExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setPurchase_product_batch_id(origin.getPurchase_product_batch_id());
        returnValue.setPurchase_product_request(origin.getPurchase_product_request());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setPlan_quantity(origin.getPlan_quantity());
        returnValue.setActual_quantity(origin.getActual_quantity());
        returnValue.setPurchase_price(origin.getPurchase_price());
        returnValue.setExchange_rate(origin.getExchange_rate());
        returnValue.setPurchase_price_in_usd(origin.getPurchase_price_in_usd());
        return returnValue;
    }
}