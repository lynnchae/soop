package org.lynn.soop.contract.member;

import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.member.dto.CartDetailsDto;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by chenwen on 5/05/16.
 */
@Path("/service/cart")
@Produces({"application/json;charset=UTF-8"})
public interface CartServiceContact {

    @POST
    @Path("/cud-product")
    BaseResponse<Long> cudProduct(long userId, long productId, int unitPrice, boolean isDelete, int number, Boolean isAdd);

    @POST
    @Path("/details")
    BaseResponse<CartDetailsDto> details(long userId);

}
