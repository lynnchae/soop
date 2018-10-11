package org.lynn.soop.contract.stock.dto;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.PurchaseProductRequest;
import org.lynn.soop.util.DisplayResourceKey;

public class BatchPurchaseExportDTO {
    @DisplayResourceKey("Batch Id")
    private String batch_id;
    @DisplayResourceKey("Product Id")
    private String product_id;

    @DisplayResourceKey("Request Id")
    private String request_id;
    @DisplayResourceKey("Number")
    private String number;
    @DisplayResourceKey("Product Chinese Name")
    private String product_name_cn;
    @DisplayResourceKey("Product SubName")
    private String product_sub_name;
    @DisplayResourceKey("Product English Name")
    private String product_name_en;
    @DisplayResourceKey("Brand Name")
    private String brand_name_cn;
    @DisplayResourceKey("Brand English Name")
    private String brand_name_en;
    @DisplayResourceKey("Main Category")
    private String product_category_l1;
    @DisplayResourceKey("Sub Category")
    private String product_category_l2;
    @DisplayResourceKey("Specs")
    private String specs;
    @DisplayResourceKey("Purchase Number")
    private String actual_quantity;
    @DisplayResourceKey("Exchange rate to USD")
    private String exchange_rate;
    @DisplayResourceKey("Purchase price($)")
    private String purchase_price_in_usd;


    public static BatchPurchaseExportDTO from(Product product, PurchaseProductRequest requestItem) {
        BatchPurchaseExportDTO toReturn = new BatchPurchaseExportDTO();
        toReturn.batch_id = String.valueOf(requestItem.getPurchase_product_batch_id());
        toReturn.product_id = String.valueOf(product.getId());
        toReturn.request_id = String.valueOf(requestItem.getId());
        toReturn.number = String.valueOf(requestItem.getPlan_quantity());
        toReturn.product_name_cn = product.getProduct_name_cn();
        toReturn.product_name_en = product.getProduct_name_en();
        toReturn.brand_name_cn = product.getBrand_name_cn();
        toReturn.brand_name_en = product.getBrand_name_en();
        toReturn.product_sub_name = product.getProduct_sub_name();
        toReturn.product_category_l1 = product.getProduct_category_l1();
        toReturn.product_category_l2 = product.getProduct_category_l2();
        toReturn.specs = product.getSpecs();
        return toReturn;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProduct_name_cn() {
        return product_name_cn;
    }

    public void setProduct_name_cn(String product_name_cn) {
        this.product_name_cn = product_name_cn;
    }

    public String getProduct_sub_name() {
        return product_sub_name;
    }

    public void setProduct_sub_name(String product_sub_name) {
        this.product_sub_name = product_sub_name;
    }

    public String getProduct_name_en() {
        return product_name_en;
    }

    public void setProduct_name_en(String product_name_en) {
        this.product_name_en = product_name_en;
    }

    public String getBrand_name_cn() {
        return brand_name_cn;
    }

    public void setBrand_name_cn(String brand_name_cn) {
        this.brand_name_cn = brand_name_cn;
    }

    public String getBrand_name_en() {
        return brand_name_en;
    }

    public void setBrand_name_en(String brand_name_en) {
        this.brand_name_en = brand_name_en;
    }

    public String getProduct_category_l1() {
        return product_category_l1;
    }

    public void setProduct_category_l1(String product_category_l1) {
        this.product_category_l1 = product_category_l1;
    }

    public String getProduct_category_l2() {
        return product_category_l2;
    }

    public void setProduct_category_l2(String product_category_l2) {
        this.product_category_l2 = product_category_l2;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getActual_quantity() {
        return actual_quantity;
    }

    public void setActual_quantity(String actual_quantity) {
        this.actual_quantity = actual_quantity;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(String exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public String getPurchase_price_in_usd() {
        return purchase_price_in_usd;
    }

    public void setPurchase_price_in_usd(String purchase_price_in_usd) {
        this.purchase_price_in_usd = purchase_price_in_usd;
    }
}
