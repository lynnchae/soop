package org.lynn.soop.business.pay.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: ethan.wang
 * Date: 3/5/14
 * Time: 3:17 PM
 */
public class GrantBrowserAccessToken {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("scope")
    private String Scope;

    public String getAccessToken() {
        return accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public String getScope() {
        return Scope;
    }
}
