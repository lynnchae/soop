package org.lynn.soop.contract.member;

import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.entity.UserSession;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by chenwen on 5/02/16.
 */
@Path("/service/member")
@Produces({"application/json;charset=UTF-8"})
public interface SessionServiceContact {

    @POST
    @Path("/session/create")
    BaseResponse<UserSession> create(String userId, String sessionId);

    @POST
    @Path("/session/check")
    BaseResponse<UserSession> check(String sessionId);

    @POST
    @Path("/session/invalid")
    BaseResponse<UserSession> invalid(String sessionId);

}
