package org.lynn.soop.contract.function;

import org.lynn.soop.contract.BaseResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by chenwen on 5/06/16.
 */
@Path("/service/function/sms")
@Produces({"application/json;charset=UTF-8"})
public interface SmsServiceContact {

    @POST
    @Path("/send")
    BaseResponse<String> sendSMS(String text, List<String> mobileNos);

    @POST
    @Path("/send/one")
    BaseResponse<String> sendOne(String text, String mobileNos);

}
