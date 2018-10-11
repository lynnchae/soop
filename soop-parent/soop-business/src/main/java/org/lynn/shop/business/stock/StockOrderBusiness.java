package org.lynn.soop.business.stock;

import org.lynn.soop.business.order.OrderBuisness;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.order.dto.DeliverStatus;
import org.lynn.soop.contract.order.dto.OrderStatus;
import org.lynn.soop.contract.product.dto.ProductRoutine;
import org.lynn.soop.entity.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 库存订单相关业务
 */
@Component
public class StockOrderBusiness {

    private static final Logger log = Logger.getLogger(StockOrderBusiness.class);
    @Autowired
    OrderBuisness orderBuisness;

    @Autowired
    StockReadMapper stockReadMapper;

    @Autowired
    StockWriteMapper stockWriteMapper;

    @Autowired
    OutStockHistoryWriteMapper outStockHistoryWriteMapper;

    @Autowired
    OrderReadMapper orderReadMapper;

    @Autowired
    OrderWriteMapper orderWriteMapper;

    @Autowired
    OrderProductListReadMapper orderProductListReadMapper;

    @Autowired
    OrderStatusHistoryWriteMapper orderStatusHistoryWriteMapper;

    @Autowired
    ProductReadMapper productReadMapper;

    @Autowired
    OrderDeliverRoutineReadMapper orderDeliverRoutineReadMapper;

    @Autowired
    OrderDeliveryWriteMapper orderDeliveryWriteMapper;


    /**
     * 列出已付款的商品, 按照订单时间 asc
     * 判读仓库是否满足其商品需求
     * 不满足，就忽略。如果满足则
     * 将仓库库存调减
     * 增加出库记录
     * 更新订单状态为MATCHED状态（已配货，可以打批导出，送至物流）
     * 插入订单状态变化记录
     * 根据订单商品类别制定派送路线。todo： 或者这个计算需要放前面，和运费有关？
     */
    @Transactional
    public BaseResponse deliverOrder() {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andStatusEqualTo(OrderStatus.PAYED.name());

        List<Order> orders = orderReadMapper.selectByExample(orderExample);
        if (orders.size() == 0) {
            log.info("no payed order found.");
            return BaseResponse.buildSuccessResponse("success");
        }


        log.info("total payed order found: " + orders.size());
        List<Stock> stocks = stockReadMapper.selectByExample(new StockExample());
        Map<Long, Stock> stockMap = new HashMap<Long, Stock>();
        for (Stock stock : stocks) {
            stockMap.put(stock.getProduct_id(), stock);
        }

        boolean hasSuccessMatch = false;
        for (Order order : orders) {
            log.info("start matching order:" + order.getId());
            OrderProductListExample orderProductListExample = new OrderProductListExample();
            orderProductListExample.createCriteria().andOrder_idEqualTo(order.getId());
            List<OrderProductList> orderProductLists = orderProductListReadMapper.selectByExample(orderProductListExample);
            boolean matched = match(orderProductLists, stockMap);
            if (matched) {
                log.info("order is match with stock:" + order.getId());
                hasSuccessMatch = true;

                //更新订单状态
                order.setStatus(OrderStatus.MATCHED.name());


                //如果匹配成功，更新出库记录
                List<Long> productIds = new ArrayList<Long>();
                Map<Long, OrderProductList> orderProductListMap = new HashMap<Long, OrderProductList>();
                for (OrderProductList orderProductList : orderProductLists) {
                    OutStockHistory outStockHistory = new OutStockHistory();
                    outStockHistory.setProduct_id(orderProductList.getProduct_id());
                    outStockHistory.setQuantity(orderProductList.getQuantity());
                    outStockHistory.setProduct_price(orderProductList.getProduct_price());
                    outStockHistoryWriteMapper.insertSelective(outStockHistory);
                    productIds.add(orderProductList.getProduct_id());
                    orderProductListMap.put(orderProductList.getProduct_id(), orderProductList);
                }

                order.setDate_updated(new Date());
                orderWriteMapper.updateByPrimaryKeySelective(order);

                ProductExample example = new ProductExample();
                example.createCriteria().andIdIn(productIds);
                List<Product> products = productReadMapper.selectByExample(example);

                String productInfo = generateProductInfo(products, orderProductListMap);
                //物流订单更新
                OrderDeliverRoutine routine = determineRoutine(products);

                OrderDelivery orderDelivery = new OrderDelivery();
                orderDelivery.setProduct_info(productInfo);
                orderDelivery.setOrder_id(order.getId());
                orderDelivery.setStatus(DeliverStatus.matched.name());
                orderDelivery.setSource_delivery_route(routine.getRoutine_name());
                orderDelivery.setDelivery_address(order.getDelivery_address());
                orderDelivery.setDelivery_post_code(order.getDelivery_post_code());
                orderDelivery.setDelivery_contact_name(order.getDelivery_contact_name());
                orderDelivery.setDelivery_contact_phone(order.getDelivery_contact_phone());
                orderDelivery.setDelivery_order_no(buildOrderDeliverNo(order.getId(), 9));
                orderDeliveryWriteMapper.insert(orderDelivery);

                //订单状态变更历史
                OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
                orderStatusHistory.setTo_status(OrderStatus.MATCHED.name());
                orderStatusHistory.setOrder_id(order.getId());
                orderStatusHistoryWriteMapper.insertSelective(orderStatusHistory);
            } else {
                log.info("order is not matched:" + order.getId());
            }
        }

        //如果有匹配成功的
        if (hasSuccessMatch) {
            for (Stock stock : stocks) {
                stock.setDate_updated(new Date());
                stockWriteMapper.updateByPrimaryKeySelective(stock);
            }
        }

        return BaseResponse.buildSuccessResponse("ok");
    }

