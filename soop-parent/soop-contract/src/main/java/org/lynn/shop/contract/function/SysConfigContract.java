package org.lynn.soop.contract.function;



import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.SysParameter;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/function/config")
@Produces({"application/json;charset=UTF-8"})
public interface SysConfigContract {

    @POST
    @Path("/param")
    BaseResponse<String> getConfig(BaseAPIRequest<String> request);


    @POST
    @Path("/param/list")
    PageViewDto<SysParameter> getConfigList(QueryCondition queryCondition);


    @POST
    @Path("/param/update")
    BaseResponse saveConfig(BaseRequest<SysParameter> request);

    @POST
    @Path("/common/sync/exchangerate")
    BaseResponse syncExchangeRate();
}
