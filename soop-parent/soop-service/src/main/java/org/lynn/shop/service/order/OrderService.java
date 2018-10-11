package org.lynn.soop.service.order;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.order.OrderBuisness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.member.dto.ProductCalRequest;
import org.lynn.soop.contract.member.dto.ProductCalResponse;
import org.lynn.soop.contract.order.OrderServiceContract;
import org.lynn.soop.contract.order.dto.AcceptOrderDTO;
import org.lynn.soop.contract.order.dto.BatchDeliveryExportDTO;
import org.lynn.soop.contract.order.dto.OrderDetailDTO;
import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderDeliverBatch;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/6/16
 * Time         : 7:59 PM
 * Description  : describe your class here
 */
@Service
public class OrderService implements OrderServiceContract {
    @Autowired
    OrderBuisness orderBuisness;

    public BaseResponse updateOrder(BaseRequest<Order> request) {
        return orderBuisness.updateOrder(request);
    }

    public PageViewDto<Order> listOrder(BaseQueryRequest queryCondition) {
        return orderBuisness.listOrder(queryCondition);
    }

    public BaseResponse batchRemoveOrder(BaseRequest<List<String>> request) {
        return orderBuisness.batchRemoveOrder(request);
    }

    public BaseResponse<String> acceptOrder(BaseAPIRequest<AcceptOrderDTO> request) {
        return orderBuisness.acceptOrder(request);
    }

    /**
     * 同步订单的快递物流状态
     *
     * @return
     */
    public BaseResponse syncDeliveryStatus() {
        orderBuisness.syncDeliveryStatus();
        return BaseResponse.buildSuccessResponse("ok");
    }

    public List<BatchDeliveryExportDTO> listDeliveryDetailListToExport(BaseRequest<String> request) {
        return orderBuisness.listDeliveryDetailListToExport(request);
    }

    public BaseResponse importDeliveryResult(List<BatchDeliveryExportDTO> result) {
        return orderBuisness.importDeliveryResult(result);
    }

    public BaseResponse generateNewBatchDelivery() {
        return orderBuisness.generateNewBatchDelivery();
    }

    public PageViewDto<OrderDeliverBatch> listDeliveryBatch(BaseQueryRequest queryCondition) {
        return orderBuisness.listDeliveryBatch(queryCondition);
    }

    public BaseResponse<OrderDetailDTO> getOrderDetail(BaseAPIRequest<String> request) {
        return orderBuisness.getOrderDetail(request);
    }

    public BaseResponse getOrderDetailList(BaseAPIRequest<String> request) {
        return orderBuisness.getOrderDetailList(request);
    }

    public BaseResponse<ProductCalResponse> calOrder(BaseAPIRequest<ProductCalRequest> request) {
        return orderBuisness.calOrder(request);
    }
}