    public static String buildOrderDeliverNo(String orderId, int length) {
        String orderNo = String.valueOf(orderId);
        int left = length - orderNo.length();
        if (left < 0) {
            throw new RuntimeException("订单号超过物流单号长度，需要更新物流单号策略");
        }
        return String.format("QX%s%sNA", "00000000000000000".substring(0, left), orderNo);
    }

    /**
     * 生成订单的商品列表的描述
     *
     * @param products
     * @return
     */
    public String generateProductInfo(List<Product> products, Map<Long, OrderProductList> orderProductListMap) {
        StringBuilder toReturn = new StringBuilder();
        for (Product product : products) {
            OrderProductList orderProductList = orderProductListMap.get(product.getId());
            toReturn.append(String.format("%s %s %s x %s", product.getId(), product.getBrand_name_cn(), product.getProduct_name_cn() , orderProductList.getQuantity()));
            toReturn.append(System.lineSeparator());
        }
        return toReturn.toString();
    }

    /**
     * get top priority routine.
     *
     * @param products
     * @return
     */
    public OrderDeliverRoutine determineRoutine(List<Product> products) {
        OrderDeliverRoutine toReturn = new OrderDeliverRoutine();
        ProductRoutine targetRoutine = ProductRoutine.A;
        for (Product product : products) {
            ProductRoutine productRoutine = ProductRoutine.parse(product.getRoutine_id());
            if (targetRoutine.getPriority() > productRoutine.getPriority()) {
                targetRoutine = productRoutine;
            }
        }
        toReturn.setId(Long.valueOf(targetRoutine.getCode()));
        toReturn.setRoutine_name(targetRoutine.getDisplayName());
        return toReturn;
    }

    public ProductRoutine determineProductRoutine(List<Product> products) {
        ProductRoutine targetRoutine = ProductRoutine.A;
        for (Product product : products) {
            ProductRoutine productRoutine = ProductRoutine.parse(product.getRoutine_id());
            if (targetRoutine.getPriority() > productRoutine.getPriority()) {
                targetRoutine = productRoutine;
            }
        }
        return targetRoutine;
    }

    public OrderDeliverRoutine determineRoutine(int routineId) {
        OrderDeliverRoutine toReturn = new OrderDeliverRoutine();
        ProductRoutine productRoutine = ProductRoutine.parse(routineId);
        toReturn.setId(Long.valueOf(productRoutine.getCode()));
        toReturn.setRoutine_name(productRoutine.getDisplayName());
        return toReturn;
    }


    /**
     * 检查是否仓库库存余量充足
     *
     * @param productLists
     * @param stockMap
     * @return
     */
    private boolean match(List<OrderProductList> productLists, Map<Long, Stock> stockMap) {
        for (OrderProductList productList : productLists) {
            Stock stock = stockMap.get(productList.getProduct_id());
            if (stock.getQuantity() < productList.getQuantity()) {
                return false;
            }
        }
        //如果仓库库存充足
        for (OrderProductList productList : productLists) {
            Stock stock = stockMap.get(productList.getProduct_id());
            stock.setQuantity(stock.getQuantity() - productList.getQuantity());
        }
        return true;
    }
}
