package org.lynn.soop.contract.sku;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/sku")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface SkuServiceContact {

    @POST
    @Path("/test")
    BaseResponse test(BaseRequest abc);
}
