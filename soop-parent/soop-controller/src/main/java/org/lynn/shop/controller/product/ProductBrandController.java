package org.lynn.soop.controller.product;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.controller.product.dto.SelectKeyValueDTO;
import org.lynn.soop.entity.ProductBrand;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/service/product/brand")
@Produces({"application/json;charset=UTF-8"})
public class ProductBrandController extends BaseController {
    @Resource
    ProductServiceContact productServiceContact;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateBrand(ProductBrand productBrand) {
        log.info("start to update brand :" + toJSON(productBrand));

        BaseResponse result;
        try {
            BaseRequest<ProductBrand> request = setupRequest(productBrand);
            result = productServiceContact.updateBrand(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update brand info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新品牌信息失败");
        }
        return result;
    }

    @POST
    @Path("/list")
    @Consumes({"application/json;charset=UTF-8"})
    public PageViewDto<ProductBrand> listBrand(BaseQueryRequest queryCondition) {
        log.info("start handle list user request:" + toJSON(queryCondition));
        PageViewDto<ProductBrand> toReturn;
        try {
            toReturn = productServiceContact.listBrand(queryCondition);
        } catch (Exception e) {
            log.error("error in list brand.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list brand request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @GET
    @Path("/list/dic")
    public List<SelectKeyValueDTO> listBrandDic() {
        List<SelectKeyValueDTO> toReturn = new ArrayList<>();
        try {
            BaseQueryRequest queryCondition = new BaseQueryRequest();
            PageRequest pageRequest = new PageRequest();
            pageRequest.setOffset(0);
            pageRequest.setLimit(100);
            queryCondition.setPageRequest(pageRequest);
            PageViewDto<ProductBrand> productCategoryPageViewDto = productServiceContact.listBrand(queryCondition);
            toReturn = SelectKeyValueDTO.fromBrandList(productCategoryPageViewDto.getDataList());
        } catch (Exception e) {
            log.error("error in list brand.", e);
        }
        log.info("complete handle list category request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @POST
    @Path("/remove/batch")
    public BaseResponse batchRemoveBrand(List<Long> brands) {
        log.info("start to remove brand :" + toJSON(brands));

        BaseResponse result;
        try {
            BaseRequest<List<Long>> request = setupRequest(brands);
            result = productServiceContact.batchRemoveBrand(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove brand.", e);
            result = BaseResponse.buildClientErrorResponse("删除品牌失败");
        }
        return result;
    }


}
