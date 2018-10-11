package org.lynn.soop.service.function;

import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.function.SmsServiceContact;
import org.lynn.soop.service.common.BaseService;
import org.lynn.soop.util.SimpleHttpClient;
import org.lynn.soop.util.XmlUtil;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenwen on 5/06/16.
 */
public class MengwangSmsService extends BaseService implements SmsServiceContact {

    public static final String USER_ID = "userId";
    public static final String PASSWORD = "password";
    public static final String PSZSUBPORT = "pszSubPort";
    public static final String MOBILE_NOS = "pszMobis";
    public static final String MESSAGE = "pszMsg";
    public static final String COUNT_OF_MOBILE_NO = "iMobiCount";

    public static final String userId = "M10227";       // todo 配置信息移入配置文件
//    public static final String userId = "JC2137";       // todo 配置信息移入配置文件
    public static final String password = "325150";
//    public static final String password = "630771";
    public static final String url = "http://61.145.229.28:8027/MWGate/wmgw.asmx/MongateCsSpSendSmsNew";
//    public static final String url = "http://61.145.229.29:9006/MWGate/wmgw.asmx/MongateCsSpSendSmsNew";
    public static final String pszSubPort = "*";
    public static final Charset charset = Charset.forName("UTF-8");


    public BaseResponse<String> sendSMS(String smsContent, List<String> mobileNoList) {
        Assert.notNull(smsContent);
        Assert.notNull(mobileNoList);

        String mobileNos = "";
        for (String no : mobileNoList) {
            if (mobileNos.length() > 0) {
                mobileNos += ",";       //todo 分隔符 待确认,带验证
            }
            mobileNos += no;
        }
        String iMobiCount = mobileNoList.size() + "";

        //参数是有顺序的，需要按照接口说明中的顺序
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put(USER_ID, userId);
        params.put(PASSWORD, password);
        params.put(MOBILE_NOS, mobileNos);
        params.put(MESSAGE, smsContent);
        params.put(COUNT_OF_MOBILE_NO, iMobiCount);
        params.put(PSZSUBPORT, pszSubPort);

        String callResult;
        try {
            String logHead = String.format("sendSMS (POST %s) with params %s ", url, params);
            logger.info(logHead + " starting...");

            callResult = doHttpPost(url, params, charset);

            logger.info("sendSMS result: [" + callResult + "]");

            Map<String, Object> resultMap = XmlUtil.parseXml(callResult, charset);
            String flowNo = resultMap.get("string").toString();
            int length = flowNo.length();
            //返回的流水号，再15到帐目之间的长度，可以认为发送成功
            if (length >= 15 && length <= 20) {
                return BaseResponse.buildSuccessResponse(flowNo);
            } else {
                logger.error("send sms failed.");
                return BaseResponse.buildServerErrorResponse("短信发送失败：" + callResult);
            }
        } catch (Exception e) {
            logger.error("sendSMS error: ", e);
            return BaseResponse.buildServerErrorResponse("短信发送异常");
        }
    }

    public BaseResponse<String> sendOne(String text, String mobileNos) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(mobileNos);
        return sendSMS(text, list);
    }


    protected String doHttpPost(String url, Map<String, String> params, Charset charset) throws Exception {
        return SimpleHttpClient.sendPost(url, params, charset);
    }
}
