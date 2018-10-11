package org.lynn.soop.controller.goods;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.goods.SalesPropertyServiceContract;
import org.lynn.soop.contract.goods.dto.GoodsQueryRequest;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.controller.goods.dto.SpSelectKeyValueDto;
import org.lynn.soop.entity.SalesProperty;
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
@Path("/service/sales/property")
@Produces({"application/json;charset=UTF-8"})
public class SalesPropertyController extends BaseController {
    @Resource
    private SalesPropertyServiceContract salesPropertyServiceContract;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateSalesProperty(SalesProperty salesProperty) {
        log.info("start to update salesProperty :" + toJSON(salesProperty));

        BaseResponse result;
        try {
            BaseRequest<SalesProperty> request = setupRequest(salesProperty);
            result = salesPropertyServiceContract.updateSalesProperty(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update salesProperty info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @GET
    @Path("/list")
    public List<SalesProperty> listSalesProperty(@QueryParam("goodsId") Long goodsId) {
        log.info("start handle list SalesProperty request:" + goodsId);
        PageViewDto<SalesProperty> toReturn;
        try {
            toReturn = salesPropertyServiceContract.listSalesProperty(goodsId);
        } catch (Exception e) {
            log.error("error in list attribute.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list property request with response: " + toJSON(toReturn));

        return toReturn.getDataList();
    }

    @POST
    @Path("/remove")
    public BaseResponse removeSaleProperty(@QueryParam("id") Long id) {
        log.info("start to remove saleProperty :" + id);

        BaseResponse result;
        try {
            BaseRequest<Long> request = setupRequest(id);
            result = salesPropertyServiceContract.removeSalesProperty(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove saleProperty.", e);
            result = BaseResponse.buildClientErrorResponse("删除失败");
        }
        return result;
    }

    @GET
    @Path("/list/dic")
    public List<SpSelectKeyValueDto> listSalesPropertyByGoodsid(@QueryParam("goodsId") Long goodsId) {
        List<SpSelectKeyValueDto> toReturn = new ArrayList<>();
        try {
            GoodsQueryRequest queryCondition = new GoodsQueryRequest();
            PageRequest pageRequest = new PageRequest();
            pageRequest.setOffset(0);
            pageRequest.setLimit(100);
            queryCondition.setPageRequest(pageRequest);
            queryCondition.setGoodsId(goodsId);
            PageViewDto<SalesProperty> productCategoryPageViewDto = salesPropertyServiceContract.listSalesProperty(goodsId);
            toReturn = SpSelectKeyValueDto.fromList(productCategoryPageViewDto.getDataList());
        } catch (Exception e) {
            log.error("error in list salesProperty.", e);
        }
        log.info("complete handle list salesProperty by goodsId request with response: " + toJSON(toReturn));

        return toReturn;
    }
}
