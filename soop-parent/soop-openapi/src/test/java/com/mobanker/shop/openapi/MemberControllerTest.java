package org.lynn.soop.openapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.lynn.soop.contract.member.dto.UserAddressDto;
import org.lynn.soop.entity.UserIdInfo;
import org.junit.Test;

import javax.ws.rs.core.NewCookie;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

public class MemberControllerTest {


    //    private String server = "http://123.59.130.199/openapi";
    private String server = "http://localhost:9002/openapi";

    @Test
    public void testDirectLogin() {
        Client client = Client.create();
        ClientResponse response = client.resource(server + "/login/direct").header("content-type", "application/x-www-form-urlencoded")
                .post(ClientResponse.class, "mobile=18321268749&code=703324&msgCaptchaKey=gougou_99d17df3-7cfc-4f30-b2ef-cc129942d0fc");
        System.out.println(response.getEntity(String.class));
    }

    @Test
    public void test_getImageCode() throws Exception {
        Client client = Client.create();
        ClientResponse clientResponse = client.resource(server + "/verify-image-code-request").get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void test_authSMS() {
        Client client = Client.create();
        ClientResponse clientResponse = client.resource(server + "/verify-sms")
                .header("content-type", "application/x-www-form-urlencoded")
                .post(ClientResponse.class, "mobileNo=15618677512&smscode=resetpwcode");
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void test_register() {
        Client client = Client.create();
        String server = "http://localhost:9003/openapi";
        ClientResponse clientResponse = client.resource(server + "/register")
                .header("content-type", "application/x-www-form-urlencoded")
                .post(ClientResponse.class, "mobileNo=15618677520&password=123456" +
                        "&msgCaptcha=111111&msgCaptchaKey=gougou_99d17df3-7cfc-4f30-b2ef-cc129942d0fc" +
                        "&imgCaptcha=TDLL&imgCaptchaKey=gougou_4cdedac6-cebc-4e98-a42c-f4f0f98cd7b5");
        System.out.println(clientResponse.getEntity(String.class));
        //{"token":{},"code":200,"message":"SUCCESS","data":"gougou_ac6ffaf9-7412-40df-bfe8-afccb66b5003","success":true}
    }

    @Test
    public void test_genImageVerifyCode() {
        Client client = Client.create();
        ClientResponse clientResponse = client.resource(server + "/verify-image-code").queryParam("imagekey", "gougou_f1002e8f-d6a1-4899-a150-424e6a787dc3").get(ClientResponse.class);
        System.out.println(clientResponse.getEntity(String.class));
    }

    @Test
    public void testLogin() {
        Client client = Client.create();
        ClientResponse response = client.resource(server + "/login").header("content-type", "application/x-www-form-urlencoded")
                .post(ClientResponse.class, "mobileNo=15700000002&password=abc123");
        System.out.println(response.getEntity(String.class));
    }

    @Test
    public void testLogout() {
        Client client = Client.create();
        ClientResponse response = client.resource(server + "/logout").queryParam("_utk","142c55769970c0a93d9ae1937f5fcff1").get(ClientResponse.class);;
        System.out.println(response.getEntity(String.class));
    }
    
    @Test
	public void testResetPassword() {
		Client client = Client.create();
        ClientResponse clientResponse = client.resource(server + "/resetPassword")
        		.queryParam("_utk", "142c55769970c0a93d9ae1937f5fcff1")
                .header("content-type", "application/x-www-form-urlencoded")
                .post(ClientResponse.class, "mobileNo=15618677520&newPassword=aaaaaa" +
                        "&smsCode=111111&msgCaptchaKey=gougou_99d17df3-7cfc-4f30-b2ef-cc129942d0fc" +
                        "&imgCaptcha=TDLL&imgCaptchaKey=gougou_4cdedac6-cebc-4e98-a42c-f4f0f98cd7b5");
		System.out.println(clientResponse.getEntity(String.class));
	}

    @Test
    public void testMy() {
        Client client = Client.create();
        ClientResponse response = client.resource(server + "/my").queryParam("_utk","gougou_a4d2c2f8-db69-495c-bbae-96b152bad1fb").get(ClientResponse.class);
        System.out.println(response.getEntity(String.class));
    }

    @Test
    public void testMyInfo() {
        Client client = Client.create();
        ClientResponse response = client.resource(server + "/myinfo").queryParam("_utk","gougou_a4d2c2f8-db69-495c-bbae-96b152bad1fb").get(ClientResponse.class);
        System.out.println(response.getEntity(String.class));
    }


    @Test
    public void testAddAddress() {
        Client client = Client.create();
        ClientResponse response = null;

        UserAddressDto userAddressDto = new UserAddressDto();
        userAddressDto.setContactName("12test");
        userAddressDto.setContactPhone("123123123");
        userAddressDto.setProvince("12123123132123");
        userAddressDto.setCity("city");
        userAddressDto.setDistrict("distict");
        userAddressDto.setDetailAddress("detail address");
        userAddressDto.setPostCode("123123");
        userAddressDto.setIsDefault(false);
        userAddressDto.setFrontIdImage("http://qiniu.com/front.png");
        userAddressDto.setBackIdImage("http://qiniu.com/back.png");
        userAddressDto.setId(12l);
        userAddressDto.setProvince_id(30);

        userAddressDto.setIdNo("123123123123123123");


        WebResource.Builder builder = client.resource(server + "/address/save")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .header("content-type", "application/json;charset=UTF-8");

        String requestEntity = toJSON(userAddressDto);
        System.out.println(requestEntity);
        response = builder.post(ClientResponse.class, requestEntity);
        System.out.println(response.getEntity(String.class));
    }


    @Test
    public void testAddressList() {
        Client client = Client.create();
        ClientResponse response = null;

        WebResource.Builder builder = client.resource(server + "/address/list")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063").getRequestBuilder();

        response = builder.get(ClientResponse.class);

        System.out.println(response.getEntity(String.class));
    }

    @Test
    public void testIdImageList() {
        Client client = Client.create();

        WebResource.Builder builder = client.resource(server + "/address/idimage/list")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063").getRequestBuilder();


        ClientResponse response = builder.get(ClientResponse.class);

        System.out.println(response.getEntity(String.class));
    }

    public static void main(String[] args) {
        UserIdInfo userIdInfo = new UserIdInfo();
        userIdInfo.setId_back_image("http://abc.com/a.png");
        userIdInfo.setId_front_image("http://abc.com/b.png");
        userIdInfo.setId(3l);
        System.out.println(toJSON(userIdInfo));
    }

    @Test
    public void testSaveIDImage() {
        Client client = Client.create();
        UserIdInfo userIdInfo = new UserIdInfo();
        userIdInfo.setId_back_image("http://abc.com/a.png");
        userIdInfo.setId_front_image("http://abc.com/b.png");
        userIdInfo.setId(3l);

        WebResource.Builder builder = client.resource(server + "/address/idimage/save")
                .queryParam("_utk", "gougou_25b7a184-4902-4694-b6ec-045566386063")
                .header("content-type", "application/json;charset=UTF-8");

        ClientResponse response = builder.post(ClientResponse.class, toJSON(userIdInfo));

        System.out.println(response.getEntity(String.class));
    }


    @Test
    public void testCart() {
        ClientResponse response = Client.create().resource("http://localhost:9002/openapi/cart/cudGoods")
                .queryParam("_utk", "gougou_ad0ab445-724d-4553-86b5-a713755e6db3")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("_utk", "gougou_ad0ab445-724d-4553-86b5-a713755e6db3")
                .post(ClientResponse.class, "productId=7&number=1");
        System.out.println(response.getEntity(String.class));
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