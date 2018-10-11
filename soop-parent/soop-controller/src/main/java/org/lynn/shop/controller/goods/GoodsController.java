package org.lynn.soop.controller.goods;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.goods.GoodsServiceContract;
import org.lynn.soop.contract.goods.dto.GoodsQueryRequest;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.controller.goods.dto.SelectKeyValueDTO;
import org.lynn.soop.entity.Goods;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.controller.goods
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/12
 */
@Controller
@Path("/service/goods")
@Produces({"application/json;charset=UTF-8"})
public class GoodsController extends BaseController {

    @Resource
    private GoodsServiceContract goodsService;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateGoods(Goods goods) {
        log.info("start to update goods :" + toJSON(goods));

        BaseResponse result;
        try {
            BaseRequest<Goods> request = setupRequest(goods);
            result = goodsService.updateGoods(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update attribute info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @POST
    @Path("/list")
    public PageViewDto listGoods(BaseQueryRequest queryCondition) {
        log.info("start handle list goods request:" + toJSON(queryCondition));
        PageViewDto<Goods> toReturn;
        try {
            toReturn = goodsService.listGoods(queryCondition);
        } catch (Exception e) {
            log.error("error in list goods.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list goods request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @GET
    @Path("/list/dic")
    public List<SelectKeyValueDTO> listCategoryDic(@QueryParam("goodsId") Long goodsId) {
        List<SelectKeyValueDTO> toReturn = new ArrayList<>();
        try {
            GoodsQueryRequest queryCondition = new GoodsQueryRequest();
            PageRequest pageRequest = new PageRequest();
            pageRequest.setOffset(0);
            pageRequest.setLimit(100);
            queryCondition.setPageRequest(pageRequest);
            queryCondition.setGoodsId(goodsId);
            PageViewDto<Goods> productCategoryPageViewDto = goodsService.listGoods(queryCondition);
            toReturn = SelectKeyValueDTO.fromList(productCategoryPageViewDto.getDataList());
        } catch (Exception e) {
            log.error("error in list brand.", e);
        }
        log.info("complete handle list goods request with response: " + toJSON(toReturn));

        return toReturn;
    }

}
