package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.MembershipLevelRule;
import org.lynn.soop.entity.MembershipLevelRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface MembershipLevelRuleMapper {
    @SelectProvider(type=MembershipLevelRuleSqlProvider.class, method="countByExample")
    int countByExample(MembershipLevelRuleExample example);

    @SelectProvider(type=MembershipLevelRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="point_floor", property="point_floor", jdbcType=JdbcType.INTEGER),
        @Result(column="point_ceiling", property="point_ceiling", jdbcType=JdbcType.INTEGER),
        @Result(column="discount_percentage", property="discount_percentage", jdbcType=JdbcType.INTEGER),
        @Result(column="user_group", property="user_group", jdbcType=JdbcType.VARCHAR)
    })
    List<MembershipLevelRule> selectByExample(MembershipLevelRuleExample example);

    @Select({
        "select",
        "`id`, `name`, `level`, `date_created`, `created_by`, `date_updated`, `updated_by`, ",
        "`point_floor`, `point_ceiling`, `discount_percentage`, `user_group`",
        "from `membership_level_rule`",
        "where `id` = #{id,jdbcType=BIGINT}",
          "and `name` = #{name,jdbcType=VARCHAR}",
          "and `level` = #{level,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="point_floor", property="point_floor", jdbcType=JdbcType.INTEGER),
        @Result(column="point_ceiling", property="point_ceiling", jdbcType=JdbcType.INTEGER),
        @Result(column="discount_percentage", property="discount_percentage", jdbcType=JdbcType.INTEGER),
        @Result(column="user_group", property="user_group", jdbcType=JdbcType.VARCHAR)
    })
    MembershipLevelRule selectByPrimaryKey(@Param("id") Long id, @Param("name") String name, @Param("level") String level);
}