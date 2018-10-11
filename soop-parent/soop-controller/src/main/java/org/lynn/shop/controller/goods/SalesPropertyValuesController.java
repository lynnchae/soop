package org.lynn.soop.controller.goods;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.goods.SalesPropertyValuesServiceContract;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.controller.goods.dto.SpValueSelectKeyValueDto;
import org.lynn.soop.entity.SalesPropertyValues;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Created by gaoguoxiang on 2016/7/13
 */
@Controller
@Path("/service/sales/property/values")
@Produces({"application/json;charset=UTF-8"})
public class SalesPropertyValuesController extends BaseController {

    @Resource
    private SalesPropertyValuesServiceContract salesPropertyValuesServiceContract;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateSalesPropertyValues(SalesPropertyValues salesPropertyValues) {
        log.info("start to update salesPropertyValues :" + toJSON(salesPropertyValues));

        BaseResponse result;
        try {
            BaseRequest<SalesPropertyValues> request = setupRequest(salesPropertyValues);
            result = salesPropertyValuesServiceContract.updateSalesPropertyValues(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update salesPropertyValues info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @GET
    @Path("/list")
    public List<SalesPropertyValues> listSalesPropertyValues(@QueryParam("spId") Long spId) {
        log.info("start handle list SalesPropertyValues request:" + spId);
        PageViewDto<SalesPropertyValues> toReturn;
        try {
            toReturn = salesPropertyValuesServiceContract.listSalesPropertyValues(spId);
        } catch (Exception e) {
            log.error("error in list attribute.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list property request with response: " + toJSON(toReturn));

        return toReturn.getDataList();
    }

    @POST
    @Path("/remove")
    public BaseResponse removeSalesPropertyValues(@QueryParam("id") Long id) {
        log.info("start to remove salePropertyValues :" + id);

        BaseResponse result;
        try {
            BaseRequest<Long> request = setupRequest(id);
            result = salesPropertyValuesServiceContract.removeSalesPropertyValues(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove salePropertyValues.", e);
            result = BaseResponse.buildClientErrorResponse("删除失败");
        }
        return result;
    }


    @GET
    @Path("/list/dic")
    public List<SpValueSelectKeyValueDto> listSalesPropertyValue(@QueryParam("spId") Long spId) {
        List<SpValueSelectKeyValueDto> toReturn = new ArrayList<>();
        try {
//            GoodsQueryRequest queryCondition = new GoodsQueryRequest();
//            PageRequest pageRequest = new PageRequest();
//            pageRequest.setOffset(0);
//            pageRequest.setLimit(100);
//            queryCondition.setPageRequest(pageRequest);
//            queryCondition.setGoodsId(spId);
            PageViewDto<SalesPropertyValues> productCategoryPageViewDto = salesPropertyValuesServiceContract.listSalesPropertyValues(spId);
            toReturn = SpValueSelectKeyValueDto.fromList(productCategoryPageViewDto.getDataList());
        } catch (Exception e) {
            log.error("error in list SalesPropertyValue.", e);
        }
        log.info("complete handle list SalesPropertyValue by spId request with response: " + toJSON(toReturn));

        return toReturn;
    }
}
