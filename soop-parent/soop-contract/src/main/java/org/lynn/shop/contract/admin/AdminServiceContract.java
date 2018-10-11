package org.lynn.soop.contract.admin;



import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.admin.dto.LoginRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/admin")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface AdminServiceContract {

    @POST
    @Path("/login")
    BaseResponse<String> login(LoginRequest loginRequest);

    @POST
    @Path("/login/check")
    BaseResponse<String> checkSession(String sessionId);


    @POST
    @Path("/password/change")
    BaseResponse changePassword(BaseRequest<String> request);
}
