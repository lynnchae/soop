package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.User;
import org.lynn.soop.entity.UserExample;
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

public interface UserMapper {
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from `user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `user` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`login_name`, `unique_token`, ",
        "`password`, `user_name`, ",
        "`user_group`, `current_membership_level`, ",
        "`mobile_no`, `email`, ",
        "`current_status`, `avatar`, ",
        "`id_type`, `id_no`, ",
        "`online_status`, `last_login_time`, ",
        "`openid`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{login_name,jdbcType=VARCHAR}, #{unique_token,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{user_name,jdbcType=VARCHAR}, ",
        "#{user_group,jdbcType=VARCHAR}, #{current_membership_level,jdbcType=VARCHAR}, ",
        "#{mobile_no,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{current_status,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{id_type,jdbcType=VARCHAR}, #{id_no,jdbcType=VARCHAR}, ",
        "#{online_status,jdbcType=BIT}, #{last_login_time,jdbcType=TIMESTAMP}, ",
        "#{openid,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(User record);

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

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update `user`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`login_name` = #{login_name,jdbcType=VARCHAR},",
          "`unique_token` = #{unique_token,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "`user_name` = #{user_name,jdbcType=VARCHAR},",
          "`user_group` = #{user_group,jdbcType=VARCHAR},",
          "`current_membership_level` = #{current_membership_level,jdbcType=VARCHAR},",
          "`mobile_no` = #{mobile_no,jdbcType=VARCHAR},",
          "`email` = #{email,jdbcType=VARCHAR},",
          "`current_status` = #{current_status,jdbcType=VARCHAR},",
          "`avatar` = #{avatar,jdbcType=VARCHAR},",
          "`id_type` = #{id_type,jdbcType=VARCHAR},",
          "`id_no` = #{id_no,jdbcType=VARCHAR},",
          "`online_status` = #{online_status,jdbcType=BIT},",
          "`last_login_time` = #{last_login_time,jdbcType=TIMESTAMP},",
          "`openid` = #{openid,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}