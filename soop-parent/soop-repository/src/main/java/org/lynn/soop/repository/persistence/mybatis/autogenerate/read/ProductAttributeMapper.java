package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.ProductAttribute;
import org.lynn.soop.entity.ProductAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductAttributeMapper {
    @SelectProvider(type=ProductAttributeSqlProvider.class, method="countByExample")
    int countByExample(ProductAttributeExample example);

    @SelectProvider(type=ProductAttributeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr_name", property="attr_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr_value", property="attr_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr_type", property="attr_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="product_category_id", jdbcType=JdbcType.BIGINT)
    })
    List<ProductAttribute> selectByExample(ProductAttributeExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `attr_name`, ",
        "`attr_value`, `attr_type`, `product_category_id`",
        "from `product_attribute`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr_name", property="attr_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr_value", property="attr_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr_type", property="attr_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="product_category_id", jdbcType=JdbcType.BIGINT)
    })
    ProductAttribute selectByPrimaryKey(Long id);
}