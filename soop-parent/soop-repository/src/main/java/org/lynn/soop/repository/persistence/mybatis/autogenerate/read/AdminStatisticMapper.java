package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.AdminStatistic;
import org.lynn.soop.entity.AdminStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface AdminStatisticMapper {
    @SelectProvider(type=AdminStatisticSqlProvider.class, method="countByExample")
    int countByExample(AdminStatisticExample example);

    @SelectProvider(type=AdminStatisticSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_product_count", property="total_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_product_count_in_stock", property="total_product_count_in_stock", jdbcType=JdbcType.INTEGER),
        @Result(column="total_hot_product_count", property="total_hot_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_new_product_count", property="total_new_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_promo_product_count", property="total_promo_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_order_count", property="total_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="pending_delivery_order_count", property="pending_delivery_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="pending_pay_order_count", property="pending_pay_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="done_order_count", property="done_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_order_count", property="refund_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_user_online", property="total_user_online", jdbcType=JdbcType.INTEGER)
    })
    List<AdminStatistic> selectByExample(AdminStatisticExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `total_product_count`, ",
        "`total_product_count_in_stock`, `total_hot_product_count`, `total_new_product_count`, ",
        "`total_promo_product_count`, `total_order_count`, `pending_delivery_order_count`, ",
        "`pending_pay_order_count`, `done_order_count`, `refund_order_count`, `total_user_online`",
        "from `admin_statistic`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_product_count", property="total_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_product_count_in_stock", property="total_product_count_in_stock", jdbcType=JdbcType.INTEGER),
        @Result(column="total_hot_product_count", property="total_hot_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_new_product_count", property="total_new_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_promo_product_count", property="total_promo_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_order_count", property="total_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="pending_delivery_order_count", property="pending_delivery_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="pending_pay_order_count", property="pending_pay_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="done_order_count", property="done_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_order_count", property="refund_order_count", jdbcType=JdbcType.INTEGER),
        @Result(column="total_user_online", property="total_user_online", jdbcType=JdbcType.INTEGER)
    })
    AdminStatistic selectByPrimaryKey(Long id);
}