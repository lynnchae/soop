package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.member.MemberServiceContact;
import org.lynn.soop.contract.member.VerifyCodeUtils;
import org.lynn.soop.contract.member.dto.*;
import org.lynn.soop.entity.UserIdInfo;
import org.lynn.soop.entity.UserSession;
import org.lynn.soop.util.ExceptionUtil;
import org.lynn.soop.util.HttpHelper;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static org.lynn.soop.util.DataHelper.buildErrorMsg;
import static org.lynn.soop.util.JsonHelper.toJSON;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Controller
@Path("/openapi")
@Produces({"application/json;charset=UTF-8"})
public class MemberController extends BaseResource {

    @Resource
    private MemberServiceContact memberService;

    /**
     * 获取图像验证码code请求
     *
     * @return 验证码code
     */
    @GET
    @Path("/verify-image-code-request")
    public BaseResponse<String> getImageCode() {
        BaseResponse<String> toReturn;
        try {
            toReturn = memberService.genImageVerifyCode();
        } catch (Exception e) {
            String errorMsg = buildErrorMsg("获取图片验证码失败");
            logger.error(errorMsg, e);
            toReturn = BaseResponse.buildServerErrorResponse(errorMsg);
        }
        return toReturn;
    }

    @GET
    @Path("/verify-image-code")
    @Produces({"image/jpeg,image/png"})
    public StreamingOutput genImageVerifyCode(@QueryParam("imagekey") String imageKey) {
        logger.debug("start to `genImageVerifyCode` with request...");
        String verifyCode = null;
        try {
            BaseAPIRequest<String> request = setupRequest(imageKey, false);
            BaseResponse<String> response = memberService.getImageCode(request);
            if (!response.isSuccess()) {
                throw new RuntimeException("验证码图片生成失败");
            }

            verifyCode = response.getData();

            //生成图片
            httpResponse.getOutputHeaders().add(HttpHeaders.Names.EXPIRES, "0");
            httpResponse.getOutputHeaders().add(HttpHeaders.Names.CACHE_CONTROL, "no-cache");
            httpResponse.getOutputHeaders().add(HttpHeaders.Names.PRAGMA, "No-cache");

            int w = 200, h = 80;
            final ByteArrayOutputStream bos = new ByteArrayOutputStream(4096);
            VerifyCodeUtils.outputImage(w, h, bos, verifyCode);
            return new StreamingOutput() {
                @Override
                public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    outputStream.write(bos.toByteArray());
                }
            };

        } catch (Throwable e) {
            String errorMsg = buildErrorMsg("genImageVerifyCode` error" + e.getMessage());
            logger.error(errorMsg, e);
        } finally {
            logger.debug("end `genImageVerifyCode` with result: <<" + verifyCode + ">>");
        }
        return null;
    }


    /**
     * 注册前获取手机验证码
     *
     * @param mobileNo 手机号码
     * @return
     */
    @POST
    @Path("/verify-sms")
	public BaseResponse<String> authSMS(@FormParam("mobileNo") String mobileNo, @FormParam("smscode") String smscode) {
        BaseResponse<String> vcResp;
        try {
            if (isEmpty(mobileNo)) {
                return BaseResponse.buildClientErrorResponse("手机号码不能为空");
            }

            BaseAPIRequest<String> request = setupRequest(mobileNo, false);
            String remoteIp = getIpAddress(httpRequest);
            vcResp = memberService.genSmsVerifyCode(request, smscode, remoteIp);
            vcResp.put(SessionHelper.KEY_random, "0"); // 无意义的0
        } catch (MyBizException e) {
            logger.error(e.getMessage());
            vcResp = e.getResp();
        } catch (Exception e) {
            String errorMsg = buildErrorMsg("获取短信验证码失败");
            logger.error(errorMsg, e);
            vcResp = BaseResponse.buildServerErrorResponse(errorMsg);
        }
        return vcResp;
    }

    @POST
    @Path("/register")
    public BaseResponse register(
            @FormParam("mobileNo") String mobileNo,
            @FormParam("password") String password,
            @FormParam("msgCaptcha") String msgCaptcha,
            @FormParam("msgCaptchaKey") String msgCaptchaKey,
            @FormParam("imgCaptcha") String imgCaptcha,
            @FormParam("imgCaptchaKey") String imgCaptchaKey,
            @FormParam("code") String code) {
        try {
            Map<String, String> illegalArgs = new LinkedHashMap<String, String>();
            if (StringUtils.isBlank(mobileNo)) {
                illegalArgs.put("userId", "blank");
            }
            if (StringUtils.isBlank(imgCaptcha)) {
                illegalArgs.put("imgCaptcha", "blank");
            }
            if (StringUtils.isBlank(msgCaptcha)) {
                illegalArgs.put("msgCaptcha", "blank");
            }
            if (StringUtils.isBlank(password)) {
                illegalArgs.put("password", "blank");
            }
            if (!illegalArgs.isEmpty()) {
                return BaseResponse.buildClientErrorResponse("请求参数非法:" + illegalArgs);
            }

            BaseAPIRequest<String> request = setupRequest(imgCaptchaKey, false);
            BaseResponse<String> response = memberService.getImageCode(request);
            if (!response.isSuccess() || !response.getData().toUpperCase().equals(imgCaptcha.toUpperCase())) {
                return BaseResponse.buildClientErrorResponse("图形验证码错误!");
            }

//            request = setupRequest(msgCaptchaKey, false);
//            response = memberService.getSmsCode(request);
//            if (!response.isSuccess() || !response.getData().equals(msgCaptcha)) {
//                return BaseResponse.buildClientErrorResponse("短信验证码错误!");
//            }

            RegisterReqDto dto = new RegisterReqDto();
            dto.setUserId(mobileNo);
            dto.setPassword(DigestUtils.md5Hex(password));
            dto.setMsgCaptcha(msgCaptcha);
            dto.setCode(code);

            logger.info("start to `register` with request: <<" + toJSON(dto) + ">>");
            BaseResponse result;
            try {
                result = memberService.register(dto);
            } catch (Throwable e) {
                Throwable ee = ExceptionUtil.getRootCause(e);
                logger.error("`register` error: " + ee, e);
                if (ee instanceof MyBizException) {
                    result = ((MyBizException) ee).getResp();
                } else {
                    result = BaseResponse.buildServerErrorResponse("注册失败!");
                }
            }
            logger.info("end `register` with result: <<" + toJSON(result) + ">>");

            if (result.getCode() == BaseResponse.CODE_OK) {
                //注册成功后,默认做自动登陆
                result = login(mobileNo, password, code);
            }

            return result;
        } catch (Exception e) {
            String errorMsg = buildErrorMsg("注册信息提交失败" + e.getMessage());
            logger.error(errorMsg, e);
            return BaseResponse.buildServerErrorResponse(errorMsg);
        }
    }


    @POST
    @Path("/login/direct")
    public BaseResponse directLogin(@FormParam("mobileNo") String mobileNo,
                                    @FormParam("code") String password,
                                    @FormParam("msgCaptchaKey") String msgCaptchaKey) {
        BaseResponse toReturn;
        try {
            DirectLoginRequest loginRequest = new DirectLoginRequest(mobileNo, password, msgCaptchaKey);

            toReturn = memberService.directLogin(loginRequest);
        } catch (Exception e) {
            String errorMsg = buildErrorMsg("注册登录失败" + e.getMessage());
            logger.error(errorMsg, e);
            toReturn = BaseResponse.buildServerErrorResponse(errorMsg);
        }

        return toReturn;
    }

    /**
     * @return token令牌
     */
	@POST
	@Path("/login")
	public BaseResponse login(@FormParam("mobileNo") String mobileNo, @FormParam("password") String password, @FormParam("code") String code) {
		LoginReqDto dto = new LoginReqDto();
		dto.setUserId(mobileNo);
		dto.setPassword(password);
		dto.setCode(code);

		logger.info("start to `login` with request: <<" + toJSON(dto) + ">>");
		BaseResponse result;
		try {
			BaseResponse<String> session = memberService.login(dto);
			result = session;

			if (BaseResponse.CODE_OK == session.getCode()) {
				// 往session中加入登陆用户信息
				String sessionId = session.getData();
				// HttpHelper.addCookie(httpResponse,
				// SessionHelper.KEY_SessionId, sessionId, null);
				httpResponse.addNewCookie(HttpHelper.buildCookie(SessionHelper.KEY_SessionId, sessionId));
			}

		} catch (Throwable e) {
			String errorMsg = buildErrorMsg("登陆异常!" + e.getMessage());
			logger.error(errorMsg, e);
			Throwable ee = ExceptionUtil.getRootCause(e);
			if (ee instanceof MyBizException) {
				result = ((MyBizException) ee).getResp();
			} else {
				result = BaseResponse.buildServerErrorResponse(errorMsg);
			}
		}
		logger.info("end `login` with result: <<" + toJSON(result) + ">>");
		return result;
	}

	@POST
    @Path("/logout")
	public BaseResponse<String> logout() {
		return invoke("退出", new Callable<BaseResponse<String>>() {
			@Override
			public BaseResponse<String> call() throws Exception {
				UserSession session = checkLogin();
				return memberService.logout(session.getSession_id());
			}
		});
	}
	
	@POST
    @Path("/resetPassword")
	public BaseResponse<String> resetPassword(
        @FormParam("mobileNo") String mobileNo,
        @FormParam("newPassword") String newPassword,
        @FormParam("msgCaptcha") String msgCaptcha,
        @FormParam("imgCaptcha") String imgCaptcha,
        @FormParam("imgCaptchaKey") String imgCaptchaKey) {

        BaseAPIRequest<String> request = setupRequest(imgCaptchaKey, false);
        BaseResponse<String> response = memberService.getImageCode(request);
        if (!response.isSuccess() || !response.getData().toUpperCase().equals(imgCaptcha.toUpperCase())) {
            return BaseResponse.buildClientErrorResponse("图形验证码错误!");
        }

		final RestPwdReqDto restPwd = new RestPwdReqDto();
		restPwd.setNewPassword(newPassword);
		restPwd.setSmsCode(msgCaptcha);
		restPwd.setMobileNo(mobileNo);
		
		return invoke("重置密码", new Callable<BaseResponse<String>>() {
			@Override
			public BaseResponse<String> call() throws Exception {
				return memberService.resetPassword(restPwd);
			}
		});
	}


    @GET
    @Path("/my")
    public BaseResponse<MyShowDto> my() {
        return invoke("加载个人帐户信息", new Callable<BaseResponse<MyShowDto>>() {
            @Override
            public BaseResponse<MyShowDto> call() throws Exception {
                UserSession session = checkLogin();

                return memberService.showMy(session.getUser_id());
            }
        });
    }

    @GET
    @Path("/myinfo")
    public BaseResponse<UserDto> getMyInfo() {
        return invoke("加载个人基本信息", new Callable<BaseResponse<UserDto>>() {
            @Override
            public BaseResponse<UserDto> call() throws Exception {
                UserSession session = checkLogin();

                return memberService.getMyInfo(session.getUser_id());
            }
        });
    }

    @POST
    @Path("/myinfo/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse<Long> updateMyInfo(final UserDto reqDto) {
        return invoke("更新个人基本信息", new Callable<BaseResponse<Long>>() {
            @Override
            public BaseResponse<Long> call() throws Exception {
                UserSession session = checkLogin();

                reqDto.setId(session.getUser_id());

                return memberService.updateMyInfo(reqDto);
            }
        });
    }


    @POST
    @Path("/address/save")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse<Long> saveAddress(final UserAddressDto reqDto) {
        return invoke("保存地址信息", new Callable<BaseResponse<Long>>() {
            @Override
            public BaseResponse<Long> call() throws Exception {
                UserSession session = checkLogin();

                reqDto.setUserId(session.getUser_id());

                return memberService.saveAddress(reqDto);
            }
        });
    }

    @POST
    @Path("/address/delete")
    public BaseResponse<Long> deleteAddress(final @FormParam("id") Long aid) {
        return invoke("删除地址信息", new Callable<BaseResponse<Long>>() {
            @Override
            public BaseResponse<Long> call() throws Exception {
                UserSession session = checkLogin();

                return memberService.deleteAddress(aid, session.getUser_id());
            }
        });
    }

    @GET
    @Path("/address/list")
    public BaseResponse<List<UserAddressDto>> listAddress() {
        return invoke("获取地址列表", new Callable<BaseResponse<List<UserAddressDto>>>() {
            @Override
            public BaseResponse<List<UserAddressDto>> call() throws Exception {
                UserSession session = checkLogin();

                return memberService.listAddress(session.getUser_id());
            }
        });
    }

    @GET
    @Path("/address/idimage/list")
    public BaseResponse<List<UserIdInfo>> listUserIdImage() {
        return invoke("获取地址列表", new Callable<BaseResponse<List<UserIdInfo>>>() {
            @Override
            public BaseResponse<List<UserIdInfo>> call() throws Exception {
                UserSession session = checkLogin();

                return memberService.listUserIdImage(session.getUser_id());
            }
        });
    }

    @POST
    @Path("/address/idimage/save")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse<Long> saveIdImage(final UserIdInfo reqDto) {
        return invoke("保存证件图片信息", new Callable<BaseResponse<Long>>() {
            @Override
            public BaseResponse<Long> call() throws Exception {
                BaseAPIRequest<UserIdInfo> request = setupRequest(reqDto);
                return memberService.saveIdImage(request);
            }
        });
    }


}
