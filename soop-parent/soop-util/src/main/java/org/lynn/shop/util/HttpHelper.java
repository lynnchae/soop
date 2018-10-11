package org.lynn.soop.util;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;

public final class HttpHelper {
    public static NewCookie buildCookie(String key, String value, int expiredInSeconds) {
        return new NewCookie(key, value, "/", null, null, expiredInSeconds, false);
    }

    public static NewCookie buildCookie(String key, String value) {
        return new NewCookie(key, value, "/", null, null, 36000, false);
    }

    public static NewCookie expireCookie(String key) {
        return new NewCookie(key, "", "/", null, null, 0, false);
    }


    public static void addCookie(HttpResponse httpResponse, String key, String value, Integer expiredInSeconds) {
        if (expiredInSeconds == null) {
            expiredInSeconds = 36000;
        }
        Cookie cookie = new Cookie(key, value, "/", null);
        NewCookie c = new NewCookie(cookie, null, expiredInSeconds, false);
        httpResponse.addNewCookie(c);
    }

    public static String getCookieValue(HttpRequest httpRequest, String key) {
        Cookie c = httpRequest.getHttpHeaders().getCookies().get(key);
        return c.getValue();
    }

    public static void removeCookie(HttpResponse httpResponse, String key) {
        NewCookie c = new NewCookie(key, "", "/", null, null, 0, false);
        httpResponse.addNewCookie(c);
    }

}
