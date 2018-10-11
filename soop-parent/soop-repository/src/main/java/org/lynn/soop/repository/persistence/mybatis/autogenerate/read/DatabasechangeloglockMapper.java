package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.Databasechangeloglock;
import org.lynn.soop.entity.DatabasechangeloglockExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface DatabasechangeloglockMapper {
    @SelectProvider(type=DatabasechangeloglockSqlProvider.class, method="countByExample")
    int countByExample(DatabasechangeloglockExample example);

    @SelectProvider(type=DatabasechangeloglockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="ID", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="LOCKED", property="LOCKED", jdbcType=JdbcType.BIT),
        @Result(column="LOCKGRANTED", property="LOCKGRANTED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOCKEDBY", property="LOCKEDBY", jdbcType=JdbcType.VARCHAR)
    })
    List<Databasechangeloglock> selectByExample(DatabasechangeloglockExample example);

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
}