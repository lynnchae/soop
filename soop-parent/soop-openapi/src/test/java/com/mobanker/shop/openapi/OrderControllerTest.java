package org.lynn.soop.openapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.lynn.soop.contract.member.dto.ProductCalRequest;
import org.lynn.soop.contract.order.dto.AcceptOrderDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.lynn.soop.util.JsonHelper.toJSON;

public class OrderControllerTest {

//        private String server = "http://123.59.130.199/openapi";
    private String server = "http://localhost:9002/openapi";

    @Test
    public void testOrderList() {
        Client client = Client.create();
        ClientResponse clientResponse = client.resource(server + "/order/list")
                .queryParam("_utk", "gougou_24bbbde1-44b4-4745-8ec3-13065e17935c")
                .get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void syncExchangeRate(){
        String response = Client.create().resource("http://api.k780.com:88/?app=finance.rate&scur=USD&tcur=CNY&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&jsoncallback=").get(String.class);
        System.out.println(response);
    }

    @Test
    public void testLogin() {
        Client client = Client.create();
        ClientResponse clientResponse = client.resource(server + "/login").header("content-type", "application/x-www-form-urlencoded")
                .post(ClientResponse.class, "userId=13472867512&password=123456");
        System.out.println(clientResponse.getEntity(String.class));
    }


    @Test
    public void testAccept() throws Exception {
        Client client = Client.create();
        WebResource.Builder builder = client.resource(server + "/order/accept")
                .queryParam("_utk", "gougou_24bbbde1-44b4-4745-8ec3-13065e17935c")
                .header("content-type", "application/json;charset=UTF-8");

        AcceptOrderDTO req = new AcceptOrderDTO();
        req.setAddress_id(1);
        ArrayList<AcceptOrderDTO.ProductOrderItem> product_list = new ArrayList<AcceptOrderDTO.ProductOrderItem>();
        AcceptOrderDTO.ProductOrderItem orderItem = new AcceptOrderDTO.ProductOrderItem();
        orderItem.setNumber(2);
        orderItem.setProduct_id(1);
        product_list.add(orderItem);
//        orderItem = new AcceptOrderDTO.ProductOrderItem();
//        orderItem.setNumber(1);
//        orderItem.setProduct_id(1);
//        product_list.add(orderItem);
        req.setProduct_list(product_list);

        String requestEntity = toJSON(req);
        System.out.println(requestEntity);
        ClientResponse clientResponse = builder.post(ClientResponse.class, requestEntity);
        System.out.println(clientResponse.getEntity(String.class));
    }

    public static void main(String[] args) {
        int result = (int) Math.ceil(new BigDecimal(1).multiply(new BigDecimal("6.1").multiply(new BigDecimal(100))).divide(new BigDecimal(100)).doubleValue());
        System.out.println(result);
    }

    @Test
    public void testGetOrderDetail() {
        Client client = Client.create();
        ClientResponse clientResponse = null;

        WebResource.Builder builder = client.resource(server + "/order/detail")
                .queryParam("orderId", "155")
                .queryParam("_utk", "gougou_24bbbde1-44b4-4745-8ec3-13065e17935c").getRequestBuilder();

        clientResponse = builder.get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void testCalc() {
        Client client = Client.create();
        WebResource.Builder builder = client.resource(server + "/order/calc").header("content-type", "application/json;charset=UTF-8");
        ProductCalRequest request = new ProductCalRequest();
        request.getProductList().put(1l, 2);
        request.getProductList().put(2l, 3);
        String requestEntity = toJSON(request);
        System.out.println(requestEntity);
        ClientResponse clientResponse = builder.post(ClientResponse.class, requestEntity);
        System.out.println(clientResponse.getEntity(String.class));
    }
}