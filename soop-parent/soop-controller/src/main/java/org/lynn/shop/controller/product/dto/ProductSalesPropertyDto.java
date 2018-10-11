package org.lynn.soop.controller.product.dto;

import java.util.Date;
import java.util.Map;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.controller.product.dto
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/14
 */
public class ProductSalesPropertyDto {

    public Map<Long, String> getSpList() {
        return spList;
    }

    public void setSpList(Map<Long, String> spList) {
        this.spList = spList;
    }

    //key = spId, value = spValue
    private Map<Long, String> spList;

    private Long id;

    private Date date_created;

    private String created_by;

    private Date date_updated;

    private String updated_by;

    private String brand_name_cn;

    private String brand_name_en;

    private String product_name_cn;

    private String product_name_en;

    private Integer recommend_index;

    private String product_category_l1;

    private String product_category_l2;

    private String product_category_l3;

    private Long product_category_id;

    private Boolean is_online;

    private String is_new;

    private Boolean is_hot;

    private String source;

    private Integer product_weight;

    private Long brand_id;

    private Long product_category_l1_id;

    private Long product_category_l2_id;

    private String product_sub_name;

    private String specs;

    private Integer overseas_price;

    private Integer product_price;

    private String product_number;

    private String source_channel;

    private Integer stock_count;

    private String product_properties;

    private String product_image_list;

    private Integer routine_id;

    private Integer price_on_sale;

    private Boolean delivery_free;

    private Long goods_id;

    private String product_attr;

    private String product_images;

    private String merchants_code;

    public String getMerchants_code() {
        return merchants_code;
    }

    public void setMerchants_code(String merchants_code) {
        this.merchants_code = merchants_code;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by == null ? null : created_by.trim();
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by == null ? null : updated_by.trim();
    }

    public String getBrand_name_cn() {
        return brand_name_cn;
    }

    public void setBrand_name_cn(String brand_name_cn) {
        this.brand_name_cn = brand_name_cn == null ? null : brand_name_cn.trim();
    }

    public String getBrand_name_en() {
        return brand_name_en;
    }

    public void setBrand_name_en(String brand_name_en) {
        this.brand_name_en = brand_name_en == null ? null : brand_name_en.trim();
    }

    public String getProduct_name_cn() {
        return product_name_cn;
    }

    public void setProduct_name_cn(String product_name_cn) {
        this.product_name_cn = product_name_cn == null ? null : product_name_cn.trim();
    }

    public String getProduct_name_en() {
        return product_name_en;
    }

    public void setProduct_name_en(String product_name_en) {
        this.product_name_en = product_name_en == null ? null : product_name_en.trim();
    }

    public Integer getRecommend_index() {
        return recommend_index;
    }

    public void setRecommend_index(Integer recommend_index) {
        this.recommend_index = recommend_index;
    }

    public String getProduct_category_l1() {
        return product_category_l1;
    }

    public void setProduct_category_l1(String product_category_l1) {
        this.product_category_l1 = product_category_l1 == null ? null : product_category_l1.trim();
    }

    public String getProduct_category_l2() {
        return product_category_l2;
    }

    public void setProduct_category_l2(String product_category_l2) {
        this.product_category_l2 = product_category_l2 == null ? null : product_category_l2.trim();
    }

    public String getProduct_category_l3() {
        return product_category_l3;
    }

    public void setProduct_category_l3(String product_category_l3) {
        this.product_category_l3 = product_category_l3 == null ? null : product_category_l3.trim();
    }

