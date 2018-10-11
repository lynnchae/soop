package org.lynn.soop.contract.member.dto;


import org.lynn.soop.contract.BaseDto;
import com.sun.istack.internal.NotNull;

/**
 * Created by chenwen on 4/29/16.
 */
public class LoginReqDto extends BaseDto {

    // 用户名(目前为手机号)
    @NotNull
    private String userId;

    @NotNull
    private String password;
    
    private String code;


    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
