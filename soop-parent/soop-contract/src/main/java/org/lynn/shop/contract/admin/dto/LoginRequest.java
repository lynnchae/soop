package org.lynn.soop.contract.admin.dto;


import org.lynn.soop.contract.BaseRequest;

public class LoginRequest extends BaseRequest {
    private String loginAccount;
    private String password;

    public LoginRequest(String loginAccount, String password) {
        this.loginAccount = loginAccount;
        this.password = password;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public String getPassword() {
        return password;
    }
}
