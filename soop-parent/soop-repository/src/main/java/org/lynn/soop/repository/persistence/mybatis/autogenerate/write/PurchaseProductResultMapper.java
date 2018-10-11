package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.PurchaseProductResult;
import org.lynn.soop.entity.PurchaseProductResultExample;
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

public interface PurchaseProductResultMapper {
    @DeleteProvider(type=PurchaseProductResultSqlProvider.class, method="deleteByExample")
    int deleteByExample(PurchaseProductResultExample example);

    @Delete({
        "delete from `purchase_product_result`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `purchase_product_result` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`purchase_product_batch_id`, `purchase_product_request`, ",
        "`product_id`, `plan_quantity`, ",
        "`actual_quantity`, `purchase_price`, ",
        "`exchange_rate`, `purchase_price_in_usd`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{purchase_product_batch_id,jdbcType=BIGINT}, #{purchase_product_request,jdbcType=BIGINT}, ",
        "#{product_id,jdbcType=BIGINT}, #{plan_quantity,jdbcType=INTEGER}, ",
        "#{actual_quantity,jdbcType=INTEGER}, #{purchase_price,jdbcType=INTEGER}, ",
        "#{exchange_rate,jdbcType=INTEGER}, #{purchase_price_in_usd,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PurchaseProductResult record);

    @InsertProvider(type=PurchaseProductResultSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PurchaseProductResult record);

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

    @UpdateProvider(type=PurchaseProductResultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchaseProductResult record, @Param("example") PurchaseProductResultExample example);

    @UpdateProvider(type=PurchaseProductResultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PurchaseProductResult record, @Param("example") PurchaseProductResultExample example);

    @UpdateProvider(type=PurchaseProductResultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PurchaseProductResult record);

    @Update({
        "update `purchase_product_result`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`purchase_product_batch_id` = #{purchase_product_batch_id,jdbcType=BIGINT},",
          "`purchase_product_request` = #{purchase_product_request,jdbcType=BIGINT},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`plan_quantity` = #{plan_quantity,jdbcType=INTEGER},",
          "`actual_quantity` = #{actual_quantity,jdbcType=INTEGER},",
          "`purchase_price` = #{purchase_price,jdbcType=INTEGER},",
          "`exchange_rate` = #{exchange_rate,jdbcType=INTEGER},",
          "`purchase_price_in_usd` = #{purchase_price_in_usd,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PurchaseProductResult record);
}