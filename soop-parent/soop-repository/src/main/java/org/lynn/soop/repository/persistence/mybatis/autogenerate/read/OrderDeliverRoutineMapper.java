package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.OrderDeliverRoutine;
import org.lynn.soop.entity.OrderDeliverRoutineExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderDeliverRoutineMapper {
    @SelectProvider(type=OrderDeliverRoutineSqlProvider.class, method="countByExample")
    int countByExample(OrderDeliverRoutineExample example);

    @SelectProvider(type=OrderDeliverRoutineSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_id", property="category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="routine_name", property="routine_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_detail", property="routine_detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="priority", property="priority", jdbcType=JdbcType.INTEGER)
    })
    List<OrderDeliverRoutine> selectByExample(OrderDeliverRoutineExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `category_id`, ",
        "`routine_name`, `routine_detail`, `priority`",
        "from `order_deliver_routine`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_id", property="category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="routine_name", property="routine_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_detail", property="routine_detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="priority", property="priority", jdbcType=JdbcType.INTEGER)
    })
    OrderDeliverRoutine selectByPrimaryKey(Long id);
}