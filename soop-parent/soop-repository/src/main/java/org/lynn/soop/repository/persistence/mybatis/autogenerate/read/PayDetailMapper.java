package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.PayDetail;
import org.lynn.soop.entity.PayDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface PayDetailMapper {
    @SelectProvider(type=PayDetailSqlProvider.class, method="countByExample")
    int countByExample(PayDetailExample example);

    @SelectProvider(type=PayDetailSqlProvider.class, method="selectByExampleWithBLOBs")
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
    List<PayDetail> selectByExampleWithBLOBs(PayDetailExample example);

    @SelectProvider(type=PayDetailSqlProvider.class, method="selectByExample")
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
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<PayDetail> selectByExample(PayDetailExample example);

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
}