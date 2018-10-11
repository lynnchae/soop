package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderExample;
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

public interface OrderMapper {
    @DeleteProvider(type=OrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderExample example);

    @Delete({
        "delete from `order`",
        "where `id` = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into `order` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`status`, `total_product_amount`, ",
        "`total_order_amount`, `post_delivery_factor`, ",
        "`post_delivery_order_no`, `delivery_address`, ",
        "`delivery_post_code`, `delivery_contact_name`, ",
        "`delivery_contact_phone`, `order_description`, ",
        "`total_product_number`, `total_weight`, ",
        "`address_id`, `freight`, ",
        "`discount_amount`, `delivery_freight`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{total_product_amount,jdbcType=INTEGER}, ",
        "#{total_order_amount,jdbcType=INTEGER}, #{post_delivery_factor,jdbcType=INTEGER}, ",
        "#{post_delivery_order_no,jdbcType=VARCHAR}, #{delivery_address,jdbcType=VARCHAR}, ",
        "#{delivery_post_code,jdbcType=VARCHAR}, #{delivery_contact_name,jdbcType=VARCHAR}, ",
        "#{delivery_contact_phone,jdbcType=VARCHAR}, #{order_description,jdbcType=VARCHAR}, ",
        "#{total_product_number,jdbcType=INTEGER}, #{total_weight,jdbcType=INTEGER}, ",
        "#{address_id,jdbcType=BIGINT}, #{freight,jdbcType=INTEGER}, ",
        "#{discount_amount,jdbcType=INTEGER}, #{delivery_freight,jdbcType=INTEGER})"
    })
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(Order record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `status`, ",
        "`total_product_amount`, `total_order_amount`, `post_delivery_factor`, `post_delivery_order_no`, ",
        "`delivery_address`, `delivery_post_code`, `delivery_contact_name`, `delivery_contact_phone`, ",
        "`order_description`, `total_product_number`, `total_weight`, `address_id`, `freight`, ",
        "`discount_amount`, `delivery_freight`",
        "from `order`",
        "where `id` = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_product_amount", property="total_product_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_order_amount", property="total_order_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="post_delivery_factor", property="post_delivery_factor", jdbcType=JdbcType.INTEGER),
        @Result(column="post_delivery_order_no", property="post_delivery_order_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_address", property="delivery_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_post_code", property="delivery_post_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_contact_name", property="delivery_contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_contact_phone", property="delivery_contact_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_description", property="order_description", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_product_number", property="total_product_number", jdbcType=JdbcType.INTEGER),
        @Result(column="total_weight", property="total_weight", jdbcType=JdbcType.INTEGER),
        @Result(column="address_id", property="address_id", jdbcType=JdbcType.BIGINT),
        @Result(column="freight", property="freight", jdbcType=JdbcType.INTEGER),
        @Result(column="discount_amount", property="discount_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="delivery_freight", property="delivery_freight", jdbcType=JdbcType.INTEGER)
    })
    Order selectByPrimaryKey(String id);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update `order`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`total_product_amount` = #{total_product_amount,jdbcType=INTEGER},",
          "`total_order_amount` = #{total_order_amount,jdbcType=INTEGER},",
          "`post_delivery_factor` = #{post_delivery_factor,jdbcType=INTEGER},",
          "`post_delivery_order_no` = #{post_delivery_order_no,jdbcType=VARCHAR},",
          "`delivery_address` = #{delivery_address,jdbcType=VARCHAR},",
          "`delivery_post_code` = #{delivery_post_code,jdbcType=VARCHAR},",
          "`delivery_contact_name` = #{delivery_contact_name,jdbcType=VARCHAR},",
          "`delivery_contact_phone` = #{delivery_contact_phone,jdbcType=VARCHAR},",
          "`order_description` = #{order_description,jdbcType=VARCHAR},",
          "`total_product_number` = #{total_product_number,jdbcType=INTEGER},",
          "`total_weight` = #{total_weight,jdbcType=INTEGER},",
          "`address_id` = #{address_id,jdbcType=BIGINT},",
          "`freight` = #{freight,jdbcType=INTEGER},",
          "`discount_amount` = #{discount_amount,jdbcType=INTEGER},",
          "`delivery_freight` = #{delivery_freight,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Order record);
}