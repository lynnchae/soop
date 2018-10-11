package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.SalesProperty;
import org.lynn.soop.entity.SalesPropertyExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SalesPropertyMapper {
    @SelectProvider(type=SalesPropertySqlProvider.class, method="countByExample")
    int countByExample(SalesPropertyExample example);

    @SelectProvider(type=SalesPropertySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_name", property="sp_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT)
    })
    List<SalesProperty> selectByExample(SalesPropertyExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `sp_name`, ",
        "`goods_id`",
        "from `sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_name", property="sp_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT)
    })
    SalesProperty selectByPrimaryKey(Long id);
}