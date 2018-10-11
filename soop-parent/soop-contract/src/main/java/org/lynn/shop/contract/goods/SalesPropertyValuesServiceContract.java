package org.lynn.soop.contract.goods;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.SalesPropertyValues;

import javax.ws.rs.*;

/**
 * Created by gaoguoxiang on 2016/7/13
 */
@Path("/service/sales/property/values")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface SalesPropertyValuesServiceContract {

    @POST
    @Path("/update")
    public BaseResponse updateSalesPropertyValues(BaseRequest request);

    @GET
    @Path("/list")
    public PageViewDto<SalesPropertyValues> listSalesPropertyValues(Long spId);

    @POST
    @Path("/remove")
    public BaseResponse removeSalesPropertyValues(BaseRequest<Long> request);
}
