package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.UserAddressExample;
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

public interface UserAddressMapper {
    @DeleteProvider(type=UserAddressSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserAddressExample example);

    @Delete({
        "delete from `user_address`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `user_address` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`user_id`, `contact_name`, ",
        "`contact_phone`, `province`, ",
        "`city`, `district`, ",
        "`detail_address`, `post_code`, ",
        "`id_no_no`, `id_no_scan_front`, ",
        "`id_no_scan_back`, `is_default`, ",
        "`user_identify_image_id`, `province_id`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=BIGINT}, #{contact_name,jdbcType=VARCHAR}, ",
        "#{contact_phone,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{detail_address,jdbcType=VARCHAR}, #{post_code,jdbcType=VARCHAR}, ",
        "#{id_no_no,jdbcType=VARCHAR}, #{id_no_scan_front,jdbcType=VARCHAR}, ",
        "#{id_no_scan_back,jdbcType=VARCHAR}, #{is_default,jdbcType=BIT}, ",
        "#{user_identify_image_id,jdbcType=BIGINT}, #{province_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserAddress record);

    @InsertProvider(type=UserAddressSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserAddress record);

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

    @UpdateProvider(type=UserAddressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    @UpdateProvider(type=UserAddressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    @UpdateProvider(type=UserAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAddress record);

    @Update({
        "update `user_address`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`contact_name` = #{contact_name,jdbcType=VARCHAR},",
          "`contact_phone` = #{contact_phone,jdbcType=VARCHAR},",
          "`province` = #{province,jdbcType=VARCHAR},",
          "`city` = #{city,jdbcType=VARCHAR},",
          "`district` = #{district,jdbcType=VARCHAR},",
          "`detail_address` = #{detail_address,jdbcType=VARCHAR},",
          "`post_code` = #{post_code,jdbcType=VARCHAR},",
          "`id_no_no` = #{id_no_no,jdbcType=VARCHAR},",
          "`id_no_scan_front` = #{id_no_scan_front,jdbcType=VARCHAR},",
          "`id_no_scan_back` = #{id_no_scan_back,jdbcType=VARCHAR},",
          "`is_default` = #{is_default,jdbcType=BIT},",
          "`user_identify_image_id` = #{user_identify_image_id,jdbcType=BIGINT},",
          "`province_id` = #{province_id,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserAddress record);
}