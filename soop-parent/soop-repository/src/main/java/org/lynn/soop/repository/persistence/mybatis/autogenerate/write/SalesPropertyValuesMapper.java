package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.SalesPropertyValuesExample;
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

public interface SalesPropertyValuesMapper {
    @DeleteProvider(type=SalesPropertyValuesSqlProvider.class, method="deleteByExample")
    int deleteByExample(SalesPropertyValuesExample example);

    @Delete({
        "delete from `sales_property_values`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `sales_property_values` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`sp_id`, `sp_value`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{sp_id,jdbcType=BIGINT}, #{sp_value,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SalesPropertyValues record);

    @InsertProvider(type=SalesPropertyValuesSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SalesPropertyValues record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `sp_id`, `sp_value`",
        "from `sales_property_values`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_id", property="sp_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_value", property="sp_value", jdbcType=JdbcType.VARCHAR)
    })
    SalesPropertyValues selectByPrimaryKey(Long id);

    @UpdateProvider(type=SalesPropertyValuesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesPropertyValues record, @Param("example") SalesPropertyValuesExample example);

    @UpdateProvider(type=SalesPropertyValuesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SalesPropertyValues record, @Param("example") SalesPropertyValuesExample example);

    @UpdateProvider(type=SalesPropertyValuesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SalesPropertyValues record);

    @Update({
        "update `sales_property_values`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`sp_id` = #{sp_id,jdbcType=BIGINT},",
          "`sp_value` = #{sp_value,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SalesPropertyValues record);
}