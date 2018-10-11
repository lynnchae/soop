package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.InStockHistory;
import org.lynn.soop.entity.InStockHistoryExample;
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

public interface InStockHistoryMapper {
    @DeleteProvider(type=InStockHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(InStockHistoryExample example);

    @Delete({
        "delete from `in_stock_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `in_stock_history` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`product_id`, `quantity`, ",
        "`purchase_time`, `purchase_price`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{product_id,jdbcType=BIGINT}, #{quantity,jdbcType=INTEGER}, ",
        "#{purchase_time,jdbcType=TIMESTAMP}, #{purchase_price,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(InStockHistory record);

    @InsertProvider(type=InStockHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(InStockHistory record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `product_id`, ",
        "`quantity`, `purchase_time`, `purchase_price`",
        "from `in_stock_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_time", property="purchase_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="purchase_price", property="purchase_price", jdbcType=JdbcType.INTEGER)
    })
    InStockHistory selectByPrimaryKey(Long id);

    @UpdateProvider(type=InStockHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InStockHistory record, @Param("example") InStockHistoryExample example);

    @UpdateProvider(type=InStockHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InStockHistory record, @Param("example") InStockHistoryExample example);

    @UpdateProvider(type=InStockHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InStockHistory record);

    @Update({
        "update `in_stock_history`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`quantity` = #{quantity,jdbcType=INTEGER},",
          "`purchase_time` = #{purchase_time,jdbcType=TIMESTAMP},",
          "`purchase_price` = #{purchase_price,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(InStockHistory record);
}