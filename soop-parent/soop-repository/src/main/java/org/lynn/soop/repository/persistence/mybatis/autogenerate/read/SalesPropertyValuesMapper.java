package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.entity.SalesPropertyValuesExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SalesPropertyValuesMapper {
    @SelectProvider(type=SalesPropertyValuesSqlProvider.class, method="countByExample")
    int countByExample(SalesPropertyValuesExample example);

    @SelectProvider(type=SalesPropertyValuesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_id", property="sp_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_value", property="sp_value", jdbcType=JdbcType.VARCHAR)
    })
    List<SalesPropertyValues> selectByExample(SalesPropertyValuesExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `sp_id`, `sp_value`",
        "from `sales_property_values`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_id", property="sp_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_value", property="sp_value", jdbcType=JdbcType.VARCHAR)
    })
    SalesPropertyValues selectByPrimaryKey(Long id);
}