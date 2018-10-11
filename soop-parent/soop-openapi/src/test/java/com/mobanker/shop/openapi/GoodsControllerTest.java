package org.lynn.soop.openapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import javax.ws.rs.core.NewCookie;
import java.util.List;

public class GoodsControllerTest {

//        private String server = "http://123.59.130.199/openapi";
    private String server = "http://localhost:9002/openapi";
//    .queryParam("_utk", "gougou_24bbbde1-44b4-4745-8ec3-13065e17935c")

    @Test
    public void testIndex() throws Exception {
        Client client = Client.create();
        ClientResponse clientResponse = null;

        WebResource.Builder builder = client.resource(server + "/goodsList")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .queryParam("limit", "2")
                .getRequestBuilder();
        clientResponse = builder.get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void testGetByAttribute() {
        Client client = Client.create();
        ClientResponse clientResponse = null;

        WebResource.Builder builder = client.resource(server + "/goodsList/searchByAttributes")
                .queryParam("attrId", "2")
                .queryParam("limit", "2")
                .queryParam("offset", "2")
                .getRequestBuilder();
        clientResponse = builder.get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }


    @Test
    public void testSearch(){
        Client client = Client.create();
        WebResource.Builder builder = client.resource(server + "/goodsList/searchByName")
                .queryParam("productName", "2")
                .queryParam("_utk", "gougou_24bbbde1-44b4-4745-8ec3-13065e17935c")
                .getRequestBuilder();
        ClientResponse clientResponse = builder.get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }


    @Test
    public void testGetProductInfo(){
        String response = Client.create().resource(server + "/goodsBasicInfo/search")
                .queryParam("id", "1").queryParam("_utk", "gougou_24bbbde1-44b4-4745-8ec3-13065e17935c").get(String.class);
        System.out.println(response);


    }

    @Test
    public void testCardList(){
        Client client = Client.create();
//        String server = "http://localhost:9002/openapi";
        WebResource.Builder builder = client.resource(server + "/goodsList/searchByUser")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .getRequestBuilder();
        ClientResponse clientResponse = builder.get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }


    public String getCookie(List<NewCookie> cookies, String key) {
        for (NewCookie cookie : cookies) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return "";
    }
}