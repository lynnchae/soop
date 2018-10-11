package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.PurchaseProductResult;
import org.lynn.soop.entity.PurchaseProductResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface PurchaseProductResultMapper {
    @SelectProvider(type=PurchaseProductResultSqlProvider.class, method="countByExample")
    int countByExample(PurchaseProductResultExample example);

    @SelectProvider(type=PurchaseProductResultSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="purchase_product_batch_id", property="purchase_product_batch_id", jdbcType=JdbcType.BIGINT),
        @Result(column="purchase_product_request", property="purchase_product_request", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_quantity", property="plan_quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_quantity", property="actual_quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_price", property="purchase_price", jdbcType=JdbcType.INTEGER),
        @Result(column="exchange_rate", property="exchange_rate", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_price_in_usd", property="purchase_price_in_usd", jdbcType=JdbcType.INTEGER)
    })
    List<PurchaseProductResult> selectByExample(PurchaseProductResultExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `purchase_product_batch_id`, ",
        "`purchase_product_request`, `product_id`, `plan_quantity`, `actual_quantity`, ",
        "`purchase_price`, `exchange_rate`, `purchase_price_in_usd`",
        "from `purchase_product_result`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="purchase_product_batch_id", property="purchase_product_batch_id", jdbcType=JdbcType.BIGINT),
        @Result(column="purchase_product_request", property="purchase_product_request", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_quantity", property="plan_quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_quantity", property="actual_quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_price", property="purchase_price", jdbcType=JdbcType.INTEGER),
        @Result(column="exchange_rate", property="exchange_rate", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_price_in_usd", property="purchase_price_in_usd", jdbcType=JdbcType.INTEGER)
    })
    PurchaseProductResult selectByPrimaryKey(Long id);
}