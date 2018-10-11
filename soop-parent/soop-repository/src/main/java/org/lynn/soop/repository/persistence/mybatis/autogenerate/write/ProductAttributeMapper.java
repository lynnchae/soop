package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.ProductAttribute;
import org.lynn.soop.entity.ProductAttributeExample;
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

public interface ProductAttributeMapper {
    @DeleteProvider(type=ProductAttributeSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductAttributeExample example);

    @Delete({
        "delete from `product_attribute`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product_attribute` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`attr_name`, `attr_value`, ",
        "`attr_type`, `product_category_id`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{attr_name,jdbcType=VARCHAR}, #{attr_value,jdbcType=VARCHAR}, ",
        "#{attr_type,jdbcType=VARCHAR}, #{product_category_id,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductAttribute record);

    @InsertProvider(type=ProductAttributeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProductAttribute record);

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

    @UpdateProvider(type=ProductAttributeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductAttribute record, @Param("example") ProductAttributeExample example);

    @UpdateProvider(type=ProductAttributeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductAttribute record, @Param("example") ProductAttributeExample example);

    @UpdateProvider(type=ProductAttributeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductAttribute record);

    @Update({
        "update `product_attribute`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`attr_name` = #{attr_name,jdbcType=VARCHAR},",
          "`attr_value` = #{attr_value,jdbcType=VARCHAR},",
          "`attr_type` = #{attr_type,jdbcType=VARCHAR},",
          "`product_category_id` = #{product_category_id,jdbcType=BIGINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductAttribute record);
}