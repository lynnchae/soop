package org.lynn.soop.service.admin;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import org.lynn.soop.business.admin.AdminBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.admin.AdminServiceContract;
import org.lynn.soop.contract.admin.dto.LoginRequest;
import org.lynn.soop.entity.dto.response.LoginResponse;
import org.lynn.soop.entity.dto.response.VerifyTokenResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import static org.lynn.soop.util.JsonHelper.toJSON;

@Service
public class AdminService implements AdminServiceContract {

    private static final Logger log = Logger.getLogger(AdminService.class);

    @Autowired
    AdminBusiness adminBusiness;

    public BaseResponse<String> login(LoginRequest loginRequest) {
        log.info("start process login for admin user, with request: " + toJSON(loginRequest));
        BaseResponse toReturn = null;
        try {
            String result = adminBusiness.login(loginRequest.getLoginAccount(), loginRequest.getPassword());
            if (result != null) {
                try {
                    LoginResponse resp = JSONObject.parseObject(result, LoginResponse.class);
                    if ((resp.getStatus() == 1) && "00000000".equals(resp.getError())) {
                        toReturn = BaseResponse.buildSuccessResponse(result);
                    } else {
                        toReturn = BaseResponse.buildClientErrorResponse("登录账号或者密码错误");
                    }
                } catch (Exception e) {
                    toReturn = BaseResponse.buildClientErrorResponse("登录账号或者密码错误");
                }
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            toReturn = BaseResponse.buildClientErrorResponse("登陆失败！");
        }
        log.info("end process login for admin user, response is :" + toJSON(toReturn));
        return toReturn;
    }

    public BaseResponse<String> checkSession(String sessionId) {
        BaseResponse toReturn = null;
        try {
            String result = adminBusiness.checkSession(sessionId);
            if (result != null) {
                try {
                    VerifyTokenResponse resp = JSONObject.parseObject(result, VerifyTokenResponse.class);
                    if ((resp.getStatus() == 1) && "00000000".equals(resp.getError()) && resp.getData().getValidity() == 1) {
                        toReturn = BaseResponse.buildSuccessResponse(result);
                    } else {
                        toReturn = BaseResponse.buildClientErrorResponse("登录账号或者密码错误");
                    }
                } catch (Exception e) {
                    toReturn = BaseResponse.buildClientErrorResponse("登录账号或者密码错误");
                }
            }
        } catch (Exception e) {
           log.debug(e.getMessage());
            toReturn = BaseResponse.buildClientErrorResponse("登录失败！");
        }
        return toReturn;
    }

    public BaseResponse changePassword(BaseRequest<String> request) {
        return adminBusiness.changePassword(request);
    }
}
