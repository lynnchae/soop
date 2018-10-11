package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.Databasechangelog;
import org.lynn.soop.entity.DatabasechangelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface DatabasechangelogMapper {
    @SelectProvider(type=DatabasechangelogSqlProvider.class, method="countByExample")
    int countByExample(DatabasechangelogExample example);

    @SelectProvider(type=DatabasechangelogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="ID", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTHOR", property="AUTHOR", jdbcType=JdbcType.VARCHAR),
        @Result(column="FILENAME", property="FILENAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATEEXECUTED", property="DATEEXECUTED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ORDEREXECUTED", property="ORDEREXECUTED", jdbcType=JdbcType.INTEGER),
        @Result(column="EXECTYPE", property="EXECTYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="MD5SUM", property="MD5SUM", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="DESCRIPTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMENTS", property="COMMENTS", jdbcType=JdbcType.VARCHAR),
        @Result(column="TAG", property="TAG", jdbcType=JdbcType.VARCHAR),
        @Result(column="LIQUIBASE", property="LIQUIBASE", jdbcType=JdbcType.VARCHAR)
    })
    List<Databasechangelog> selectByExample(DatabasechangelogExample example);
}