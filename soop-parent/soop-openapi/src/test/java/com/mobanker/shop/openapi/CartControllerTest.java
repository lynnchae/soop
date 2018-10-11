package org.lynn.soop.openapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import javax.ws.rs.core.NewCookie;

import java.util.List;

import static org.junit.Assert.*;

public class CartControllerTest {


        private String server = "http://123.59.130.199/openapi";
//    private String server = "http://localhost:9002/openapi";
    @Test
    public void testCudGoods() throws Exception {
        Client client = Client.create();
        ClientResponse clientResponse = null;

        WebResource.Builder builder = client.resource(server + "/cart/cudGoods")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .header("content-type", "application/x-www-form-urlencoded");

        clientResponse = builder.post(ClientResponse.class, "productId=83&number=30&isAdd=true");
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void testListCart(){
        Client client = Client.create();
        ClientResponse clientResponse = null;
        WebResource.Builder builder = client.resource(server + "/goodsList/searchByUser")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063").getRequestBuilder();

        clientResponse = builder.get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }
}