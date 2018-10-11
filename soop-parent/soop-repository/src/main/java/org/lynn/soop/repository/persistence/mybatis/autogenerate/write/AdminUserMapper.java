package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.AdminUser;
import org.lynn.soop.entity.AdminUserExample;
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

public interface AdminUserMapper {
    @DeleteProvider(type=AdminUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminUserExample example);

    @Delete({
        "delete from `admin_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_user` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`login_account`, `password`, ",
        "`role`, `session_id`, ",
        "`session_expired`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{login_account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{role,jdbcType=VARCHAR}, #{session_id,jdbcType=VARCHAR}, ",
        "#{session_expired,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminUser record);

    @InsertProvider(type=AdminUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminUser record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `login_account`, ",
        "`password`, `role`, `session_id`, `session_expired`",
        "from `admin_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_account", property="login_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_id", property="session_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_expired", property="session_expired", jdbcType=JdbcType.TIMESTAMP)
    })
    AdminUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    @UpdateProvider(type=AdminUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    @UpdateProvider(type=AdminUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminUser record);

    @Update({
        "update `admin_user`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`login_account` = #{login_account,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "`role` = #{role,jdbcType=VARCHAR},",
          "`session_id` = #{session_id,jdbcType=VARCHAR},",
          "`session_expired` = #{session_expired,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminUser record);
}