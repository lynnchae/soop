package org.lynn.soop.contract.pay.dto;

import org.lynn.soop.util.DataHelper;
import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/11/16
 * Time         : 5:03 PM
 * Description  : describe your class here
 */
public class WechatPayInfo {
    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    private String deviceInfo;
    /**
     * 商品或支付单简要描述
     */
    private String body;
    /**
     * 商品名称明细列表
     */
    private String detail;
    /**
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String attach;
    /**
     * 订单总金额，单位为元，详见支付金额
     */
    private int totalFee;
    /**
     * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    private String spbillCreateIp;
    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
     */
    private String timeStart;
    /**
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010
     * 注意：最短失效时间间隔必须大于5分钟
     */
    private String timeExpire;
    /**
     * 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     */
    private String goodsTag;
    /**
     * 取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
     */
    private String tradeType;
    /**
     * trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义
     */
    private String productId;
    /**
     * no_credit--指定不能使用信用卡支付
     */
    private String limitPay;
    /**
     * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
     */
    private String openid;

    private String orderNo;

    private String callbackUrl;

    public String getOrderNo() {
        return orderNo;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public WechatPayInfo() {
        this.deviceInfo = "WEB";
        this.attach = "Gougou pay";
        this.timeStart = DataHelper.dateFormat(DateTime.now(), "yyyyMMddHHmmss");
        this.timeExpire = DataHelper.dateFormat(DateTime.now().plusHours(24), "yyyyMMddHHmmss");
        this.tradeType = "JSAPI";
    }

    public static WechatPayInfo build(String body, String detail, int totalFee, String spbillCreateIp, String openid, String orderNo, String callbackUrl) {
        WechatPayInfo toReturn = new WechatPayInfo();
        toReturn.body = body;
        toReturn.detail = detail;
        toReturn.totalFee = totalFee;
        toReturn.spbillCreateIp = spbillCreateIp;
        toReturn.openid = openid;
        toReturn.orderNo = orderNo;
        toReturn.callbackUrl = callbackUrl;
        return toReturn;
    }


    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
