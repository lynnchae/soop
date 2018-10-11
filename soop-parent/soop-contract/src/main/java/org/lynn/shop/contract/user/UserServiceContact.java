package org.lynn.soop.contract.user;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.user.dto.AddMemberRequest;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.User;

import javax.ws.rs.*;
import java.util.List;

@Path("/service/user")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface UserServiceContact {

    /**
     * 后台管理员添加会员接口
     *
     * @param addMemberRequest
     * @return
     */
    @POST
    @Path("/add")
    BaseResponse addMember(AddMemberRequest addMemberRequest);


    /**
     * 按分页请求查询用户列表
     *
     * @param queryCondition 查询条件＋分页条件
     * @return
     */
    @POST
    @Path("/list")
    PageViewDto<User> listUser(QueryCondition queryCondition);


    /**
     * 删除用户
     *
     * @param request
     * @return
     */
    @POST
    @Path("/remove")
    BaseResponse removeMember(BaseRequest<Long> request);

    @POST
    @Path("/remove/batch")
    BaseResponse batchRemoveMember(BaseRequest<List<Long>> removeUserRequest);

    @POST
    @Path("/update")
    BaseResponse updateUserInfo(BaseRequest<User> removeUserRequest);

    @GET
    @Path("address/list")
    BaseResponse getUserAddressList(String userId);
}
