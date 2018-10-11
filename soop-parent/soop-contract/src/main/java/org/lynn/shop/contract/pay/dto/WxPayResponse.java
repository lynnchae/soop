package org.lynn.soop.contract.pay.dto;

import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WxPayResponse {
    private String appId;
    private String timeStamp;
    private String nonceStr;
    @JsonProperty("package")
    private String packageParam;
    private String signType;
    private String paySign;

    public static WxPayResponse build(String appId, String prepareId) {
        WxPayResponse toReturn = new WxPayResponse();
        toReturn.appId = appId;
        toReturn.timeStamp = String.valueOf(new Date().getTime()).substring(0, 10);
        toReturn.nonceStr = RandomStringUtils.randomAlphanumeric(32);
        toReturn.packageParam = "prepay_id=" + prepareId;
        toReturn.signType = "MD5";
        return toReturn;
    }

    public Map<String, String> toMap() {
        Map<String, String> toReturn = new HashMap<String, String>();
        toReturn.put("appId", appId);
        toReturn.put("timeStamp", timeStamp);
        toReturn.put("nonceStr", nonceStr);
        toReturn.put("package", packageParam);
        toReturn.put("signType", signType);
        return toReturn;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public void setPackageParam(String packageParam) {
        this.packageParam = packageParam;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getAppId() {
        return appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getPackageParam() {
        return packageParam;
    }

    public String getSignType() {
        return signType;
    }

    public String getPaySign() {
        return paySign;
    }
}
