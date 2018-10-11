package org.lynn.soop.contract.pay.dto;

public class WxNotifyResult {
    private String out_trade_no;
    private boolean isSuccess;
    private String rawRequst;


    public static WxNotifyResult build(String request) {
        WxNotifyResult wxNotifyResult = new WxNotifyResult();
        wxNotifyResult.setRawRequst(request);
        return wxNotifyResult;
    }

    public String getRawRequst() {
        return rawRequst;
    }

    public void setRawRequst(String rawRequst) {
        this.rawRequst = rawRequst;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
