package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.OrderProductList;
import org.lynn.soop.entity.OrderProductListExample;
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

public interface OrderProductListMapper {
    @DeleteProvider(type=OrderProductListSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderProductListExample example);

    @Delete({
        "delete from `order_product_list`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `order_product_list` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`order_id`, `product_id`, ",
        "`product_price`, `product_name`, ",
        "`quantity`, `purchase_status`, ",
        "`order_status`, `pay_complete_time`, ",
        "`purchase_complete_time`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{order_id,jdbcType=CHAR}, #{product_id,jdbcType=BIGINT}, ",
        "#{product_price,jdbcType=INTEGER}, #{product_name,jdbcType=VARCHAR}, ",
        "#{quantity,jdbcType=INTEGER}, #{purchase_status,jdbcType=VARCHAR}, ",
        "#{order_status,jdbcType=VARCHAR}, #{pay_complete_time,jdbcType=TIMESTAMP}, ",
        "#{purchase_complete_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderProductList record);

    @InsertProvider(type=OrderProductListSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OrderProductList record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `order_id`, ",
        "`product_id`, `product_price`, `product_name`, `quantity`, `purchase_status`, ",
        "`order_status`, `pay_complete_time`, `purchase_complete_time`",
        "from `order_product_list`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="purchase_status", property="purchase_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_complete_time", property="pay_complete_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="purchase_complete_time", property="purchase_complete_time", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderProductList selectByPrimaryKey(Long id);

    @UpdateProvider(type=OrderProductListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderProductList record, @Param("example") OrderProductListExample example);

    @UpdateProvider(type=OrderProductListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderProductList record, @Param("example") OrderProductListExample example);

    @UpdateProvider(type=OrderProductListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderProductList record);

    @Update({
        "update `order_product_list`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`order_id` = #{order_id,jdbcType=CHAR},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`product_price` = #{product_price,jdbcType=INTEGER},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`quantity` = #{quantity,jdbcType=INTEGER},",
          "`purchase_status` = #{purchase_status,jdbcType=VARCHAR},",
          "`order_status` = #{order_status,jdbcType=VARCHAR},",
          "`pay_complete_time` = #{pay_complete_time,jdbcType=TIMESTAMP},",
          "`purchase_complete_time` = #{purchase_complete_time,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderProductList record);
}