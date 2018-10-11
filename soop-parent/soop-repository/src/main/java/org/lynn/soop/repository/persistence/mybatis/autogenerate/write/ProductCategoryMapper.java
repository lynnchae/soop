package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.ProductCategory;
import org.lynn.soop.entity.ProductCategoryExample;
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

public interface ProductCategoryMapper {
    @DeleteProvider(type=ProductCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductCategoryExample example);

    @Delete({
        "delete from `product_category`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product_category` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`category_name`, `description`, ",
        "`parent_category_id`, `duties`, ",
        "`parent_category_name`, `discount_standard_amount`, ",
        "`discount_percentage`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{category_name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{parent_category_id,jdbcType=BIGINT}, #{duties,jdbcType=INTEGER}, ",
        "#{parent_category_name,jdbcType=VARCHAR}, #{discount_standard_amount,jdbcType=INTEGER}, ",
        "#{discount_percentage,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductCategory record);

    @InsertProvider(type=ProductCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProductCategory record);

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

    @UpdateProvider(type=ProductCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    @UpdateProvider(type=ProductCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    @UpdateProvider(type=ProductCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductCategory record);

    @Update({
        "update `product_category`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`category_name` = #{category_name,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`parent_category_id` = #{parent_category_id,jdbcType=BIGINT},",
          "`duties` = #{duties,jdbcType=INTEGER},",
          "`parent_category_name` = #{parent_category_name,jdbcType=VARCHAR},",
          "`discount_standard_amount` = #{discount_standard_amount,jdbcType=INTEGER},",
          "`discount_percentage` = #{discount_percentage,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductCategory record);


    @Update({
        "update `product_category` set parent_category_name = #{1} where parent_category_id = #{0}"
    })
    void updateSubParentCatgoryName(Long parentId, String parentCategoryName);
}