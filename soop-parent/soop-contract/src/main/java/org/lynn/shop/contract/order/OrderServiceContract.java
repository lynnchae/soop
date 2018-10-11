package org.lynn.soop.contract.order;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.member.dto.ProductCalRequest;
import org.lynn.soop.contract.member.dto.ProductCalResponse;
import org.lynn.soop.contract.order.dto.AcceptOrderDTO;
import org.lynn.soop.contract.order.dto.BatchDeliveryExportDTO;
import org.lynn.soop.contract.order.dto.OrderDetailDTO;
import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderDeliverBatch;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/6/16
 * Time         : 7:55 PM
 * Description  : 订单契约
 */
@Path("/service/order")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface OrderServiceContract {
    /**
     * 更新订单，没有会创建
     *
     * @param request
     * @return
     */
    @POST
    @Path("/update")
    BaseResponse updateOrder(BaseRequest<Order> request);

    @POST
    @Path("/list")
    PageViewDto<Order> listOrder(BaseQueryRequest queryCondition);

    @POST
    @Path("/remove/batch")
    BaseResponse batchRemoveOrder(BaseRequest<List<String>> request);

    @POST
    @Path("/accept/order")
    BaseResponse<String> acceptOrder(BaseAPIRequest<AcceptOrderDTO> request);

    /**
     * 快递状态查询
     *
     * @return
     */
    @POST
    @Path("/delivery/status")
    BaseResponse syncDeliveryStatus();

    @POST
    @Path("/delivery/export")
    List<BatchDeliveryExportDTO> listDeliveryDetailListToExport(BaseRequest<String> request);

    @POST
    @Path("/delivery/import")
    BaseResponse importDeliveryResult(List<BatchDeliveryExportDTO> result);


    @POST
    @Path("/delivery/batch/new")
    BaseResponse generateNewBatchDelivery();

    @POST
    @Path("/delivery/batch/list")
    PageViewDto<OrderDeliverBatch> listDeliveryBatch(BaseQueryRequest queryCondition);


    @POST
    @Path("/order/detail")
    BaseResponse<OrderDetailDTO> getOrderDetail(BaseAPIRequest<String> request);


    @POST
    @Path("/order/detail/list")
    BaseResponse getOrderDetailList(BaseAPIRequest<String> request);

    @POST
    @Path("/order/price/calc")
    BaseResponse<ProductCalResponse> calOrder(BaseAPIRequest<ProductCalRequest> request);
}
