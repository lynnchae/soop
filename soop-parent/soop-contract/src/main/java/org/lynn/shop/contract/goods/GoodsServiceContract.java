package org.lynn.soop.contract.goods;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.Goods;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/goods")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface GoodsServiceContract {

    @POST
    @Path("/update")
    BaseResponse<Long> updateGoods(BaseRequest req);

    @POST
    @Path("/list")
    PageViewDto<Goods> listGoods(BaseQueryRequest queryCondition);
}
