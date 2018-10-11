package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.OrderDeliverBatch;
import org.lynn.soop.entity.OrderDeliverBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderDeliverBatchMapper {
    @SelectProvider(type=OrderDeliverBatchSqlProvider.class, method="countByExample")
    int countByExample(OrderDeliverBatchExample example);

    @SelectProvider(type=OrderDeliverBatchSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="batch_id", property="batch_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_name", property="routine_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="already_import", property="already_import", jdbcType=JdbcType.BIT)
    })
    List<OrderDeliverBatch> selectByExample(OrderDeliverBatchExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `batch_id`, ",
        "`routine_name`, `already_import`",
        "from `order_deliver_batch`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="batch_id", property="batch_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_name", property="routine_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="already_import", property="already_import", jdbcType=JdbcType.BIT)
    })
    OrderDeliverBatch selectByPrimaryKey(Long id);
}