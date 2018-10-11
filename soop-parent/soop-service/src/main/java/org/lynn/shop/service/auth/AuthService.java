package org.lynn.soop.service.auth;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.auth.AuthBusiness;
import org.lynn.soop.contract.auth.AuthServiceContract;

@Service
public class AuthService implements AuthServiceContract{
	
	@Resource
	private AuthBusiness authBusiness;

	@Override
	public String getAccessToken(String code, String type, String orderId, String phone) {
		return authBusiness.getAccessToken(code, type, orderId, phone);
	}
}
