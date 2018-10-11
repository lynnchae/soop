package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.PurchaseProductRequest;
import org.lynn.soop.entity.PurchaseProductRequestExample;
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

public interface PurchaseProductRequestMapper {
    @DeleteProvider(type=PurchaseProductRequestSqlProvider.class, method="deleteByExample")
    int deleteByExample(PurchaseProductRequestExample example);

    @Delete({
        "delete from `purchase_product_request`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `purchase_product_request` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`product_id`, `plan_quantity`, ",
        "`actual_quantity`, `purchase_product_batch_id`, ",
        "`purchase_time`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{product_id,jdbcType=BIGINT}, #{plan_quantity,jdbcType=INTEGER}, ",
        "#{actual_quantity,jdbcType=INTEGER}, #{purchase_product_batch_id,jdbcType=BIGINT}, ",
        "#{purchase_time,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PurchaseProductRequest record);

    @InsertProvider(type=PurchaseProductRequestSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PurchaseProductRequest record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `product_id`, ",
        "`plan_quantity`, `actual_quantity`, `purchase_product_batch_id`, `purchase_time`",
        "from `purchase_product_request`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_quantity", property="plan_quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_quantity", property="actual_quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_product_batch_id", property="purchase_product_batch_id", jdbcType=JdbcType.BIGINT),
        @Result(column="purchase_time", property="purchase_time", jdbcType=JdbcType.INTEGER)
    })
    PurchaseProductRequest selectByPrimaryKey(Long id);

    @UpdateProvider(type=PurchaseProductRequestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchaseProductRequest record, @Param("example") PurchaseProductRequestExample example);

    @UpdateProvider(type=PurchaseProductRequestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PurchaseProductRequest record, @Param("example") PurchaseProductRequestExample example);

    @UpdateProvider(type=PurchaseProductRequestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PurchaseProductRequest record);

    @Update({
        "update `purchase_product_request`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`plan_quantity` = #{plan_quantity,jdbcType=INTEGER},",
          "`actual_quantity` = #{actual_quantity,jdbcType=INTEGER},",
          "`purchase_product_batch_id` = #{purchase_product_batch_id,jdbcType=BIGINT},",
          "`purchase_time` = #{purchase_time,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PurchaseProductRequest record);
}