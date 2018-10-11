package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.InStockHistory;
import org.lynn.soop.entity.InStockHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface InStockHistoryMapper {
    @SelectProvider(type=InStockHistorySqlProvider.class, method="countByExample")
    int countByExample(InStockHistoryExample example);

    @SelectProvider(type=InStockHistorySqlProvider.class, method="selectByExample")
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
    List<InStockHistory> selectByExample(InStockHistoryExample example);

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
}