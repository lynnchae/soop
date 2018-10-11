package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.OrderStatusHistory;
import org.lynn.soop.entity.OrderStatusHistoryExample;
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

public interface OrderStatusHistoryMapper {
    @DeleteProvider(type=OrderStatusHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderStatusHistoryExample example);

    @Delete({
        "delete from `order_status_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `order_status_history` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`order_id`, `to_status`, ",
        "`from_status`, `operation`, ",
        "`record_id`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{order_id,jdbcType=BIGINT}, #{to_status,jdbcType=VARCHAR}, ",
        "#{from_status,jdbcType=VARCHAR}, #{operation,jdbcType=VARCHAR}, ",
        "#{record_id,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderStatusHistory record);

    @InsertProvider(type=OrderStatusHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OrderStatusHistory record);

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

    @UpdateProvider(type=OrderStatusHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderStatusHistory record, @Param("example") OrderStatusHistoryExample example);

    @UpdateProvider(type=OrderStatusHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderStatusHistory record, @Param("example") OrderStatusHistoryExample example);

    @UpdateProvider(type=OrderStatusHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderStatusHistory record);

    @Update({
        "update `order_status_history`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`order_id` = #{order_id,jdbcType=CHAR},",
          "`to_status` = #{to_status,jdbcType=VARCHAR},",
          "`from_status` = #{from_status,jdbcType=VARCHAR},",
          "`operation` = #{operation,jdbcType=VARCHAR},",
          "`record_id` = #{record_id,jdbcType=BIGINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderStatusHistory record);
}