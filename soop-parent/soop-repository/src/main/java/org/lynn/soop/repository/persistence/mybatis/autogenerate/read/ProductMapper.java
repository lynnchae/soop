package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductExample;
import org.lynn.soop.entity.dto.ProductDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ProductMapper {
    @SelectProvider(type=ProductSqlProvider.class, method="countByExample")
    int countByExample(ProductExample example);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_cn", property="brand_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_en", property="brand_name_en", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name_cn", property="product_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name_en", property="product_name_en", jdbcType=JdbcType.VARCHAR),
        @Result(column="recommend_index", property="recommend_index", jdbcType=JdbcType.INTEGER),
        @Result(column="product_category_l1", property="product_category_l1", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_l2", property="product_category_l2", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_l3", property="product_category_l3", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="product_category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_online", property="is_online", jdbcType=JdbcType.BIT),
        @Result(column="is_new", property="is_new", jdbcType=JdbcType.BIT),
        @Result(column="is_hot", property="is_hot", jdbcType=JdbcType.BIT),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_weight", property="product_weight", jdbcType=JdbcType.INTEGER),
        @Result(column="brand_id", property="brand_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_category_l1_id", property="product_category_l1_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_category_l2_id", property="product_category_l2_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_sub_name", property="product_sub_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="specs", property="specs", jdbcType=JdbcType.VARCHAR),
        @Result(column="overseas_price", property="overseas_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_number", property="product_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_channel", property="source_channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_count", property="stock_count", jdbcType=JdbcType.INTEGER),
        @Result(column="product_properties", property="product_properties", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_image_list", property="product_image_list", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_id", property="routine_id", jdbcType=JdbcType.INTEGER),
        @Result(column="price_on_sale", property="price_on_sale", jdbcType=JdbcType.INTEGER),
        @Result(column="delivery_free", property="delivery_free", jdbcType=JdbcType.BIT),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_zero_interest", property="is_zero_interest", jdbcType=JdbcType.BIT),
        @Result(column="is_zero_downpayment", property="is_zero_downpayment", jdbcType=JdbcType.BIT),
        @Result(column="product_attr", property="product_attr", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="product_images", property="product_images", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="merchants_code", property="merchants_code", jdbcType=JdbcType.VARCHAR)

    })
    List<Product> selectByExampleWithBLOBs(ProductExample example);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExample")
    @Options(flushCache = false,useCache = true)
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_cn", property="brand_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_en", property="brand_name_en", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name_cn", property="product_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name_en", property="product_name_en", jdbcType=JdbcType.VARCHAR),
        @Result(column="recommend_index", property="recommend_index", jdbcType=JdbcType.INTEGER),
        @Result(column="product_category_l1", property="product_category_l1", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_l2", property="product_category_l2", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_l3", property="product_category_l3", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="product_category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_online", property="is_online", jdbcType=JdbcType.BIT),
        @Result(column="is_new", property="is_new", jdbcType=JdbcType.BIT),
        @Result(column="is_hot", property="is_hot", jdbcType=JdbcType.BIT),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_weight", property="product_weight", jdbcType=JdbcType.INTEGER),
        @Result(column="brand_id", property="brand_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_category_l1_id", property="product_category_l1_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_category_l2_id", property="product_category_l2_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_sub_name", property="product_sub_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="specs", property="specs", jdbcType=JdbcType.VARCHAR),
        @Result(column="overseas_price", property="overseas_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_number", property="product_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_channel", property="source_channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_count", property="stock_count", jdbcType=JdbcType.INTEGER),
        @Result(column="product_properties", property="product_properties", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_image_list", property="product_image_list", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_images", property="product_images", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_id", property="routine_id", jdbcType=JdbcType.INTEGER),
        @Result(column="price_on_sale", property="price_on_sale", jdbcType=JdbcType.INTEGER),
        @Result(column="delivery_free", property="delivery_free", jdbcType=JdbcType.BIT),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_zero_interest", property="is_zero_interest", jdbcType=JdbcType.BIT),
        @Result(column="is_zero_downpayment", property="is_zero_downpayment", jdbcType=JdbcType.BIT),
        @Result(column="merchants_code", property="merchants_code", jdbcType=JdbcType.VARCHAR)
    })
    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `brand_name_cn`, ",
        "`brand_name_en`, `product_name_cn`, `product_name_en`, `recommend_index`, `product_category_l1`, ",
        "`product_category_l2`, `product_category_l3`, `product_category_id`, `is_online`, ",
        "`is_new`, `is_hot`, `source`, `product_weight`, `brand_id`, `product_category_l1_id`, ",
        "`product_category_l2_id`, `product_sub_name`, `specs`, `overseas_price`, `product_price`, ",
        "`product_number`, `source_channel`, `stock_count`, `product_properties`, `product_image_list`, ",
        "`routine_id`, `price_on_sale`, `delivery_free`, `goods_id`, `is_zero_interest`, ",
        "`is_zero_downpayment`, `product_attr`, `product_images`, `merchants_code`",
        "from `product`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_cn", property="brand_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_en", property="brand_name_en", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name_cn", property="product_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name_en", property="product_name_en", jdbcType=JdbcType.VARCHAR),
        @Result(column="recommend_index", property="recommend_index", jdbcType=JdbcType.INTEGER),
        @Result(column="product_category_l1", property="product_category_l1", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_l2", property="product_category_l2", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_l3", property="product_category_l3", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="product_category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_online", property="is_online", jdbcType=JdbcType.BIT),
        @Result(column="is_new", property="is_new", jdbcType=JdbcType.BIT),
        @Result(column="is_hot", property="is_hot", jdbcType=JdbcType.BIT),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_weight", property="product_weight", jdbcType=JdbcType.INTEGER),
        @Result(column="brand_id", property="brand_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_category_l1_id", property="product_category_l1_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_category_l2_id", property="product_category_l2_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_sub_name", property="product_sub_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="specs", property="specs", jdbcType=JdbcType.VARCHAR),
        @Result(column="overseas_price", property="overseas_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_number", property="product_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_channel", property="source_channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_count", property="stock_count", jdbcType=JdbcType.INTEGER),
        @Result(column="product_properties", property="product_properties", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_image_list", property="product_image_list", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_id", property="routine_id", jdbcType=JdbcType.INTEGER),
        @Result(column="price_on_sale", property="price_on_sale", jdbcType=JdbcType.INTEGER),
        @Result(column="delivery_free", property="delivery_free", jdbcType=JdbcType.BIT),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_zero_interest", property="is_zero_interest", jdbcType=JdbcType.BIT),
        @Result(column="is_zero_downpayment", property="is_zero_downpayment", jdbcType=JdbcType.BIT),
        @Result(column="product_attr", property="product_attr", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="product_images", property="product_images", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="merchants_code", property="merchants_code", jdbcType=JdbcType.VARCHAR)
    })
    Product selectByPrimaryKey(Long id);



    @Select({
            "select",
            "p.`id`, p.`date_created`, p.`created_by`, p.`date_updated`, p.`updated_by`, p.`brand_name_cn`, ",
            "p.`brand_name_en`, p.`product_name_cn`, p.`product_name_en`, p.`recommend_index`, p.`product_category_l1`, ",
            "p.`product_category_l2`, p.`product_category_l3`, p.`product_category_id`, p.`is_online`, ",
            "p.`is_new`, p.`is_hot`, p.`source`, p.`product_weight`, p.`brand_id`, p.`product_category_l1_id`, ",
            "p.`product_category_l2_id`, p.`product_sub_name`, p.`specs`, p.`overseas_price`, p.`product_price`, ",
            "p.`product_number`, p.`source_channel`, p.`stock_count`, p.`product_properties`, p.`product_image_list`, ",
            "p.`routine_id`, p.`price_on_sale`, p.`delivery_free`, p.`goods_id`, p.`product_attr`, ",
            "p.`product_images` , p.`is_zero_interest`, p.`merchants_code`, p.`is_zero_downpayment`,  GROUP_CONCAT(sp.`sp_name`,':', spv.sp_value SEPARATOR ' | ') properties ",
            "from `product` p LEFT JOIN product_sales_property psp ON p.`id`=psp.`product_id` LEFT JOIN sales_property_values spv ON psp.spv_id = spv.`id` LEFT JOIN sales_property sp ON spv.sp_id = sp.id\n" +
                    "where p.product_name_cn like #{search} GROUP BY p.`id` order by p.`date_created` desc limit #{pageStart}, #{pageCount}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
            @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
            @Result(column="brand_name_cn", property="brand_name_cn", jdbcType=JdbcType.VARCHAR),
            @Result(column="brand_name_en", property="brand_name_en", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_name_cn", property="product_name_cn", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_name_en", property="product_name_en", jdbcType=JdbcType.VARCHAR),
            @Result(column="recommend_index", property="recommend_index", jdbcType=JdbcType.INTEGER),
            @Result(column="product_category_l1", property="product_category_l1", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_category_l2", property="product_category_l2", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_category_l3", property="product_category_l3", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_category_id", property="product_category_id", jdbcType=JdbcType.BIGINT),
            @Result(column="is_online", property="is_online", jdbcType=JdbcType.BIT),
            @Result(column="is_new", property="is_new", jdbcType=JdbcType.BIT),
            @Result(column="is_hot", property="is_hot", jdbcType=JdbcType.BIT),
            @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_weight", property="product_weight", jdbcType=JdbcType.INTEGER),
            @Result(column="brand_id", property="brand_id", jdbcType=JdbcType.BIGINT),
            @Result(column="product_category_l1_id", property="product_category_l1_id", jdbcType=JdbcType.BIGINT),
            @Result(column="product_category_l2_id", property="product_category_l2_id", jdbcType=JdbcType.BIGINT),
            @Result(column="product_sub_name", property="product_sub_name", jdbcType=JdbcType.VARCHAR),
            @Result(column="specs", property="specs", jdbcType=JdbcType.VARCHAR),
            @Result(column="overseas_price", property="overseas_price", jdbcType=JdbcType.INTEGER),
            @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
            @Result(column="product_number", property="product_number", jdbcType=JdbcType.VARCHAR),
            @Result(column="source_channel", property="source_channel", jdbcType=JdbcType.VARCHAR),
            @Result(column="stock_count", property="stock_count", jdbcType=JdbcType.INTEGER),
            @Result(column="product_properties", property="product_properties", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_image_list", property="product_image_list", jdbcType=JdbcType.VARCHAR),
            @Result(column="routine_id", property="routine_id", jdbcType=JdbcType.INTEGER),
            @Result(column="price_on_sale", property="price_on_sale", jdbcType=JdbcType.INTEGER),
            @Result(column="delivery_free", property="delivery_free", jdbcType=JdbcType.BIT),
            @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
            @Result(column="is_zero_interest", property="is_zero_interest", jdbcType=JdbcType.BIT),
            @Result(column="is_zero_downpayment", property="is_zero_downpayment", jdbcType=JdbcType.BIT),
            @Result(column="product_attr", property="product_attr", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="product_images", property="product_images", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="properties", property="properties", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="merchants_code", property="merchants_code", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ProductDto> selectProductDtoExample(ProductExample example);


    
    
    @Select({
        "select",
        "`id` ",
        "from `product` ",
        "where `goods_id` = #{goodsId,jdbcType=BIGINT} and `merchants_code` = #{merchants_code,jdbcType=VARCHAR} and stock_count > 0"
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.BIGINT)
    })
    List<Long> selectProductListByGoodsId(@Param("goodsId") Long goodsId, @Param("merchants_code")String merchants_code);


    @Select({
            "select count(1) from (select",
            "count(1)",
            "from `product` p LEFT JOIN product_sales_property psp ON p.`id`=psp.`product_id` LEFT JOIN sales_property_values spv ON psp.spv_id = spv.`id` LEFT JOIN sales_property sp ON spv.sp_id = sp.id\n" +
                    "where p.product_name_cn like #{search} GROUP BY p.`id` order by p.`id` asc) t"
    })
    Integer selectProductDtoExampleCount(ProductExample example);
}