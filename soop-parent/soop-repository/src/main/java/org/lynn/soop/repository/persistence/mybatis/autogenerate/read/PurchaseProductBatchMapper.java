package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.PurchaseProductBatch;
import org.lynn.soop.entity.PurchaseProductBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface PurchaseProductBatchMapper {
    @SelectProvider(type=PurchaseProductBatchSqlProvider.class, method="countByExample")
    int countByExample(PurchaseProductBatchExample example);

    @SelectProvider(type=PurchaseProductBatchSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="purchase_product_batch_id", property="purchase_product_batch_id", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_product_count", property="plan_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_product_count", property="actual_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_total_item_count", property="plan_total_item_count", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_total_item_count", property="actual_total_item_count", jdbcType=JdbcType.INTEGER),
        @Result(column="progress_percentage", property="progress_percentage", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_time", property="purchase_time", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="start_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="end_time", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PurchaseProductBatch> selectByExample(PurchaseProductBatchExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `purchase_product_batch_id`, ",
        "`plan_product_count`, `actual_product_count`, `plan_total_item_count`, `actual_total_item_count`, ",
        "`progress_percentage`, `purchase_time`, `start_time`, `end_time`",
        "from `purchase_product_batch`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="purchase_product_batch_id", property="purchase_product_batch_id", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_product_count", property="plan_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_product_count", property="actual_product_count", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_total_item_count", property="plan_total_item_count", jdbcType=JdbcType.INTEGER),
        @Result(column="actual_total_item_count", property="actual_total_item_count", jdbcType=JdbcType.INTEGER),
        @Result(column="progress_percentage", property="progress_percentage", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_time", property="purchase_time", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="start_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="end_time", jdbcType=JdbcType.TIMESTAMP)
    })
    PurchaseProductBatch selectByPrimaryKey(Long id);
}