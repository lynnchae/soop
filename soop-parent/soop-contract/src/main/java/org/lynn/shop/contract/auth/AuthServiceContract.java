package org.lynn.soop.contract.auth;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/auth")
@Produces({"application/json;charset=UTF-8"})
public interface AuthServiceContract {

    @POST
    @Path("/getAccessToken")
	String getAccessToken(String code, String type, String orderId, String phone);
}
