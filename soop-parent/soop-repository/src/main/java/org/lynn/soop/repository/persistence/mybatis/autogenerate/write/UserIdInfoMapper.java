package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.UserIdInfo;
import org.lynn.soop.entity.UserIdInfoExample;
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

public interface UserIdInfoMapper {
    @DeleteProvider(type=UserIdInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserIdInfoExample example);

    @Delete({
        "delete from `user_id_info`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `user_id_info` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`user_id`, `id_front_image`, ",
        "`id_back_image`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=BIGINT}, #{id_front_image,jdbcType=VARCHAR}, ",
        "#{id_back_image,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserIdInfo record);

    @InsertProvider(type=UserIdInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserIdInfo record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `user_id`, ",
        "`id_front_image`, `id_back_image`",
        "from `user_id_info`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="id_front_image", property="id_front_image", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_back_image", property="id_back_image", jdbcType=JdbcType.VARCHAR)
    })
    UserIdInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserIdInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserIdInfo record, @Param("example") UserIdInfoExample example);

    @UpdateProvider(type=UserIdInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserIdInfo record, @Param("example") UserIdInfoExample example);

    @UpdateProvider(type=UserIdInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserIdInfo record);

    @Update({
        "update `user_id_info`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`id_front_image` = #{id_front_image,jdbcType=VARCHAR},",
          "`id_back_image` = #{id_back_image,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserIdInfo record);
}