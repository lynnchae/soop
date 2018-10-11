package org.lynn.soop.business.member;

import com.alibaba.fastjson.JSONObject;
import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.business.pay.PayBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.member.VerifyCodeUtils;
import org.lynn.soop.contract.member.dto.*;
import org.lynn.soop.contract.order.dto.AcceptOrderDTO;
import org.lynn.soop.entity.*;
import org.lynn.soop.entity.handwrite.VerificationCodeExtend;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.*;
import org.lynn.soop.util.DataHelper;
import org.lynn.soop.util.HttpClientUtils;
import org.lynn.soop.util.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by chenwen on 4/30/16.
 */
@Component
public class MemberBusiness extends BaseBusiness {

    @Resource
    private VerificationCodeReadMapper verificationCodeReadMapper;
    @Resource
    private VerificationCodeWriteMapper verificationCodeWriteMapper;

    @Resource
    private UserReadMapper userReadMapper;
    @Resource
    private UserWriteMapper userWriteMapper;

    @Resource
    private UserSessionReadMapper userSessionReadMapper;
    @Resource
    private UserSessionWriteMapper userSessionWriteMapper;

    @Resource
    private UserAddressReadMapper userAddressReadMapper;
    @Resource
    private UserAddressWriteMapper userAddressWriteMapper;

    @Autowired
    UserIdInfoReadMapper userIdInfoReadMapper;

    @Autowired
    UserIdInfoWriteMapper userIdInfoWriteMapper;
    
    @Resource
    private PayBusiness payBusiness;


    public VerificationCode generateVerifyCode(VerificationCodeExtend.Type type, String businessRefNo) {
        int expiredSeconds = type.getExpiredTimeInSecond();
        String keyNumber = DataHelper.generateUniqueToken();
        String verifyCode;
        if (VerificationCodeExtend.Type.SMS.equals(type)) {
            verifyCode = VerifyCodeUtils.generateNumericVerifyCode(type.getLength());
        } else {
            verifyCode = VerifyCodeUtils.generateVerifyCode(type.getLength());
        }
        VerificationCode vc = new VerificationCode();
        vc.setType(type.name());
        vc.setCode(verifyCode);
        vc.setKey_number(keyNumber);
        vc.setBusiness_ref_no(businessRefNo);
        vc.setExpired_at(new Date(System.currentTimeMillis() + expiredSeconds * 1000));
        int effectedRow = verificationCodeWriteMapper.insert(vc);
        if (effectedRow != 1)
            throw new RuntimeException("error in generate image verify code.");
        return vc;
    }


    public VerificationCode getVerifyCode(VerificationCodeExtend.Type type, String keyNumber, String verifyCode) {
        VerificationCodeExample example = new VerificationCodeExample();
        VerificationCodeExample.Criteria c = example.createCriteria();
        c.andTypeEqualTo(type.name());
        c.andKey_numberEqualTo(keyNumber);
        c.andCodeEqualTo(verifyCode);
        List<VerificationCode> list = verificationCodeReadMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (list.size() > 1) {
            throw new RuntimeException(String.format("found one more record with example: { type=[%s], keyNumber=[%s], verifyCode=[%s] }", type.name(), keyNumber, verifyCode));
        }
        return list.get(0);
    }

	public User registerMember(RegisterReqDto dto) {
		return registerMember(dto, "");
	}

	public User registerMember(RegisterReqDto dto, String group) {
		User u = new User();
		u.setLogin_name(dto.getUserId());
		u.setMobile_no(dto.getUserId());
		u.setPassword("");
		u.setUnique_token(DataHelper.generateUniqueToken());
		if (!StringUtils.isEmpty(dto.getCode()) && !"null".equals(dto.getCode())) {
			String openid = payBusiness.exchangeOpenId(dto.getCode());
			u.setOpenid(openid);
		}
		u.setUser_name("");
		u.setCurrent_membership_level("");
		u.setDate_created(new Date());
		u.setDate_updated(new Date());
		u.setCreated_by("system");
		u.setUpdated_by("system");
		u.setUser_group(group);
		userWriteMapper.insert(u);
		return u;
	}


