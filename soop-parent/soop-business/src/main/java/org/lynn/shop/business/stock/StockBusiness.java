package org.lynn.soop.business.stock;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.stock.dto.BatchPurchaseExportDTO;
import org.lynn.soop.entity.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.lynn.soop.util.DataHelper.dateFormat;

/**
 * 库存采购相关业务
 */
@Component
public class StockBusiness {

    @Autowired
    PurchaseProductBatchWriteMapper purchaseProductBatchWriteMapper;


    @Autowired
    PurchaseProductBatchReadMapper purchaseProductBatchReadMapper;

    @Autowired
    PurchaseProductRequestReadMapper purchaseProductRequestReadMapper;

    @Autowired
    PurchaseProductRequestWriteMapper purchaseProductRequestWriteMapper;


    @Autowired
    PurchaseProductResultReadMapper purchaseProductResultReadMapper;

    @Autowired
    PurchaseProductResultWriteMapper purchaseProductResultWriteMapper;

    @Autowired
    ProductReadMapper productReadMapper;

    @Autowired
    StockReadMapper stockReadMapper;

    @Autowired
    StockWriteMapper stockWriteMapper;


    @Autowired
    InStockHistoryWriteMapper inStockHistoryWriteMapper;

    public void addToPurchasePool(List<OrderProductList> orderProductLists) {
        Long batchId = Long.parseLong(dateFormat(DateTime.now(), "yyyyMMdd"));
        PurchaseProductBatch productBatch;
        PurchaseProductBatchExample batchExample = new PurchaseProductBatchExample();
        batchExample.createCriteria().andPurchase_product_batch_idEqualTo(batchId);
        //准备批次号，一天一批
        List<PurchaseProductBatch> batches = purchaseProductBatchReadMapper.selectByExample(batchExample);
        if (batches.size() == 0) {
            productBatch = new PurchaseProductBatch();
            productBatch.setPurchase_product_batch_id(batchId);
            productBatch.setPlan_product_count(0);
            productBatch.setPlan_total_item_count(0);
            purchaseProductBatchWriteMapper.insertSelective(productBatch);
        } else {
            productBatch = batches.get(0);
        }

        int totalProductType = 0;
        int totalProductNum = 0;
        for (OrderProductList orderProductList : orderProductLists) {
            PurchaseProductRequestExample requestExample = new PurchaseProductRequestExample();
            requestExample.createCriteria().andPurchase_product_batch_idEqualTo(batchId);
            requestExample.createCriteria().andProduct_idEqualTo(orderProductList.getProduct_id());
            PurchaseProductRequest request;
            List<PurchaseProductRequest> requests = purchaseProductRequestReadMapper.selectByExample(requestExample);
            if (requests.size() == 0) {
                request = new PurchaseProductRequest();
                request.setPurchase_product_batch_id(batchId);
                request.setProduct_id(orderProductList.getProduct_id());
                request.setPlan_quantity(orderProductList.getQuantity());
                purchaseProductRequestWriteMapper.insertSelective(request);
            } else {
                request = requests.get(0);
                request.setPlan_quantity(request.getPlan_quantity() + orderProductList.getQuantity());
                request.setDate_updated(new Date());
                purchaseProductRequestWriteMapper.updateByPrimaryKeySelective(request);
            }

            totalProductType++;
            totalProductNum = totalProductNum + orderProductList.getQuantity();
        }

        productBatch.setPlan_total_item_count(productBatch.getPlan_total_item_count() + totalProductNum);
        productBatch.setPlan_product_count(productBatch.getPlan_product_count() + totalProductType);

        purchaseProductBatchWriteMapper.updateByPrimaryKeySelective(productBatch);
    }


    public List<BatchPurchaseExportDTO> listPurseDetailListToExport(BaseRequest<Long> request) {
        List<BatchPurchaseExportDTO> toReturn = new ArrayList<BatchPurchaseExportDTO>();
        PurchaseProductRequestExample requestExample = new PurchaseProductRequestExample();
        requestExample.createCriteria().andPurchase_product_batch_idEqualTo(request.getData());
        List<PurchaseProductRequest> requests = purchaseProductRequestReadMapper.selectByExample(requestExample);
        for (PurchaseProductRequest requestItem : requests) {
            Product product = productReadMapper.selectByPrimaryKey(requestItem.getProduct_id());
            toReturn.add(BatchPurchaseExportDTO.from(product, requestItem));
        }
        return toReturn;
    }

