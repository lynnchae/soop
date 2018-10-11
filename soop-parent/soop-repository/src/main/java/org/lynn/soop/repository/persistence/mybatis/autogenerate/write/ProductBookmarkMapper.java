package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.ProductBookmark;
import org.lynn.soop.entity.ProductBookmarkExample;
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

public interface ProductBookmarkMapper {
    @DeleteProvider(type=ProductBookmarkSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductBookmarkExample example);

    @Delete({
        "delete from `product_bookmark`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `product_bookmark` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`user_id`, `product_id`, ",
        "`product_name`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=BIGINT}, #{product_id,jdbcType=BIGINT}, ",
        "#{product_name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProductBookmark record);

    @InsertProvider(type=ProductBookmarkSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProductBookmark record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `user_id`, ",
        "`product_id`, `product_name`",
        "from `product_bookmark`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date_created", property="date_created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="created_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="date_updated", property="date_updated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updated_by", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.BIGINT),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR)
    })
    ProductBookmark selectByPrimaryKey(Long id);

    @UpdateProvider(type=ProductBookmarkSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductBookmark record, @Param("example") ProductBookmarkExample example);

    @UpdateProvider(type=ProductBookmarkSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductBookmark record, @Param("example") ProductBookmarkExample example);

    @UpdateProvider(type=ProductBookmarkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductBookmark record);

    @Update({
        "update `product_bookmark`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`product_name` = #{product_name,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductBookmark record);
}