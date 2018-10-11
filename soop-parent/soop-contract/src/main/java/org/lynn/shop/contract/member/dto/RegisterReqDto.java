package org.lynn.soop.contract.member.dto;

/**
 * Created by chenwen on 4/29/16.
 */
public class RegisterReqDto extends LoginReqDto {

    // 图片验证码
    private String imgCaptcha;
    private transient String imgKeyNumber;
    // 短信验证码
    private String msgCaptcha;
    private transient String msgKeyNumber;

	public String getImgCaptcha() {
        return imgCaptcha;
    }

    public void setImgCaptcha(String imgCaptcha) {
        this.imgCaptcha = imgCaptcha;
    }

    public String getMsgCaptcha() {
        return msgCaptcha;
    }

    public void setMsgCaptcha(String msgCaptcha) {
        this.msgCaptcha = msgCaptcha;
    }

    public String getImgKeyNumber() {
        return imgKeyNumber;
    }

    public void setImgKeyNumber(String imgKeyNumber) {
        this.imgKeyNumber = imgKeyNumber;
    }

    public String getMsgKeyNumber() {
        return msgKeyNumber;
    }

    public void setMsgKeyNumber(String msgKeyNumber) {
        this.msgKeyNumber = msgKeyNumber;
    }
}
