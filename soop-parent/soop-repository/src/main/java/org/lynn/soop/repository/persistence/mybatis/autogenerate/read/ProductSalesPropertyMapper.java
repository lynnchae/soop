package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.ProductSalesProperty;
import org.lynn.soop.entity.ProductSalesPropertyExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ProductSalesPropertyMapper {
    @SelectProvider(type=ProductSalesPropertySqlProvider.class, method="countByExample")
    int countByExample(ProductSalesPropertyExample example);

    @SelectProvider(type=ProductSalesPropertySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="spv_id", property="spv_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_name", property="sp_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_value", property="sp_value", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductSalesProperty> selectByExample(ProductSalesPropertyExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `product_id`, ",
        "`spv_id`, `sp_name`, `sp_value`",
        "from `product_sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="spv_id", property="spv_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_name", property="sp_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_value", property="sp_value", jdbcType=JdbcType.VARCHAR)
    })
    ProductSalesProperty selectByPrimaryKey(Long id);
}