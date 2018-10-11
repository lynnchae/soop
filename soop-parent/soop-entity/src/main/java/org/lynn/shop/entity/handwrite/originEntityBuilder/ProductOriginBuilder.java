package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.handwrite.ProductExtend;

public class ProductOriginBuilder extends Product {

    public static ProductExtend buildOrigin(Product origin) {
        ProductExtend returnValue=new ProductExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setBrand_name_cn(origin.getBrand_name_cn());
        returnValue.setBrand_name_en(origin.getBrand_name_en());
        returnValue.setProduct_name_cn(origin.getProduct_name_cn());
        returnValue.setProduct_name_en(origin.getProduct_name_en());
        returnValue.setRecommend_index(origin.getRecommend_index());
        returnValue.setProduct_category_l1(origin.getProduct_category_l1());
        returnValue.setProduct_category_l2(origin.getProduct_category_l2());
        returnValue.setProduct_category_l3(origin.getProduct_category_l3());
        returnValue.setProduct_category_id(origin.getProduct_category_id());
        returnValue.setIs_online(origin.getIs_online());
        returnValue.setIs_new(origin.getIs_new());
        returnValue.setIs_hot(origin.getIs_hot());
        returnValue.setSource(origin.getSource());
        returnValue.setProduct_weight(origin.getProduct_weight());
        returnValue.setBrand_id(origin.getBrand_id());
        returnValue.setProduct_category_l1_id(origin.getProduct_category_l1_id());
        returnValue.setProduct_category_l2_id(origin.getProduct_category_l2_id());
        returnValue.setProduct_sub_name(origin.getProduct_sub_name());
        returnValue.setSpecs(origin.getSpecs());
        returnValue.setOverseas_price(origin.getOverseas_price());
        returnValue.setProduct_price(origin.getProduct_price());
        returnValue.setProduct_number(origin.getProduct_number());
        returnValue.setSource_channel(origin.getSource_channel());
        returnValue.setStock_count(origin.getStock_count());
        returnValue.setProduct_properties(origin.getProduct_properties());
        returnValue.setProduct_image_list(origin.getProduct_image_list());
        returnValue.setRoutine_id(origin.getRoutine_id());
        returnValue.setPrice_on_sale(origin.getPrice_on_sale());
        returnValue.setDelivery_free(origin.getDelivery_free());
        returnValue.setGoods_id(origin.getGoods_id());
        returnValue.setIs_zero_interest(origin.getIs_zero_interest());
        returnValue.setIs_zero_downpayment(origin.getIs_zero_downpayment());
        returnValue.setProduct_attr(origin.getProduct_attr());
        returnValue.setProduct_images(origin.getProduct_images());
        return returnValue;
    }
}