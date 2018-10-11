package org.lynn.soop.business.auth;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import org.lynn.common.configUtil.StaticConfigHelper;
import org.lynn.soop.baseresp.ResponseEntity;
import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.business.auth.dto.AccessTokenRequest;
import org.lynn.soop.business.auth.dto.AreasDataResp;
import org.lynn.soop.business.auth.dto.GoodsInfo;
import org.lynn.soop.business.auth.dto.ReceiverInfo;
import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderProductList;
import org.lynn.soop.entity.OrderProductListExample;
import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.OrderProductListReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.OrderReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.ProductReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.UserAddressReadMapper;
import org.lynn.soop.util.HttpClientUtils;

@Component
public class AuthBusiness extends BaseBusiness{
    @Autowired
    OrderReadMapper orderReadMapper;
    @Autowired
    OrderProductListReadMapper orderProductListReadMapper;
    @Autowired
    UserAddressReadMapper userAddressReadMapper;
    @Autowired
    private ProductReadMapper productReadMapper;
	
	
	public String getAccessToken(String code, String type, String orderId, String phone) {
		if ("personal".equals(type)) {
			AccessTokenRequest atRequest = new AccessTokenRequest();
			atRequest.setCode(code);
			atRequest.setPage("personal");
			atRequest.setPhone(phone);
			atRequest.setBackUrl(StaticConfigHelper.get("auth.backUrl.personal"));
			atRequest.setMerchantsNo(StaticConfigHelper.get("auth.merchantsNo"));
			atRequest.setBackGoodsUrl(StaticConfigHelper.get("auth.backGoodsUrl"));

			// 协议参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("data", JSONObject.toJSONString(atRequest));

			try {
				String url = StaticConfigHelper.get("auth.yhfq.url");
				logger.info("获取token请求地址:" + url);
				logger.info("获取token请求参数:" + params.toString());
				String result = HttpClientUtils.doPost(url, params);
				logger.info("获取token请求结果:" + result);
				return result;
			} catch (Exception e) {
				logger.error("获取授权token出错:", e);
				return null;
			}
		}


		Order order = orderReadMapper.selectByPrimaryKey(orderId);
		if (order == null) {
			logger.error("getAccessToken -------> 获取订单失败,订单id:" + orderId);
			throw new RuntimeException("订单不存在");
		}

		ReceiverInfo receiverInfo = null;
		Long addressId = order.getAddress_id();
		UserAddress address = userAddressReadMapper.selectByPrimaryKey(addressId);
		if (address != null) {
			logger.error("getAccessToken -------> 获取用户地址失败,地址id:" + addressId);
			//throw new RuntimeException("用户地址不存在");

			receiverInfo = new ReceiverInfo();
			receiverInfo.setAddress(address.getDetail_address());

			//Integer cityCode = getAreaCodeByName(address.getCity(), "city", address.getProvince());
			Integer districtCode = getAreaCodeByName(address.getDistrict(), "district", address.getProvince());
			//Integer provinceCode = getAreaCodeByName(address.getProvince(), "province", address.getProvince());

			receiverInfo.setAddressCode(String.valueOf(districtCode));
			receiverInfo.setCity(address.getCity());
			receiverInfo.setRegion(address.getDistrict());
			receiverInfo.setProvince(address.getProvince());
			receiverInfo.setReceiverName(address.getContact_name());
			receiverInfo.setReceiverPhone(address.getContact_phone());
			receiverInfo.setZipcode(address.getPost_code());
		}

		OrderProductListExample example = new OrderProductListExample();
		example.createCriteria().andOrder_idEqualTo(orderId);
		List<OrderProductList> orderProductList = orderProductListReadMapper.selectByExample(example);

		String merchantsNo = "";
		List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
		for (OrderProductList orderProduct : orderProductList) {
			Long productId = orderProduct.getProduct_id();
			Product prodcut = productReadMapper.selectByPrimaryKey(productId);
			merchantsNo = prodcut.getMerchants_code();
			if (prodcut != null) {
				Integer stockCount = prodcut.getStock_count();
				if (stockCount < 1) {
					throw new RuntimeException("库存不足");
				}

				if (!prodcut.getIs_online()) {
					throw new RuntimeException("商品已下架");
				}

				GoodsInfo goodInfo = new GoodsInfo();
				goodInfo.setGoodsName(prodcut.getProduct_name_cn());
				goodInfo.setGoodsPrice(new BigDecimal(prodcut.getPrice_on_sale()).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP));
				goodInfo.setGoodsNum(orderProduct.getQuantity());
				goodInfo.setGoodsImg(prodcut.getProduct_images());
				goodInfo.setGoodsDesc(prodcut.getProduct_properties());
				goodsInfoList.add(goodInfo);
			} else {
				logger.warn("获取商品信息失败!商品id:" + productId);
			}
		}

