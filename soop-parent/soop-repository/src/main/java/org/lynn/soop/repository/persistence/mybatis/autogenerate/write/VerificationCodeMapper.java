package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.VerificationCode;
import org.lynn.soop.entity.VerificationCodeExample;
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

public interface VerificationCodeMapper {
    @DeleteProvider(type=VerificationCodeSqlProvider.class, method="deleteByExample")
    int deleteByExample(VerificationCodeExample example);

    @Delete({
        "delete from `verification_code`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `verification_code` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`type`, `key_number`, ",
        "`code`, `expired_at`, ",
        "`business_ref_no`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{key_number,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{expired_at,jdbcType=TIMESTAMP}, ",
        "#{business_ref_no,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VerificationCode record);

    @InsertProvider(type=VerificationCodeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VerificationCode record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `type`, `key_number`, ",
        "`code`, `expired_at`, `business_ref_no`",
        "from `verification_code`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="key_number", property="key_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="expired_at", property="expired_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="business_ref_no", property="business_ref_no", jdbcType=JdbcType.VARCHAR)
    })
    VerificationCode selectByPrimaryKey(Long id);

    @UpdateProvider(type=VerificationCodeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VerificationCode record, @Param("example") VerificationCodeExample example);

    @UpdateProvider(type=VerificationCodeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VerificationCode record, @Param("example") VerificationCodeExample example);

    @UpdateProvider(type=VerificationCodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VerificationCode record);

    @Update({
        "update `verification_code`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "`key_number` = #{key_number,jdbcType=VARCHAR},",
          "`code` = #{code,jdbcType=VARCHAR},",
          "`expired_at` = #{expired_at,jdbcType=TIMESTAMP},",
          "`business_ref_no` = #{business_ref_no,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VerificationCode record);
}