package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.member.CartServiceContact;
import org.lynn.soop.entity.UserSession;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.concurrent.Callable;

import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/openapi/cart")
@Produces({"application/json;charset=UTF-8"})
public class CartController extends BaseResource {
    @Resource
    private CartServiceContact cartService;


    /**
     * 增加，更新，或者删除购物车
     *
     * @param productId 商品编号
     * @param unitPrice 商品单价
     * @param isDelete  true的时候，将商品移除
     * @param number    数量
     * @return
     */
    @POST
    @Path("/cudGoods")
    public BaseResponse<Long> cudGoods(
            @FormParam("productId") final long productId,
            @FormParam("unitPrice") final int unitPrice,
            @FormParam("isDelete") @DefaultValue("false") final Boolean isDelete,
            @FormParam("isAdd") @DefaultValue("false") final Boolean isAdd,
            @FormParam("number") @DefaultValue("0") final Integer number
    ) {
        return invoke("购物车商品CUD", new Callable<BaseResponse<Long>>() {
            @Override
            public BaseResponse<Long> call() throws Exception {
                UserSession session = checkLogin();

                return cartService.cudProduct(session.getUser_id(), productId, unitPrice, isDelete, number, isAdd);
            }
        });
    }


    @GET
    @Path("/showFeeRule")
    public BaseResponse showFeeRule(BaseRequest req) {
        logger.info("start to showFeeRule with request: <<" + toJSON(req) + ">>");
        BaseResponse result;
        try {
            result = null;      //FIXME
        } catch (Exception e) {
            logger.error("showFeeRule error: " + e, e);
            result = BaseResponse.buildClientErrorResponse("加载运费规则异常!");
        }
        logger.info("end showFeeRule with result: <<" + toJSON(result) + ">>");
        return result;
    }

}
