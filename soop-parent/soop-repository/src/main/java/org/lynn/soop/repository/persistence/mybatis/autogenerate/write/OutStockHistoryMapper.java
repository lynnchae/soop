package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.OutStockHistory;
import org.lynn.soop.entity.OutStockHistoryExample;
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

public interface OutStockHistoryMapper {
    @DeleteProvider(type=OutStockHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(OutStockHistoryExample example);

    @Delete({
        "delete from `out_stock_history`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `out_stock_history` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`product_id`, `quantity`, ",
        "`product_price`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{product_id,jdbcType=BIGINT}, #{quantity,jdbcType=INTEGER}, ",
        "#{product_price,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OutStockHistory record);

    @InsertProvider(type=OutStockHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OutStockHistory record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `product_id`, ",
        "`quantity`, `product_price`",
        "from `out_stock_history`",
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
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER)
    })
    OutStockHistory selectByPrimaryKey(Long id);

    @UpdateProvider(type=OutStockHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OutStockHistory record, @Param("example") OutStockHistoryExample example);

    @UpdateProvider(type=OutStockHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OutStockHistory record, @Param("example") OutStockHistoryExample example);

    @UpdateProvider(type=OutStockHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OutStockHistory record);

    @Update({
        "update `out_stock_history`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`quantity` = #{quantity,jdbcType=INTEGER},",
          "`product_price` = #{product_price,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OutStockHistory record);
}