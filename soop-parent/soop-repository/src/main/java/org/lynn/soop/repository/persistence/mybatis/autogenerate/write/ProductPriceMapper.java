package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.ProductPrice;
import org.lynn.soop.entity.ProductPriceExample;
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

public interface ProductPriceMapper {
    @DeleteProvider(type=ProductPriceSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductPriceExample example);

    @Delete({
        "delete from `product_price`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product_price` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`product_id`, `product_name_cn`, ",
        "`source`, `overseas_price`, ",
        "`domestic_price`, `product_price`, ",
        "`source_id`, `price_on_sale`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{product_id,jdbcType=BIGINT}, #{product_name_cn,jdbcType=VARCHAR}, ",
        "#{source,jdbcType=VARCHAR}, #{overseas_price,jdbcType=INTEGER}, ",
        "#{domestic_price,jdbcType=INTEGER}, #{product_price,jdbcType=INTEGER}, ",
        "#{source_id,jdbcType=BIGINT}, #{price_on_sale,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductPrice record);

    @InsertProvider(type=ProductPriceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProductPrice record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `product_id`, ",
        "`product_name_cn`, `source`, `overseas_price`, `domestic_price`, `product_price`, ",
        "`source_id`, `price_on_sale`",
        "from `product_price`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_name_cn", property="product_name_cn", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="overseas_price", property="overseas_price", jdbcType=JdbcType.INTEGER),
        @Result(column="domestic_price", property="domestic_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="source_id", property="source_id", jdbcType=JdbcType.BIGINT),
        @Result(column="price_on_sale", property="price_on_sale", jdbcType=JdbcType.INTEGER)
    })
    ProductPrice selectByPrimaryKey(Long id);

    @UpdateProvider(type=ProductPriceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);

    @UpdateProvider(type=ProductPriceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);

    @UpdateProvider(type=ProductPriceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductPrice record);

    @Update({
        "update `product_price`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`product_name_cn` = #{product_name_cn,jdbcType=VARCHAR},",
          "`source` = #{source,jdbcType=VARCHAR},",
          "`overseas_price` = #{overseas_price,jdbcType=INTEGER},",
          "`domestic_price` = #{domestic_price,jdbcType=INTEGER},",
          "`product_price` = #{product_price,jdbcType=INTEGER},",
          "`source_id` = #{source_id,jdbcType=BIGINT},",
          "`price_on_sale` = #{price_on_sale,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductPrice record);
}