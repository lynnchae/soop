package org.lynn.soop.business.pay;

import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.pay.dto.WechatPayInfo;
import org.lynn.soop.util.XmlUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/11/16
 * Time         : 6:28 PM
 * Description  : describe your class here
 */
public class SpiHelper {
    public final static String KEY_ORDER_STATUS = "orderStatus";
    public final static String KEY_ERROR_CODE = "errorCode";
    public final static String KEY_ERROR_MSG = "errorMsg";
    public final static String KEY_TRADE_TYPE = "tradeType";
    public final static String KEY_PREPAY_ID = "prepayId";
    public final static String KEY_CODE_URL = "codeUrl";
    public final static String KEY_OUT_TRADE_NO = "out_trade_no";
    public final static String KEY_PAY_TIME = "time_end";
    public final static String KEY_OPEN_ID = "openid";
    public final static String KEY_SUCCESS_FEE = "successFee";
    public final static String KEY_COUPON_FEE = "couponFee ";
    public final static String KEY_CASH_FEE = "cashFee";
    public final static String KEY_BANK_TYPE = "bankType";

    private final static String ORDER_QUERY_ORDER_NOT_EXIST = "ORDERNOTEXIST";
    private final static String ORDER_QUERY_SYSTEM_ERROR = "SYSTEMERROR ";

    private final static int BILL_DETAIL_DATA_COLUMN_SIZE = 24;
    private final static int BILL_SUMMARY_DATA_COLUMN_SIZE = 5;

    public static final String REQUEST_SUCCESS = "SUCCESS";
    public static final String BIZ_SUCCESS = "SUCCESS";

    public static final BigDecimal FEE_MULTIPLE_100 = new BigDecimal("100");
    public static final String STR_CHARSET_UTF8 = "UTF-8";

    public static final Charset CHARSET_UTF8 = Charset.forName(STR_CHARSET_UTF8);

    private static final Logger logger = Logger.getLogger(SpiHelper.class);

