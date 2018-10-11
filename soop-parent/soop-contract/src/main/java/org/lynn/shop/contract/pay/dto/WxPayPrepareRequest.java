package org.lynn.soop.contract.pay.dto;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/11/16
 * Time         : 5:41 PM
 * Description  : describe your class here
 */
public class WxPayPrepareRequest {
    private String openid;
    private String orderNo;
    private String spbillCreateIp;
    private int amount;
    private String productInfo;
    //用户授权，获取code
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getOpenid() {
        return openid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
