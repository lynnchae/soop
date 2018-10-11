package org.lynn.soop.service.pay;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.order.OrderBuisness;
import org.lynn.soop.business.pay.PayBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.pay.PayServiceContract;
import org.lynn.soop.contract.pay.dto.AlipayNotifyResult;
import org.lynn.soop.contract.pay.dto.UnionWapPayRequest;
import org.lynn.soop.contract.pay.dto.WxNotifyResult;
import org.lynn.soop.contract.pay.dto.WxPayPrepareRequest;
import org.lynn.soop.service.common.BaseService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.Callable;

@Service
public class PayService extends BaseService implements PayServiceContract {
    @Autowired
    OrderBuisness orderBuisness;

    @Autowired
    PayBusiness payBusiness;

    /**
     * 处理微信支付回调结果
     *
     * @param wxNotifyResult
     * @return
     */
     
    public BaseResponse handleWxPayResult(WxNotifyResult wxNotifyResult) {
        BaseResponse response = payBusiness.handleWxPayResult(wxNotifyResult);
        if (wxNotifyResult.isSuccess()) {
            String orderId = payBusiness.getOrderNo(wxNotifyResult.getOut_trade_no());
            orderBuisness.onOrderPayed(orderId);
        }
        return response;
    }

    /**
     * 微信支付准备下单
     *
     * @param request
     * @return
     */
     
    public BaseResponse prepareWxPay(BaseAPIRequest<WxPayPrepareRequest> request) {
        return payBusiness.prepareWxPay(request);

    }

     
    public BaseResponse handleAlipayNotifyResult(final AlipayNotifyResult alipayNotifyResult) {
        return service("处理支付宝异步回调通知", new Callable() {
             
            public Object call() throws Exception {

                boolean handleOK = payBusiness.handleAlipayResult(alipayNotifyResult);

                if (handleOK && alipayNotifyResult.isSuccess()) {

                    String orderId = payBusiness.getOrderNo(alipayNotifyResult.getOut_trade_no());

                    orderBuisness.onOrderPayed(orderId);
                }
                return null;
            }
        });
    }

     
    public BaseResponse prepareWxPayThroughCode(BaseAPIRequest<WxPayPrepareRequest> request) {
        return payBusiness.prepareWxPayThroughCode(request);
    }


    /**
     * 银联WAP支付订单查询
     * @param request
     * @return
     */
    @Override
    public BaseResponse waptcOrderQuery(BaseAPIRequest<String> request) {
        return payBusiness.waptcOrderQuery(request);
    }


    @Override
    public BaseResponse payWithUnion(BaseAPIRequest<UnionWapPayRequest> request) {
        return payBusiness.payWithUnion(request);
    }

	@Override
	public void handleUnionpayNotifyResult(Map<String, String> params) {
		payBusiness.handleUnionpayNotifyResult(params);
	}

}
