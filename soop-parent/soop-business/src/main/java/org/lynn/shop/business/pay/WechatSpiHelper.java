package org.lynn.soop.business.pay;

import org.lynn.soop.util.XmlUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;
import java.util.*;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Created by ethan on 2016/1/11.
 */
public class WechatSpiHelper {
    private static final Logger logger = Logger.getLogger(WechatSpiHelper.class);
    public final static String KEY_RETURN_CODE = "return_code";
    public final static String KEY_RETURN_MSG = "return_msg";

    public final static String KEY_APPID = "appid";
    public final static String KEY_MCHID = "mch_id";
    public final static String KEY_DEVICE_INFO = "device_info";
    public final static String KEY_NONCE_SRE = "nonce_str";
    public final static String KEY_SIGN = "sign";
    public final static String KEY_RESULT_CODE = "result_code";
    public final static String KEY_ERR_CODE = "err_code";
    public final static String KEY_ERR_CODE_DES = "err_code_des";
    public final static String KEY_OPENID = "openid";
    public final static String KEY_IS_SUBSCRIBE = "is_subscribe";
    public final static String KEY_TRADE_TYPE = "trade_type";
    public final static String KEY_BANK_TYPE = "bank_type";
    public final static String KEY_TOTAL_FEE = "total_fee";
    public final static String KEY_FEE_TYPE = "fee_type";
    public final static String KEY_CASH_FEE = "cash_fee";
    public final static String KEY_CASH_FEE_TYPE = "cash_fee_type";
    public final static String KEY_COUPON_FEE = "coupon_fee";
    public final static String KEY_TRANSACTION_ID = "transaction_id";
    public final static String KEY_OUT_TRADE_NO = "out_trade_no";
    public final static String KEY_ATTACH = "attach";
    public final static String KEY_TIME_END = "time_end";

    public static final String STR_CHARSET_UTF8 = "UTF-8";
    public static final Charset CHARSET_UTF8 = Charset.forName(STR_CHARSET_UTF8);
    public static final String REQUEST_SUCCESS = "SUCCESS";
    public static final String BIZ_SUCCESS = "SUCCESS";
    public static final String BIZ_FAIL = "FAIL";

    public static Map<String, String> parsePayResult(String resp, String appKey) {
        Map<String, Object> respMap = XmlUtil.parseXml(resp, CHARSET_UTF8, Collections.<String>emptyList());

        @SuppressWarnings("unchecked")
        Map<String, String> resultMap = (Map<String, String>) respMap.get("xml");
        logger.info("Form data for wechat-pay-result-callback: " + toJSON(resultMap));

        String requestStatus = resultMap.get(KEY_RETURN_CODE);
        String requestMsg = resultMap.get(KEY_RETURN_MSG);

        if (!REQUEST_SUCCESS.equals(requestStatus)) {
            throw new RuntimeException(String.format("Unexpected return code [%s]: return_msg [%s]", requestStatus, requestMsg));
        } else {
            Map<String, String> paramForSign = new HashMap<String, String>();

            for (Map.Entry<String, String> e : resultMap.entrySet()) {
                paramForSign.put(e.getKey(), e.getValue());
            }
            String sign = paramForSign.remove(KEY_SIGN);
            //验签名失败直接返回失败
            String actualSign = wechatSignByMd5(paramForSign, appKey);
            if (!sign.equals(actualSign)) {
                throw new RuntimeException(String.format("Failed to verify sign: expectedSign [%s], actualSign [%s], signObject [%s]", sign, actualSign, paramForSign));
            }

            //微信只通知成功结果，失败为异常状态
            String bizStatus = resultMap.get(KEY_RESULT_CODE);
            String bizErrorCode = resultMap.get(KEY_ERR_CODE);
            String bizErrorMsg = resultMap.get(KEY_ERR_CODE_DES);
            if (!BIZ_SUCCESS.equals(bizStatus)) {
                throw new RuntimeException(String.format("Unexpected result code [%s]: err_code [%s], err_code_des [%s]", bizStatus, bizErrorCode, bizErrorMsg));
            }

            return resultMap;
        }
    }

    private static String wechatSignByMd5(Map<String, String> data, String salt) {
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(data.keySet());
        Collections.sort(keyList);

        StringBuffer paramForSign = new StringBuffer();
        for (String key : keyList) {
            String v = data.get(key);
            if (StringUtils.isNotBlank(v)) {
                paramForSign.append(key).append("=").append(v).append("&");
            }
        }
        paramForSign.append("key=").append(salt);
        logger.debug("origin sign string:" + paramForSign.toString());
        return DigestUtil.digestToHex(paramForSign.toString(), STR_CHARSET_UTF8).toUpperCase();
    }
}