package org.lynn.soop.openapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.lynn.soop.contract.pay.dto.WxPayPrepareRequest;
import org.junit.Test;

import javax.ws.rs.core.NewCookie;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

public class PayControllerTest {


//    private String server = "http://123.59.130.199/openapi";
    private String server = "http://localhost:9002/openapi";

    @Test
    public void testWxPrepare() {
        Client client = Client.create();
        ClientResponse clientResponse = null;

        WebResource.Builder builder = client.resource(server + "/pay/wx/prepare-pay-through-code")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .header("content-type", "application/json;charset=UTF-8");
        WxPayPrepareRequest req = new WxPayPrepareRequest();
        req.setOpenid("oJSd8wAX5LEB6b5lliIocPhIlkQ8");
        req.setOrderNo("56");

        clientResponse = builder.post(ClientResponse.class, toJSON(req));
        System.out.println(clientResponse.getEntity(String.class));
    }


    @Test
    public void testWxPrepare1() {
        Client client = Client.create();
        ClientResponse clientResponse = null;

        WebResource.Builder builder = client.resource(server + "/pay/wx/prepare-pay")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .header("content-type", "application/json;charset=UTF-8");
        WxPayPrepareRequest req = new WxPayPrepareRequest();
        req.setOpenid("oJSd8wAX5LEB6b5lliIocPhIlkQ8");
        req.setOrderNo("31");

        clientResponse = builder.post(ClientResponse.class, toJSON(req));
        System.out.println(clientResponse.getEntity(String.class));
    }


    @Test
    public void testWxPayResult() throws Exception {
        Client client = Client.create();
        String server = "http://localhost:9002/openapi";
        String request = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B9244035E465AB2C825BC1286029264C]]></sign>\n" +
                "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";
        request = request.replace("1409811653", "4");
        ClientResponse clientResponse = client.resource(server + "/pay/wx/pay-result")
                .header("content-type", "application/xml")
                .post(ClientResponse.class, request);
        System.out.println(clientResponse.getEntity(String.class));
    }
}