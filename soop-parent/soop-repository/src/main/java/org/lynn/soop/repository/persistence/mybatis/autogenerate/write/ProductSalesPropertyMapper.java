package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.ProductSalesProperty;
import org.lynn.soop.entity.ProductSalesPropertyExample;
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

public interface ProductSalesPropertyMapper {
    @DeleteProvider(type=ProductSalesPropertySqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductSalesPropertyExample example);

    @Delete({
        "delete from `product_sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product_sales_property` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`product_id`, `spv_id`, ",
        "`sp_name`, `sp_value`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{product_id,jdbcType=BIGINT}, #{spv_id,jdbcType=BIGINT}, ",
        "#{sp_name,jdbcType=VARCHAR}, #{sp_value,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductSalesProperty record);

    @InsertProvider(type=ProductSalesPropertySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProductSalesProperty record);

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

    @UpdateProvider(type=ProductSalesPropertySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductSalesProperty record, @Param("example") ProductSalesPropertyExample example);

    @UpdateProvider(type=ProductSalesPropertySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductSalesProperty record, @Param("example") ProductSalesPropertyExample example);

    @UpdateProvider(type=ProductSalesPropertySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductSalesProperty record);

    @Update({
        "update `product_sales_property`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`spv_id` = #{spv_id,jdbcType=BIGINT},",
          "`sp_name` = #{sp_name,jdbcType=VARCHAR},",
          "`sp_value` = #{sp_value,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductSalesProperty record);
}