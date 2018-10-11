package org.lynn.soop.contract.pay.dto;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.contract.pay.dto
 * Description :
 * Author : cailinfeng
 * Date : 2016/8/2
 */
public class UnionWapPayRequest {

    private String billNo;

    private Long money;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
