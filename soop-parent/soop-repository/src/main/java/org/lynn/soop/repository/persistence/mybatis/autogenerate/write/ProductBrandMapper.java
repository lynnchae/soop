package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.ProductBrand;
import org.lynn.soop.entity.ProductBrandExample;
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

public interface ProductBrandMapper {
    @DeleteProvider(type=ProductBrandSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductBrandExample example);

    @Delete({
        "delete from `product_brand`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product_brand` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`brand_name_cn`, `brand_name_en`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{brand_name_cn,jdbcType=VARCHAR}, #{brand_name_en,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductBrand record);

    @InsertProvider(type=ProductBrandSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProductBrand record);

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

    @UpdateProvider(type=ProductBrandSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductBrand record, @Param("example") ProductBrandExample example);

    @UpdateProvider(type=ProductBrandSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductBrand record, @Param("example") ProductBrandExample example);

    @UpdateProvider(type=ProductBrandSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductBrand record);

    @Update({
        "update `product_brand`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`brand_name_cn` = #{brand_name_cn,jdbcType=VARCHAR},",
          "`brand_name_en` = #{brand_name_en,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductBrand record);
}