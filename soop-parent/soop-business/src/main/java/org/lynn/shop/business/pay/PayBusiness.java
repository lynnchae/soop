package org.lynn.soop.business.pay;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.lynn.soop.baseresp.ResponseEntity;
import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.business.order.OrderBuisness;
import org.lynn.soop.business.pay.alipay.AlipayConfig;
import org.lynn.soop.business.pay.alipay.AlipayHelper;
import org.lynn.soop.business.pay.alipay.GrantBrowserAccessToken;
import org.lynn.soop.business.product.ProductCrudBusiness;
import org.lynn.soop.business.product.ProductTrxBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.order.dto.OrderStatus;
import org.lynn.soop.contract.pay.dto.*;
import org.lynn.soop.entity.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.OrderProductListReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.PayDetailReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.UserReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.OrderProductListWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.OrderStatusHistoryWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.OrderWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.PayDetailWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.ProductWriteMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.UserWriteMapper;
import org.lynn.soop.util.HttpClientUtils;
import org.lynn.soop.util.PropertyUtils;
import org.lynn.soop.util.SimpleHttpClient;
import org.lynn.soop.util.XmlUtil;
import com.sun.jersey.api.client.Client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lynn.soop.business.pay.SpiHelper.*;
import static org.lynn.soop.util.DataHelper.shortString;
import static org.lynn.soop.util.JsonHelper.fromJSON;
import static org.lynn.soop.util.JsonHelper.toJSON;

@Component
public class PayBusiness extends BaseBusiness {

    ///////todo 微信支付相关配置
    String appId = "wxacb6bc71c68c8999";
    String appSecrect = "d6479c7895fd6c9936f1656b2155b5f6";
    String merchantNo = "1372813602";
    String appKey = "AB3onisUvsvtFa2wbJSACNkwc2Jt9NVd";
//    String callbackUrl = "http://123.59.130.199/openapi/pay/wx/pay-result";
    String callbackUrl = PropertyUtils.getValue("wxpay.callbackUrl");

    ///////FIXME 支付宝支付相关配置
    AlipayConfig alipayConfig = new AlipayConfig();
    AlipayHelper alipayHelper = new AlipayHelper(alipayConfig);


    @Autowired
    ProductCrudBusiness productCrudBusiness;

    @Autowired
    ProductTrxBusiness productTrxBusiness;

    @Autowired
    OrderBuisness orderBuisness;

    @Autowired
    OrderWriteMapper orderWriteMapper;


    @Autowired
    PayDetailWriteMapper payDetailWriteMapper;

    @Autowired
    PayDetailReadMapper payDetailReadMapper;


    @Autowired
    UserReadMapper userReadMapper;

    @Autowired
    UserWriteMapper userWriteMapper;
    
    @Autowired
    OrderProductListReadMapper productListReadMapper;
    
    @Autowired
    OrderProductListWriteMapper productListWriteMapper;
    
    @Autowired
    ProductWriteMapper productWriteMapper;
    
    @Autowired
    OrderStatusHistoryWriteMapper orderStatusHistoryWriteMapper;

    private static final Logger log = Logger.getLogger(PayBusiness.class);

    @Transactional
    public BaseResponse handleWxPayResult(WxNotifyResult wxNotifyResult) {
        parseWeChatResponse(wxNotifyResult);
        PayDetailExample example = new PayDetailExample();
        example.createCriteria().andInner_order_noEqualTo(wxNotifyResult.getOut_trade_no());
        List<PayDetail> payDetails = payDetailReadMapper.selectByExample(example);
        if (payDetails.size() == 1) {
            PayDetail payDetail = payDetails.get(0);
            payDetail.setResponse(wxNotifyResult.getRawRequst());
            payDetail.setStatus(PayStatus.success.name());//只有支付成功才会通知
            PayDetailExample payDetailExample = new PayDetailExample();
            PayDetailExample.Criteria criteria = payDetailExample.createCriteria();
            criteria.andIdEqualTo(payDetail.getId());
            criteria.andStatusEqualTo(PayStatus.submited.name());
            payDetail.setDate_updated(new Date());
            int effectedRow = payDetailWriteMapper.updateByPrimaryKeySelective(payDetail);
            if (effectedRow != 1) {
                log.error("error in handle wx callback : " + toJSON(wxNotifyResult));
                throw new RuntimeException("微信支付结果通知，订单更新失败");
            }
        } else {
            log.error("no record found for order id : " + wxNotifyResult.getOut_trade_no());
            throw new RuntimeException("微信支付结果通知，订单更新失败");
        }
        return BaseResponse.buildSuccessResponse("ok");
    }


