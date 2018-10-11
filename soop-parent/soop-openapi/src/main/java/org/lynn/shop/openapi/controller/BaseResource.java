package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.member.SessionServiceContact;
import org.lynn.soop.contract.user.UserServiceContact;
import org.lynn.soop.entity.UserSession;
import org.lynn.soop.util.ExceptionUtil;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.concurrent.Callable;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public abstract class BaseResource {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private final static String user_session_is_key = "_utk";

    @Context
    protected HttpHeaders httpHeaders;
    @Context
    protected HttpRequest httpRequest;
    @Context
    protected HttpResponse httpResponse;

    @Resource
    protected SessionServiceContact sessionService;

    @Resource
    protected UserServiceContact userServiceContact;

    protected BaseAPIRequest<String> setupRequest() {
        return setupRequest("");
    }

    protected BaseAPIRequest<String> setupRequest(boolean requiredLogin) {
        return setupRequest("", requiredLogin);
    }

    protected <T> BaseAPIRequest<T> setupRequest(T data) throws MyBizException {
        return setupRequest(data, true);
    }

    protected <T> BaseAPIRequest<T> setupRequest(T data, boolean requiredLogin) throws MyBizException {
        BaseAPIRequest<T> toReturn = new BaseAPIRequest<T>();
        toReturn.setData(data);
        try {
            toReturn.setUser(resolveLoginUser());
        } catch (RuntimeException e) {
            if (requiredLogin) {
                throw e;
            }
        }
        return toReturn;
    }

    private Long resolveLoginUser() {
        UserSession userSession = checkLogin();
        return userSession.getUser_id();
    }


    protected UserSession checkLogin() {
        String sessionIdFromHeader = httpHeaders.getHeaderString(user_session_is_key);
        if (isEmpty(sessionIdFromHeader)) {
            MultivaluedMap<String, String> queryParameters = httpRequest.getUri().getQueryParameters();
            if (queryParameters != null) {
                List<String> userSessionIds = queryParameters.get(user_session_is_key);
                if(userSessionIds == null || userSessionIds.size()==0){
                	throw new MyBizException(BaseResponse.buildResponse(null, BaseResponse.CODE_CLIENT_NO_LOGIN));
                }
                sessionIdFromHeader = userSessionIds.get(0);
            }
        }

        if (sessionIdFromHeader != null) {
            BaseResponse<UserSession> resp = sessionService.check(sessionIdFromHeader);
            if (resp.getCode() == BaseResponse.CODE_OK && resp.getData() != null) {
                return resp.getData();
            }
        }

        throw new MyBizException(BaseResponse.buildResponse(null, BaseResponse.CODE_CLIENT_NO_LOGIN));
    }


    protected <T> BaseResponse<T> invoke(String controllerName, Callable<BaseResponse<T>> logic) {
        String logHead = String.format("[%s] invoke ", controllerName);
        logger.info(logHead + "starting...");
        try {

            BaseResponse<T> resp = logic.call();

            logger.info(logHead + "done.");
            return resp;

        } catch (Throwable e) {
            Throwable ee = ExceptionUtil.getRootCause(e);
            String msg = logHead + "error: " + ee;
            logger.error(msg, e);
            if (ee instanceof MyBizException) {
                return ((MyBizException) ee).getResp();
            } else if (ee instanceof IllegalArgumentException) {
                return BaseResponse.buildClientErrorResponse(msg);
            } else {
                return BaseResponse.buildServerErrorResponse(msg);
            }
        }
    }

    public String getIpAddress(HttpRequest httpRequest) {
        HttpHeaders headers = httpRequest.getHttpHeaders();
        String ip = headers.getHeaderString("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getHeaderString("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getHeaderString("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getHeaderString("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getHeaderString("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getHeaderString("host");
        }
        if (!StringUtils.isEmpty(ip) && ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        if (!StringUtils.isEmpty(ip) && ip.indexOf(":") > 0) {
            ip = ip.substring(0, ip.indexOf(":"));
        }
        return ip;
    }
}
