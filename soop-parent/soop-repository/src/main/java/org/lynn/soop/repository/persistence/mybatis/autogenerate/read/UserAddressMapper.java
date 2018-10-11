package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.UserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserAddressMapper {
    @SelectProvider(type=UserAddressSqlProvider.class, method="countByExample")
    int countByExample(UserAddressExample example);

    @SelectProvider(type=UserAddressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="contact_name", property="contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contact_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_address", property="detail_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="post_code", property="post_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no_no", property="id_no_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no_scan_front", property="id_no_scan_front", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no_scan_back", property="id_no_scan_back", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_default", property="is_default", jdbcType=JdbcType.BIT),
        @Result(column="user_identify_image_id", property="user_identify_image_id", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="province_id", jdbcType=JdbcType.INTEGER)
    })
    List<UserAddress> selectByExample(UserAddressExample example);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `user_id`, ",
        "`contact_name`, `contact_phone`, `province`, `city`, `district`, `detail_address`, ",
        "`post_code`, `id_no_no`, `id_no_scan_front`, `id_no_scan_back`, `is_default`, ",
        "`user_identify_image_id`, `province_id`",
        "from `user_address`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="contact_name", property="contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contact_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_address", property="detail_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="post_code", property="post_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no_no", property="id_no_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no_scan_front", property="id_no_scan_front", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no_scan_back", property="id_no_scan_back", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_default", property="is_default", jdbcType=JdbcType.BIT),
        @Result(column="user_identify_image_id", property="user_identify_image_id", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="province_id", jdbcType=JdbcType.INTEGER)
    })
    UserAddress selectByPrimaryKey(Long id);
}