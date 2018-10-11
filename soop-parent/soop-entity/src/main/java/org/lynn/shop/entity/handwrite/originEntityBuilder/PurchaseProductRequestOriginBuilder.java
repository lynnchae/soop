package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.PurchaseProductRequest;
import org.lynn.soop.entity.handwrite.PurchaseProductRequestExtend;

public class PurchaseProductRequestOriginBuilder extends PurchaseProductRequest {

    public static PurchaseProductRequestExtend buildOrigin(PurchaseProductRequest origin) {
        PurchaseProductRequestExtend returnValue=new PurchaseProductRequestExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setPlan_quantity(origin.getPlan_quantity());
        returnValue.setActual_quantity(origin.getActual_quantity());
        returnValue.setPurchase_product_batch_id(origin.getPurchase_product_batch_id());
        returnValue.setPurchase_time(origin.getPurchase_time());
        return returnValue;
    }
}