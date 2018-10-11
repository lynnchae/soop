package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductMapper {
    @DeleteProvider(type=ProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductExample example);

    @Delete({
        "delete from `product`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`brand_name_cn`, `brand_name_en`, ",
        "`product_name_cn`, `product_name_en`, ",
        "`recommend_index`, `product_category_l1`, ",
        "`product_category_l2`, `product_category_l3`, ",
        "`product_category_id`, `is_online`, ",
        "`is_new`, `is_hot`, `source`, ",
        "`product_weight`, `brand_id`, ",
        "`product_category_l1_id`, `product_category_l2_id`, ",
        "`product_sub_name`, `specs`, ",
        "`overseas_price`, `product_price`, ",
        "`product_number`, `source_channel`, ",
        "`stock_count`, `product_properties`, ",
        "`product_image_list`, `routine_id`, ",
        "`price_on_sale`, `delivery_free`, ",
        "`goods_id`, `is_zero_interest`, ",
        "`is_zero_downpayment`, `product_attr`, ",
        "`product_images`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{brand_name_cn,jdbcType=VARCHAR}, #{brand_name_en,jdbcType=VARCHAR}, ",
        "#{product_name_cn,jdbcType=VARCHAR}, #{product_name_en,jdbcType=VARCHAR}, ",
        "#{recommend_index,jdbcType=INTEGER}, #{product_category_l1,jdbcType=VARCHAR}, ",
        "#{product_category_l2,jdbcType=VARCHAR}, #{product_category_l3,jdbcType=VARCHAR}, ",
        "#{product_category_id,jdbcType=BIGINT}, #{is_online,jdbcType=BIT}, ",
        "#{is_new,jdbcType=BIT}, #{is_hot,jdbcType=BIT}, #{source,jdbcType=VARCHAR}, ",
        "#{product_weight,jdbcType=INTEGER}, #{brand_id,jdbcType=BIGINT}, ",
        "#{product_category_l1_id,jdbcType=BIGINT}, #{product_category_l2_id,jdbcType=BIGINT}, ",
        "#{product_sub_name,jdbcType=VARCHAR}, #{specs,jdbcType=VARCHAR}, ",
        "#{overseas_price,jdbcType=INTEGER}, #{product_price,jdbcType=INTEGER}, ",
        "#{product_number,jdbcType=VARCHAR}, #{source_channel,jdbcType=VARCHAR}, ",
        "#{stock_count,jdbcType=INTEGER}, #{product_properties,jdbcType=VARCHAR}, ",
        "#{product_image_list,jdbcType=VARCHAR}, #{routine_id,jdbcType=INTEGER}, ",
        "#{price_on_sale,jdbcType=INTEGER}, #{delivery_free,jdbcType=BIT}, ",
        "#{goods_id,jdbcType=BIGINT}, #{is_zero_interest,jdbcType=BIT}, ",
        "#{is_zero_downpayment,jdbcType=BIT}, #{product_attr,jdbcType=LONGVARCHAR}, ",
        "#{merchants_code,jdbcType=VARCHAR},",
        "#{product_images,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Product record);

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

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update `product`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`brand_name_cn` = #{brand_name_cn,jdbcType=VARCHAR},",
          "`brand_name_en` = #{brand_name_en,jdbcType=VARCHAR},",
          "`product_name_cn` = #{product_name_cn,jdbcType=VARCHAR},",
          "`product_name_en` = #{product_name_en,jdbcType=VARCHAR},",
          "`recommend_index` = #{recommend_index,jdbcType=INTEGER},",
          "`product_category_l1` = #{product_category_l1,jdbcType=VARCHAR},",
          "`product_category_l2` = #{product_category_l2,jdbcType=VARCHAR},",
          "`product_category_l3` = #{product_category_l3,jdbcType=VARCHAR},",
          "`product_category_id` = #{product_category_id,jdbcType=BIGINT},",
          "`is_online` = #{is_online,jdbcType=BIT},",
          "`is_new` = #{is_new,jdbcType=BIT},",
          "`is_hot` = #{is_hot,jdbcType=BIT},",
          "`source` = #{source,jdbcType=VARCHAR},",
          "`product_weight` = #{product_weight,jdbcType=INTEGER},",
          "`brand_id` = #{brand_id,jdbcType=BIGINT},",
          "`product_category_l1_id` = #{product_category_l1_id,jdbcType=BIGINT},",
          "`product_category_l2_id` = #{product_category_l2_id,jdbcType=BIGINT},",
          "`product_sub_name` = #{product_sub_name,jdbcType=VARCHAR},",
          "`specs` = #{specs,jdbcType=VARCHAR},",
          "`overseas_price` = #{overseas_price,jdbcType=INTEGER},",
          "`product_price` = #{product_price,jdbcType=INTEGER},",
          "`product_number` = #{product_number,jdbcType=VARCHAR},",
          "`source_channel` = #{source_channel,jdbcType=VARCHAR},",
          "`stock_count` = #{stock_count,jdbcType=INTEGER},",
          "`product_properties` = #{product_properties,jdbcType=VARCHAR},",
          "`product_image_list` = #{product_image_list,jdbcType=VARCHAR},",
          "`routine_id` = #{routine_id,jdbcType=INTEGER},",
          "`price_on_sale` = #{price_on_sale,jdbcType=INTEGER},",
          "`delivery_free` = #{delivery_free,jdbcType=BIT},",
          "`goods_id` = #{goods_id,jdbcType=BIGINT},",
          "`is_zero_interest` = #{is_zero_interest,jdbcType=BIT},",
          "`is_zero_downpayment` = #{is_zero_downpayment,jdbcType=BIT},",
          "`product_attr` = #{product_attr,jdbcType=LONGVARCHAR},",
          "`merchants_code` = #{merchants_code,jdbcType=VARCHAR}",
          "`product_images` = #{product_images,jdbcType=LONGVARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Product record);

    @Update({
        "update `product`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`brand_name_cn` = #{brand_name_cn,jdbcType=VARCHAR},",
          "`brand_name_en` = #{brand_name_en,jdbcType=VARCHAR},",
          "`product_name_cn` = #{product_name_cn,jdbcType=VARCHAR},",
          "`product_name_en` = #{product_name_en,jdbcType=VARCHAR},",
          "`recommend_index` = #{recommend_index,jdbcType=INTEGER},",
          "`product_category_l1` = #{product_category_l1,jdbcType=VARCHAR},",
          "`product_category_l2` = #{product_category_l2,jdbcType=VARCHAR},",
          "`product_category_l3` = #{product_category_l3,jdbcType=VARCHAR},",
          "`product_category_id` = #{product_category_id,jdbcType=BIGINT},",
          "`is_online` = #{is_online,jdbcType=BIT},",
          "`is_new` = #{is_new,jdbcType=BIT},",
          "`is_hot` = #{is_hot,jdbcType=BIT},",
          "`source` = #{source,jdbcType=VARCHAR},",
          "`product_weight` = #{product_weight,jdbcType=INTEGER},",
          "`brand_id` = #{brand_id,jdbcType=BIGINT},",
          "`product_category_l1_id` = #{product_category_l1_id,jdbcType=BIGINT},",
          "`product_category_l2_id` = #{product_category_l2_id,jdbcType=BIGINT},",
          "`product_sub_name` = #{product_sub_name,jdbcType=VARCHAR},",
          "`specs` = #{specs,jdbcType=VARCHAR},",
          "`overseas_price` = #{overseas_price,jdbcType=INTEGER},",
          "`product_price` = #{product_price,jdbcType=INTEGER},",
          "`product_number` = #{product_number,jdbcType=VARCHAR},",
          "`source_channel` = #{source_channel,jdbcType=VARCHAR},",
          "`stock_count` = #{stock_count,jdbcType=INTEGER},",
          "`product_properties` = #{product_properties,jdbcType=VARCHAR},",
          "`product_image_list` = #{product_image_list,jdbcType=VARCHAR},",
          "`routine_id` = #{routine_id,jdbcType=INTEGER},",
          "`price_on_sale` = #{price_on_sale,jdbcType=INTEGER},",
          "`delivery_free` = #{delivery_free,jdbcType=BIT},",
          "`goods_id` = #{goods_id,jdbcType=BIGINT},",
          "`is_zero_interest` = #{is_zero_interest,jdbcType=BIT},",
          "`merchants_code` = #{merchants_code,jdbcType=VARCHAR}",
          "`is_zero_downpayment` = #{is_zero_downpayment,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Product record);
}