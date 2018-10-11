package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.LoginHistory;
import org.lynn.soop.entity.LoginHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoginHistoryMapper {
    @SelectProvider(type=LoginHistorySqlProvider.class, method="countByExample")
    int countByExample(LoginHistoryExample example);

    @SelectProvider(type=LoginHistorySqlProvider.class, method="selectByExample")
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
    List<LoginHistory> selectByExample(LoginHistoryExample example);

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
}