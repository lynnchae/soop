package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.User;
import org.lynn.soop.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="login_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="unique_token", property="unique_token", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_group", property="user_group", jdbcType=JdbcType.VARCHAR),
        @Result(column="current_membership_level", property="current_membership_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_no", property="mobile_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="current_status", property="current_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_type", property="id_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="id_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="online_status", property="online_status", jdbcType=JdbcType.BIT),
        @Result(column="last_login_time", property="last_login_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `login_name`, ",
        "`unique_token`, `password`, `user_name`, `user_group`, `current_membership_level`, ",
        "`mobile_no`, `email`, `current_status`, `avatar`, `id_type`, `id_no`, `online_status`, ",
        "`last_login_time`, `openid`",
        "from `user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="login_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="unique_token", property="unique_token", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_group", property="user_group", jdbcType=JdbcType.VARCHAR),
        @Result(column="current_membership_level", property="current_membership_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_no", property="mobile_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="current_status", property="current_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_type", property="id_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="id_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="online_status", property="online_status", jdbcType=JdbcType.BIT),
        @Result(column="last_login_time", property="last_login_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);
}