    /**
     * 导入采购记录
     *
     * @param result
     * @return
     */
    @Transactional
    public BaseResponse importPurchaseResult(List<BatchPurchaseExportDTO> result) {
        long batchId = -1;
        int productCount = 0;

        for (BatchPurchaseExportDTO dto : result) {
            //先更新导入记录表
            PurchaseProductResult productResult = new PurchaseProductResult();
            productResult.setProduct_id(Long.valueOf(dto.getProduct_id()));
            productResult.setPurchase_product_batch_id(Long.valueOf(dto.getBatch_id()));

            int exchange_rate = new BigDecimal(dto.getExchange_rate()).multiply(new BigDecimal(100)).setScale(0).intValue();
            productResult.setExchange_rate(exchange_rate);
            int purchase_price_in_usd = new BigDecimal(dto.getPurchase_price_in_usd()).multiply(new BigDecimal(100)).setScale(0).intValue();
            productResult.setPurchase_price_in_usd(purchase_price_in_usd);
            int actualQuatity = new BigDecimal(dto.getActual_quantity()).intValue();
            productResult.setActual_quantity(actualQuatity);
            productResult.setPurchase_product_request(Long.valueOf(dto.getRequest_id()));
            purchaseProductResultWriteMapper.insertSelective(productResult);

            //再更新采购详情表
            PurchaseProductRequest request = purchaseProductRequestReadMapper.selectByPrimaryKey(Long.valueOf(dto.getRequest_id()));
            Integer actual_quantity = request.getActual_quantity();
            if (actual_quantity == null) {
                actual_quantity = 0;
            }
            request.setActual_quantity(actual_quantity + actualQuatity);
            Integer purchase_time = request.getPurchase_time();
            if (purchase_time == null) {
                purchase_time = 0;
            }
            request.setPurchase_time(purchase_time + 1);
            if (batchId == -1)
                batchId = Long.parseLong(dto.getBatch_id());
            request.setDate_updated(new Date());
            purchaseProductRequestWriteMapper.updateByPrimaryKeySelective(request);

            productCount = productCount + actualQuatity;
            //更新库存信息
            updateInStockInfo(dto, productResult);
        }

        //再更新采购汇总表
        PurchaseProductBatchExample example = new PurchaseProductBatchExample();
        example.createCriteria().andPurchase_product_batch_idEqualTo(batchId);
        List<PurchaseProductBatch> batches = purchaseProductBatchReadMapper.selectByExample(example);
        PurchaseProductBatch purchaseProductBatch = batches.get(0);
        Integer actual_total_item_count = purchaseProductBatch.getActual_total_item_count();
        if (actual_total_item_count == null) {
            actual_total_item_count = 0;
        }
        purchaseProductBatch.setActual_total_item_count(actual_total_item_count + productCount);
        purchaseProductBatch.setDate_updated(new Date());
        purchaseProductBatchWriteMapper.updateByPrimaryKeySelective(purchaseProductBatch);

        return BaseResponse.buildSuccessResponse("ok");
    }

    private int parseInt(String val) {
        return new BigDecimal(val).intValue();
    }

    /**
     * 更新库存信息
     *
     * @param dto
     */
    private void updateInStockInfo(BatchPurchaseExportDTO dto, PurchaseProductResult productResult) {
        //更新库存信息
        StockExample stockExample = new StockExample();
        stockExample.createCriteria().andProduct_idEqualTo(Long.valueOf(dto.getProduct_id()));
        List<Stock> stocks = stockReadMapper.selectByExample(stockExample);
        if (stocks.size() == 0) {
            Stock stock = new Stock();
            stock.setProduct_id(Long.valueOf(dto.getProduct_id()));
            stock.setQuantity(parseInt(dto.getActual_quantity()));
            stockWriteMapper.insertSelective(stock);
        } else {
            Stock stock = stocks.get(0);
            stock.setQuantity(stock.getQuantity() + parseInt(dto.getActual_quantity()));
            stock.setDate_updated(new Date());
            stockWriteMapper.updateByPrimaryKeySelective(stock);
        }
        //记录入库信息
        InStockHistory inStockHistory = new InStockHistory();
        inStockHistory.setQuantity(productResult.getActual_quantity());
        inStockHistory.setProduct_id(Long.valueOf(dto.getProduct_id()));
        //计算成RMB的采购成本
        int purchase_price = productResult.getPurchase_price_in_usd() * productResult.getExchange_rate();
        inStockHistory.setPurchase_price(purchase_price);
        inStockHistoryWriteMapper.insertSelective(inStockHistory);
    }

    public PageViewDto<PurchaseProductBatch> listPurchaseBatch(BaseQueryRequest queryCondition) {
        PurchaseProductBatchExample example = new PurchaseProductBatchExample();
        int totalCount = purchaseProductBatchReadMapper.countByExample(example);

        PageRequest pageRequest = queryCondition.getPageRequest();
        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<PurchaseProductBatch> result = purchaseProductBatchReadMapper.selectByExample(example);
        PageViewDto<PurchaseProductBatch> toReturn = new PageViewDto<PurchaseProductBatch>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }
}
