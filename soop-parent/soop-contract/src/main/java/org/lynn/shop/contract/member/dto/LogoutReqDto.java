package org.lynn.soop.contract.member.dto;


import org.lynn.soop.contract.BaseDto;

/**
 * Created by chenwen on 4/29/16.
 */
public class LogoutReqDto extends BaseDto {

    // 用户名(目前为手机号)
    private String userId;

    // 登陆令牌
    private String token;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
