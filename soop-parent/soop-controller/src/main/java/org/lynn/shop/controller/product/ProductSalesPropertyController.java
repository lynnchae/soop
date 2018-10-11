package org.lynn.soop.controller.product;

import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductSalesPropertyServiceContact;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.entity.dto.ProductSalesPropertyAndValuesDto;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by gaoguoxiang on 2016/7/14
 */
@Controller
@Path("/service/product/sales/property")
@Produces({"application/json;charset=UTF-8"})
public class ProductSalesPropertyController extends BaseController {

    @Resource
    private ProductSalesPropertyServiceContact productSalesPropertyServiceContact;

   /* @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateProductSalesProperty() {
        log.info("start to update productSalesProperty :" + toJSON());
        BaseResponse result;
        try {
            BaseRequest<Product> request = setupRequest();
            result = productSalesPropertyServiceContact.updateProductSalesProperty(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update product info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }*/

    @GET
    @Path("/list")
    public List<ProductSalesPropertyAndValuesDto> listProductSalesProperty(@QueryParam("productId") Long productId) {
        log.info("start handle list productSalesProperty request:" + productId);
        PageViewDto<ProductSalesPropertyAndValuesDto> toReturn;
        try {
            toReturn = productSalesPropertyServiceContact.listProductSalesProperty(productId);
        } catch (Exception e) {
            log.error("error in list attribute.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list productSalesProperty request with response: " + toReturn);

        return toReturn.getDataList();
    }

}
