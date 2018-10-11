package org.lynn.soop.business.order;

import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.business.common.SysConfigBusiness;
import org.lynn.soop.business.stock.StockBusiness;
import org.lynn.soop.business.stock.StockOrderBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.function.KuaidiResp;
import org.lynn.soop.contract.function.KuaidiServiceContact;
import org.lynn.soop.contract.member.dto.ProductCalRequest;
import org.lynn.soop.contract.member.dto.ProductCalResponse;
import org.lynn.soop.contract.order.dto.*;
import org.lynn.soop.contract.product.dto.ProductDto;
import org.lynn.soop.contract.product.dto.ProductRoutine;
import org.lynn.soop.entity.*;
import org.lynn.soop.entity.handwrite.UserAddressExtend;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.*;
import org.lynn.soop.util.JsonHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;
import static org.lynn.soop.util.DataHelper.*;
import static org.lynn.soop.util.JsonHelper.toJSON;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

@Component
public class OrderBuisness extends BaseBusiness {

    public static final String SYS_EXCHANGE_RATE = "sys.exchange.rate";//汇率键值
    public static final String SYS_PROFIT_RATE = "sys.profit.rate";//汇率键值
    public static final String DEFAULT_EXCHANGE_VALUE = "6.5"; //默认汇率
    @Autowired
    SysConfigBusiness sysConfigBusiness;
    @Autowired
    OrderWriteMapper orderWriteMapper;

    @Autowired
    OrderReadMapper orderReadMapper;

    @Autowired
    OrderProductListReadMapper orderProductListReadMapper;

    @Autowired
    OrderProductListWriteMapper orderProductListWriteMapper;


    @Autowired
    OrderStatusHistoryWriteMapper orderStatusHistoryWriteMapper;


    @Autowired
    OrderDeliveryReadMapper orderDeliveryReadMapper;

    @Autowired
    OrderDeliveryWriteMapper orderDeliveryWriteMapper;


    @Autowired
    OrderDeliverBatchWriteMapper orderDeliverBatchWriteMapper;


    @Autowired
    OrderDeliverBatchReadMapper orderDeliverBatchReadMapper;


    @Autowired
    ProductReadMapper productReadMapper;


    @Autowired
    StockBusiness stockBusiness;

    @Autowired
    StockOrderBusiness stockOrderBusiness;

    @Autowired
    UserAddressReadMapper userAddressReadMapper;

    @Autowired
    KuaidiServiceContact kuaidiService;


    @Autowired
    UsersooppingCartWriteMapper usersooppingCartWriteMapper;


    @Autowired
    SysParameterReadMapper sysParameterReadMapper;

