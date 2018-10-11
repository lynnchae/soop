package org.lynn.soop.contract.member.dto;

public class DirectLoginRequest {
    private String mobileNo;
    private String password;
    private String msgCaptchaKey;


    public DirectLoginRequest(String mobileNo, String password, String msgCaptchaKey) {
        this.mobileNo = mobileNo;
        this.password = password;
        this.msgCaptchaKey = msgCaptchaKey;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public String getMsgCaptchaKey() {
        return msgCaptchaKey;
    }
}
