package org.lynn.soop.service.member;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import org.lynn.common.configUtil.StaticConfigHelper;
import org.lynn.soop.business.member.MemberBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.function.SmsServiceContact;
import org.lynn.soop.contract.member.MemberServiceContact;
import org.lynn.soop.contract.member.SessionServiceContact;
import org.lynn.soop.contract.member.dto.DirectLoginRequest;
import org.lynn.soop.contract.member.dto.LoginReqDto;
import org.lynn.soop.contract.member.dto.MyShowDto;
import org.lynn.soop.contract.member.dto.RegisterReqDto;
import org.lynn.soop.contract.member.dto.RestPwdReqDto;
import org.lynn.soop.contract.member.dto.UserAddressDto;
import org.lynn.soop.contract.member.dto.UserDto;
import org.lynn.soop.entity.User;
import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.UserIdInfo;
import org.lynn.soop.entity.UserSession;
import org.lynn.soop.entity.VerificationCode;
import org.lynn.soop.entity.handwrite.VerificationCodeExtend;
import org.lynn.soop.service.common.BaseService;
import org.lynn.soop.util.DataHelper;
import org.lynn.soop.util.ExceptionUtil;
import org.lynn.soop.util.SimpleHttpClient;


@Service
public class MemberService extends BaseService implements MemberServiceContact {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    @Resource
    private MemberBusiness memberBusiness;
    @Resource
    private SessionServiceContact sessionService;
    @Resource
    private SmsServiceContact smsService;

    public static final Charset charset = Charset.forName("UTF-8");
     