    public BaseResponse updateOrder(BaseRequest<Order> request) {
        Order order = request.getData();
        boolean createNew = order.getId() == null;
        int result;
        if (createNew) {
            result = orderWriteMapper.insertSelective(order);
        } else {
            order.setDate_updated(new Date());
            order.setTotal_product_amount(order.getTotal_order_amount());
            result = orderWriteMapper.updateByPrimaryKeySelective(order);
        }
        BaseResponse toReturn;
        if (result > 0) {
            toReturn = BaseResponse.buildSuccessResponse("ok");
        } else {
            logger.error(String.format("error in update order order: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        return toReturn;
    }

    public PageViewDto<Order> listOrder(BaseQueryRequest queryCondition) {
        OrderExample example = new OrderExample();
        example.setOrderByClause(" id desc ");
        PageRequest pageRequest = queryCondition.getPageRequest();

        //后台通过手机号码可以搜索到
        if (isNotEmpty(pageRequest.getSearch())) {
            OrderExample.Criteria criteria = example.createCriteria();
            criteria.andDelivery_contact_phoneLike("%"+pageRequest.getSearch()+"%");
        }

        int totalCount = orderReadMapper.countByExample(example);

        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        example.setPageCount(pageRequest.getLimit());
        List<Order> result = orderReadMapper.selectByExample(example);
        PageViewDto<Order> toReturn = new PageViewDto<Order>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    public BaseResponse batchRemoveOrder(BaseRequest<List<String>> request) {
        List<String> ids = request.getData();
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int effectedRows = orderWriteMapper.deleteByExample(example);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRows == 0) {
            logger.error(String.format("error in remove order: [%s]", toJSON(ids)));
            toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
        }
        return toReturn;
    }


    @Transactional
    public BaseResponse<String> acceptOrder(BaseAPIRequest<AcceptOrderDTO> request) {
    	
        AcceptOrderDTO dto = request.getData();

    	// 校验库存
		for (AcceptOrderDTO.ProductOrderItem productOrderItem : dto.getProduct_list()) {
			long productId = productOrderItem.getProduct_id();
			int num = productOrderItem.getNumber();

			Product product = productReadMapper.selectByPrimaryKey(productId);
			if (product.getStock_count() < num) {
				throw new MyBizException(BaseResponse.buildClientErrorResponse("库存不足"));
			}

            // 下单商品个数校验
            if (num <= 0) {
                throw new MyBizException(BaseResponse.buildClientErrorResponse("非法请求"));
            }
        }
    	
        //计算验证订单价格信息
        //插入订单表
        Order order = new Order();
        order.setId("YHFQ"+ GenerateBillNo());
        order.setTotal_order_amount(dto.getPayable_amount());
        order.setFreight(dto.getFreight());
        order.setAddress_id(dto.getAddress_id());
        order.setTotal_product_number(dto.getTotal_product_number());
        order.setTotal_weight(dto.getTotal_weight());
        order.setStatus(OrderStatus.NEW.name());
        order.setCreated_by(String.valueOf(request.getUser()));

        UserAddress userAddress = userAddressReadMapper.selectByPrimaryKey(dto.getAddress_id());
        if (userAddress != null) {
            //logger.error("invalid user address to submitted:" + dto.getAddress_id());
            //throw new RuntimeException("无效地址");
            UserAddressExtend userAddressExt = UserAddressExtend.generateFromOriginEntity(userAddress);
            order.setDelivery_address(userAddressExt.getFullAddressDetail());
            order.setDelivery_post_code(userAddress.getPost_code());
            order.setDelivery_contact_name(userAddress.getContact_name());
            order.setDelivery_contact_phone(userAddress.getContact_phone());
        }


        int effectedRow = orderWriteMapper.insertSelective(order);
        if (effectedRow < 1) {
            throw new RuntimeException("error in add order.");
        }
        //获取商品信息，更新入库
        List<Long> productIds = new ArrayList<Long>();
        Map<Long, OrderProductList> orderProductListMap = new HashMap<Long, OrderProductList>();
        for (AcceptOrderDTO.ProductOrderItem productOrderItem : dto.getProduct_list()) {
            OrderProductList orderProductList = new OrderProductList();
            orderProductList.setOrder_id(order.getId());
            orderProductList.setProduct_id(productOrderItem.getProduct_id());
            orderProductList.setProduct_price(productOrderItem.getProduct_price());
            orderProductList.setQuantity(productOrderItem.getNumber());
            orderProductList.setOrder_status(OrderStatus.NEW.name());
            orderProductListWriteMapper.insertSelective(orderProductList);
            productIds.add(orderProductList.getProduct_id());
            orderProductListMap.put(orderProductList.getProduct_id(), orderProductList);
        }


        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(productIds);
        List<Product> products = productReadMapper.selectByExample(example);
        String productInfo = stockOrderBusiness.generateProductInfo(products, orderProductListMap);
        order.setOrder_description(productInfo);


//        calculateOrderInfo(order, products, orderProductListMap, userAddressExt);
        if (dto.getPayable_amount() > 0) {
            // Mark:2017.1.22 租房项目议价功能
            order.setTotal_product_number(1);//总数量
            order.setTotal_weight(1);//总重量
            order.setTotal_product_amount(dto.getPayable_amount());//总原价
            order.setTotal_order_amount(dto.getPayable_amount());
        } else {
            // 根据商品数量计算订单金额
            calcOrderFeeV20160607(order, products, orderProductListMap, null);
        }
        order.setDate_updated(new Date());
        orderWriteMapper.updateByPrimaryKeySelective(order);

        OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
        orderStatusHistory.setOrder_id(order.getId());
        orderStatusHistory.setTo_status(OrderStatus.NEW.name());
        orderStatusHistoryWriteMapper.insertSelective(orderStatusHistory);
        //更新订单物流信息表

        //clean soopping cart
        UsersooppingCartExample usersooppingCartExample = new UsersooppingCartExample();
        usersooppingCartExample.createCriteria().andProduct_idIn(productIds);
        effectedRow = usersooppingCartWriteMapper.deleteByExample(usersooppingCartExample);
        if (effectedRow == 0) {
            logger.error("购物车清除失败");
        }

        return BaseResponse.buildSuccessResponse(order.getId());
    }


    /**
     * 运费规则计算逻辑：
     * 商品单价x数量
     * 商品单价＝汇率x销售价格 ＋ 根据毛重和路线算出来的运费
     *
     * @param order
     * @param products
     * @param orderProductListMap
     * @param userAddress
     */
    private void calcOrderFeeV20160607(Order order, List<Product> products, Map<Long, OrderProductList> orderProductListMap, UserAddressExtend userAddress) {

        /*去掉了配送区域限制  张海峰 2016-09-11*/
        /*if (userAddress.isSpecialRegion()) {
            throw new RuntimeException("不支持配送区域，下单失败");
        }*/

        //boolean deliveryFeeFree = isDeliveryFeeFree(products);
        BigDecimal exchangeRate = BigDecimal.ONE;
        int totalOriginPay = 0; //商品原价
        int totalWeight = 0;
        int totalNumber = 0;
        for (Product product : products) {
            OrderProductList orderProductList = orderProductListMap.get(product.getId());
            Integer quantity = 0;
            if (orderProductList != null) {
                quantity = orderProductList.getQuantity();
            } else {
                logger.error("no product found in current order list");
            }

            totalNumber += quantity;

            ProductRoutine productRoutine = ProductRoutine.parse(product.getRoutine_id());
            int unitPrice = multiple(product.getPrice_on_sale(), exchangeRate);
            int unitDeliveryPrice = 0;

            totalOriginPay += (unitPrice + unitDeliveryPrice) * quantity;

            totalWeight += product.getProduct_weight() * quantity;

        }

        order.setTotal_product_number(totalNumber);//总数量
        order.setTotal_weight(totalWeight);//总重量


        order.setTotal_product_amount(totalOriginPay);//总原价
        order.setTotal_order_amount(totalOriginPay);

    }

    private void calcOrderFee(Order order, List<Product> products, Map<Long, OrderProductList> orderProductListMap, UserAddressExtend userAddress) {
        boolean deliveryFeeFree = isDeliveryFeeFree(products);
        int totalOriginPay = 0; //商品原价
        int totalFreightAmount = 0; //应付运费
        int totalActualFreightAmount = 0; //优惠后运费
        int totalWeight = 0;
        int totalNumber = 0;
        ProductRoutine productRoutine = stockOrderBusiness.determineProductRoutine(products);
        for (Product product : products) {
            OrderProductList orderProductList = orderProductListMap.get(product.getId());
            Integer quantity = 0;
            if (orderProductList != null) {
                quantity = orderProductList.getQuantity();
            } else {
                logger.error("no product found in current order list");
            }

            totalNumber += quantity;

            if (!deliveryFeeFree) {
                totalFreightAmount += getDeliveryFee(productRoutine, product.getProduct_weight(), userAddress) * quantity;
            }

            totalOriginPay += product.getPrice_on_sale() * quantity;

            totalWeight += product.getProduct_weight() * quantity;

        }

        order.setTotal_product_number(totalNumber);//总数量
        order.setTotal_weight(totalWeight);//总重量


        BigDecimal exchangeRate = sysConfigBusiness.getExchangeRate();
        order.setTotal_product_amount(multiple(totalOriginPay, exchangeRate) + totalFreightAmount);//总原价

        if (!deliveryFeeFree) {
            totalActualFreightAmount = getDeliveryFee(productRoutine, totalWeight, userAddress);
        }
        order.setTotal_order_amount(multiple(totalOriginPay, exchangeRate) + totalActualFreightAmount);//优惠后总原价

    }

    private boolean isDeliveryFeeFree(List<Product> products) {
        boolean deliveryFeeFree = false;
        boolean hasFree = false;
        boolean hasNormal = false;
        for (Product product : products) {
            if (product.getDelivery_free() != null && product.getDelivery_free()) {
                deliveryFeeFree = true;
                hasFree = true;
            } else {
                hasNormal = true;
            }
        }

        if (hasFree && hasNormal) {
            throw new RuntimeException("订单中包含免运费的和直邮的商品，下单失败");
        }
        return deliveryFeeFree;
    }


    /**
     * 根据运输线路运费规则不同
     * 如果是偏远地址，需要另外增加运费
     *
     * @param productRoutine
     * @param totalWeight
     * @param userAddress
     * @return
     */
    public int getDeliveryFee(ProductRoutine productRoutine, int totalWeight, UserAddressExtend userAddress) {
        int delivery_fee = 0;
//        if (userAddress.isSpecialRegion()) {
//            //delivery_fee += 3500;
//            throw new RuntimeException("不支持配送区域，下单失败");
//        }
        //如果总的需付费的订单重量为0，则不需要运费
        if (totalWeight <= 0) {
            return delivery_fee;
        }
        delivery_fee += productRoutine.getThreshold();
        if (totalWeight > 100) {
            delivery_fee += Math.ceil(Math.max((totalWeight - 100) / 100.0, 0)) * productRoutine.getStep();
        }
        return delivery_fee;
    }

    private String getConfig(String key, String defaultValue) {
        String exchangeRate = defaultValue;
        SysParameterExample example = new SysParameterExample();
        example.createCriteria().andParam_keyEqualTo(key);
        List<SysParameter> sysParameters = sysParameterReadMapper.selectByExample(example);
        if (sysParameters.size() == 1) {
            exchangeRate = sysParameters.get(0).getParam_value();
        }
        return exchangeRate;
    }


    /**
     * 计算运费，单位：分
     *
     * @param total_weight 磅数x100
     * @return
     */
    private Integer calculateFreight(Integer total_weight) {
        if (total_weight <= 0) {
            return 0;
        }
        if (total_weight < 300) {
            return 1000;
        } else if (total_weight >= 300 && total_weight < 1500) {
            return 2500;
        } else if (total_weight >= 1500 && total_weight < 2000) {
            return 4000;
        } else {
            throw new RuntimeException("单笔订单不能超过20磅");
        }
    }


    @Transactional
    public void onOrderPayed(String orderId) {
        try {
            //更新订单状态变化
            OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
            orderStatusHistory.setOrder_id(orderId);
            orderStatusHistory.setTo_status(OrderStatus.PAYED.name());
            orderStatusHistoryWriteMapper.insertSelective(orderStatusHistory);

            //更新订单状态
            Order order = new Order();
            order.setId(orderId);
            order.setStatus(OrderStatus.PAYED.name());
            order.setDate_updated(new Date());
            orderWriteMapper.updateByPrimaryKeySelective(order);

            OrderProductListExample example = new OrderProductListExample();
            example.createCriteria().andOrder_idEqualTo(orderId);

            OrderProductList orderProductList = new OrderProductList();
            orderProductList.setOrder_status(OrderStatus.PAYED.name());
            orderProductList.setDate_updated(new Date());
            orderProductListWriteMapper.updateByExampleSelective(orderProductList, example);

            //将需要采购的商品加入采购池
            List<OrderProductList> orderProductLists = orderProductListReadMapper.selectByExample(example);
            stockBusiness.addToPurchasePool(orderProductLists);

        } catch (Exception e) {
            logger.error("error in update order status", e);
        }
    }

    public Order getOrderInfo(String orderNo) {
        return orderReadMapper.selectByPrimaryKey(orderNo);
    }

    /**
     * 同步快递物流订单状态
     * 1，查询订单配送表的状态为已配送的订单
     * 2，根据表中的物流公司和订单号调用订单查询接口
     * 3，将返回的订单状态更新进入订单物流状态表
     */
    public void syncDeliveryStatus() {
        //所有的配送中的订单
        OrderExample e = new OrderExample();
        e.setOrderByClause(" id desc ");
        e.setPageIndex(1);
        e.setPageCount(1000);
        e.createCriteria().andStatusIn(Arrays.asList(OrderStatus.MATCHED.name(), OrderStatus.DELIVERED.name()));

        int maxTimes = 2;     //todo 最多支持2000个订单的物流查询
        for (int i = 0; i < maxTimes; i++) {
            List<Order> orderList = orderReadMapper.selectByExample(e);
            if (orderList.isEmpty()) {
                break;
            }
            for (Order order : orderList) {
                OrderDeliveryExample ee = new OrderDeliveryExample();
                ee.createCriteria().andOrder_idEqualTo(order.getId());
                List<OrderDelivery> list = orderDeliveryReadMapper.selectByExample(ee);
                for (OrderDelivery d : list) {
                    //todo 状态判断:已完成的单不再查

                    BaseResponse<KuaidiResp> resp = kuaidiService.query(d.getDelivery_company(), d.getDelivery_order_no());

                    if (resp.isSuccess() && resp.getData().isSuccess()) {

                        OrderDelivery dd = new OrderDelivery();
                        dd.setId(d.getId());
                        dd.setDelivery_detail_status_list(JsonHelper.toGson(resp.getData().getData()));
                        //todo 根据KuaidiResp.state更新物流状态

                        dd.setDate_updated(new Date());
                        orderDeliveryWriteMapper.updateByPrimaryKeySelective(dd);

                    } else {
                        logger.warn("物流单[" + d.getId() + "]查询失败:" + resp);
                    }
                }
            }
        }
    }

    /**
     * 导入物流配送结果，包含更新的物流公司，物流快递单号，运费信息
     * 找到对应记录并更新以上信息，和订单状态
     *
     * @param result
     * @return
     */
    @Transactional
    public BaseResponse importDeliveryResult(List<BatchDeliveryExportDTO> result) {

        long batchId = -1;
        for (BatchDeliveryExportDTO batchDeliveryExportDTO : result) {
            OrderDelivery orderDelivery = BatchDeliveryExportDTO.to(batchDeliveryExportDTO);
            orderDelivery.setDate_updated(new Date());
            int effectedRow = orderDeliveryWriteMapper.updateByPrimaryKeySelective(orderDelivery);
            if (effectedRow != 1) {
                throw new RuntimeException("更新配送详情失败:" + orderDelivery.getId());
            }

            if (batchId == -1) {
                orderDelivery = orderDeliveryReadMapper.selectByPrimaryKey(orderDelivery.getId());
                batchId = Long.parseLong(orderDelivery.getBatch_id());
            }
        }

        if (batchId == -1) {
            throw new RuntimeException("更新配送订单批次失败");
        }
        OrderDeliverBatch orderDeliverBatch = new OrderDeliverBatch();
        orderDeliverBatch.setId(batchId);
        orderDeliverBatch.setAlready_import(true);
        orderDeliverBatch.setDate_updated(new Date());
        int effectedRow = orderDeliverBatchWriteMapper.updateByPrimaryKeySelective(orderDeliverBatch);
        if (effectedRow == 0) {
            throw new RuntimeException("更新配送订单批次失败");
        }

        return BaseResponse.buildSuccessResponse("success");
    }

    /**
     * 导出对应批次号的物流信息
     *
     * @param request
     * @return
     */
    public List<BatchDeliveryExportDTO> listDeliveryDetailListToExport(BaseRequest<String> request) {
        String batchId = request.getData();
        OrderDeliveryExample orderDeliveryExample = new OrderDeliveryExample();
        orderDeliveryExample.createCriteria().andBatch_noEqualTo(batchId);
        List<OrderDelivery> orderDeliveries = orderDeliveryReadMapper.selectByExample(orderDeliveryExample);
        return BatchDeliveryExportDTO.fromList(orderDeliveries);
    }

    /**
     * 生成新的配送单批次
     * 会根据不同的配送线路生成不同的批次
     * 1，查询待配货列表中的路线
     * 2，根据路线生成新的批次，并插入批次表
     * 3，将1中待配送的订单标记成对应批次
     *
     * @return
     */
    @Transactional
    public BaseResponse generateNewBatchDelivery() {
        OrderDeliveryExample example = new OrderDeliveryExample();
        OrderDeliveryExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(DeliverStatus.matched.name());
        criteria.andBatch_idIsNull();
        List<OrderDelivery> orderDeliveries = orderDeliveryReadMapper.selectByExample(example);

        //将配送单按照线路分组
        Map<String, List<OrderDelivery>> orderDeliveryMap = new HashMap<String, List<OrderDelivery>>();
        for (OrderDelivery orderDelivery : orderDeliveries) {
            String route = orderDelivery.getSource_delivery_route();
            if (!orderDeliveryMap.containsKey(route)) {
                orderDeliveryMap.put(route, new ArrayList<OrderDelivery>());
            }
            orderDeliveryMap.get(route).add(orderDelivery);
        }

        //打批分组结束，新建批次，并且更新批次信息
        for (Map.Entry<String, List<OrderDelivery>> entry : orderDeliveryMap.entrySet()) {
            OrderDeliverBatch orderDeliverBatch = new OrderDeliverBatch();

            orderDeliverBatch.setRoutine_name(entry.getKey());
            orderDeliverBatchWriteMapper.insertSelective(orderDeliverBatch);

            orderDeliverBatch.setBatch_id(batchNo(String.valueOf(orderDeliverBatch.getId())));
            orderDeliverBatchWriteMapper.updateByPrimaryKeySelective(orderDeliverBatch);

            for (OrderDelivery orderDelivery : entry.getValue()) {
                orderDelivery.setBatch_id(String.valueOf(orderDeliverBatch.getId()));
                orderDelivery.setBatch_no(orderDeliverBatch.getBatch_id());
                orderDeliveryWriteMapper.updateByPrimaryKey(orderDelivery);
            }
        }

        return BaseResponse.buildSuccessResponse("ok");
    }

    public PageViewDto<OrderDeliverBatch> listDeliveryBatch(BaseQueryRequest queryCondition) {
        OrderDeliverBatchExample example = new OrderDeliverBatchExample();
        int totalCount = orderDeliverBatchReadMapper.countByExample(example);

        PageRequest pageRequest = queryCondition.getPageRequest();
        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<OrderDeliverBatch> result = orderDeliverBatchReadMapper.selectByExample(example);
        PageViewDto<OrderDeliverBatch> toReturn = new PageViewDto<OrderDeliverBatch>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    /**
     * 获取订单详情
     *
     * @param request
     * @return
     */
    public BaseResponse<OrderDetailDTO> getOrderDetail(BaseAPIRequest<String> request) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        String orderId = request.getData();
        //获取订单信息
        Order order = orderReadMapper.selectByPrimaryKey(orderId);
        checkNotNull(order);
        orderDetailDTO.setOrder(order);

        //获取商品信息
        OrderProductListExample orderProductListExample = new OrderProductListExample();
        orderProductListExample.createCriteria().andOrder_idEqualTo(orderId);
        List<OrderProductList> orderProductLists = orderProductListReadMapper.selectByExample(orderProductListExample);
        List<Long> productIds = new ArrayList<Long>();
        Map<Long, OrderProductList> orderProductListMap = new HashMap<Long, OrderProductList>();
        for (OrderProductList orderProductList : orderProductLists) {
            productIds.add(orderProductList.getProduct_id());
            orderProductListMap.put(orderProductList.getProduct_id(), orderProductList);
        }
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIdIn(productIds);
        List<Product> products = productReadMapper.selectByExample(productExample);
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        for (Product product : products) {
            ProductDto productDto = ProductDto.from(product);
            ProductDto.evalProductFields(productDto);
            OrderProductList orderProductList = orderProductListMap.get(product.getId());
            if (orderProductList != null) {
                productDto.setNumber(orderProductList.getQuantity());
            } else {
                logger.error("error in get order product detail number.");
            }
            productDtos.add(productDto);
        }
        orderDetailDTO.setProductDtoList(productDtos);

        OrderDeliverRoutine routine = stockOrderBusiness.determineRoutine(products);
        orderDetailDTO.setOrderDeliverRoutine(routine);

        //获取订单配送信息
        OrderDeliveryExample orderDeliveryExample = new OrderDeliveryExample();
        orderDeliveryExample.createCriteria().andOrder_idEqualTo(orderId);
        List<OrderDelivery> orderDeliveries = orderDeliveryReadMapper.selectByExample(orderDeliveryExample);
        if (orderDeliveries.size() == 1) {
            orderDetailDTO.setOrderDelivery(orderDeliveries.get(0));
        } else {
            logger.warn(String.format("order[%s] has [%s] delivery record", orderId, orderDeliveries.size()));
        }

        return BaseResponse.buildSuccessResponse(orderDetailDTO);
    }

    public BaseResponse getOrderDetailList(BaseAPIRequest<String> request) {
        Long user = request.getUser();
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause(" id desc ");
        orderExample.createCriteria().andCreated_byEqualTo(String.valueOf(user));
        List<Order> orders = orderReadMapper.selectByExample(orderExample);
        Map<String, List<Order>> map = new HashMap<String, List<Order>>();
        ArrayList<Order> payedList = new ArrayList<Order>();
        map.put(OrderStatus.PAYED.name(), payedList);
        ArrayList<Order> newList = new ArrayList<Order>();
        map.put(OrderStatus.NEW.name(), newList);
        ArrayList<Order> paySubmitList = new ArrayList<Order>();
        map.put(OrderStatus.PAY_SUBMIT.name(), paySubmitList);
        ArrayList<Order> payFailedList = new ArrayList<Order>();
        map.put(OrderStatus.PAY_FAILED.name(), payFailedList);
		for (Order order : orders) {
			if (OrderStatus.NEW.name().equals(order.getStatus())) {
				newList.add(order);
			} else if (OrderStatus.PAYED.name().equals(order.getStatus())) {
				payedList.add(order);
			} else if (OrderStatus.PAY_SUBMIT.name().equals(order.getStatus())) {
				paySubmitList.add(order);
			} else if (OrderStatus.PAY_FAILED.name().equals(order.getStatus())) {
				payFailedList.add(order);
			}
		}
        return BaseResponse.buildSuccessResponse(map);
    }

    public BaseResponse<ProductCalResponse> calOrder(BaseAPIRequest<ProductCalRequest> request) {
        ProductCalRequest requestData = request.getData();
        List<Long> idList = new ArrayList<Long>();
        Map<Long, Integer> productListMap = requestData.getProductList();
        idList.addAll(productListMap.keySet());
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIdIn(idList);
        List<Product> products = productReadMapper.selectByExample(productExample);

        int totalWeight = 0;
        int tottalProductAmount = 0;
        int totalNumber = 0;
        for (Product product : products) {
            int quantity = productListMap.get(product.getId());
            totalWeight += product.getProduct_weight() * quantity;
            Integer product_price ;
            /**
             * 产品销售价格字段即为最终价格
             */
            if (!notSet(product.getPrice_on_sale())) {
                product_price = product.getPrice_on_sale();
            } else {
                product_price = product.getProduct_price();
            }
//            deprecated
//            if (!notSet(product.getPrice_on_sale())) {
//                product_price = (product.getPrice_on_sale());
//            } else {
//                product_price = (multiple(product.getProduct_price(), new BigDecimal("1.1")));
//            }
            tottalProductAmount += product_price * quantity;
            totalNumber += quantity;
        }
        ProductRoutine productRoutine = stockOrderBusiness.determineProductRoutine(products);
        Integer freight = calculateFreight(totalWeight);
        ProductCalResponse result = new ProductCalResponse();
        result.setFreight(freight);
        result.setTotalCount(totalNumber);
        //目前系统中均采用人民币，不涉及汇率
//        String exchangeRate = getConfig(SYS_EXCHANGE_RATE, DEFAULT_EXCHANGE_VALUE);
//        result.setTotalProductAmount(multiple(tottalProductAmount, new BigDecimal(exchangeRate)));
        result.setTotalProductAmount(tottalProductAmount);
        result.setTotalWeight(totalWeight);
        result.setProductRoutine(productRoutine.getDisplayName());
        return BaseResponse.buildSuccessResponse(result);
    }
}
