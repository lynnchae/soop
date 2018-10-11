package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.PayConfig;
import org.lynn.soop.entity.PayConfigExample;
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

public interface PayConfigMapper {
    @DeleteProvider(type=PayConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(PayConfigExample example);

    @Delete({
        "delete from `pay_config`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `pay_config` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`pay_channel`, `description`, ",
        "`is_valid`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{pay_channel,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{is_valid,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PayConfig record);

    @InsertProvider(type=PayConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PayConfig record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `pay_channel`, ",
        "`description`, `is_valid`",
        "from `pay_config`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="pay_channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="is_valid", jdbcType=JdbcType.BIT)
    })
    PayConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=PayConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PayConfig record, @Param("example") PayConfigExample example);

    @UpdateProvider(type=PayConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PayConfig record, @Param("example") PayConfigExample example);

    @UpdateProvider(type=PayConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PayConfig record);

    @Update({
        "update `pay_config`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`pay_channel` = #{pay_channel,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`is_valid` = #{is_valid,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PayConfig record);
}