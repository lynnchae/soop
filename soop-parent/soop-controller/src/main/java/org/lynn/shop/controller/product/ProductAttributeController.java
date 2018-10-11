package org.lynn.soop.controller.product;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.entity.ProductAttribute;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/service/product/attribute")
@Produces({"application/json;charset=UTF-8"})
public class ProductAttributeController extends BaseController {
    @Resource
    ProductServiceContact productServiceContact;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateAttribute(ProductAttribute productAttribute) {
        log.info("start to update attribute :" + toJSON(productAttribute));

        BaseResponse result;
        try {
            BaseRequest<ProductAttribute> request = setupRequest(productAttribute);
            result = productServiceContact.updateAttribute(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update attribute info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @GET
    @Path("/list")
    public List<ProductAttribute> listCategoryAttribute(@QueryParam("categoryId") Long categoryId) {
        log.info("start handle list attribute request:" + categoryId);
        PageViewDto<ProductAttribute> toReturn;
        try {
            toReturn = productServiceContact.listCategoryAttribute(categoryId);
        } catch (Exception e) {
            log.error("error in list attribute.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list attribute request with response: " + toJSON(toReturn));

        return toReturn.getDataList();
    }


    @POST
    @Path("/remove")
    public BaseResponse removeAttribute(@QueryParam("id") Long id) {
        log.info("start to remove attribute :" + id);

        BaseResponse result;
        try {
            BaseRequest<Long> request = setupRequest(id);
            result = productServiceContact.removeAttribute(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove attribute.", e);
            result = BaseResponse.buildClientErrorResponse("删除失败");
        }
        return result;
    }


}
