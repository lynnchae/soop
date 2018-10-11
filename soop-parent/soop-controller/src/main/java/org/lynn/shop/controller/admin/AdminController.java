package org.lynn.soop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.admin.dto.LoginRequest;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.entity.dto.response.LoginResponse;
import org.lynn.soop.util.Contants;
import org.lynn.soop.util.HttpClientUtils;
import org.lynn.soop.util.PropertyUtils;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.lynn.soop.util.HttpHelper.buildCookie;
import static org.lynn.soop.util.HttpHelper.expireCookie;

@Controller
@Path("/service")
@Produces({"application/json;charset=UTF-8"})
public class AdminController extends BaseController {

    @POST
    @Path("/login")
    public BaseResponse login(@FormParam("username") String username, @FormParam("password") String password) {
        log.info(String.format("start admin user login: username [%s]", username));
        LoginRequest loginRequest = new LoginRequest(username, password);
        BaseResponse<String> loginResponse = adminServiceContract.login(loginRequest);

        BaseResponse toReturn;
        if (loginResponse.getCode() == Contants.Http.SUCCES_CODE) {
            toReturn = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "index.html", 302);
            String result = loginResponse.getData();
            LoginResponse resp = JSONObject.parseObject(result, LoginResponse.class);
            String session_id = resp.getData().getToken();
            toReturn.put(Contants.Http.ADMIN_SESSION_KEY, session_id);
            toReturn.put("result", result);
            response.addNewCookie(buildCookie(Contants.Http.ADMIN_SESSION_KEY, session_id));
        } else {
            toReturn = BaseResponse.buildClientErrorResponse("登入失败，请确保账号密码正确");
        }

        return toReturn;
    }

    @POST
    @Path("/logout")
    public BaseResponse logout() {
        log.info(String.format("admin console user logout"));
        String sessionId = "";
        BaseResponse toReturn = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        Cookie sessionCookie = httpHeaders.getCookies().get(Contants.Http.ADMIN_SESSION_KEY);
        if (sessionCookie != null) {
            sessionId = sessionCookie.getValue();
        }
        String logoutUrl = PropertyUtils.getValue("logoutUrl");
        Map<String, String> params = new HashMap<>();
        params.put("token", sessionId);
        try {
            String result = HttpClientUtils.doPost(logoutUrl, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.addNewCookie(expireCookie(Contants.Http.ADMIN_SESSION_KEY));
        return toReturn;
    }

/*    @POST
    @Path("/removeSession")
    public BaseResponse removeSession() {
        log.info(String.format("admin console user removeSession"));
        BaseResponse toReturn = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        response.addNewCookie(expireCookie(Contants.Http.ADMIN_SESSION_KEY));
        return toReturn;
    }*/

    @POST
    @Path("/passwordreset")
    public BaseResponse passwordReset(String newPassword) {
        log.info(String.format("passwordReset"));
        BaseResponse result;
        try {
            BaseRequest<String> request = setupRequest(newPassword);
            result = adminServiceContract.changePassword(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove member user.", e);
            result = BaseResponse.buildClientErrorResponse("密码修改失败");
        }
        return result;
    }


    @GET
    @Path("/login/check")
    public BaseResponse loginCheck() {
        Cookie sessionCookie = httpHeaders.getCookies().get(Contants.Http.ADMIN_SESSION_KEY);
        BaseResponse toReturn = null;
        if (sessionCookie != null) {
            String sessionId = sessionCookie.getValue();
            BaseResponse<String> loginResponse = adminServiceContract.checkSession(sessionId);
            if (loginResponse.getCode() == Contants.Http.SUCCES_CODE) {
                toReturn = BaseResponse.buildSuccessResponse(loginResponse.getData());
            }
        } else {
            log.error("[action]no cookie found for current login user.");
        }
        //if no cookie or invalid session id, redirect to login page.
        if (toReturn == null) {
            toReturn = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        }
        return toReturn;
    }
}
