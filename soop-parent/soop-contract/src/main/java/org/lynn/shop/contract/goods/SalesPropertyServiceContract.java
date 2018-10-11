package org.lynn.soop.contract.goods;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.SalesProperty;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/server/sales/property")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface SalesPropertyServiceContract {

    @POST
    @Path("/update")
    BaseResponse<Long> updateSalesProperty(BaseRequest req);

    @POST
    @Path("/list")
    PageViewDto<SalesProperty> listSalesProperty(Long goodsId);

    @POST
    @Path("/remove")
    BaseResponse removeSalesProperty(BaseRequest<Long> request);
}
