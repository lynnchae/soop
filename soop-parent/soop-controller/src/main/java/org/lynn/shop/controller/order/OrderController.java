package org.lynn.soop.controller.order;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.order.OrderServiceContract;
import org.lynn.soop.contract.order.dto.BatchDeliveryExportDTO;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderDeliverBatch;
import org.lynn.soop.util.Contants;
import org.lynn.soop.util.ExcelConversionHelper;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

import static org.lynn.soop.util.ExcelConversionHelper.convertPOJOToExcelBinary;
import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/6/16
 * Time         : 7:09 PM
 * Description  : 订单接口
 */
@Controller
@Path("/service/order")
@Produces({"application/json;charset=UTF-8"})
public class OrderController extends BaseController {

    private String sheetName = "deliver_batch";

    @Resource
    OrderServiceContract orderServiceContract;

    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateOrder(Order product) {
        log.info("start to update Order :" + toJSON(product));

        BaseResponse result;
        try {
            BaseRequest<Order> request = setupRequest(product);
            result = orderServiceContract.updateOrder(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update Order info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @POST
    @Path("/list")
    public PageViewDto listOrder(BaseQueryRequest queryCondition) {
        log.info("start handle list Order request:" + toJSON(queryCondition));
        PageViewDto<Order> toReturn;
        try {
            toReturn = orderServiceContract.listOrder(queryCondition);
        } catch (Exception e) {
            log.error("error in list product.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list Order request with response: " + toJSON(toReturn));

        return toReturn;
    }


    @POST
    @Path("/remove/batch")
    public BaseResponse batchRemoveOrder(List<String> ids) {
        log.info("start to remove Order :" + toJSON(ids));

        BaseResponse result;
        try {
            BaseRequest<List<String>> request = setupRequest(ids);
            result = orderServiceContract.batchRemoveOrder(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove Order.", e);
            result = BaseResponse.buildClientErrorResponse("删除失败");
        }
        return result;
    }


    /**
     * 导出物流配送列表
     *
     * @param batchId
     * @return
     */
    @GET
    @Path("/delivery/export/batch")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response exportDeliveryList(@QueryParam("batchId") String batchId) {

        try {
            BaseRequest<String> request = setupRequest(batchId);
            List<BatchDeliveryExportDTO> result = orderServiceContract.listDeliveryDetailListToExport(request);
            String fileName = String.valueOf(batchId);
            return Response.ok(convertPOJOToExcelBinary(result, BatchDeliveryExportDTO.class, sheetName))
                    .header("content-disposition", "attachment; filename = " + fileName + ".xls").build();
        } catch (NoLoginException e) {
            throw new WebApplicationException(Response.status(401).build());
        } catch (Exception e) {
            log.error("error in exporting data.");
            throw new WebApplicationException(Response.status(500).entity("error in exporting data.").build());
        }
    }

    /**
     * 导入物流结果列表
     *
     * @return
     */
    @POST
    @Path("/delivery/import/batch")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes("multipart/form-data")
    public BaseResponse importDeliveryResult(MultipartFormDataInput input) {
        BaseResponse toReturn;
        try {
            List<InputPart> files = input.getFormDataMap().get("file");
            InputStream inputStream = files.get(0).getBody(Contants.Http.inputStreamGenericType);

            List<BatchDeliveryExportDTO> result = ExcelConversionHelper.converToPOJO(BatchDeliveryExportDTO.class, inputStream, sheetName);
            toReturn = orderServiceContract.importDeliveryResult(result);
        } catch (Exception e) {
            log.error("error in import batch data.", e);
            toReturn = BaseResponse.buildServerErrorResponse("导入配送单失败");
        }
        return toReturn;
    }


    @POST
    @Path("/deliver/batch/generate")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public BaseResponse generateNewBatchDelivery() {
        BaseResponse toReturn;
        try {
            toReturn = orderServiceContract.generateNewBatchDelivery();
        } catch (Exception e) {
            log.info("error in generate new delivery batch", e);
            toReturn = BaseResponse.buildServerErrorResponse("生成配送单失败");
        }
        return toReturn;
    }


    @POST
    @Path("/batch/delivery/list")
    public PageViewDto listDeliveryBatch(BaseQueryRequest queryCondition) {
        log.info("start handle list product delivery request:" + toJSON(queryCondition));
        PageViewDto<OrderDeliverBatch> toReturn;
        try {
            toReturn = orderServiceContract.listDeliveryBatch(queryCondition);
        } catch (Exception e) {
            log.error("error in list product delivery batch.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list product delivery request with response: " + toJSON(toReturn));

        return toReturn;
    }

}
