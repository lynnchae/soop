package org.lynn.soop.controller.sku;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.sku.SkuServiceContact;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Controller
@Path("/test")
@Produces({"application/json;charset=UTF-8"})
public class SkuController {
    private static final Logger log = Logger.getLogger(SkuController.class);

    @Resource
    SkuServiceContact skuService;

    @GET
    public String add(@QueryParam("a") int a, @QueryParam("b") int b) {
        log.info("request started....");

        try {
            BaseRequest request = new BaseRequest();
            request.setRequestId(111);
            BaseResponse response = skuService.test(request);
            return response.getMessage();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error in call";
        }


    }
}