    private void parseWeChatResponse(WxNotifyResult wxNotifyResult) {
        Map<String, String> result = WechatSpiHelper.parsePayResult(wxNotifyResult.getRawRequst(), appKey);
        String outTradeNo = result.get(WechatSpiHelper.KEY_OUT_TRADE_NO);
        wxNotifyResult.setOut_trade_no(outTradeNo);
        wxNotifyResult.setSuccess(true);
    }

    public String getOrderNo(String out_trade_no) {
        return out_trade_no;
    }

    @Transactional
    public BaseResponse<WxPayResponse> prepareWxPay(BaseAPIRequest<WxPayPrepareRequest> request) {
        WxPayPrepareRequest wxPayPrepareRequest = request.getData();
        Order order = orderBuisness.getOrderInfo(wxPayPrepareRequest.getOrderNo());
        int totalFee = order.getTotal_order_amount();

        wxPayPrepareRequest.setAmount(totalFee);
        String productInfo = shortString(order.getOrder_description(), 128);
        wxPayPrepareRequest.setProductInfo(productInfo);

        String inner_order_no = String.valueOf(order.getId());
        PayDetailExample payDetailExample = new PayDetailExample();
        payDetailExample.createCriteria().andInner_order_noEqualTo(inner_order_no);
        PayDetail payDetail;
        List<PayDetail> payDetails = payDetailReadMapper.selectByExample(payDetailExample);
        if (payDetails.size() == 0) {
            payDetail = new PayDetail();
            payDetail.setOrder_id(order.getId());
            payDetail.setInner_order_no(inner_order_no);
            payDetail.setProduct_name(productInfo);
            payDetail.setAmount(order.getTotal_order_amount());//订单表里面存的就是分
            payDetail.setPay_channel(PayChannel.wechat.name());
            payDetailWriteMapper.insertSelective(payDetail);
        } else {
            payDetail = payDetails.get(0);
        }

        wxPayPrepareRequest.setAmount(order.getTotal_order_amount());

        BaseResponse<WxPayResponse> baseResponse = wxUnifiedOrder(wxPayPrepareRequest);
        /**
         * 如果支付准备成功，更新订单状态为已经发起支付
         */
        if (baseResponse.isSuccess()) {
            payDetail.setRequest(String.valueOf(baseResponse.getData()));
            payDetail.setStatus(PayStatus.submited.name());
            payDetail.setDate_updated(new Date());
            payDetailWriteMapper.updateByPrimaryKeySelective(payDetail);
        }
        return baseResponse;
    }

    public BaseResponse<WxPayResponse> wxUnifiedOrder(WxPayPrepareRequest wxPayPrepareRequest) {

        logger.info("wxUnifiedOrder request is: " + toJSON(wxPayPrepareRequest));
        String body = wxPayPrepareRequest.getProductInfo();
        String detail = "订单支付";
        String spbillCreateIp = wxPayPrepareRequest.getSpbillCreateIp();
        String openid = wxPayPrepareRequest.getOpenid();
        WechatPayInfo wechatPayInfo = WechatPayInfo.build(body, detail, wxPayPrepareRequest.getAmount(), spbillCreateIp, openid, wxPayPrepareRequest.getOrderNo(), callbackUrl);
        Map<String, String> requestMap = generateOrderReq(wechatPayInfo, appId, merchantNo);
        requestMap.put("sign", EncryptUtil.wechatSignByMd5(requestMap, appKey));

        String result = XmlUtil.buildXmlNode("xml", requestMap);
        logger.info("raw request xml content is: " + result);

        String response = Client.create().resource("https://api.mch.weixin.qq.com/pay/unifiedorder")
                .header("Content-Type", "application/xml;charset=UTF-8").post(String.class, result);

        logger.info("raw response from wx is: " + response);

        BaseResponse<String> handleOrderResp = handleOrderResp(response, appKey);
        if (!handleOrderResp.isSuccess()) {
            throw new RuntimeException("支付准备失败");
        }
        WxPayResponse wxPayResponse = WxPayResponse.build(appId, handleOrderResp.getData());
        wxPayResponse.setPaySign(EncryptUtil.wechatSignByMd5(wxPayResponse.toMap(), appKey));
        return BaseResponse.buildSuccessResponse(wxPayResponse);
    }

