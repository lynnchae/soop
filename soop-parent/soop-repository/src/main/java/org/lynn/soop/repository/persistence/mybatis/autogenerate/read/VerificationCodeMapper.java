package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.VerificationCode;
import org.lynn.soop.entity.VerificationCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface VerificationCodeMapper {
    @SelectProvider(type=VerificationCodeSqlProvider.class, method="countByExample")
    int countByExample(VerificationCodeExample example);

    @SelectProvider(type=VerificationCodeSqlProvider.class, method="selectByExample")
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
    List<VerificationCode> selectByExample(VerificationCodeExample example);

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
}