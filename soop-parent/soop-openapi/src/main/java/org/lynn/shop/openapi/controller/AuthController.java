package org.lynn.soop.openapi.controller;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.auth.AuthServiceContract;


@Controller
@Path("/openapi/auth")
@Produces({"application/json;charset=UTF-8"})
public class AuthController extends BaseResource{
	
    @Resource
    private AuthServiceContract authServiceContract;

	/**
	 * 获取授权访问应花token
	 */
    @POST
    @Path("/getAccessToken")
	public String getAccessToken(@FormParam("code") String code, @FormParam("type") String type, 
			                     @FormParam("orderId") String orderId, @FormParam("phone") String phone) {
		String result = null;
		try {
			if (StringUtils.isEmpty(type)) {
				throw new RuntimeException("缺少必填参数type");
			}
			if (StringUtils.isEmpty(phone)) {
				throw new RuntimeException("缺少必填参数phone");
			}
			if (type.equals("pay") && StringUtils.isEmpty(orderId)) {
				throw new RuntimeException("缺少必填参数orderId");
			}
			result = authServiceContract.getAccessToken(code, type, orderId, phone);
			logger.info("getAccessToken:" + result);
			if (result == null) {
				result = JSONObject.toJSONString(BaseResponse.buildServerErrorResponse("系统异常"));
			}
		} catch (Exception e) {
			result = JSONObject.toJSONString(BaseResponse.buildServerErrorResponse(e.getMessage()));
			logger.error("获取授权访问应花token", e);
		}
		return result;
	}
}
