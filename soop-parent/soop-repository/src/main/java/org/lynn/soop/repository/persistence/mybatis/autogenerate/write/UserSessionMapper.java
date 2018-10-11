package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.UserSession;
import org.lynn.soop.entity.UserSessionExample;
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

public interface UserSessionMapper {
    @DeleteProvider(type=UserSessionSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserSessionExample example);

    @Delete({
        "delete from `user_session`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `user_session` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`session_id`, `user_id`, ",
        "`is_valid`, `expired_at`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{session_id,jdbcType=VARCHAR}, #{user_id,jdbcType=BIGINT}, ",
        "#{is_valid,jdbcType=BIT}, #{expired_at,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserSession record);

    @InsertProvider(type=UserSessionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserSession record);

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

    @UpdateProvider(type=UserSessionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserSession record, @Param("example") UserSessionExample example);

    @UpdateProvider(type=UserSessionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserSession record, @Param("example") UserSessionExample example);

    @UpdateProvider(type=UserSessionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserSession record);

    @Update({
        "update `user_session`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`session_id` = #{session_id,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`is_valid` = #{is_valid,jdbcType=BIT},",
          "`expired_at` = #{expired_at,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserSession record);
}