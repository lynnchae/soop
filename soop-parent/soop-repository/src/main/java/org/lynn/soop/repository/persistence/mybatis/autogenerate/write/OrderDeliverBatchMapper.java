package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.OrderDeliverBatch;
import org.lynn.soop.entity.OrderDeliverBatchExample;
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

public interface OrderDeliverBatchMapper {
    @DeleteProvider(type=OrderDeliverBatchSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderDeliverBatchExample example);

    @Delete({
        "delete from `order_deliver_batch`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `order_deliver_batch` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`batch_id`, `routine_name`, ",
        "`already_import`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{batch_id,jdbcType=VARCHAR}, #{routine_name,jdbcType=VARCHAR}, ",
        "#{already_import,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderDeliverBatch record);

    @InsertProvider(type=OrderDeliverBatchSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OrderDeliverBatch record);

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

    @UpdateProvider(type=OrderDeliverBatchSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderDeliverBatch record, @Param("example") OrderDeliverBatchExample example);

    @UpdateProvider(type=OrderDeliverBatchSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderDeliverBatch record, @Param("example") OrderDeliverBatchExample example);

    @UpdateProvider(type=OrderDeliverBatchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderDeliverBatch record);

    @Update({
        "update `order_deliver_batch`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`batch_id` = #{batch_id,jdbcType=VARCHAR},",
          "`routine_name` = #{routine_name,jdbcType=VARCHAR},",
          "`already_import` = #{already_import,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderDeliverBatch record);
}