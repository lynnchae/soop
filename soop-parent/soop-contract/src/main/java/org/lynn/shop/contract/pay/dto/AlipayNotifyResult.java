package org.lynn.soop.contract.pay.dto;

import com.alibaba.dubbo.common.utils.Assert;

import java.util.Map;

/**
 * Created by chenwen on 5/12/16.
 */
public class AlipayNotifyResult {

    //商户订单号
    private String out_trade_no;

    //支付宝交易号
    private String trade_no;

    //交易状态
    private String trade_status;


    private Map<String, String> rawRequstForm;

    public boolean isSuccess() {
        return TradeStatus.TRADE_SUCCESS.name().equals(trade_status) || TradeStatus.TRADE_FINISHED.name().equals(trade_status);
    }


    /**
     * 默认地,支付宝只有下面2中状态才会回调
     */
    public static enum TradeStatus {
        TRADE_SUCCESS,      //交易成功，且可对该交易做操作，如：多级分润、退款等。
        TRADE_FINISHED      //交易成功且结束，即不可再做任何操作。
    }


    public AlipayNotifyResult(Map<String, String> rawRequstForm) {
        this.rawRequstForm = rawRequstForm;
        Assert.notNull(rawRequstForm, "参数不足");
        out_trade_no = rawRequstForm.get("out_trade_no");
        trade_no = rawRequstForm.get("trade_no");
        trade_status = rawRequstForm.get("trade_status");
        Assert.notNull(out_trade_no, "[商户订单号]为空");
        Assert.notNull(trade_no, "[支付宝交易号]为空");
        Assert.notNull(trade_status, "[交易状态]为空");
    }


    public String getOut_trade_no() {
        return out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public Map<String, String> getRawRequstForm() {
        return rawRequstForm;
    }
}
