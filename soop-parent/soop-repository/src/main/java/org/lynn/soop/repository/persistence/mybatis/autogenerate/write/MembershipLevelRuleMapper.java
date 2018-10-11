package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.MembershipLevelRule;
import org.lynn.soop.entity.MembershipLevelRuleExample;
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

public interface MembershipLevelRuleMapper {
    @DeleteProvider(type=MembershipLevelRuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(MembershipLevelRuleExample example);

    @Delete({
        "delete from `membership_level_rule`",
        "where `id` = #{id,jdbcType=BIGINT}",
          "and `name` = #{name,jdbcType=VARCHAR}",
          "and `level` = #{level,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("id") Long id, @Param("name") String name, @Param("level") String level);

    @Insert({
        "insert into `membership_level_rule` (`name`, `level`, ",
        "`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`point_floor`, `point_ceiling`, ",
        "`discount_percentage`, `user_group`)",
        "values (#{name,jdbcType=VARCHAR}, #{level,jdbcType=VARCHAR}, ",
        "#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{point_floor,jdbcType=INTEGER}, #{point_ceiling,jdbcType=INTEGER}, ",
        "#{discount_percentage,jdbcType=INTEGER}, #{user_group,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MembershipLevelRule record);

    @InsertProvider(type=MembershipLevelRuleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MembershipLevelRule record);

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

    @UpdateProvider(type=MembershipLevelRuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MembershipLevelRule record, @Param("example") MembershipLevelRuleExample example);

    @UpdateProvider(type=MembershipLevelRuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MembershipLevelRule record, @Param("example") MembershipLevelRuleExample example);

    @UpdateProvider(type=MembershipLevelRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MembershipLevelRule record);

    @Update({
        "update `membership_level_rule`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`point_floor` = #{point_floor,jdbcType=INTEGER},",
          "`point_ceiling` = #{point_ceiling,jdbcType=INTEGER},",
          "`discount_percentage` = #{discount_percentage,jdbcType=INTEGER},",
          "`user_group` = #{user_group,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}",
          "and `name` = #{name,jdbcType=VARCHAR}",
          "and `level` = #{level,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MembershipLevelRule record);
}