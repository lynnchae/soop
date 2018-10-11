package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.AdminStatistic;
import org.lynn.soop.entity.handwrite.AdminStatisticExtend;

public class AdminStatisticOriginBuilder extends AdminStatistic {

    public static AdminStatisticExtend buildOrigin(AdminStatistic origin) {
        AdminStatisticExtend returnValue=new AdminStatisticExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setTotal_product_count(origin.getTotal_product_count());
        returnValue.setTotal_product_count_in_stock(origin.getTotal_product_count_in_stock());
        returnValue.setTotal_hot_product_count(origin.getTotal_hot_product_count());
        returnValue.setTotal_new_product_count(origin.getTotal_new_product_count());
        returnValue.setTotal_promo_product_count(origin.getTotal_promo_product_count());
        returnValue.setTotal_order_count(origin.getTotal_order_count());
        returnValue.setPending_delivery_order_count(origin.getPending_delivery_order_count());
        returnValue.setPending_pay_order_count(origin.getPending_pay_order_count());
        returnValue.setDone_order_count(origin.getDone_order_count());
        returnValue.setRefund_order_count(origin.getRefund_order_count());
        returnValue.setTotal_user_online(origin.getTotal_user_online());
        return returnValue;
    }
}