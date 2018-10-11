package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.OrderStatusHistory;
import org.lynn.soop.entity.OrderStatusHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderStatusHistoryMapper {
    @SelectProvider(type=OrderStatusHistorySqlProvider.class, method="countByExample")
    int countByExample(OrderStatusHistoryExample example);

    @SelectProvider(type=OrderStatusHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="to_status", property="to_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_status", property="from_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_id", property="record_id", jdbcType=JdbcType.BIGINT)
    })
    List<OrderStatusHistory> selectByExample(OrderStatusHistoryExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `order_id`, ",
        "`to_status`, `from_status`, `operation`, `record_id`",
        "from `order_status_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="to_status", property="to_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_status", property="from_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_id", property="record_id", jdbcType=JdbcType.BIGINT)
    })
    OrderStatusHistory selectByPrimaryKey(Long id);
}