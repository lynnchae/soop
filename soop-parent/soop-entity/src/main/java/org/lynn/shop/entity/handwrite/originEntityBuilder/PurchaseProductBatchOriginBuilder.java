package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.PurchaseProductBatch;
import org.lynn.soop.entity.handwrite.PurchaseProductBatchExtend;

public class PurchaseProductBatchOriginBuilder extends PurchaseProductBatch {

    public static PurchaseProductBatchExtend buildOrigin(PurchaseProductBatch origin) {
        PurchaseProductBatchExtend returnValue=new PurchaseProductBatchExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setPurchase_product_batch_id(origin.getPurchase_product_batch_id());
        returnValue.setPlan_product_count(origin.getPlan_product_count());
        returnValue.setActual_product_count(origin.getActual_product_count());
        returnValue.setPlan_total_item_count(origin.getPlan_total_item_count());
        returnValue.setActual_total_item_count(origin.getActual_total_item_count());
        returnValue.setProgress_percentage(origin.getProgress_percentage());
        returnValue.setPurchase_time(origin.getPurchase_time());
        returnValue.setStart_time(origin.getStart_time());
        returnValue.setEnd_time(origin.getEnd_time());
        return returnValue;
    }
}