package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.SysParameter;
import org.lynn.soop.entity.SysParameterExample;
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

public interface SysParameterMapper {
    @DeleteProvider(type=SysParameterSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysParameterExample example);

    @Delete({
        "delete from `sys_parameter`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `sys_parameter` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`param_key`, `param_value`, ",
        "`description`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{param_key,jdbcType=VARCHAR}, #{param_value,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SysParameter record);

    @InsertProvider(type=SysParameterSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SysParameter record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `param_key`, ",
        "`param_value`, `description`",
        "from `sys_parameter`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_key", property="param_key", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_value", property="param_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    SysParameter selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysParameterSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    @UpdateProvider(type=SysParameterSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    @UpdateProvider(type=SysParameterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysParameter record);

    @Update({
        "update `sys_parameter`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`param_key` = #{param_key,jdbcType=VARCHAR},",
          "`param_value` = #{param_value,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysParameter record);
}