    public User getByUserId(String userId) {
        UserExample e = new UserExample();
        UserExample.Criteria uc = e.createCriteria();
        uc.andLogin_nameEqualTo(userId);
        List<User> list = userReadMapper.selectByExample(e);
        if (CollectionUtils.isEmpty(list)) {
            logger.error("userId不存在: [" + userId + "]");
            throw new MyBizException(BaseResponse.buildClientErrorResponse("用户不存在,请确认后重试!"));
        }
        if (list.size() > 1) {
            logger.error("userId有重复: [" + userId + "]");
            throw new MyBizException(BaseResponse.buildServerErrorResponse("用户信息异常,请联系客服!"));
        }
        return list.get(0);
    }
    
	public Boolean existUser(String userId) {
        UserExample e = new UserExample();
        UserExample.Criteria uc = e.createCriteria();
        uc.andLogin_nameEqualTo(userId);
        List<User> list = userReadMapper.selectByExample(e);
        if (list.size() == 1) {
            return true;
        } else if (list.size() > 1) {
            // 数据修复
            for (User user : list) {
                logger.error("删除用户:" + user.getLogin_name());
                userWriteMapper.deleteByPrimaryKey(user.getId());
            }
            return false;
        } else {
            return false;
        }
    }

    public UserSession createSession(String userId, String sessionId) {
        long now = System.currentTimeMillis();

        User user = getByUserId(userId);
        user.setLast_login_time(new Date(now));
        user.setOnline_status(true);
        userWriteMapper.updateByPrimaryKey(user);

        UserSession session = getSessionByUserId(user.getId());
        if (session == null) {
            session = new UserSession();
            session.setSession_id(sessionId);
            session.setUser_id(user.getId());
            session.setExpired_at(new Date(now + 1800000));  //todo 会话半小时不活动则过期
            session.setIs_valid(true);
            userSessionWriteMapper.insert(session);
        } else {
            session.setExpired_at(new Date(now + 1800000));  //todo 会话半小时不活动则过期
            session.setIs_valid(true);
            session.setSession_id(sessionId);
            userSessionWriteMapper.updateByPrimaryKey(session);
        }
        return session;
    }

    /**
     * 检查用户session，暂时不需要session过期
     *
     * @param sessionId
     * @return
     */
    public UserSession checkSession(String sessionId) {
        long now = System.currentTimeMillis();

        UserSession session = getBySessionId(sessionId);
        if (session == null) {
            throw new MyBizException(BaseResponse.buildResponse(BaseResponse.CODE_CLIENT_NO_LOGIN, "请先登陆!"));
        }
        boolean isValid = session.getIs_valid() != null && session.getIs_valid();
        if (!isValid || session.getExpired_at().getTime() < now) {
            throw new MyBizException(BaseResponse.buildResponse(BaseResponse.CODE_CLIENT_NO_LOGIN, "回话已过期,请重新登陆!"));
        }
        session.setExpired_at(new Date(now + 1800000));  //todo 会话半小时不活动则过期
        userSessionWriteMapper.updateByPrimaryKey(session);

        return session;
    }

    public UserSession invalidSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        UserSession session = getBySessionId(sessionId);
        if (session == null) {
            return null;
        }

        long now = System.currentTimeMillis();
        session.setExpired_at(new Date(now));
        session.setIs_valid(false);
        userSessionWriteMapper.updateByPrimaryKey(session);

        User user = userReadMapper.selectByPrimaryKey(session.getUser_id());
        user.setOnline_status(false);
        userWriteMapper.updateByPrimaryKey(user);

