package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.ProductPrice;
import org.lynn.soop.entity.ProductPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductPriceMapper {
    @SelectProvider(type=ProductPriceSqlProvider.class, method="countByExample")
    int countByExample(ProductPriceExample example);

    @SelectProvider(type=ProductPriceSqlProvider.class, method="selectByExample")
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
    List<ProductPrice> selectByExample(ProductPriceExample example);

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
}