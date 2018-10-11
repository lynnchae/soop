package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.UsersooppingCart;
import org.lynn.soop.entity.UsersooppingCartExample;
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

public interface UsersooppingCartMapper {
    @DeleteProvider(type=UsersooppingCartSqlProvider.class, method="deleteByExample")
    int deleteByExample(UsersooppingCartExample example);

    @Delete({
        "delete from `user_soopping_cart`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `user_soopping_cart` (`date_created`, `created_by`, ",
        "`date_updated`, `updated_by`, ",
        "`user_id`, `product_id`, ",
        "`product_price`, `quantity`, ",
        "`date_expired`)",
        "values (#{date_created,jdbcType=TIMESTAMP}, #{created_by,jdbcType=VARCHAR}, ",
        "#{date_updated,jdbcType=TIMESTAMP}, #{updated_by,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=BIGINT}, #{product_id,jdbcType=BIGINT}, ",
        "#{product_price,jdbcType=INTEGER}, #{quantity,jdbcType=INTEGER}, ",
        "#{date_expired,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UsersooppingCart record);

    @InsertProvider(type=UsersooppingCartSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UsersooppingCart record);

    @Select({
        "select",
        "`id`, `date_created`, `created_by`, `date_updated`, `updated_by`, `user_id`, ",
        "`product_id`, `product_price`, `quantity`, `date_expired`",
        "from `user_soopping_cart`",
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
        @Result(column="product_price", property="product_price", jdbcType=JdbcType.INTEGER),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="date_expired", property="date_expired", jdbcType=JdbcType.TIMESTAMP)
    })
    UsersooppingCart selectByPrimaryKey(Long id);

    @UpdateProvider(type=UsersooppingCartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UsersooppingCart record, @Param("example") UsersooppingCartExample example);

    @UpdateProvider(type=UsersooppingCartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UsersooppingCart record, @Param("example") UsersooppingCartExample example);

    @UpdateProvider(type=UsersooppingCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UsersooppingCart record);

    @Update({
        "update `user_soopping_cart`",
        "set `date_created` = #{date_created,jdbcType=TIMESTAMP},",
          "`created_by` = #{created_by,jdbcType=VARCHAR},",
          "`date_updated` = #{date_updated,jdbcType=TIMESTAMP},",
          "`updated_by` = #{updated_by,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`product_id` = #{product_id,jdbcType=BIGINT},",
          "`product_price` = #{product_price,jdbcType=INTEGER},",
          "`quantity` = #{quantity,jdbcType=INTEGER},",
          "`date_expired` = #{date_expired,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UsersooppingCart record);
}