    public boolean handleAlipayResult(AlipayNotifyResult alipayNotifyResult) {
        //todo 保存回调信息

        // 验签
        boolean verifyOK = alipayHelper.verify(alipayNotifyResult.getRawRequstForm());

        return verifyOK;
    }

    public BaseResponse<WxPayResponse> prepareWxPayThroughCode(BaseAPIRequest<WxPayPrepareRequest> request) {
        WxPayPrepareRequest wxPayPrepareRequest = request.getData();
        User user = userReadMapper.selectByPrimaryKey(request.getUser());
        if (user.getOpenid() == null) {
            //根据用户授权码获取openid
            String openId = exchangeOpenId(wxPayPrepareRequest.getCode());
            user.setOpenid(openId);
            user.setDate_updated(new Date());
            int effectedRow = userWriteMapper.updateByPrimaryKeySelective(user);
            if (effectedRow == 0) {
                throw new RuntimeException("更新openid异常");
            }
        }
        wxPayPrepareRequest.setOpenid(user.getOpenid());
        return prepareWxPay(request);
    }

    public GrantBrowserAccessToken getBrowserGrantedAccessToken(final String code) {
        GrantBrowserAccessToken grantBrowserAccessToken;
        try {
            String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", appId, appSecrect, code);
            log.info("request wx to exchange open id: " + url);
            String accessToken = Client.create().resource(url).get(String.class);
            log.info("response from wx:" + accessToken);
            grantBrowserAccessToken = fromJSON(accessToken, GrantBrowserAccessToken.class);
        } catch (Exception ex) {
            log.error("error in exchange access token.", ex);
            throw new RuntimeException("error in exchange access token.");
        }
        return grantBrowserAccessToken;
    }

    public String exchangeOpenId(String code) {
        return getBrowserGrantedAccessToken(code).getOpenId();
    }



    public BaseResponse waptcOrderQuery(BaseAPIRequest<String> request) {
        ResponseEntity resp = null;
        String billNo = request.getData();
        Map<String, String> params = new HashMap<>();
        params.put("billNo", billNo);
        String url = PropertyUtils.getValue("waptcOrderQueryUrl");
        try {
            String result = SimpleHttpClient.sendPost(url, params,CHARSET_UTF8);
            logger.info("call result : ", JSONObject.toJSONString(request));
            resp = JSONObject.parseObject(result, ResponseEntity.class);
        } catch (Exception e) {
           logger.info("解析返回值失败: <<" + e.getMessage() + ">>");
            throw new MyBizException(BaseResponse.buildClientErrorResponse("error in analysis result"));
        }
        return BaseResponse.buildSuccessResponse(resp);
    }

