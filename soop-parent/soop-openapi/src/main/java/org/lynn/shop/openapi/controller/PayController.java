package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.pay.PayServiceContract;
import org.lynn.soop.contract.pay.dto.AlipayNotifyResult;
import org.lynn.soop.contract.pay.dto.UnionWapPayRequest;
import org.lynn.soop.contract.pay.dto.WxNotifyResult;
import org.lynn.soop.contract.pay.dto.WxPayPrepareRequest;
import org.lynn.soop.util.ExceptionUtil;
import org.lynn.soop.util.XmlUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/openapi/pay")
@Produces({"application/json;charset=UTF-8"})
public class PayController extends BaseResource {

    @Resource
    PayServiceContract payServiceContract;


    /**
     * 银联WAP支付订单查询
     * @param billNo  支付订单号
     * @return
     */
    @POST
    @Path("/waptcOrderQuery")
    @Produces({"application/xml;charset=UTF-8"})
    public BaseResponse waptcOrderQuery (String billNo) {
        logger.info("start to accept with request: <<" + billNo + ">>");
        BaseResponse result;
        try {
            BaseAPIRequest<String> request = setupRequest(billNo);
            result = payServiceContract.waptcOrderQuery(request);
        } catch (Exception e) {
            logger.error("accept errpr: "+e, e);
            result = BaseResponse.buildClientErrorResponse("银联WAP支付订单查询异常");
        }
        logger.info("end accept with result:　<<" + toJSON(result) + ">>");
        return result;
    }



    /**
     * 微信支付准备，返回预付单号，供前段js调用发起支付，更新状态为已发起支付
     *
     * @param req
     * @return
     */
    @Deprecated
    @POST
    @Path("/wx/prepare-pay")
    public BaseResponse prepareWxPay(WxPayPrepareRequest req) {
        logger.info("start to accept with request: <<" + toJSON(req) + ">>");
        BaseResponse result;
        try {
            req.setSpbillCreateIp(resolveRealIP());
            BaseAPIRequest<WxPayPrepareRequest> request = setupRequest(req);
            result = payServiceContract.prepareWxPay(request);
        } catch (Exception e) {
            logger.error("accept error: " + e, e);
            result = BaseResponse.buildClientErrorResponse("微信支付准备异常!");
        }
        logger.info("end accept with result: <<" + toJSON(result) + ">>");
        return result;
    }


    private String resolveRealIP() {
        logger.info("request header is:" + toJSON(httpHeaders.getRequestHeaders()));
        List<String> header = httpHeaders.getRequestHeader("X-Real-IP");
        if (header != null && header.size() > 0) {
            return header.get(0);
        }

        header = httpHeaders.getRequestHeader("x-forwarded-for");
        if (header != null && header.size() > 0) {
            return header.get(0);
        }

        header = httpHeaders.getRequestHeader("Proxy-Client-IP");
        if (header != null && header.size() > 0) {
            return header.get(0);
        }

        header = httpHeaders.getRequestHeader("WL-Proxy-Client-IP");
        if (header != null && header.size() > 0) {
            return header.get(0);
        }

        logger.error("no request ip found.");
        return null;
    }

    /**
     * 微信支付准备，返回预付单号，供前段js调用发起支付，更新状态为已发起支付
     *
     * @param req
     * @return
     */
    @POST
    @Path("/wx/prepare-pay-through-code")
    public BaseResponse prepareWxPayThroughCode(WxPayPrepareRequest req) {
           BaseResponse result;
        try {
            req.setSpbillCreateIp(resolveRealIP());
            BaseAPIRequest<WxPayPrepareRequest> request = setupRequest(req);
            result = payServiceContract.prepareWxPayThroughCode(request);
        } catch (Exception e) {
            logger.error("accept error: " + e, e);
            result = BaseResponse.buildClientErrorResponse("微信支付准备异常!");
        }
        logger.info("end accept with result: <<" + toJSON(result) + ">>");
        return result;
    }


    /**
     * 微信支付结果通知处理，如果支付成功，进入待采购状态
     *
     * @param request
     * @return
     */
    @POST
    @Path("/wx/pay-result")
    @Produces({"application/xml;charset=UTF-8"})
    public String wxPayResult(String request) {
        logger.info("start to accept with request: <<" + request + ">>");
        Map<String, String> result = new HashMap<>();
        Map<String, String> body = new HashMap<>();
        try {
            WxNotifyResult wxNotifyResult = WxNotifyResult.build(request);
            payServiceContract.handleWxPayResult(wxNotifyResult);
            body.put("return_code", "SUCCESS");
            body.put("return_msg", "SUCCESS");
        } catch (Exception e) {
            logger.error("wxPayResult error: " + e, e);
            body.put("return_code", "FAIL");
            body.put("return_msg", "failed");
        }
        result.put("xml", XmlUtil.buildXmlNodes(body));
        String resultData = XmlUtil.buildXmlNodes(result);
        logger.info("end accept with result: <<" + resultData + ">>");
        return resultData;
    }

