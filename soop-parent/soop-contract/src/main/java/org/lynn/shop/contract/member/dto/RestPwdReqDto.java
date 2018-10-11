package org.lynn.soop.contract.member.dto;

import org.lynn.soop.contract.BaseDto;

public class RestPwdReqDto extends BaseDto{

	private String mobileNo;

	private String smsCode;
	
	private String newPassword;

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
