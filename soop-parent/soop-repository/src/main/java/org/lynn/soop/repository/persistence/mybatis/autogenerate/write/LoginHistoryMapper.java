package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.LoginHistory;
import org.lynn.soop.entity.LoginHistoryExample;
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

public interface LoginHistoryMapper {
    @DeleteProvider(type=LoginHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(LoginHistoryExample example);

    @Delete({
        "delete from `login_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `login_history` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`user_id`, `login_name`, ",
        "`login_ip`, `is_success`, ",
        "`error_message`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=BIGINT}, #{login_name,jdbcType=BIGINT}, ",
        "#{login_ip,jdbcType=VARCHAR}, #{is_success,jdbcType=BIT}, ",
        "#{error_message,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(LoginHistory record);

    @InsertProvider(type=LoginHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(LoginHistory record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `user_id`, ",
        "`login_name`, `login_ip`, `is_success`, `error_message`",
        "from `login_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="login_name", property="login_name", jdbcType=JdbcType.BIGINT),
        @Result(column="login_ip", property="login_ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_success", property="is_success", jdbcType=JdbcType.BIT),
        @Result(column="error_message", property="error_message", jdbcType=JdbcType.VARCHAR)
    })
    LoginHistory selectByPrimaryKey(Long id);

    @UpdateProvider(type=LoginHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LoginHistory record, @Param("example") LoginHistoryExample example);

    @UpdateProvider(type=LoginHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LoginHistory record, @Param("example") LoginHistoryExample example);

    @UpdateProvider(type=LoginHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoginHistory record);

    @Update({
        "update `login_history`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`login_name` = #{login_name,jdbcType=BIGINT},",
          "`login_ip` = #{login_ip,jdbcType=VARCHAR},",
          "`is_success` = #{is_success,jdbcType=BIT},",
          "`error_message` = #{error_message,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoginHistory record);
}