    /**
     * 微信支付结果查询补偿
     *
     * @return
     */
    @GET
    @Path("/job/wx/query-order")
    public BaseResponse wxQueryOrder() {
        logger.info("start to wxQueryOrder");
        BaseResponse result;
        try {
            result = null;      //FIXME
        } catch (Exception e) {
            logger.error("accept error: " + e, e);
            result = BaseResponse.buildClientErrorResponse("微信支付结果通知处理异常!");
        }
        logger.info("end accept with result: <<" + toJSON(result) + ">>");
        return result;
    }

    /**
     * 支付宝支付结果通知处理，如果支付成功，进入待采购状态
     */
    @POST
    @Path("/alipay/notify-result")
    public String alipayNotifyResult() {
        try {
            MultivaluedMap<String, String> formParams = httpRequest.getFormParameters();
            logger.info("accept alipayNotifyResult: " + formParams);

            Map<String, String> params = new LinkedHashMap<String, String>();
            for (String k : formParams.keySet()) {
                params.put(k, formParams.getFirst(k));
            }

            AlipayNotifyResult nr = new AlipayNotifyResult(params);

            BaseResponse serviceResp = payServiceContract.handleAlipayNotifyResult(nr);

            if (serviceResp.getCode() == BaseResponse.CODE_OK) {
                logger.info("alipayNotifyResult success.");
                return "success";
            }

            logger.warn("alipayNotifyResult failed !");
            return "fail: " + serviceResp.getMessage();

        } catch (Throwable e) {
            Throwable ee = ExceptionUtil.getRootCause(e);
            logger.error("alipayNotifyResult error: " + ee, e);
            return "fail: " + ee;
        }
    }

    @POST
    @Path("/payWithUnionWap")
    public BaseResponse payWithUnionWap(@FormParam("billNo") String billNo , @FormParam("money") Long money){
        logger.info("start to payWithUnion with request: <<" + toJSON(billNo+"--"+money) + ">>");
        BaseResponse result;
        try {
            UnionWapPayRequest req = new UnionWapPayRequest();
            req.setBillNo(billNo);
            req.setMoney(money);
            BaseAPIRequest<UnionWapPayRequest> request = setupRequest(req,false);
            result = payServiceContract.payWithUnion(request);
        }catch (RuntimeException e){
            logger.error("payWithUnion error: " + e, e);
            result = BaseResponse.buildClientErrorResponse(e.getMessage());
        } catch(Exception e) {
            logger.error("accept error: " + e, e);
            result = BaseResponse.buildClientErrorResponse("银联wap支付异常!");
        }
        logger.info("end payWithUnion with result: <<" + toJSON(result) + ">>");
        return result;
    }

    @POST
    @Path("/unionpayNotifyResult")
	public String unionpayNotifyResult() {
		try {
			MultivaluedMap<String, String> formParams = httpRequest.getFormParameters();
			logger.info("accept unionpayNotifyResult: " + formParams.toString());

			Map<String, String> params = new LinkedHashMap<String, String>();
			for (String k : formParams.keySet()) {
				params.put(k, formParams.getFirst(k));
			}
			payServiceContract.handleUnionpayNotifyResult(params);
			return "success";
		} catch (Exception e) {
			logger.info("end unionpayNotifyResult error: <<" + e.getMessage() + ">>");
			return "error";
		}
	}
    
    @POST
    @Path("/yhfqPayNotifyResult")
	public String yhfqPayNotifyResult(@FormParam("orderId") String orderId, @FormParam("payResult") String payResult) {
		try {
			logger.info("accept yhfqPayNotifyResult: " + orderId);
			Map<String, String> params = new LinkedHashMap<String, String>();
			params.put("billNo", orderId);
			params.put("billStatus", payResult);
			payServiceContract.handleUnionpayNotifyResult(params);
			return "success";
		} catch (Exception e) {
			logger.info("end unionpayNotifyResult error: <<" + e.getMessage() + ">>");
			return "error";
		}
	}
}
