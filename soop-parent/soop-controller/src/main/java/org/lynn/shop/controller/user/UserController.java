package org.lynn.soop.controller.user;

import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.user.UserServiceContact;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.entity.UserAddress;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.controller.user
 * Description :
 * Author : cailinfeng
 * Date : 2016/8/1
 */
@Controller
@Path("/service/user")
@Produces({"application/json;charset=UTF-8"})
public class UserController extends BaseController{

    @Resource
    private UserServiceContact userServiceContact;

    @GET
    @Path("/address/list")
    public BaseResponse<UserAddress> getUserAddress(@QueryParam("userId") String userId){
        log.info("start to getUserAddress :" + userId);
        BaseResponse toReturn = new BaseResponse();
        try {
            toReturn = userServiceContact.getUserAddressList(userId);
        } catch (Exception e) {
            toReturn = BaseResponse.buildServerErrorResponse("获取用户地址失败!");
            log.error("getUserAddress error",e);
        }
        return toReturn;
    }

}
