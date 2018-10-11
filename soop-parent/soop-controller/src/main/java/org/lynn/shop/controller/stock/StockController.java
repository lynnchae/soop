package org.lynn.soop.controller.stock;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.stock.StockServiceContract;
import org.lynn.soop.contract.stock.dto.BatchPurchaseExportDTO;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.entity.PurchaseProductBatch;
import org.lynn.soop.util.Contants;
import org.lynn.soop.util.ExcelConversionHelper;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

import static org.lynn.soop.util.ExcelConversionHelper.convertPOJOToExcelBinary;
import static org.lynn.soop.util.JsonHelper.toJSON;

@Controller
@Path("/service/stock")
@Produces({"application/json;charset=UTF-8"})
public class StockController extends BaseController {
    @Resource
    StockServiceContract stockServiceContract;
    private String sheetName = "purchase_batch";

    /**
     * 展示对应批次的采购详情，如果批次号没传，展示最近的批次
     *
     * @param batchId
     * @return
     */
    @GET
    @Path("/purchase/list")
    public PageViewDto listPurchaseList(@QueryParam("batchId") long batchId) {
        log.info("start handle listPurchaseList:" + batchId);
        PageViewDto toReturn;
        try {
            BaseRequest<Long> request = setupRequest(batchId);
            toReturn = stockServiceContract.listPurchaseList(request);
        } catch (Exception e) {
            log.error("error in listPurchaseList.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle listPurchaseList: " + toJSON(toReturn));

        return toReturn;
    }


    @POST
    @Path("/batch/purchase/list")
    public PageViewDto listPurchaseBatch(BaseQueryRequest queryCondition) {
        log.info("start handle list product purchase request:" + toJSON(queryCondition));
        PageViewDto<PurchaseProductBatch> toReturn;
        try {
            toReturn = stockServiceContract.listPurchaseBatch(queryCondition);
        } catch (Exception e) {
            log.error("error in list product purchase batch.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list product purchase request with response: " + toJSON(toReturn));

        return toReturn;
    }

    /**
     * 导出采购列表
     *
     * @param batchId
     * @return
     */
    @GET
    @Path("/export/batch")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response exportPurchaseList(@QueryParam("batchId") long batchId) {

        try {
            BaseRequest<Long> request = setupRequest(batchId);
            List<BatchPurchaseExportDTO> result = stockServiceContract.listPurseDetailListToExport(request);
            String fileName = String.valueOf(batchId);
            return Response.ok(convertPOJOToExcelBinary(result, BatchPurchaseExportDTO.class, sheetName))
                    .header("content-disposition", "attachment; filename = " + fileName + ".xls").build();
        } catch (NoLoginException e) {
            throw new WebApplicationException(Response.status(401).build());
        } catch (Exception e) {
            log.error("error in exporting data.", e);
            throw new WebApplicationException(Response.status(500).entity("error in exporting data.").build());
        }
    }

    /**
     * 导入采购结果列表
     *
     * @return
     */
    @POST
    @Path("/import/batch")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes("multipart/form-data")
    public BaseResponse importPurchaseResult(MultipartFormDataInput input) {
        BaseResponse toReturn;
        try {
            List<InputPart> files = input.getFormDataMap().get("file");
            InputStream inputStream = files.get(0).getBody(Contants.Http.inputStreamGenericType);

            List<BatchPurchaseExportDTO> result = ExcelConversionHelper.converToPOJO(BatchPurchaseExportDTO.class, inputStream, sheetName);
            if (CollectionUtils.isEmpty(result)) {
                throw new RuntimeException("采购清单导入失败");
            }
            toReturn = stockServiceContract.importPurchaseResult(result);
        } catch (Exception e) {
            log.error("error in import batch data.", e);
            toReturn = BaseResponse.buildServerErrorResponse("采购导入失败");
        }
        return toReturn;
    }


}
