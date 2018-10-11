package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.PurchaseProductBatch;
import org.lynn.soop.entity.PurchaseProductBatchExample;
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

public interface PurchaseProductBatchMapper {
    @DeleteProvider(type=PurchaseProductBatchSqlProvider.class, method="deleteByExample")
    int deleteByExample(PurchaseProductBatchExample example);

    @Delete({
        "delete from `purchase_product_batch`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `purchase_product_batch` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`purchase_product_batch_id`, `plan_product_count`, ",
        "`actual_product_count`, `plan_total_item_count`, ",
        "`actual_total_item_count`, `progress_percentage`, ",
        "`purchase_time`, `start_time`, ",
        "`end_time`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{purchase_product_batch_id,jdbcType=BIGINT}, #{plan_product_count,jdbcType=INTEGER}, ",
        "#{actual_product_count,jdbcType=INTEGER}, #{plan_total_item_count,jdbcType=INTEGER}, ",
        "#{actual_total_item_count,jdbcType=INTEGER}, #{progress_percentage,jdbcType=INTEGER}, ",
        "#{purchase_time,jdbcType=INTEGER}, #{start_time,jdbcType=TIMESTAMP}, ",
        "#{end_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PurchaseProductBatch record);

    @InsertProvider(type=PurchaseProductBatchSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PurchaseProductBatch record);

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

    @UpdateProvider(type=PurchaseProductBatchSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchaseProductBatch record, @Param("example") PurchaseProductBatchExample example);

    @UpdateProvider(type=PurchaseProductBatchSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PurchaseProductBatch record, @Param("example") PurchaseProductBatchExample example);

    @UpdateProvider(type=PurchaseProductBatchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PurchaseProductBatch record);

    @Update({
        "update `purchase_product_batch`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`purchase_product_batch_id` = #{purchase_product_batch_id,jdbcType=BIGINT},",
          "`plan_product_count` = #{plan_product_count,jdbcType=INTEGER},",
          "`actual_product_count` = #{actual_product_count,jdbcType=INTEGER},",
          "`plan_total_item_count` = #{plan_total_item_count,jdbcType=INTEGER},",
          "`actual_total_item_count` = #{actual_total_item_count,jdbcType=INTEGER},",
          "`progress_percentage` = #{progress_percentage,jdbcType=INTEGER},",
          "`purchase_time` = #{purchase_time,jdbcType=INTEGER},",
          "`start_time` = #{start_time,jdbcType=TIMESTAMP},",
          "`end_time` = #{end_time,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PurchaseProductBatch record);
}