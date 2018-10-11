package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.PayDetail;
import org.lynn.soop.entity.PayDetailExample;
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

public interface PayDetailMapper {
    @DeleteProvider(type=PayDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(PayDetailExample example);

    @Delete({
        "delete from `pay_detail`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `pay_detail` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`order_id`, `inner_order_no`, ",
        "`product_name`, `amount`, ",
        "`pay_channel`, `status`, ",
        "`request`, `response`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{order_id,jdbcType=CHAR}, #{inner_order_no,jdbcType=VARCHAR}, ",
        "#{product_name,jdbcType=VARCHAR}, #{amount,jdbcType=INTEGER}, ",
        "#{pay_channel,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{request,jdbcType=LONGVARCHAR}, #{response,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PayDetail record);

    @InsertProvider(type=PayDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PayDetail record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `order_id`, ",
        "`inner_order_no`, `product_name`, `amount`, `pay_channel`, `status`, `request`, ",
        "`response`",
        "from `pay_detail`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="inner_order_no", property="inner_order_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="pay_channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="request", property="request", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="response", property="response", jdbcType=JdbcType.LONGVARCHAR)
    })
    PayDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=PayDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PayDetail record, @Param("example") PayDetailExample example);

    @UpdateProvider(type=PayDetailSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PayDetail record, @Param("example") PayDetailExample example);

    @UpdateProvider(type=PayDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PayDetail record, @Param("example") PayDetailExample example);

    @UpdateProvider(type=PayDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PayDetail record);

    @Update({
        "update `pay_detail`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`order_id` = #{order_id,jdbcType=CHAR},",
          "`inner_order_no` = #{inner_order_no,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`amount` = #{amount,jdbcType=INTEGER},",
          "`pay_channel` = #{pay_channel,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`request` = #{request,jdbcType=LONGVARCHAR},",
          "`response` = #{response,jdbcType=LONGVARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(PayDetail record);

    @Update({
        "update `pay_detail`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`order_id` = #{order_id,jdbcType=CHAR},",
          "`inner_order_no` = #{inner_order_no,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`amount` = #{amount,jdbcType=INTEGER},",
          "`pay_channel` = #{pay_channel,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PayDetail record);
}