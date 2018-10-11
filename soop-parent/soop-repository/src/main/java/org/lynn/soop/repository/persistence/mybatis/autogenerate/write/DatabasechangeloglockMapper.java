package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.Databasechangeloglock;
import org.lynn.soop.entity.DatabasechangeloglockExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DatabasechangeloglockMapper {
    @DeleteProvider(type=DatabasechangeloglockSqlProvider.class, method="deleteByExample")
    int deleteByExample(DatabasechangeloglockExample example);

    @Delete({
        "delete from `databasechangeloglock`",
        "where `ID` = #{ID,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ID);

    @Insert({
        "insert into `databasechangeloglock` (`ID`, `LOCKED`, ",
        "`LOCKGRANTED`, `LOCKEDBY`)",
        "values (#{ID,jdbcType=INTEGER}, #{LOCKED,jdbcType=BIT}, ",
        "#{LOCKGRANTED,jdbcType=TIMESTAMP}, #{LOCKEDBY,jdbcType=VARCHAR})"
    })
    int insert(Databasechangeloglock record);

    @InsertProvider(type=DatabasechangeloglockSqlProvider.class, method="insertSelective")
    int insertSelective(Databasechangeloglock record);

    @Select({
        "select",
        "`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`",
        "from `databasechangeloglock`",
        "where `ID` = #{ID,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="ID", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="LOCKED", property="LOCKED", jdbcType=JdbcType.BIT),
        @Result(column="LOCKGRANTED", property="LOCKGRANTED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOCKEDBY", property="LOCKEDBY", jdbcType=JdbcType.VARCHAR)
    })
    Databasechangeloglock selectByPrimaryKey(Integer ID);

    @UpdateProvider(type=DatabasechangeloglockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Databasechangeloglock record, @Param("example") DatabasechangeloglockExample example);

    @UpdateProvider(type=DatabasechangeloglockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Databasechangeloglock record, @Param("example") DatabasechangeloglockExample example);

    @UpdateProvider(type=DatabasechangeloglockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Databasechangeloglock record);

    @Update({
        "update `databasechangeloglock`",
        "set `LOCKED` = #{LOCKED,jdbcType=BIT},",
          "`LOCKGRANTED` = #{LOCKGRANTED,jdbcType=TIMESTAMP},",
          "`LOCKEDBY` = #{LOCKEDBY,jdbcType=VARCHAR}",
        "where `ID` = #{ID,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Databasechangeloglock record);
}