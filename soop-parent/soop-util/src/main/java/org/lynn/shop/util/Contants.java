package org.lynn.soop.util;

import org.jboss.resteasy.util.GenericType;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;

public class Contants {
    public static final Charset UTF8 = Charset.forName("UTF8");

    public static final class Http {
        public static final int SUCCES_CODE = 200;
        public static final String ADMIN_SESSION_KEY = "_admin_session_id";
        public static final GenericType<InputStream> inputStreamGenericType = new GenericType<InputStream>() {
        };
    }

    public static final class product {
        public static final BigDecimal DEFAULT_PROFIT_RATE = new BigDecimal("1.05");
    }
}
