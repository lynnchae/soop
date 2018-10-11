package org.lynn.soop.business.auth.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccessTokenRequest {

	private String merchantsNo;

	private String code;
	private String page;
	private String backUrl;
	private String backGoodsUrl;
	private String phone;
	private String outOrderNo;
	private BigDecimal amount;
	private ReceiverInfo receiverInfo;
	private List<GoodsInfo> goodsList;
	private Object addition;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMerchantsNo() {
		return merchantsNo;
	}

	public void setMerchantsNo(String merchantsNo) {
		this.merchantsNo = merchantsNo;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public String getBackGoodsUrl() {
		return backGoodsUrl;
	}

	public void setBackGoodsUrl(String backGoodsUrl) {
		this.backGoodsUrl = backGoodsUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOutOrderNo() {
		return outOrderNo;
	}

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ReceiverInfo getReceiverInfo() {
		return receiverInfo;
	}

	public void setReceiverInfo(ReceiverInfo receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public List<GoodsInfo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfo> goodsList) {
		this.goodsList = goodsList;
	}

	public Object getAddition() {
		return addition;
	}

	public void setAddition(Object addition) {
		this.addition = addition;
	}
}
