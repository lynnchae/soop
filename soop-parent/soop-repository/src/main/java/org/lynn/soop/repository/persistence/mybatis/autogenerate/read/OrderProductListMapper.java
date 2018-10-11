package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.OrderProductList;
import org.lynn.soop.entity.OrderProductListExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderProductListMapper {
    @SelectProvider(type=OrderProductListSqlProvider.class, method="countByExample")
    int countByExample(OrderProductListExample example);

    @SelectProvider(type=OrderProductListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_status", property="purchase_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_complete_time", property="pay_complete_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="purchase_complete_time", property="purchase_complete_time", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderProductList> selectByExample(OrderProductListExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `order_id`, ",
        "`product_id`, `product_price`, `product_name`, `quantity`, `purchase_status`, ",
        "`order_status`, `pay_complete_time`, `purchase_complete_time`",
        "from `order_product_list`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_status", property="purchase_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_complete_time", property="pay_complete_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="purchase_complete_time", property="purchase_complete_time", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderProductList selectByPrimaryKey(Long id);
}