		// 业务参数
		AccessTokenRequest atRequest = new AccessTokenRequest();
		atRequest.setCode(code);
		atRequest.setPage("pay");
		atRequest.setBackUrl(StaticConfigHelper.get("auth.backUrl.pay"));
		atRequest.setBackGoodsUrl(StaticConfigHelper.get("auth.backGoodsUrl"));
		atRequest.setPhone(phone);
		atRequest.setOutOrderNo(order.getId());
		BigDecimal orderAmount = new BigDecimal(order.getTotal_order_amount())
		.divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
		atRequest.setAmount(orderAmount);
		atRequest.setReceiverInfo(receiverInfo);
		atRequest.setGoodsList(goodsInfoList);
		atRequest.setMerchantsNo(merchantsNo);

		try {
			// 协议参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("data", JSONObject.toJSONString(atRequest));

			String url = StaticConfigHelper.get("auth.yhfq.url");
			logger.info("获取token请求地址:" + url);
			logger.info("获取token请求参数:" + params.toString());
			String result = HttpClientUtils.doPost(url, params);
			logger.info("获取token请求结果:" + result);

			return result;
		} catch (Exception e) {
			logger.error("获取授权token出错:", e);
		}
		return null;
	}
	
	
	private Integer getAreaCodeByName(String name, String level, String provinceName) {
		if (StringUtils.isEmpty(name)) {
			logger.error("getAreaCodeByName -------> 获取地址code失败,地址名称:" + name);
			throw new RuntimeException("获取地址编码错误");
		}
		if (level.equals("city")) {
			name = name.replace("市", "");
		}
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("name", name);
		String jsonDto = JSONObject.toJSONString(dataMap);

		Map<String, String> jsonParams = new HashMap<>();
		jsonParams.put("areasDict", jsonDto);
		String areasUrl = StaticConfigHelper.get("base.address.url");
		logger.info("getAreasList url -------> " + areasUrl);
		String areaResult;
		try {
			areaResult = HttpClientUtils.doPost(areasUrl, jsonParams);

			logger.info("areaResult------->" + areaResult);
			ResponseEntity responseEntity = JSONObject.parseObject(areaResult, ResponseEntity.class);
			if (!"1".equals(responseEntity.getStatus()) && !"00000000".equals(responseEntity.getError())) {
				throw new RuntimeException("获取地址编码错误");
			}
			List<AreasDataResp> areasList = JSONObject.parseArray(responseEntity.getData().toString(),
					AreasDataResp.class);
			if (!CollectionUtils.isEmpty(areasList)) {
				if (areasList.size() > 1) {
					for (AreasDataResp areaData : areasList) {
						String areaName = areaData.getProvinceName().replace("省", "");
						if (areaName.equals(provinceName)) {
							return areaData.getCode();
						}
					}
				} else {
					AreasDataResp areaData = areasList.get(0);
					return areaData.getCode();
				}
			} else {
				throw new RuntimeException("获取地址编码错误");
			}
		} catch (IOException e) {
			logger.error("获取地址码错误", e);
			throw new RuntimeException("获取地址编码错误");
		}
		return null;
	}
}