    public BaseResponse payWithUnion(BaseAPIRequest<UnionWapPayRequest> request) {
        UnionWapPayRequest unionWepRequest = request.getData();
        String unionWapUrl = PropertyUtils.getValue("unionwap.pay.url");
        Map paramsMap = new HashMap();
        paramsMap.put("billNo", unionWepRequest.getBillNo());
        paramsMap.put("money", unionWepRequest.getMoney()+"");
        paramsMap.put("frontUrl", PropertyUtils.getValue("unionwap.frontUrl"));
        //paramsMap.put("backUrl", PropertyUtils.getValue("unionwap.backUrl"));
        logger.info(String.format(">>>>>> unionWapUrl is [%s] , paramsMap is [%s]",unionWapUrl,paramsMap.toString()));
        String payResult = "";
        try {
            payResult = HttpClientUtils.doPost(unionWapUrl, paramsMap);
            logger.info(String.format(">>>>>>>>>>>>>>>>>>>> payResult is [%s]",payResult));
            JSONObject payResultJson = JSON.parseObject(payResult);
            logger.info(String.format(">>>>>>>>>>>>>>>>>>>> payResultJson is [%s]",payResultJson.toString()));
            if (payResultJson.get("status").equals("1")) {
                //修改订单状态为  OrderStatus.PAY_SUBMIT
                Order order = new Order();
                order.setId(unionWepRequest.getBillNo());
                order.setStatus(OrderStatus.PAY_SUBMIT.name());
//                Base64.encode(toByteArray(payResultJson.get("data")))
                BaseResponse toReturn = BaseResponse.buildSuccessResponse(payResultJson.get("data"));
                if(orderWriteMapper.updateByPrimaryKeySelective(order) > 0){
                    toReturn.setMessage("unionWap pay success! update order status success !");
                    logger.info("unionWap pay and update order status success !");
                }else{
                    toReturn.setMessage("unionWap pay success! update order status failed !");
                    logger.info("unionWap pay success! update order status failed !");
                }
                return toReturn;
            } else {
                return BaseResponse.buildClientErrorResponse(String.format("调用银联wap接口失败 [%s]", payResultJson));
            }
        } catch (Exception e) {
        	logger.error(e.getStackTrace().toString());
            return BaseResponse.buildClientErrorResponse((String.format("调用银联wap接口异常,payResult [%s] , exception [%s]",payResult , e)));
        }
    }
    
    public void handleUnionpayNotifyResult(String params){
    	System.out.println(params);
    }
	
	public void handleUnionpayNotifyResult(Map<String, String> params) {
		logger.info("支付系统MQ消息: <<" + params.toString() + ">>");
		if (params.containsKey("billNo")) {
			String orderStatus = OrderStatus.PAY_FAILED.name();
			String billStatus = params.get("billStatus").toString();
			if (billStatus.equalsIgnoreCase("SUCCESS")) {
				orderStatus = OrderStatus.PAYED.name();
			}

			String order_no = params.get("billNo").toString();
			Order order = orderWriteMapper.selectByPrimaryKey(order_no);
			if(order != null && order.getStatus().equals(OrderStatus.PAYED.name())){
				return;
			}
			order.setStatus(orderStatus);
			order.setDate_updated(new Date());
			orderWriteMapper.updateByPrimaryKey(order);

			// 更新库存
			OrderProductListExample example = new OrderProductListExample();
			example.createCriteria().andOrder_idEqualTo(order_no);
			List<OrderProductList> productList = productListReadMapper.selectByExample(example);
			for (OrderProductList tpProductList : productList) {
				if (billStatus.equals("SUCCESS")) {
					Long productId = tpProductList.getProduct_id();
					Product product = productWriteMapper.selectByPrimaryKey(productId);
					if (product != null) {
						product.setStock_count(product.getStock_count() - 1);
						productWriteMapper.updateByPrimaryKey(product);
					}
				}
				tpProductList.setDate_updated(new Date());
				tpProductList.setOrder_status(orderStatus);
				productListWriteMapper.updateByPrimaryKey(tpProductList);
			}
			

			// 更新订单状态变化
			OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
			orderStatusHistory.setOrder_id(order_no);
			orderStatusHistory.setTo_status(orderStatus);
			orderStatusHistoryWriteMapper.insertSelective(orderStatusHistory);

			// 记录支付详情
			String productInfo = shortString(order.getOrder_description(), 128);
			PayDetailExample payDetailExample = new PayDetailExample();
			payDetailExample.createCriteria().andInner_order_noEqualTo(order_no);
			PayDetail payDetail;
			List<PayDetail> payDetails = payDetailReadMapper.selectByExample(payDetailExample);
			if (payDetails.size() == 0) {
				payDetail = new PayDetail();
				payDetail.setOrder_id(order.getId());
				payDetail.setInner_order_no(order_no);
				payDetail.setProduct_name(productInfo);
				payDetail.setAmount(order.getTotal_order_amount());// 订单表里面存的就是分
				payDetail.setPay_channel(PayChannel.unionpay.name());
				payDetail.setRequest(params.toString());
				payDetailWriteMapper.insertSelective(payDetail);
			}
		}
	}

    private static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

}