        return session;
    }

    public UserSession getSessionByUserId(String userId) {
        return getSessionByUserIdOrSessionId(userId);
    }

    public UserSession getSessionByUserId(Long userId) {
        return getSessionByUserIdOrSessionId(userId);

    }

    private UserSession getSessionByUserIdOrSessionId(Object userId) {
        Long uid;
        if (userId instanceof Long) {
            uid = (Long) userId;
        } else {
            User user = getByUserId(String.valueOf(userId));
            uid = user.getId();
        }
        UserSessionExample e = new UserSessionExample();
        UserSessionExample.Criteria usc = e.createCriteria();
        usc.andUser_idEqualTo(uid);

        List<UserSession> list = userSessionReadMapper.selectByExample(e);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (list.size() > 1) {
            logger.error("userSession有重复: userId=[" + userId + "]");
            throw new MyBizException(BaseResponse.buildServerErrorResponse("用户信息异常,请联系客服!"));
        }
        return list.get(0);
    }

    public UserSession getBySessionId(String sessionId) {
        UserSessionExample e = new UserSessionExample();
        UserSessionExample.Criteria usc = e.createCriteria();
        usc.andSession_idEqualTo(sessionId);

        List<UserSession> list = userSessionReadMapper.selectByExample(e);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (list.size() > 1) {
            logger.error("userSession有重复: sessionId=[" + sessionId + "]");
            throw new MyBizException(BaseResponse.buildServerErrorResponse("用户信息异常,请联系客服!"));
        }
        return list.get(0);
    }


    /**
     * 保存地址信息
     * 如果证件图片未保存过，增加到用户证件图片记录中
     *
     * @param po
     * @return 地址ID
     */
    public Long saveAddress(UserAddress po) {
        if (po.getId() == null) {
            userAddressWriteMapper.insertSelective(po);
            po.setFlag("insert");
        } else {
            userAddressWriteMapper.updateByPrimaryKey(po);
            po.setFlag("update");
        }

        //先去user表根据id查询user_name(uid)
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(po.getUser_id());
        List<User> users = userReadMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(users)) {
            String userId = users.get(0).getUser_name();
            po.setUser_id(Long.valueOf(userId));
        }
        Map<String, String> map = new HashMap<>();
        String json = JSONObject.toJSONString(po);
        map.put("jsonAddress", json);
        String url = PropertyUtils.getValue("yhfq.syncAddress");
        //String url = "http://192.168.1.107:8080/vip-web/yhfq/sync";
        //调用 应花分期接口
        logger.debug("同步地址参数：{}", json);
        logger.debug("同步地址url:{}", url);
        try {
            HttpClientUtils.doPost(url, map);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return po.getId();
    }

    public void deleteAdress(long aid, long uid) {
        UserAddress a = userAddressReadMapper.selectByPrimaryKey(aid);
        //Assert.notNull(a, "Not found address with id: [" + aid + "]");
        //Assert.isTrue(a.getUser_id() == uid, "Address is not current user: [" + uid + "], but [" + a.getUser_id() + "]");
        if (a != null) {
            userAddressWriteMapper.deleteByPrimaryKey(aid);
        }
    }

    public List<UserAddressDto> listAddress(long uid) {
        UserAddressExample e = new UserAddressExample();
        e.createCriteria().andUser_idEqualTo(uid);
        List<UserAddress> list = userAddressReadMapper.selectByExample(e);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<UserAddressDto> results = new ArrayList<UserAddressDto>();
        for (UserAddress po : list) {
            UserAddressDto dto = new UserAddressDto();
            UserAddressDto.fromPO2DTO(po, dto);
            results.add(dto);
        }
        return results;
    }


    public UserDto getMyInfo(long uid) {
        User po = userReadMapper.selectByPrimaryKey(uid);
        UserDto dto = new UserDto();
        UserDto.fromPO2DTO(po, dto);
        return dto;
    }

    public UserDto getMyInfoByMobileNo(String mobileNo) {
        UserExample e = new UserExample();
        UserExample.Criteria uec = e.createCriteria();
        uec.andMobile_noEqualTo(mobileNo);
        List<User> userList = userReadMapper.selectByExample(e);
        if(userList.size() == 0){
            return  null;
        }
        UserDto dto = new UserDto();
        UserDto.fromPO2DTO(userList.get(0), dto);
        dto.setId(userList.get(0).getId());
        return dto;
    }

    public void updateMyInfo(UserDto dto) {
        User po = userReadMapper.selectByPrimaryKey(dto.getId());
        po.setMobile_no(dto.getMobileNo());
        po.setEmail(dto.getEmail());
        // TODO 性别 gender; 生日 birthday
        userWriteMapper.updateByPrimaryKey(po);
    }
    
    public void updateMyInfo(User dto) {
        userWriteMapper.updateByPrimaryKey(dto);
    }

    public MyShowDto showMy(long uid) {
        MyShowDto result = new MyShowDto();

        User userPO = userReadMapper.selectByPrimaryKey(uid);
        UserDto userDTO = new UserDto();
        UserDto.fromPO2DTO(userPO, userDTO);
        result.setUser(userDTO);

        List<UserAddressDto> addressList = listAddress(uid);
        result.setAddressList(addressList);
        result.setAddressNum(addressList.size());

        List<AcceptOrderDTO> orderList = Collections.emptyList();  //FIXME 获取未完成的订单列表
        result.setOrderList(orderList);
        result.setOrderNum(orderList.size());

        return result;
    }

    public List<UserIdInfo> listUserIdImage(Long userId) {
        UserIdInfoExample userIdInfoExample = new UserIdInfoExample();
        userIdInfoExample.createCriteria().andUser_idEqualTo(userId);
        return userIdInfoReadMapper.selectByExample(userIdInfoExample);
    }

    public BaseResponse<String> getImageCode(BaseAPIRequest<String> request) {
        VerificationCodeExample example = new VerificationCodeExample();
        example.createCriteria().andKey_numberEqualTo(request.getData()).andTypeEqualTo(VerificationCodeExtend.Type.IMAGE.name());

        List<VerificationCode> verificationCodes = verificationCodeReadMapper.selectByExample(example);
        if (verificationCodes.size() == 1) {
            return BaseResponse.buildSuccessResponse(verificationCodes.get(0).getCode());
        }
        throw new RuntimeException("获取图片验证码失败");
    }

    public BaseResponse<String> getSmsCode(BaseAPIRequest<String> request) {
        VerificationCodeExample example = new VerificationCodeExample();
        example.createCriteria().andKey_numberEqualTo(request.getData())
                .andTypeEqualTo(VerificationCodeExtend.Type.SMS.name());

        List<VerificationCode> verificationCodes = verificationCodeReadMapper.selectByExample(example);
        if (verificationCodes.size() == 1) {
            return BaseResponse.buildSuccessResponse(verificationCodes.get(0).getCode());
        }
        throw new RuntimeException("获取短信验证码失败");
    }

    public boolean canSendSMSValidateCode(String mobileNo) {
        long now = System.currentTimeMillis();
        VerificationCodeExample example = new VerificationCodeExample();
        example.createCriteria().andBusiness_ref_noEqualTo(mobileNo)
                .andDate_createdGreaterThan(new Date(now - 1000 * 60 * 60 * 24));
        int count = verificationCodeReadMapper.countByExample(example);
        return count < 5; //5 sms per day
    }

    public BaseResponse<Long> saveIdImage(BaseAPIRequest<UserIdInfo> request) {
        UserIdInfo userIdInfo = request.getData();
        userIdInfo.setUser_id(request.getUser());
        int effectedRow;
        if (userIdInfo.getId() == null) {
            effectedRow = userIdInfoWriteMapper.insertSelective(userIdInfo);
        } else {
            userIdInfo.setDate_updated(new Date());
            effectedRow = userIdInfoWriteMapper.updateByPrimaryKeySelective(userIdInfo);
        }

        if (effectedRow == 0) {
            throw new RuntimeException("保存更新用户证件图片失败");
        }

        return BaseResponse.buildSuccessResponse(userIdInfo.getId());
    }

    public BaseResponse directLogin(DirectLoginRequest loginRequest) {
        String msgCaptchaKey = loginRequest.getMsgCaptchaKey();
        VerificationCodeExample example = new VerificationCodeExample();
        example.createCriteria()
                .andKey_numberEqualTo(msgCaptchaKey)
                .andCodeEqualTo(loginRequest.getPassword())
                .andTypeEqualTo(VerificationCodeExtend.Type.SMS.name());

        int count = verificationCodeReadMapper.countByExample(example);
        if (count == 1) {
            //verify pass
            UserExample userExample = new UserExample();
            userExample.createCriteria().andMobile_noEqualTo(loginRequest.getMobileNo());

            List<User> users = userReadMapper.selectByExample(userExample);
            User user;
            if (users.size() == 0) {
                //not exist, create new
                RegisterReqDto registerReqDto = new RegisterReqDto();
                registerReqDto.setUserId(loginRequest.getMobileNo());
                registerReqDto.setPassword("");
                user = registerMember(registerReqDto);
            } else {
                user = users.get(0);
            }

            String sessionId = DataHelper.generateUniqueToken();
            UserSession userSession = createSession(String.valueOf(user.getMobile_no()),sessionId);

            return BaseResponse.buildSuccessResponse(userSession.getSession_id());
        } else {
            //verify failed
            throw new RuntimeException("短信验证码验证失败");
        }
    }
}