    public static Map<String, String> generateOrderReq(WechatPayInfo orderDTO, String appId, String merchantNo) {
        Map<String, String> req = new HashMap<String, String>();

        req.put("appid", appId);
        req.put("mch_id", merchantNo);
        req.put("device_info", orderDTO.getDeviceInfo());
        req.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));
        req.put("body", orderDTO.getBody());
        req.put("detail", orderDTO.getDetail());
        req.put("attach", orderDTO.getAttach());
        req.put("out_trade_no", orderDTO.getOrderNo());
        req.put("fee_type", "CNY");
        req.put("total_fee", String.valueOf(orderDTO.getTotalFee()));
        req.put("spbill_create_ip", orderDTO.getSpbillCreateIp());
        req.put("time_start", orderDTO.getTimeStart());
        req.put("time_expire", orderDTO.getTimeExpire());
        req.put("goods_tag", orderDTO.getGoodsTag());
        req.put("notify_url", orderDTO.getCallbackUrl());
        req.put("trade_type", orderDTO.getTradeType());
        req.put("product_id", orderDTO.getProductId());
        req.put("limit_pay", orderDTO.getLimitPay());
        req.put("openid", orderDTO.getOpenid());

        return req;
    }

    public static Map<String, String> generateOrderQueryReq(String orderNo, String appId, String merchantNo) {
        Map<String, String> req = new HashMap<String, String>();

        req.put("appid", appId);
        req.put("mch_id", merchantNo);
        req.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));
        req.put("transaction_id", "");//微信订单号 优先使用
        req.put("out_trade_no", orderNo);

        return req;
    }


    public static BaseResponse handleOrderResp(String resp, String appKey) {

        Map<String, String> result = new HashMap<String, String>();

        Map<String, Object> respMap = XmlUtil.parseXml(resp, CHARSET_UTF8, Collections.<String>emptyList());

        @SuppressWarnings("unchecked")
        Map<String, String> resultMap = (Map<String, String>) respMap.get("xml");

        String requestStatus = resultMap.get("return_code");
        String requestMsg = resultMap.get("return_msg");

        if (!REQUEST_SUCCESS.equals(requestStatus)) {
            return BaseResponse.buildClientErrorResponse(requestMsg);
        }

        Map<String, String> paramForSign = new HashMap<String, String>();

        for (Map.Entry<String, String> e : resultMap.entrySet()) {
            paramForSign.put(e.getKey(), e.getValue());
        }
        String sign = paramForSign.remove("sign");
        String actualSign = EncryptUtil.wechatSignByMd5(paramForSign, appKey);
        if (!sign.equals(actualSign)) {
            String message = "order request verify sign failed!! expectedSign:" + sign + " actualSign:" + actualSign + " signObject:" + paramForSign;
            logger.error(message);
            return BaseResponse.buildServerErrorResponse(message);
        }

        String appid = resultMap.get("appid");
        String merchantNo = resultMap.get("mch_id");
        String deviceInfo = resultMap.get("device_info");
        String nonceStr = resultMap.get("nonce_str");
        String bizStatus = resultMap.get("result_code");
        String bizErrorCode = resultMap.get("err_code");
        String bizErrorMsg = resultMap.get("err_code_des");
        String tradeType = "";
        String prepayId = resultMap.get("prepay_id");
        String codeUrl = "";

        BaseResponse toReturn;
        if (BIZ_SUCCESS.equals(bizStatus)) {
            toReturn = BaseResponse.buildSuccessResponse(prepayId);
        } else {
            logger.error("error in handle wx order response:" + bizErrorCode);
            toReturn = BaseResponse.buildServerErrorResponse(bizErrorMsg);
        }
        result.put(KEY_TRADE_TYPE, tradeType);
        result.put(KEY_PREPAY_ID, prepayId);
        result.put(KEY_CODE_URL, codeUrl);

        return toReturn;
    }

    public static BaseResponse handleOrderQueryResp(String resp, String appKey) {

        Map<String, String> result = new HashMap<String, String>();

        Map<String, Object> respMap = XmlUtil.parseXml(resp, CHARSET_UTF8, Collections.<String>emptyList());

        @SuppressWarnings("unchecked")
        Map<String, String> resultMap = (Map<String, String>) respMap.get("xml");

        String requestStatus = resultMap.get("return_code");
        String requestMsg = resultMap.get("return_msg");

        if (!REQUEST_SUCCESS.equals(requestStatus)) {

            return BaseResponse.buildClientErrorResponse(requestMsg);
        }

        Map<String, String> paramForSign = new HashMap<String, String>();

        for (Map.Entry<String, String> e : resultMap.entrySet()) {
            paramForSign.put(e.getKey(), e.getValue());
        }
        String sign = paramForSign.remove("sign");

        String actualSign = EncryptUtil.wechatSignByMd5(paramForSign, appKey);
        if (!sign.equals(actualSign)) {
            String message = "order request verify sign failed!! expectedSign:" + sign + " actualSign:" + actualSign + " signObject:" + paramForSign;
            logger.error(message);
            return BaseResponse.buildServerErrorResponse(message);
        }

        String bizStatus = resultMap.get("result_code");
        String bizErrorCode = resultMap.get("err_code");
        String bizErrorMsg = resultMap.get("err_code_des");
        String trxStatus = "";
        String trxDesc = "";
        String payTime = "";
        String prepayId = "";
        String lufaxRedId = "";
        String openId = "";
        String successFee = "";
        String cashFee = "";
        String couponFee = "";
        String bankType = "";

        //业务失败指 接口调用失败，执行接口业务就失败了，还没有到具体验证参数
        BaseResponse toReturn;
        if (!BIZ_SUCCESS.equals(bizStatus)) {
            if (ORDER_QUERY_ORDER_NOT_EXIST.equals(bizErrorCode)) {
                toReturn = BaseResponse.buildServerErrorResponse("NON_EXISTENT");
            } else if (ORDER_QUERY_SYSTEM_ERROR.equals(bizErrorCode)) {
                toReturn = BaseResponse.buildServerErrorResponse("PROCESSING");
            } else {
                toReturn = BaseResponse.buildServerErrorResponse("PROCESSING");
            }

            return toReturn;
        }
        trxStatus = resultMap.get("trade_state");
        trxDesc = resultMap.get("trade_state_desc");
        prepayId = resultMap.get("transaction_id");
        lufaxRedId = resultMap.get("out_trade_no");
        payTime = resultMap.get("time_end");
        openId = resultMap.get("openid");
        successFee = resultMap.get("total_fee");
        cashFee = resultMap.get("cash_fee");
        couponFee = resultMap.get("coupon_fee");
        bankType = resultMap.get("bank_type");

        if (OrderQueryTrxStatus.isPaySuccess(trxStatus)) {
            toReturn = BaseResponse.buildSuccessResponse(lufaxRedId);
        } else if (OrderQueryTrxStatus.isPayFail(trxStatus)) {
            toReturn = BaseResponse.buildServerErrorResponse(lufaxRedId);
        } else {
            toReturn = BaseResponse.buildResponse(999, lufaxRedId);
        }
        return toReturn;
    }


    private static String trimLastComma(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        if (str.endsWith(",")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static enum OrderQueryTrxStatus {
        SUCCESS("支付成功"),
        REFUND("转入退款"),
        NOTPAY("未支付"),
        CLOSED("已关闭"),
        REVOKED("已撤销（刷卡支付） "),
        USERPAYING("用户支付中"),
        PAYERROR("支付失败(其他原因，如银行返回失败)");

        private String desc;

        OrderQueryTrxStatus(String desc) {
            this.desc = desc;
        }

        public static boolean isPaySuccess(String trxStatus) {
            return SUCCESS.name().equals(trxStatus);
        }

        public static boolean isPayFail(String trxStatus) {
            return Arrays.asList(REFUND.name(), CLOSED.name(), REVOKED.name(), PAYERROR.name()).contains(trxStatus);
        }
    }
}
