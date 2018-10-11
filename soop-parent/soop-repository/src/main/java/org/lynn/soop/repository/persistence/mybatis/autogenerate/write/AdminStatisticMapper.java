package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.AdminStatistic;
import org.lynn.soop.entity.AdminStatisticExample;
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

public interface AdminStatisticMapper {
    @DeleteProvider(type=AdminStatisticSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminStatisticExample example);

    @Delete({
        "delete from `admin_statistic`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_statistic` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`total_product_count`, `total_product_count_in_stock`, ",
        "`total_hot_product_count`, `total_new_product_count`, ",
        "`total_promo_product_count`, `total_order_count`, ",
        "`pending_delivery_order_count`, `pending_pay_order_count`, ",
        "`done_order_count`, `refund_order_count`, ",
        "`total_user_online`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{total_product_count,jdbcType=INTEGER}, #{total_product_count_in_stock,jdbcType=INTEGER}, ",
        "#{total_hot_product_count,jdbcType=INTEGER}, #{total_new_product_count,jdbcType=INTEGER}, ",
        "#{total_promo_product_count,jdbcType=INTEGER}, #{total_order_count,jdbcType=INTEGER}, ",
        "#{pending_delivery_order_count,jdbcType=INTEGER}, #{pending_pay_order_count,jdbcType=INTEGER}, ",
        "#{done_order_count,jdbcType=INTEGER}, #{refund_order_count,jdbcType=INTEGER}, ",
        "#{total_user_online,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminStatistic record);

    @InsertProvider(type=AdminStatisticSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminStatistic record);

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

    @UpdateProvider(type=AdminStatisticSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminStatistic record, @Param("example") AdminStatisticExample example);

    @UpdateProvider(type=AdminStatisticSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminStatistic record, @Param("example") AdminStatisticExample example);

    @UpdateProvider(type=AdminStatisticSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminStatistic record);

    @Update({
        "update `admin_statistic`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`total_product_count` = #{total_product_count,jdbcType=INTEGER},",
          "`total_product_count_in_stock` = #{total_product_count_in_stock,jdbcType=INTEGER},",
          "`total_hot_product_count` = #{total_hot_product_count,jdbcType=INTEGER},",
          "`total_new_product_count` = #{total_new_product_count,jdbcType=INTEGER},",
          "`total_promo_product_count` = #{total_promo_product_count,jdbcType=INTEGER},",
          "`total_order_count` = #{total_order_count,jdbcType=INTEGER},",
          "`pending_delivery_order_count` = #{pending_delivery_order_count,jdbcType=INTEGER},",
          "`pending_pay_order_count` = #{pending_pay_order_count,jdbcType=INTEGER},",
          "`done_order_count` = #{done_order_count,jdbcType=INTEGER},",
          "`refund_order_count` = #{refund_order_count,jdbcType=INTEGER},",
          "`total_user_online` = #{total_user_online,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminStatistic record);
}