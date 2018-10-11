package org.lynn.soop.openapi.controller;

import com.alibaba.dubbo.common.utils.LRUCache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class SessionHelper {

    public static final String KEY_ImgVerifyCode = "_verify_code_image";
    public static final String KEY_SessionId     = "_session_id";
    public static final String KEY_random = "_random_";
    public static final String KEY_SmsVerifyCode = "_verify_code_sms";

    public static final int DEFAULT_EXPIRED_SECONDS = 3600;

    public static final int VC_EXPIRED_SECONDS_IMAGE = DEFAULT_EXPIRED_SECONDS;
    public static final int VC_EXPIRED_SECONDS_SMS = 120;

    public static final int SESSION_EXPIRED_SECONDS = DEFAULT_EXPIRED_SECONDS;

    public static final int VC_LENGTH_IMAGE = 4;
    public static final int VC_LENGTH_SMS = 6;


    private static final Map<Long, Map<String, Object>> session = Collections.synchronizedMap(new LRUCache<Long, Map<String, Object>>(Integer.MAX_VALUE/100));  //最大支持在线用户数:21474836, 2千万+

    public void addSessionKey(long sessionId, String k, Object v) {
        Map<String, Object> kv = session.get(sessionId);
        if (kv == null) {
            kv = new HashMap<String, Object>();
            session.put(sessionId, kv);
        }
        synchronized (kv) {
            kv.put(k, v);
        }
    }

    public Object getSessionValue(long sessionId, String k) {
        Map<String, Object> kv = session.get(sessionId);
        if (kv == null) {
            return null;
        }
        synchronized (kv) {
            return kv.get(k);
        }
    }

}