    public Long getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(Long product_category_id) {
        this.product_category_id = product_category_id;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public Boolean getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Boolean is_hot) {
        this.is_hot = is_hot;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(Integer product_weight) {
        this.product_weight = product_weight;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public Long getProduct_category_l1_id() {
        return product_category_l1_id;
    }

    public void setProduct_category_l1_id(Long product_category_l1_id) {
        this.product_category_l1_id = product_category_l1_id;
    }

    public Long getProduct_category_l2_id() {
        return product_category_l2_id;
    }

    public void setProduct_category_l2_id(Long product_category_l2_id) {
        this.product_category_l2_id = product_category_l2_id;
    }

    public String getProduct_sub_name() {
        return product_sub_name;
    }

    public void setProduct_sub_name(String product_sub_name) {
        this.product_sub_name = product_sub_name == null ? null : product_sub_name.trim();
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs == null ? null : specs.trim();
    }

    public Integer getOverseas_price() {
        return overseas_price;
    }

    public void setOverseas_price(Integer overseas_price) {
        this.overseas_price = overseas_price;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number == null ? null : product_number.trim();
    }

    public String getSource_channel() {
        return source_channel;
    }

    public void setSource_channel(String source_channel) {
        this.source_channel = source_channel == null ? null : source_channel.trim();
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public String getProduct_properties() {
        return product_properties;
    }

    public void setProduct_properties(String product_properties) {
        this.product_properties = product_properties == null ? null : product_properties.trim();
    }

    public String getProduct_image_list() {
        return product_image_list;
    }

    public void setProduct_image_list(String product_image_list) {
        this.product_image_list = product_image_list == null ? null : product_image_list.trim();
    }

    public Integer getRoutine_id() {
        return routine_id;
    }

    public void setRoutine_id(Integer routine_id) {
        this.routine_id = routine_id;
    }

    public Integer getPrice_on_sale() {
        return price_on_sale;
    }

    public void setPrice_on_sale(Integer price_on_sale) {
        this.price_on_sale = price_on_sale;
    }

    public Boolean getDelivery_free() {
        return delivery_free;
    }

    public void setDelivery_free(Boolean delivery_free) {
        this.delivery_free = delivery_free;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public String getProduct_attr() {
        return product_attr;
    }

    public void setProduct_attr(String product_attr) {
        this.product_attr = product_attr == null ? null : product_attr.trim();
    }

    public String getProduct_images() {
        return product_images;
    }

    public void setProduct_images(String product_images) {
        this.product_images = product_images == null ? null : product_images.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", date_created=").append(date_created);
        sb.append(", created_by=").append(created_by);
        sb.append(", date_updated=").append(date_updated);
        sb.append(", updated_by=").append(updated_by);
        sb.append(", brand_name_cn=").append(brand_name_cn);
        sb.append(", brand_name_en=").append(brand_name_en);
        sb.append(", product_name_cn=").append(product_name_cn);
        sb.append(", product_name_en=").append(product_name_en);
        sb.append(", recommend_index=").append(recommend_index);
        sb.append(", product_category_l1=").append(product_category_l1);
        sb.append(", product_category_l2=").append(product_category_l2);
        sb.append(", product_category_l3=").append(product_category_l3);
        sb.append(", product_category_id=").append(product_category_id);
        sb.append(", is_online=").append(is_online);
        sb.append(", is_new=").append(is_new);
        sb.append(", is_hot=").append(is_hot);
        sb.append(", source=").append(source);
        sb.append(", product_weight=").append(product_weight);
        sb.append(", brand_id=").append(brand_id);
        sb.append(", product_category_l1_id=").append(product_category_l1_id);
        sb.append(", product_category_l2_id=").append(product_category_l2_id);
        sb.append(", product_sub_name=").append(product_sub_name);
        sb.append(", specs=").append(specs);
        sb.append(", overseas_price=").append(overseas_price);
        sb.append(", product_price=").append(product_price);
        sb.append(", product_number=").append(product_number);
        sb.append(", source_channel=").append(source_channel);
        sb.append(", stock_count=").append(stock_count);
        sb.append(", product_properties=").append(product_properties);
        sb.append(", product_image_list=").append(product_image_list);
        sb.append(", routine_id=").append(routine_id);
        sb.append(", price_on_sale=").append(price_on_sale);
        sb.append(", delivery_free=").append(delivery_free);
        sb.append(", goods_id=").append(goods_id);
        sb.append(", product_attr=").append(product_attr);
        sb.append(", product_images=").append(product_images);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}
