package org.lynn.soop.contract.order.dto;

public enum OrderStatus {
    NEW,
    PAY_SUBMIT, //已经提交支付
    PAYED,
    MATCHED, //已配货
    PAY_FAILED,
    DELIVERED,
    COMPLETED,
    CANCELED
}
