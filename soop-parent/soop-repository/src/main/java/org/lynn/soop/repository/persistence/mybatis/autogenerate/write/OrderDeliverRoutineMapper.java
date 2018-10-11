package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.OrderDeliverRoutine;
import org.lynn.soop.entity.OrderDeliverRoutineExample;
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

public interface OrderDeliverRoutineMapper {
    @DeleteProvider(type=OrderDeliverRoutineSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderDeliverRoutineExample example);

    @Delete({
        "delete from `order_deliver_routine`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `order_deliver_routine` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`category_id`, `routine_name`, ",
        "`routine_detail`, `priority`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{category_id,jdbcType=BIGINT}, #{routine_name,jdbcType=VARCHAR}, ",
        "#{routine_detail,jdbcType=VARCHAR}, #{priority,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderDeliverRoutine record);

    @InsertProvider(type=OrderDeliverRoutineSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OrderDeliverRoutine record);

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

    @UpdateProvider(type=OrderDeliverRoutineSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderDeliverRoutine record, @Param("example") OrderDeliverRoutineExample example);

    @UpdateProvider(type=OrderDeliverRoutineSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderDeliverRoutine record, @Param("example") OrderDeliverRoutineExample example);

    @UpdateProvider(type=OrderDeliverRoutineSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderDeliverRoutine record);

    @Update({
        "update `order_deliver_routine`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`category_id` = #{category_id,jdbcType=BIGINT},",
          "`routine_name` = #{routine_name,jdbcType=VARCHAR},",
          "`routine_detail` = #{routine_detail,jdbcType=VARCHAR},",
          "`priority` = #{priority,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderDeliverRoutine record);
}