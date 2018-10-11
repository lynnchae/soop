package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.OrderDelivery;
import org.lynn.soop.entity.OrderDeliveryExample;
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

public interface OrderDeliveryMapper {
    @DeleteProvider(type=OrderDeliverySqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderDeliveryExample example);

    @Delete({
        "delete from `order_delivery`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `order_delivery` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`source_delivery_route`, `order_id`, ",
        "`delivery_address`, `delivery_post_code`, ",
        "`delivery_contact_name`, `delivery_contact_phone`, ",
        "`status`, `delivery_order_no`, ",
        "`delivery_company`, `batch_id`, ",
        "`product_info`, `delivery_fee`, ",
        "`batch_no`, `delivery_detail_status_list`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{source_delivery_route,jdbcType=VARCHAR}, #{order_id,jdbcType=CHAR}, ",
        "#{delivery_address,jdbcType=VARCHAR}, #{delivery_post_code,jdbcType=VARCHAR}, ",
        "#{delivery_contact_name,jdbcType=VARCHAR}, #{delivery_contact_phone,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{delivery_order_no,jdbcType=VARCHAR}, ",
        "#{delivery_company,jdbcType=VARCHAR}, #{batch_id,jdbcType=VARCHAR}, ",
        "#{product_info,jdbcType=VARCHAR}, #{delivery_fee,jdbcType=INTEGER}, ",
        "#{batch_no,jdbcType=VARCHAR}, #{delivery_detail_status_list,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderDelivery record);

    @InsertProvider(type=OrderDeliverySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OrderDelivery record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `source_delivery_route`, ",
        "`order_id`, `delivery_address`, `delivery_post_code`, `delivery_contact_name`, ",
        "`delivery_contact_phone`, `status`, `delivery_order_no`, `delivery_company`, ",
        "`batch_id`, `product_info`, `delivery_fee`, `batch_no`, `delivery_detail_status_list`",
        "from `order_delivery`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_delivery_route", property="source_delivery_route", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.CHAR),
        @Result(column="delivery_address", property="delivery_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_post_code", property="delivery_post_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_contact_name", property="delivery_contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_contact_phone", property="delivery_contact_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_order_no", property="delivery_order_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_company", property="delivery_company", jdbcType=JdbcType.VARCHAR),
        @Result(column="batch_id", property="batch_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_info", property="product_info", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_fee", property="delivery_fee", jdbcType=JdbcType.INTEGER),
        @Result(column="batch_no", property="batch_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_detail_status_list", property="delivery_detail_status_list", jdbcType=JdbcType.LONGVARCHAR)
    })
    OrderDelivery selectByPrimaryKey(Long id);

    @UpdateProvider(type=OrderDeliverySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderDelivery record, @Param("example") OrderDeliveryExample example);

    @UpdateProvider(type=OrderDeliverySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OrderDelivery record, @Param("example") OrderDeliveryExample example);

    @UpdateProvider(type=OrderDeliverySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderDelivery record, @Param("example") OrderDeliveryExample example);

    @UpdateProvider(type=OrderDeliverySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderDelivery record);

    @Update({
        "update `order_delivery`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`source_delivery_route` = #{source_delivery_route,jdbcType=VARCHAR},",
          "`order_id` = #{order_id,jdbcType=CHAR},",
          "`delivery_address` = #{delivery_address,jdbcType=VARCHAR},",
          "`delivery_post_code` = #{delivery_post_code,jdbcType=VARCHAR},",
          "`delivery_contact_name` = #{delivery_contact_name,jdbcType=VARCHAR},",
          "`delivery_contact_phone` = #{delivery_contact_phone,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`delivery_order_no` = #{delivery_order_no,jdbcType=VARCHAR},",
          "`delivery_company` = #{delivery_company,jdbcType=VARCHAR},",
          "`batch_id` = #{batch_id,jdbcType=VARCHAR},",
          "`product_info` = #{product_info,jdbcType=VARCHAR},",
          "`delivery_fee` = #{delivery_fee,jdbcType=INTEGER},",
          "`batch_no` = #{batch_no,jdbcType=VARCHAR},",
          "`delivery_detail_status_list` = #{delivery_detail_status_list,jdbcType=LONGVARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OrderDelivery record);

    @Update({
        "update `order_delivery`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`source_delivery_route` = #{source_delivery_route,jdbcType=VARCHAR},",
          "`order_id` = #{order_id,jdbcType=CHAR},",
          "`delivery_address` = #{delivery_address,jdbcType=VARCHAR},",
          "`delivery_post_code` = #{delivery_post_code,jdbcType=VARCHAR},",
          "`delivery_contact_name` = #{delivery_contact_name,jdbcType=VARCHAR},",
          "`delivery_contact_phone` = #{delivery_contact_phone,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`delivery_order_no` = #{delivery_order_no,jdbcType=VARCHAR},",
          "`delivery_company` = #{delivery_company,jdbcType=VARCHAR},",
          "`batch_id` = #{batch_id,jdbcType=VARCHAR},",
          "`product_info` = #{product_info,jdbcType=VARCHAR},",
          "`delivery_fee` = #{delivery_fee,jdbcType=INTEGER},",
          "`batch_no` = #{batch_no,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderDelivery record);
}