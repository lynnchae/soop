package org.lynn.soop.openapi.controller;

import static org.lynn.soop.util.JsonHelper.toJSON;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Controller;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.member.dto.ProductCalRequest;
import org.lynn.soop.contract.order.OrderServiceContract;
import org.lynn.soop.contract.order.dto.AcceptOrderDTO;
import org.lynn.soop.util.DataHelper;

@Controller
@Path("/openapi/order")
@Produces({"application/json;charset=UTF-8"})
public class OrderController extends BaseResource {
    @Resource
    OrderServiceContract orderServiceContract;


    /**
     * 订单下单接口，接受商品信息和物流信息，计算订单的价格，进入待支付状态
     *
     * @param req
     * @return
     */
    @POST
    @Path("/accept")
    @Consumes({"application/json;charset=UTF-8"})
	public BaseResponse accept(AcceptOrderDTO req) {
		logger.info("start to accept with request: <<" + toJSON(req) + ">>");
		BaseResponse result;
		try {
			String validateResult = req.validate();
			if (isNotEmpty(validateResult)) {
				return BaseResponse.buildClientErrorResponse(validateResult);
			}
			BaseAPIRequest<AcceptOrderDTO> request = setupRequest(req);
			result = orderServiceContract.acceptOrder(request);
		} catch (MyBizException e) {
			logger.error("accept error: " + e, e);
			result = e.getResp();
		} catch (Exception e) {
			logger.error("accept error: " + e, e);
			result = BaseResponse.buildClientErrorResponse("提交订单异常!");
		}
		logger.info("end accept with result: <<" + toJSON(result) + ">>");
		return result;
	}

    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     */
    @GET
    @Path("/detail")
	public BaseResponse details(@QueryParam("orderId") String orderId) {
		logger.info("start to details with request: <<" + orderId + ">>");
		BaseResponse result;
		try {
			BaseAPIRequest<String> request = setupRequest(orderId);
			result = orderServiceContract.getOrderDetail(request);
		} catch (MyBizException e) {
			logger.error("list error: " + e, e);
			result = e.getResp();
		} catch (Exception e) {
			logger.error("details error: " + e, e);
			result = BaseResponse.buildClientErrorResponse("加载订单异常!");
		}
		logger.info("end details with result: <<" + toJSON(result) + ">>");
		return result;
	}

    /**
     * 订单列表页面，返回待付款和已付款两种订单号列表
     *
     * @return
     */
    @GET
    @Path("/list")
	public BaseResponse detailList() {
		BaseResponse result;
		try {
			BaseAPIRequest<String> request = setupRequest("");
			result = orderServiceContract.getOrderDetailList(request);
		} catch (MyBizException e) {
			logger.error("list error: " + e, e);
			result = e.getResp();
		} catch (Exception e) {
			logger.error("details error: " + e, e);
			result = BaseResponse.buildClientErrorResponse("加载订单列表异常!");
		}

		return result;
	}


    @POST
    @Path("/calc")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse calOrder(ProductCalRequest productCalRequest) {
        BaseResponse toReturn;
        try {
            BaseAPIRequest<ProductCalRequest> request = setupRequest(productCalRequest, false);
            toReturn = orderServiceContract.calOrder(request);
        } catch (Exception e) {
            String errorMsg = DataHelper.buildErrorMsg("商品列表价格试算失败");
            logger.error(errorMsg, e);
            toReturn = BaseResponse.buildServerErrorResponse(errorMsg);
        }
        return toReturn;
    }


}
