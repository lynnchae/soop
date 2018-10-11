package org.lynn.soop.controller.common;

import com.alibaba.fastjson.JSONObject;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.admin.AdminServiceContract;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.entity.AdminUser;
import org.lynn.soop.entity.dto.response.VerifyTokenResponse;
import org.lynn.soop.util.Contants;
import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.HttpResponse;

import javax.annotation.Resource;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;

public abstract class BaseController {
    protected static final Logger log = Logger.getLogger(BaseController.class);
    protected static final String ERP_CONTEXT_PATH = "/erp/";

    @Resource
    protected AdminServiceContract adminServiceContract;

    @Context
    protected HttpHeaders httpHeaders;

    @Context
    protected HttpResponse response;


    protected <T> BaseRequest<T> setupRequest(T data) throws NoLoginException {
        BaseRequest<T> toReturn = new BaseRequest<T>();
        toReturn.setData(data);
        toReturn.setOperator(resolveLoginUser());
        return toReturn;
    }

    private AdminUser resolveLoginUser() throws NoLoginException {
        AdminUser toReturn = null;
        Cookie sessionCookie = httpHeaders.getCookies().get(Contants.Http.ADMIN_SESSION_KEY);
        if (sessionCookie != null) {
            String sessionId = sessionCookie.getValue();
            BaseResponse<String> loginResponse = adminServiceContract.checkSession(sessionId);
            if (loginResponse.getCode() == Contants.Http.SUCCES_CODE) {
                VerifyTokenResponse entity = JSONObject.parseObject(loginResponse.getData(), VerifyTokenResponse.class);
                toReturn = new AdminUser();
                toReturn.setSession_id(sessionId);
                toReturn.setLogin_account(entity.getData().getUid().toString());
            }
        } else {
            log.error("no login cookie found here.");
        }

        if (toReturn == null) {
            throw new NoLoginException();
        }

        return toReturn;
    }
}
