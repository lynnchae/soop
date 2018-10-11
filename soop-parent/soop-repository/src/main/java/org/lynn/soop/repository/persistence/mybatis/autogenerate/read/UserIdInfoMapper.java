package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.UserIdInfo;
import org.lynn.soop.entity.UserIdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserIdInfoMapper {
    @SelectProvider(type=UserIdInfoSqlProvider.class, method="countByExample")
    int countByExample(UserIdInfoExample example);

    @SelectProvider(type=UserIdInfoSqlProvider.class, method="selectByExample")
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
    List<UserIdInfo> selectByExample(UserIdInfoExample example);

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
}