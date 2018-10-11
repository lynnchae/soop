package org.lynn.soop.contract.member;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.member.dto.*;
import org.lynn.soop.entity.UserIdInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

/**
 * Created by chenwen on 4/30/16.
 */
@Path("/service/member")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface MemberServiceContact {

    @POST
    @Path("/verifyCode/image")
    BaseResponse<String> genImageVerifyCode();

    @POST
    @Path("/verifyCode/sms")
    BaseResponse<String> genSmsVerifyCode(BaseAPIRequest<String> request, String smsCode, String remoteIp);

    @POST
    @Path("/register")
    BaseResponse<Long> register(RegisterReqDto dto);

    /**
     * @return token令牌, 目前用 User.ID 的某种编码充当
     */
    @POST
    @Path("/login")
    BaseResponse<String> login(LoginReqDto dto);
    
    @POST
    @Path("/logout")
    BaseResponse<String> logout(String code);
    
    @POST
    @Path("/resetPassword")
    BaseResponse<String> resetPassword(RestPwdReqDto restPwd);


    @POST
    @Path("/my")
    BaseResponse<MyShowDto> showMy(long uid);

    @POST
    @Path("/myinfo")
    BaseResponse<UserDto> getMyInfo(long uid);


    @POST
    @Path("/myinfo/update")
    BaseResponse<Long> updateMyInfo(UserDto dto);

    @POST
    @Path("/address/save")
    BaseResponse<Long> saveAddress(UserAddressDto dto);

    @POST
    @Path("/address/delete")
    BaseResponse<Long> deleteAddress(long aid, long uid);

    @POST
    @Path("/address/list")
    BaseResponse<List<UserAddressDto>> listAddress(long uid);

    @POST
    @Path("/address/idimage/list")
    BaseResponse<List<UserIdInfo>> listUserIdImage(Long user_id);


    @POST
    @Path("/register/imagecode/get")
    BaseResponse<String> getImageCode(BaseAPIRequest<String> request);


    @POST
    @Path("/register/smscode/get")
    BaseResponse<String> getSmsCode(BaseAPIRequest<String> request);


    @POST
    @Path("/address/idimage/save")
    BaseResponse<Long> saveIdImage(BaseAPIRequest<UserIdInfo> request);

    @POST
    @Path("/member/direct/login")
    BaseResponse directLogin(DirectLoginRequest loginRequest);
}
