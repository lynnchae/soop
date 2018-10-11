package org.lynn.soop.business.pay;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by ethan on 2016/1/5.
 */
public final class EncryptUtil {
    public static final String STR_CHARSET_UTF8 = "UTF-8";


    public static String wechatSignByMd5(Map<String, String> data, String salt) {
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

        return DigestUtil.digestToHex(paramForSign.toString(), STR_CHARSET_UTF8).toUpperCase();
    }
}