package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.UserSession;
import org.lynn.soop.entity.UserSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserSessionMapper {
    @SelectProvider(type=UserSessionSqlProvider.class, method="countByExample")
    int countByExample(UserSessionExample example);

    @SelectProvider(type=UserSessionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_id", property="session_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_valid", property="is_valid", jdbcType=JdbcType.BIT),
        @Result(column="expired_at", property="expired_at", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserSession> selectByExample(UserSessionExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `session_id`, ",
        "`user_id`, `is_valid`, `expired_at`",
        "from `user_session`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_id", property="session_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="is_valid", property="is_valid", jdbcType=JdbcType.BIT),
        @Result(column="expired_at", property="expired_at", jdbcType=JdbcType.TIMESTAMP)
    })
    UserSession selectByPrimaryKey(Long id);
}