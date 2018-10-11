package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.GoodsSalesProperty;
import org.lynn.soop.entity.GoodsSalesPropertyExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GoodsSalesPropertyMapper {
    @SelectProvider(type=GoodsSalesPropertySqlProvider.class, method="countByExample")
    int countByExample(GoodsSalesPropertyExample example);

    @SelectProvider(type=GoodsSalesPropertySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_id", property="sp_id", jdbcType=JdbcType.BIGINT)
    })
    List<GoodsSalesProperty> selectByExample(GoodsSalesPropertyExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `goods_id`, ",
        "`sp_id`",
        "from `goods_sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_id", property="sp_id", jdbcType=JdbcType.BIGINT)
    })
    GoodsSalesProperty selectByPrimaryKey(Long id);
}