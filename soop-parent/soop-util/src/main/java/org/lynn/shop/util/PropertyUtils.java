package org.lynn.soop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gaoguoxiang on 2016/7/19
 */
public final class PropertyUtils {
    public static Properties prop = new Properties();

    static {
        InputStream in = PropertyUtils.class.getResourceAsStream("/application.properties");
        try {
            prop.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = "";
        Object obj = prop.get(key);
        if (obj != null) {
            value = obj.toString();
        }
        return value;
    }

}
