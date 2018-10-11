package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.ProductCategory;
import org.lynn.soop.entity.ProductCategoryExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ProductCategoryMapper {
    @SelectProvider(type=ProductCategorySqlProvider.class, method="countByExample")
    int countByExample(ProductCategoryExample example);

    @SelectProvider(type=ProductCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="category_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_category_id", property="parent_category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="duties", property="duties", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_category_name", property="parent_category_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_standard_amount", property="discount_standard_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="discount_percentage", property="discount_percentage", jdbcType=JdbcType.INTEGER)
    })
    List<ProductCategory> selectByExample(ProductCategoryExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `category_name`, ",
        "`description`, `parent_category_id`, `duties`, `parent_category_name`, `discount_standard_amount`, ",
        "`discount_percentage`",
        "from `product_category`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="category_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_category_id", property="parent_category_id", jdbcType=JdbcType.BIGINT),
        @Result(column="duties", property="duties", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_category_name", property="parent_category_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_standard_amount", property="discount_standard_amount", jdbcType=JdbcType.INTEGER),
        @Result(column="discount_percentage", property="discount_percentage", jdbcType=JdbcType.INTEGER)
    })
    ProductCategory selectByPrimaryKey(Long id);


    @Select({
            "select",
            "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `category_name`, ",
            "`description`, `parent_category_id`, `duties`, `parent_category_name`, `discount_standard_amount`, ",
            "`discount_percentage`",
            "from `product_category`",
            "where `parent_category_id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
            @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
            @Result(column="category_name", property="category_name", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="parent_category_id", property="parent_category_id", jdbcType=JdbcType.BIGINT),
            @Result(column="duties", property="duties", jdbcType=JdbcType.INTEGER),
            @Result(column="parent_category_name", property="parent_category_name", jdbcType=JdbcType.VARCHAR),
            @Result(column="discount_standard_amount", property="discount_standard_amount", jdbcType=JdbcType.INTEGER),
            @Result(column="discount_percentage", property="discount_percentage", jdbcType=JdbcType.INTEGER)
    })
    List<ProductCategory> selectByParentId(Long id);
}