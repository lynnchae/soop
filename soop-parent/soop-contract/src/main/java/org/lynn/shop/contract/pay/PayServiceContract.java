package org.lynn.soop.contract.pay;

import java.util.Map;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.pay.dto.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/pay")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface PayServiceContract {
    /**
     * 微信支付回调结果确认
     *
     * @param wxNotifyResult
     * @return
     */
    @POST
    @Path("/wx/callback")
    BaseResponse handleWxPayResult(WxNotifyResult wxNotifyResult);

    @POST
    @Path("/wx/prepare-pay")
    BaseResponse<WxPayResponse> prepareWxPay(BaseAPIRequest<WxPayPrepareRequest> request);


    @POST
    @Path("/alipay/notify-result")
    BaseResponse handleAlipayNotifyResult(AlipayNotifyResult alipayNotifyResult);

    @POST
    @Path("/wx/prepare-pay-through-code")
    BaseResponse<WxPayResponse> prepareWxPayThroughCode(BaseAPIRequest<WxPayPrepareRequest> request);


    @POST
    @Path("waptcOrderQuery")
    BaseResponse waptcOrderQuery(BaseAPIRequest<String> request);

    BaseResponse payWithUnion(BaseAPIRequest<UnionWapPayRequest> request);

    void handleUnionpayNotifyResult(Map<String, String> params);
}