    public BaseResponse<String> genImageVerifyCode() {
        return service("生成图形验证码", new Callable<String>() {
             
            public String call() throws Exception {
                VerificationCode verifyCode = memberBusiness.generateVerifyCode(VerificationCodeExtend.Type.IMAGE, null);
                return verifyCode.getKey_number();
            }
        });
    }

     
	public BaseResponse<String> genSmsVerifyCode(final BaseAPIRequest<String> request, final String smsCode, final String remoteIp) {
		return service("生成短信验证码", new Callable<String>() {

			public String call() throws Exception {
				String url = StaticConfigHelper.get("user_system") + "/sendSmsCode";
				Map<String, String> params = new HashMap<String, String>();
				params.put("phoneNum", request.getData());
				params.put("smsCode", smsCode);
				params.put("smsType", "sms");
				params.put("ip", remoteIp);

				String callResult;
				try {
					logger.info("----------> 发送短信请求:" + params.toString());
					callResult = SimpleHttpClient.sendGet(url, params, charset);
					logger.info("----------> 发送短信结果:" + callResult);
                    JSONObject jsonResult = JSONObject.parseObject(callResult);
                    if (!jsonResult.get("status").equals(BaseResponse.OK)) {
                        throw new MyBizException(BaseResponse.buildClientErrorResponse(jsonResult.get("msg").toString()));
                    }
				} catch (Exception e) {
					throw e;
				}
				return callResult;
			}
		});
	}

     
    public BaseResponse<Long> register(final RegisterReqDto dto) {
        return service("用户注册", new Callable<Long>() {
             
            public Long call() throws Exception {
                Map<String, String> illegalArgs = dto.checkArgs();
                if (!CollectionUtils.isEmpty(illegalArgs)) {
                    throw new MyBizException(BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs));
                }
                illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.TRX.name());
                if (!CollectionUtils.isEmpty(illegalArgs)) {
                    throw new MyBizException(BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs));
                }

                //------------------------------------------ Register to UserSystem--------------------------------
				String url = StaticConfigHelper.get("user_system") + "/register";
				Map<String, String> params = new HashMap<String, String>();
				params.put("userName", dto.getUserId());
				params.put("password", dto.getPassword());
				params.put("smsCode", dto.getMsgCaptcha());
                
				try {
					logger.info("----------> 用户注册请求:" + params.toString());
					String callResult = SimpleHttpClient.sendPost(url, params, charset);
					logger.info("----------> 用户注册结果:" + callResult);
					JSONObject jsonResult = JSONObject.parseObject(callResult);
					if (!jsonResult.get("status").equals(BaseResponse.OK)) {
						throw new MyBizException(BaseResponse.buildClientErrorResponse(jsonResult.get("msg").toString()));
					}
				} catch (MyBizException e) {
                    throw new MyBizException(e.getResp());
                }
                // ----------------------------------------------- end --------------------------------------------
				
                try {
                    User member = memberBusiness.registerMember(dto, "soop");
                    return member.getId();
                } catch (RuntimeException e) {
                    if (ExceptionUtil.isConflictUK(e)) {
                        throw new MyBizException(BaseResponse.buildClientErrorResponse("用户名已经存在!"));
                    }
                    throw e;
                }
            }
        });
    }

    /**
     * @return token令牌
     */
     
    public BaseResponse<String> login(final LoginReqDto dto) {
        return service("用户登陆", new Callable<String>() {

            public String call() throws Exception {
                Map<String, String> illegalArgs = dto.checkArgs();
                if (!CollectionUtils.isEmpty(illegalArgs)) {
                    throw new MyBizException(BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs));
                }
                illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.TRX.name());
                if (!CollectionUtils.isEmpty(illegalArgs)) {
                    throw new MyBizException(BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs));
                }

                String userId = dto.getUserId();
                String password = dto.getPassword();
                
                // ---------------------------------------- userSystem login --------------------------------------

				String url = StaticConfigHelper.get("user_system") + "/login";
				Map<String, String> params = new HashMap<String, String>();
				params.put("userName", userId);
				params.put("password", DigestUtils.md5Hex(password));

				String sessionId = DataHelper.generateUniqueToken();
				String mobp2pUid = "";
				try {
					logger.info("----------> 用户登陆请求:" + params.toString());
					String callResult = SimpleHttpClient.sendPost(url, params, charset);
					logger.info("----------> 用户登陆结果:" + callResult);
					JSONObject jsonResult = JSONObject.parseObject(callResult);
					if (jsonResult.get("status").equals(BaseResponse.OK)) {
						JSONObject dataJson = JSONObject.parseObject(jsonResult.get("data").toString());
						sessionId = dataJson.get("code").toString();
                        mobp2pUid = dataJson.get("userId").toString();
					} else {
						throw new MyBizException(BaseResponse.buildClientErrorResponse(jsonResult.get("msg").toString()));
					}
				} catch (MyBizException e) {
                    throw new MyBizException(e.getResp());
                } catch (Exception e){
                	throw new MyBizException(BaseResponse.buildClientErrorResponse("系统错误"));
                }
                // ---------------------------------------- end --------------------------------------------------
                
				if (!memberBusiness.existUser(userId)) {
					RegisterReqDto rgdto = new RegisterReqDto();
					rgdto.setUserId(userId);
					rgdto.setCode(dto.getCode());
					memberBusiness.registerMember(rgdto);
				}

                // 手机贷user_id补偿
				User user = memberBusiness.getByUserId(userId);
				if(user.getUser_name() == null || "".equals(user.getUser_name())){
					user.setUser_name(mobp2pUid);
					memberBusiness.updateMyInfo(user);
				}
				
                BaseResponse<UserSession> r = sessionService.create(userId, sessionId);
                if (r.getCode() != BaseResponse.CODE_OK) {
                    throw new MyBizException(r);
                }
//                return EncryptHelper.oneWayEncryptPassword(user.getId()+"");
                return sessionId;
            }
        });
    }
    
    
	public BaseResponse<String> logout(final String code) {
 		String url = StaticConfigHelper.get("user_system") + "/logout";
		Map<String, String> params = new HashMap<String, String>();
		params.put("code", code);
		String callResult = "";
		try {
			callResult = SimpleHttpClient.sendGet(url, params, charset);
		} catch (Exception e) {
			// throw new MyBizException(BaseResponse.buildClientErrorResponse("登出错误"));
		}
		return BaseResponse.buildSuccessResponse(callResult);
	}
	
	public BaseResponse<String> resetPassword(final RestPwdReqDto restPwd) {
        String url = StaticConfigHelper.get("user_system") + "/resetPassword";
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName", restPwd.getMobileNo());
        params.put("smsCode", restPwd.getSmsCode());
        params.put("newPassword", DigestUtils.md5Hex(restPwd.getNewPassword()));
        String callResult = "";
        try {
        	logger.info("----------> 用户重置密码请求:" + params.toString());
            callResult = SimpleHttpClient.sendPost(url, params, charset);
            logger.info("----------> 用户重置密码陆结果:" + callResult);
            JSONObject jsonResult = JSONObject.parseObject(callResult);
            if (!jsonResult.get("status").equals(BaseResponse.OK)) {
                throw new MyBizException(BaseResponse.buildClientErrorResponse(jsonResult.get("msg").toString()));
            }
		} catch (MyBizException e) {
			throw new MyBizException(e.getResp());
		} catch (Exception e) {
			throw new MyBizException(BaseResponse.buildClientErrorResponse("系统错误"));
		}

        return BaseResponse.buildSuccessResponse(callResult);
    }


     
    public BaseResponse<MyShowDto> showMy(final long uid) {
        return service("加载个人帐户信息", new Callable<MyShowDto>() {
             
            public MyShowDto call() throws Exception {
                return memberBusiness.showMy(uid);
            }
        });
    }

     
    public BaseResponse<UserDto> getMyInfo(final long uid) {
        return service("加载个人基本信息", new Callable<UserDto>() {
             
            public UserDto call() throws Exception {
                return memberBusiness.getMyInfo(uid);
            }
        });
    }

     
    public BaseResponse<Long> updateMyInfo(final UserDto dto) {
        return service("更新个人基本信息", new Callable<Long>() {
             
            public Long call() throws Exception {
                memberBusiness.updateMyInfo(dto);
                return dto.getId();
            }
        });
    }


     
    public BaseResponse<Long> saveAddress(final UserAddressDto dto) {
        return service("保存地址信息", new Callable<Long>() {
             
            public Long call() {
                UserAddress po = new UserAddress();
                UserAddressDto.fromDTO2PO(dto, po);
                return memberBusiness.saveAddress(po);
            }
        });
    }

     
    public BaseResponse<Long> deleteAddress(final long aid, final long uid) {
        return service("删除收货地址", new Callable<Long>() {
             
            public Long call() throws Exception {
                memberBusiness.deleteAdress(aid, uid);
                return aid;
            }
        });
    }

     
    public BaseResponse<List<UserAddressDto>> listAddress(final long uid) {
        return service("获取地址列表", new Callable<List<UserAddressDto>>() {
             
            public List<UserAddressDto> call() throws Exception {
                return memberBusiness.listAddress(uid);
            }
        });
    }

     
    public BaseResponse<List<UserIdInfo>> listUserIdImage(final Long user_id) {
        return service("获取身份证图片列表", new Callable<List<UserIdInfo>>() {
             
            public List<UserIdInfo> call() throws Exception {
                return memberBusiness.listUserIdImage(user_id);
            }
        });
    }

     
    public BaseResponse<String> getImageCode(BaseAPIRequest<String> request) {
        return memberBusiness.getImageCode(request);
    }

     
    public BaseResponse<String> getSmsCode(BaseAPIRequest<String> request) {
        return memberBusiness.getSmsCode(request);
    }

     
    public BaseResponse<Long> saveIdImage(BaseAPIRequest<UserIdInfo> request) {
        return memberBusiness.saveIdImage(request);
    }

     
    public BaseResponse directLogin(DirectLoginRequest loginRequest) {
        return memberBusiness.directLogin(loginRequest);
    }

}
