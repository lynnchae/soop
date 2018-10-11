package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.GoodsSalesProperty;
import org.lynn.soop.entity.GoodsSalesPropertyExample;
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

public interface GoodsSalesPropertyMapper {
    @DeleteProvider(type=GoodsSalesPropertySqlProvider.class, method="deleteByExample")
    int deleteByExample(GoodsSalesPropertyExample example);

    @Delete({
        "delete from `goods_sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `goods_sales_property` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`goods_id`, `sp_id`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{goods_id,jdbcType=BIGINT}, #{sp_id,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(GoodsSalesProperty record);

    @InsertProvider(type=GoodsSalesPropertySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(GoodsSalesProperty record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `goods_id`, ",
        "`sp_id`",
        "from `goods_sales_property`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goods_id", jdbcType=JdbcType.BIGINT),
        @Result(column="sp_id", property="sp_id", jdbcType=JdbcType.BIGINT)
    })
    GoodsSalesProperty selectByPrimaryKey(Long id);

    @UpdateProvider(type=GoodsSalesPropertySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GoodsSalesProperty record, @Param("example") GoodsSalesPropertyExample example);

    @UpdateProvider(type=GoodsSalesPropertySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GoodsSalesProperty record, @Param("example") GoodsSalesPropertyExample example);

    @UpdateProvider(type=GoodsSalesPropertySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsSalesProperty record);

    @Update({
        "update `goods_sales_property`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`goods_id` = #{goods_id,jdbcType=BIGINT},",
          "`sp_id` = #{sp_id,jdbcType=BIGINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GoodsSalesProperty record);
}