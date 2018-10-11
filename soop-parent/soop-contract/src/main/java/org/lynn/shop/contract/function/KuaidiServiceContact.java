package org.lynn.soop.contract.function;

import org.lynn.soop.contract.BaseResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by chenwen on 5/15/16.
 */
@Path("/service/function/kuaidi")
@Produces({"application/json;charset=UTF-8"})
public interface KuaidiServiceContact {

    @POST
    @Path("/query")
    BaseResponse<KuaidiResp> query(String com, String nu);

}
