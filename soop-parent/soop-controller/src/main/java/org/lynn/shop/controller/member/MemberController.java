package org.lynn.soop.controller.member;


import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.user.UserServiceContact;
import org.lynn.soop.contract.user.dto.AddMemberRequest;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.entity.User;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/service/member")
@Produces({"application/json;charset=UTF-8"})
public class MemberController extends BaseController {

    @Resource
    UserServiceContact userServiceContact;

    @POST
    @Path("/add")
    public BaseResponse addMember(AddMemberRequest addMemberRequest) {
        log.info("start to add member with request:" + toJSON(addMemberRequest));
        BaseResponse result;
        try {
            result = userServiceContact.addMember(addMemberRequest);
        } catch (Exception e) {
            log.error("error in add member user.", e);
            result = BaseResponse.buildClientErrorResponse("添加用户失败");
        }
        return result;
    }

    @POST
    @Path("/list")
    public PageViewDto<User> listUser(QueryCondition queryCondition) {
        log.info("start handle list user request:" + toJSON(queryCondition));
        PageViewDto<User> toReturn;
        try {
            toReturn = userServiceContact.listUser(queryCondition);
        } catch (Exception e) {
            log.error("error in list user.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list user request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @POST
    @Path("/remove")
    public BaseResponse removeMember(@FormParam("id") long userId) {
        log.info("start to remove member :" + userId);

        BaseResponse result;
        try {
            BaseRequest<Long> removeUserRequest = setupRequest(userId);
            result = userServiceContact.removeMember(removeUserRequest);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove member user.", e);
            result = BaseResponse.buildClientErrorResponse("删除用户失败");
        }
        return result;
    }

    @POST
    @Path("/remove/batch")
    public BaseResponse batchRemoveMember(List<Long> users) {
        log.info("start to remove member :" + toJSON(users));

        BaseResponse result;
        try {
            BaseRequest<List<Long>> removeUserRequest = setupRequest(users);
            result = userServiceContact.batchRemoveMember(removeUserRequest);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove member user.", e);
            result = BaseResponse.buildClientErrorResponse("删除用户失败");
        }
        return result;
    }

    @POST
    @Path("/update")
    public BaseResponse update(User user) {
        log.info("start to update member :" + toJSON(user));

        BaseResponse result;
        try {
            BaseRequest<User> removeUserRequest = setupRequest(user);
            result = userServiceContact.updateUserInfo(removeUserRequest);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update member user.", e);
            result = BaseResponse.buildClientErrorResponse("更新用户信息失败");
        }
        return result;
    }

}
