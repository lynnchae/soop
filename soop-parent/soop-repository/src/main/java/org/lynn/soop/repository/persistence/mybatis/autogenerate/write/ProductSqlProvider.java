package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductExample;
import org.lynn.soop.entity.ProductExample.Criteria;
import org.lynn.soop.entity.ProductExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductSqlProvider {

    public String deleteByExample(ProductExample example) {
        BEGIN();
        DELETE_FROM("`product`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Product record) {
        BEGIN();
        INSERT_INTO("`product`");
        
        if (record.getDate_created() != null) {
            VALUES("`date_created`", "#{date_created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated_by() != null) {
            VALUES("`created_by`", "#{created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getDate_updated() != null) {
            VALUES("`date_updated`", "#{date_updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_by() != null) {
            VALUES("`updated_by`", "#{updated_by,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_name_cn() != null) {
            VALUES("`brand_name_cn`", "#{brand_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_name_en() != null) {
            VALUES("`brand_name_en`", "#{brand_name_en,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name_cn() != null) {
            VALUES("`product_name_cn`", "#{product_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name_en() != null) {
            VALUES("`product_name_en`", "#{product_name_en,jdbcType=VARCHAR}");
        }
        
        if (record.getRecommend_index() != null) {
            VALUES("`recommend_index`", "#{recommend_index,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_category_l1() != null) {
            VALUES("`product_category_l1`", "#{product_category_l1,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_l2() != null) {
            VALUES("`product_category_l2`", "#{product_category_l2,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_l3() != null) {
            VALUES("`product_category_l3`", "#{product_category_l3,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_id() != null) {
            VALUES("`product_category_id`", "#{product_category_id,jdbcType=BIGINT}");
        }
        
        if (record.getIs_online() != null) {
            VALUES("`is_online`", "#{is_online,jdbcType=BIT}");
        }
        
        if (record.getIs_new() != null) {
            VALUES("`is_new`", "#{is_new,jdbcType=BIT}");
        }
        
        if (record.getIs_hot() != null) {
            VALUES("`is_hot`", "#{is_hot,jdbcType=BIT}");
        }
        
        if (record.getSource() != null) {
            VALUES("`source`", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_weight() != null) {
            VALUES("`product_weight`", "#{product_weight,jdbcType=INTEGER}");
        }
        
        if (record.getBrand_id() != null) {
            VALUES("`brand_id`", "#{brand_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_category_l1_id() != null) {
            VALUES("`product_category_l1_id`", "#{product_category_l1_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_category_l2_id() != null) {
            VALUES("`product_category_l2_id`", "#{product_category_l2_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_sub_name() != null) {
            VALUES("`product_sub_name`", "#{product_sub_name,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecs() != null) {
            VALUES("`specs`", "#{specs,jdbcType=VARCHAR}");
        }
        
        if (record.getOverseas_price() != null) {
            VALUES("`overseas_price`", "#{overseas_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_price() != null) {
            VALUES("`product_price`", "#{product_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_number() != null) {
            VALUES("`product_number`", "#{product_number,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_channel() != null) {
            VALUES("`source_channel`", "#{source_channel,jdbcType=VARCHAR}");
        }
        
        if (record.getStock_count() != null) {
            VALUES("`stock_count`", "#{stock_count,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_properties() != null) {
            VALUES("`product_properties`", "#{product_properties,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_image_list() != null) {
            VALUES("`product_image_list`", "#{product_image_list,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutine_id() != null) {
            VALUES("`routine_id`", "#{routine_id,jdbcType=INTEGER}");
        }
        
        if (record.getPrice_on_sale() != null) {
            VALUES("`price_on_sale`", "#{price_on_sale,jdbcType=INTEGER}");
        }
        
        if (record.getDelivery_free() != null) {
            VALUES("`delivery_free`", "#{delivery_free,jdbcType=BIT}");
        }
        
        if (record.getGoods_id() != null) {
            VALUES("`goods_id`", "#{goods_id,jdbcType=BIGINT}");
        }
        
        if (record.getIs_zero_interest() != null) {
            VALUES("`is_zero_interest`", "#{is_zero_interest,jdbcType=BIT}");
        }
        
        if (record.getIs_zero_downpayment() != null) {
            VALUES("`is_zero_downpayment`", "#{is_zero_downpayment,jdbcType=BIT}");
        }
        
        if (record.getProduct_attr() != null) {
            VALUES("`product_attr`", "#{product_attr,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getProduct_images() != null) {
            VALUES("`product_images`", "#{product_images,jdbcType=LONGVARCHAR}");
        }

        if (record.getMerchants_code() != null) {
            VALUES("`merchants_code`", "#{merchants_code,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Product record = (Product) parameter.get("record");
        ProductExample example = (ProductExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`product`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getDate_created() != null) {
            SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated_by() != null) {
            SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getDate_updated() != null) {
            SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_by() != null) {
            SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_name_cn() != null) {
            SET("`brand_name_cn` = #{record.brand_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_name_en() != null) {
            SET("`brand_name_en` = #{record.brand_name_en,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name_cn() != null) {
            SET("`product_name_cn` = #{record.product_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name_en() != null) {
            SET("`product_name_en` = #{record.product_name_en,jdbcType=VARCHAR}");
        }
        
        if (record.getRecommend_index() != null) {
            SET("`recommend_index` = #{record.recommend_index,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_category_l1() != null) {
            SET("`product_category_l1` = #{record.product_category_l1,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_l2() != null) {
            SET("`product_category_l2` = #{record.product_category_l2,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_l3() != null) {
            SET("`product_category_l3` = #{record.product_category_l3,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_id() != null) {
            SET("`product_category_id` = #{record.product_category_id,jdbcType=BIGINT}");
        }
        
        if (record.getIs_online() != null) {
            SET("`is_online` = #{record.is_online,jdbcType=BIT}");
        }
        
        if (record.getIs_new() != null) {
            SET("`is_new` = #{record.is_new,jdbcType=BIT}");
        }
        
        if (record.getIs_hot() != null) {
            SET("`is_hot` = #{record.is_hot,jdbcType=BIT}");
        }
        
        if (record.getSource() != null) {
            SET("`source` = #{record.source,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_weight() != null) {
            SET("`product_weight` = #{record.product_weight,jdbcType=INTEGER}");
        }
        
        if (record.getBrand_id() != null) {
            SET("`brand_id` = #{record.brand_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_category_l1_id() != null) {
            SET("`product_category_l1_id` = #{record.product_category_l1_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_category_l2_id() != null) {
            SET("`product_category_l2_id` = #{record.product_category_l2_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_sub_name() != null) {
            SET("`product_sub_name` = #{record.product_sub_name,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecs() != null) {
            SET("`specs` = #{record.specs,jdbcType=VARCHAR}");
        }
        
        if (record.getOverseas_price() != null) {
            SET("`overseas_price` = #{record.overseas_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_price() != null) {
            SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_number() != null) {
            SET("`product_number` = #{record.product_number,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_channel() != null) {
            SET("`source_channel` = #{record.source_channel,jdbcType=VARCHAR}");
        }
        
        if (record.getStock_count() != null) {
            SET("`stock_count` = #{record.stock_count,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_properties() != null) {
            SET("`product_properties` = #{record.product_properties,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_image_list() != null) {
            SET("`product_image_list` = #{record.product_image_list,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutine_id() != null) {
            SET("`routine_id` = #{record.routine_id,jdbcType=INTEGER}");
        }
        
        if (record.getPrice_on_sale() != null) {
            SET("`price_on_sale` = #{record.price_on_sale,jdbcType=INTEGER}");
        }
        
        if (record.getDelivery_free() != null) {
            SET("`delivery_free` = #{record.delivery_free,jdbcType=BIT}");
        }
        
        if (record.getGoods_id() != null) {
            SET("`goods_id` = #{record.goods_id,jdbcType=BIGINT}");
        }
        
        if (record.getIs_zero_interest() != null) {
            SET("`is_zero_interest` = #{record.is_zero_interest,jdbcType=BIT}");
        }
        
        if (record.getIs_zero_downpayment() != null) {
            SET("`is_zero_downpayment` = #{record.is_zero_downpayment,jdbcType=BIT}");
        }
        
        if (record.getProduct_attr() != null) {
            SET("`product_attr` = #{record.product_attr,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getProduct_images() != null) {
            SET("`product_images` = #{record.product_images,jdbcType=LONGVARCHAR}");
        }

        if (record.getMerchants_code() != null) {
            VALUES("`merchants_code`", "#{merchants_code,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`product`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`brand_name_cn` = #{record.brand_name_cn,jdbcType=VARCHAR}");
        SET("`brand_name_en` = #{record.brand_name_en,jdbcType=VARCHAR}");
        SET("`product_name_cn` = #{record.product_name_cn,jdbcType=VARCHAR}");
        SET("`product_name_en` = #{record.product_name_en,jdbcType=VARCHAR}");
        SET("`recommend_index` = #{record.recommend_index,jdbcType=INTEGER}");
        SET("`product_category_l1` = #{record.product_category_l1,jdbcType=VARCHAR}");
        SET("`product_category_l2` = #{record.product_category_l2,jdbcType=VARCHAR}");
        SET("`product_category_l3` = #{record.product_category_l3,jdbcType=VARCHAR}");
        SET("`product_category_id` = #{record.product_category_id,jdbcType=BIGINT}");
        SET("`is_online` = #{record.is_online,jdbcType=BIT}");
        SET("`is_new` = #{record.is_new,jdbcType=BIT}");
        SET("`is_hot` = #{record.is_hot,jdbcType=BIT}");
        SET("`source` = #{record.source,jdbcType=VARCHAR}");
        SET("`product_weight` = #{record.product_weight,jdbcType=INTEGER}");
        SET("`brand_id` = #{record.brand_id,jdbcType=BIGINT}");
        SET("`product_category_l1_id` = #{record.product_category_l1_id,jdbcType=BIGINT}");
        SET("`product_category_l2_id` = #{record.product_category_l2_id,jdbcType=BIGINT}");
        SET("`product_sub_name` = #{record.product_sub_name,jdbcType=VARCHAR}");
        SET("`specs` = #{record.specs,jdbcType=VARCHAR}");
        SET("`overseas_price` = #{record.overseas_price,jdbcType=INTEGER}");
        SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        SET("`product_number` = #{record.product_number,jdbcType=VARCHAR}");
        SET("`source_channel` = #{record.source_channel,jdbcType=VARCHAR}");
        SET("`stock_count` = #{record.stock_count,jdbcType=INTEGER}");
        SET("`product_properties` = #{record.product_properties,jdbcType=VARCHAR}");
        SET("`product_image_list` = #{record.product_image_list,jdbcType=VARCHAR}");
        SET("`routine_id` = #{record.routine_id,jdbcType=INTEGER}");
        SET("`price_on_sale` = #{record.price_on_sale,jdbcType=INTEGER}");
        SET("`delivery_free` = #{record.delivery_free,jdbcType=BIT}");
        SET("`goods_id` = #{record.goods_id,jdbcType=BIGINT}");
        SET("`is_zero_interest` = #{record.is_zero_interest,jdbcType=BIT}");
        SET("`is_zero_downpayment` = #{record.is_zero_downpayment,jdbcType=BIT}");
        SET("`product_attr` = #{record.product_attr,jdbcType=LONGVARCHAR}");
        SET("`merchants_code` = #{record.merchants_code,jdbcType=VARCHAR}");
        SET("`product_images` = #{record.product_images,jdbcType=LONGVARCHAR}");
        
        ProductExample example = (ProductExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`product`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`brand_name_cn` = #{record.brand_name_cn,jdbcType=VARCHAR}");
        SET("`brand_name_en` = #{record.brand_name_en,jdbcType=VARCHAR}");
        SET("`product_name_cn` = #{record.product_name_cn,jdbcType=VARCHAR}");
        SET("`product_name_en` = #{record.product_name_en,jdbcType=VARCHAR}");
        SET("`recommend_index` = #{record.recommend_index,jdbcType=INTEGER}");
        SET("`product_category_l1` = #{record.product_category_l1,jdbcType=VARCHAR}");
        SET("`product_category_l2` = #{record.product_category_l2,jdbcType=VARCHAR}");
        SET("`product_category_l3` = #{record.product_category_l3,jdbcType=VARCHAR}");
        SET("`product_category_id` = #{record.product_category_id,jdbcType=BIGINT}");
        SET("`is_online` = #{record.is_online,jdbcType=BIT}");
        SET("`is_new` = #{record.is_new,jdbcType=BIT}");
        SET("`is_hot` = #{record.is_hot,jdbcType=BIT}");
        SET("`source` = #{record.source,jdbcType=VARCHAR}");
        SET("`product_weight` = #{record.product_weight,jdbcType=INTEGER}");
        SET("`brand_id` = #{record.brand_id,jdbcType=BIGINT}");
        SET("`product_category_l1_id` = #{record.product_category_l1_id,jdbcType=BIGINT}");
        SET("`product_category_l2_id` = #{record.product_category_l2_id,jdbcType=BIGINT}");
        SET("`product_sub_name` = #{record.product_sub_name,jdbcType=VARCHAR}");
        SET("`specs` = #{record.specs,jdbcType=VARCHAR}");
        SET("`overseas_price` = #{record.overseas_price,jdbcType=INTEGER}");
        SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        SET("`product_number` = #{record.product_number,jdbcType=VARCHAR}");
        SET("`source_channel` = #{record.source_channel,jdbcType=VARCHAR}");
        SET("`stock_count` = #{record.stock_count,jdbcType=INTEGER}");
        SET("`product_properties` = #{record.product_properties,jdbcType=VARCHAR}");
        SET("`product_image_list` = #{record.product_image_list,jdbcType=VARCHAR}");
        SET("`routine_id` = #{record.routine_id,jdbcType=INTEGER}");
        SET("`price_on_sale` = #{record.price_on_sale,jdbcType=INTEGER}");
        SET("`delivery_free` = #{record.delivery_free,jdbcType=BIT}");
        SET("`goods_id` = #{record.goods_id,jdbcType=BIGINT}");
        SET("`is_zero_interest` = #{record.is_zero_interest,jdbcType=BIT}");
        SET("`merchants_code` = #{record.merchants_code,jdbcType=VARCHAR}");
        SET("`is_zero_downpayment` = #{record.is_zero_downpayment,jdbcType=BIT}");
        
        ProductExample example = (ProductExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Product record) {
        BEGIN();
        UPDATE("`product`");
        
        if (record.getDate_created() != null) {
            SET("`date_created` = #{date_created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated_by() != null) {
            SET("`created_by` = #{created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getDate_updated() != null) {
            SET("`date_updated` = #{date_updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_by() != null) {
            SET("`updated_by` = #{updated_by,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_name_cn() != null) {
            SET("`brand_name_cn` = #{brand_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_name_en() != null) {
            SET("`brand_name_en` = #{brand_name_en,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name_cn() != null) {
            SET("`product_name_cn` = #{product_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name_en() != null) {
            SET("`product_name_en` = #{product_name_en,jdbcType=VARCHAR}");
        }
        
        if (record.getRecommend_index() != null) {
            SET("`recommend_index` = #{recommend_index,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_category_l1() != null) {
            SET("`product_category_l1` = #{product_category_l1,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_l2() != null) {
            SET("`product_category_l2` = #{product_category_l2,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_l3() != null) {
            SET("`product_category_l3` = #{product_category_l3,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_category_id() != null) {
            SET("`product_category_id` = #{product_category_id,jdbcType=BIGINT}");
        }
        
        if (record.getIs_online() != null) {
            SET("`is_online` = #{is_online,jdbcType=BIT}");
        }
        
        if (record.getIs_new() != null) {
            SET("`is_new` = #{is_new,jdbcType=BIT}");
        }
        
        if (record.getIs_hot() != null) {
            SET("`is_hot` = #{is_hot,jdbcType=BIT}");
        }
        
        if (record.getSource() != null) {
            SET("`source` = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_weight() != null) {
            SET("`product_weight` = #{product_weight,jdbcType=INTEGER}");
        }
        
        if (record.getBrand_id() != null) {
            SET("`brand_id` = #{brand_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_category_l1_id() != null) {
            SET("`product_category_l1_id` = #{product_category_l1_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_category_l2_id() != null) {
            SET("`product_category_l2_id` = #{product_category_l2_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_sub_name() != null) {
            SET("`product_sub_name` = #{product_sub_name,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecs() != null) {
            SET("`specs` = #{specs,jdbcType=VARCHAR}");
        }
        
        if (record.getOverseas_price() != null) {
            SET("`overseas_price` = #{overseas_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_price() != null) {
            SET("`product_price` = #{product_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_number() != null) {
            SET("`product_number` = #{product_number,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_channel() != null) {
            SET("`source_channel` = #{source_channel,jdbcType=VARCHAR}");
        }
        
        if (record.getStock_count() != null) {
            SET("`stock_count` = #{stock_count,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_properties() != null) {
            SET("`product_properties` = #{product_properties,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_image_list() != null) {
            SET("`product_image_list` = #{product_image_list,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutine_id() != null) {
            SET("`routine_id` = #{routine_id,jdbcType=INTEGER}");
        }
        
        if (record.getPrice_on_sale() != null) {
            SET("`price_on_sale` = #{price_on_sale,jdbcType=INTEGER}");
        }
        
        if (record.getDelivery_free() != null) {
            SET("`delivery_free` = #{delivery_free,jdbcType=BIT}");
        }
        
        if (record.getGoods_id() != null) {
            SET("`goods_id` = #{goods_id,jdbcType=BIGINT}");
        }
        
        if (record.getIs_zero_interest() != null) {
            SET("`is_zero_interest` = #{is_zero_interest,jdbcType=BIT}");
        }
        
        if (record.getIs_zero_downpayment() != null) {
            SET("`is_zero_downpayment` = #{is_zero_downpayment,jdbcType=BIT}");
        }
        
        if (record.getProduct_attr() != null) {
            SET("`product_attr` = #{product_attr,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getProduct_images() != null) {
            SET("`product_images` = #{product_images,jdbcType=LONGVARCHAR}");
        }

        if (record.getMerchants_code() != null) {
            SET("`merchants_code` = #{merchants_code,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ProductExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}