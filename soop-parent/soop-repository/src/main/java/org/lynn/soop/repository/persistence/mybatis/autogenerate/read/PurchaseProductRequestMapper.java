package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.PurchaseProductRequest;
import org.lynn.soop.entity.PurchaseProductRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface PurchaseProductRequestMapper {
    @SelectProvider(type=PurchaseProductRequestSqlProvider.class, method="countByExample")
    int countByExample(PurchaseProductRequestExample example);

    @SelectProvider(type=PurchaseProductRequestSqlProvider.class, method="selectByExample")
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
    List<PurchaseProductRequest> selectByExample(PurchaseProductRequestExample example);

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
}