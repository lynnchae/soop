package org.lynn.soop.service.stock;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.stock.StockBusiness;
import org.lynn.soop.business.stock.StockOrderBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.stock.StockServiceContract;
import org.lynn.soop.contract.stock.dto.BatchPurchaseExportDTO;
import org.lynn.soop.contract.stock.dto.PurchaseRequestListDTO;
import org.lynn.soop.entity.PurchaseProductBatch;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 库存服务
 */
@Service
public class StockService implements StockServiceContract {
    @Autowired
    StockBusiness stockBusiness;

    @Autowired
    StockOrderBusiness stockOrderBusiness;

    public BaseResponse addToPurchaseList(BaseRequest<Long> request) {
        return null;
    }

    public PageViewDto<PurchaseRequestListDTO> listPurchaseList(BaseRequest<Long> request) {
        return null;
    }

    public List<BatchPurchaseExportDTO> listPurseDetailListToExport(BaseRequest<Long> request) {
        return stockBusiness.listPurseDetailListToExport(request);
    }

    public BaseResponse importPurchaseResult(List<BatchPurchaseExportDTO> result) {
        return stockBusiness.importPurchaseResult(result);

    }

    public PageViewDto<PurchaseProductBatch> listPurchaseBatch(BaseQueryRequest queryCondition) {
        return stockBusiness.listPurchaseBatch(queryCondition);
    }

    public BaseResponse deliverOrder() {
        return stockOrderBusiness.deliverOrder();
    }
}
