package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.ProductBrand;
import org.lynn.soop.entity.ProductBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductBrandMapper {
    @SelectProvider(type=ProductBrandSqlProvider.class, method="countByExample")
    int countByExample(ProductBrandExample example);

    @SelectProvider(type=ProductBrandSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_cn", property="brand_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_en", property="brand_name_en", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductBrand> selectByExample(ProductBrandExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `brand_name_cn`, ",
        "`brand_name_en`",
        "from `product_brand`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_cn", property="brand_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name_en", property="brand_name_en", jdbcType=JdbcType.VARCHAR)
    })
    ProductBrand selectByPrimaryKey(Long id);
}