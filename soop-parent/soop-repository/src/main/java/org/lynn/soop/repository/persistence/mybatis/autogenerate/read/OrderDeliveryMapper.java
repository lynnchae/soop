package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.OrderDelivery;
import org.lynn.soop.entity.OrderDeliveryExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderDeliveryMapper {
    @SelectProvider(type=OrderDeliverySqlProvider.class, method="countByExample")
    int countByExample(OrderDeliveryExample example);

    @SelectProvider(type=OrderDeliverySqlProvider.class, method="selectByExampleWithBLOBs")
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
    List<OrderDelivery> selectByExampleWithBLOBs(OrderDeliveryExample example);

    @SelectProvider(type=OrderDeliverySqlProvider.class, method="selectByExample")
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
        @Result(column="batch_no", property="batch_no", jdbcType=JdbcType.VARCHAR)
    })
    List<OrderDelivery> selectByExample(OrderDeliveryExample example);

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
}