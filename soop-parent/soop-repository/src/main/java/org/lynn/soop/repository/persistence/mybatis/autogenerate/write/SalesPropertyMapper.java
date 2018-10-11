package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.SalesProperty;
import org.lynn.soop.entity.SalesPropertyExample;
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

public interface SalesPropertyMapper {
    @DeleteProvider(type=SalesPropertySqlProvider.class, method="deleteByExample")
    int deleteByExample(SalesPropertyExample example);

    @Delete({
        "delete from `sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `sales_property` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`sp_name`, `goods_id`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{sp_name,jdbcType=VARCHAR}, #{goods_id,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SalesProperty record);

    @InsertProvider(type=SalesPropertySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SalesProperty record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `sp_name`, ",
        "`goods_id`",
        "from `sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp_name", property="sp_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT)
    })
    SalesProperty selectByPrimaryKey(Long id);

    @UpdateProvider(type=SalesPropertySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesProperty record, @Param("example") SalesPropertyExample example);

    @UpdateProvider(type=SalesPropertySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SalesProperty record, @Param("example") SalesPropertyExample example);

    @UpdateProvider(type=SalesPropertySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SalesProperty record);

    @Update({
        "update `sales_property`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`sp_name` = #{sp_name,jdbcType=VARCHAR},",
          "`goods_id` = #{goods_id,jdbcType=BIGINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SalesProperty record);
}