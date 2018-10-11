package org.lynn.soop.contract.stock;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.stock.dto.BatchPurchaseExportDTO;
import org.lynn.soop.contract.stock.dto.PurchaseRequestListDTO;
import org.lynn.soop.entity.PurchaseProductBatch;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/service/stock")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface StockServiceContract {
    /**
     * 将已经支付成功的订单进入采购列表
     *
     * @param request 包含订单号
     * @return
     */
    @POST
    @Path("/addToPurchaseList")
    BaseResponse addToPurchaseList(BaseRequest<Long> request);

    /**
     * 列出对应批次的采购商品列表
     *
     * @param request
     * @return
     */
    @POST
    @Path("/listPurchaseList")
    PageViewDto<PurchaseRequestListDTO> listPurchaseList(BaseRequest<Long> request);

    @POST
    @Path("/listPurchaseList4export")
    List<BatchPurchaseExportDTO> listPurseDetailListToExport(BaseRequest<Long> request);

    @POST
    @Path("/purchase/result")
    BaseResponse importPurchaseResult(List<BatchPurchaseExportDTO> result);

    @POST
    @Path("/purchase/batch/list")
    PageViewDto<PurchaseProductBatch> listPurchaseBatch(BaseQueryRequest queryCondition);

    /**
     * 根据仓库库存请看，匹配订单
     *
     * @return
     */
    @POST
    @Path("/stock/match/order")
    BaseResponse deliverOrder();
}
