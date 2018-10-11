package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.PayDetail;
import org.lynn.soop.entity.handwrite.PayDetailExtend;

public class PayDetailOriginBuilder extends PayDetail {

    public static PayDetailExtend buildOrigin(PayDetail origin) {
        PayDetailExtend returnValue=new PayDetailExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setOrder_id(origin.getOrder_id());
        returnValue.setInner_order_no(origin.getInner_order_no());
        returnValue.setProduct_name(origin.getProduct_name());
        returnValue.setAmount(origin.getAmount());
        returnValue.setPay_channel(origin.getPay_channel());
        returnValue.setStatus(origin.getStatus());
        returnValue.setRequest(origin.getRequest());
        returnValue.setResponse(origin.getResponse());
        return returnValue;
    }
}