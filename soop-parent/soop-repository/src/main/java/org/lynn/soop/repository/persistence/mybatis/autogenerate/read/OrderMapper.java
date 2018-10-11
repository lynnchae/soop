package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderMapper {
    @SelectProvider(type=OrderSqlProvider.class, method="countByExample")
    int countByExample(OrderExample example);

    @SelectProvider(type=OrderSqlProvider.class, method="selectByExample")
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
    List<Order> selectByExample(OrderExample example);

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
}