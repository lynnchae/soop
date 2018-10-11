package org.lynn.soop.controller.product;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.contract.product.dto.CategoryQueryRequest;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.contract.product.dto.MainCategoryDto;
import org.lynn.soop.controller.product.dto.SelectKeyValueDTO;
import org.lynn.soop.entity.ProductCategory;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toGson;
import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/service/product/category")
@Produces({"application/json;charset=UTF-8"})
public class ProductCategoryController extends BaseController {
    @Resource
    ProductServiceContact productServiceContact;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateCategory(ProductCategory productCategory) {
        log.info("start to update category :" + toJSON(productCategory));

        BaseResponse result;
        try {
            BaseRequest<ProductCategory> request = setupRequest(productCategory);
            result = productServiceContact.updateCategory(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update category info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @POST
    @Path("/list")
    @Consumes({"application/json;charset=UTF-8"})
    public PageViewDto<ProductCategory> listCategory(CategoryQueryRequest queryCondition) {
        log.info("start handle list category request:" + toJSON(queryCondition));
        PageViewDto<ProductCategory> toReturn;
        try {
            toReturn = productServiceContact.listCategory(queryCondition);
        } catch (Exception e) {
            log.error("error in list brand.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list category request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @GET
    @Path("/list/dic")
    public List<SelectKeyValueDTO> listCategoryDic(@QueryParam("mainCategoryId") Long mainCategoryId) {
        List<SelectKeyValueDTO> toReturn = new ArrayList<>();
        try {
            CategoryQueryRequest queryCondition = new CategoryQueryRequest();
            PageRequest pageRequest = new PageRequest();
            pageRequest.setOffset(0);
            pageRequest.setLimit(100);
            queryCondition.setPageRequest(pageRequest);
            queryCondition.setMainCategoryId(mainCategoryId);
            PageViewDto<ProductCategory> productCategoryPageViewDto = productServiceContact.listCategory(queryCondition);
            toReturn = SelectKeyValueDTO.fromList(productCategoryPageViewDto.getDataList());
        } catch (Exception e) {
            log.error("error in list brand.", e);
        }
        log.info("complete handle list category request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @POST
    @Path("/sub/list")
    @Consumes({"application/json;charset=UTF-8"})
    public PageViewDto<ProductCategory> listSubCategory(BaseQueryRequest queryCondition) {
        log.info("start handle list category request:" + toGson(queryCondition));
        PageViewDto<ProductCategory> toReturn;
        try {
            toReturn = productServiceContact.listSubCategory(queryCondition);
        } catch (Exception e) {
            log.error("error in list brand.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list category request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @POST
    @Path("/remove/batch")
    public BaseResponse batchRemoveCategory(List<Long> ids) {
        log.info("start to remove category :" + toJSON(ids));

        BaseResponse result;
        try {
            BaseRequest<List<Long>> request = setupRequest(ids);
            result = productServiceContact.batchRemoveCategory(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove category.", e);
            result = BaseResponse.buildClientErrorResponse("删除失败");
        }
        return result;
    }

    /**
     * 获取主类列表
     * @return
     */
    @GET
    @Path("/main/list")
    public List<MainCategoryDto> listMainCategory(){
        log.info("start to listMainCategory");
        List<MainCategoryDto> result;
        try {
            List<ProductCategory> list = productServiceContact.listMainCategory();
            result = MainCategoryDto.fromList(list);
        }catch (Exception e) {
            log.error("error in listMainCategory.", e);
            result = new ArrayList<>();
        }
        return result;
    }

}
