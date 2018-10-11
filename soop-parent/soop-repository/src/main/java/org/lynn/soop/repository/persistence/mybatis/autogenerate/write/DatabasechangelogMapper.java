package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import org.lynn.soop.entity.Databasechangelog;
import org.lynn.soop.entity.DatabasechangelogExample;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

public interface DatabasechangelogMapper {
    @DeleteProvider(type=DatabasechangelogSqlProvider.class, method="deleteByExample")
    int deleteByExample(DatabasechangelogExample example);

    @Insert({
        "insert into `databasechangelog` (`ID`, `AUTHOR`, ",
        "`FILENAME`, `DATEEXECUTED`, ",
        "`ORDEREXECUTED`, `EXECTYPE`, ",
        "`MD5SUM`, `DESCRIPTION`, ",
        "`COMMENTS`, `TAG`, `LIQUIBASE`)",
        "values (#{ID,jdbcType=VARCHAR}, #{AUTHOR,jdbcType=VARCHAR}, ",
        "#{FILENAME,jdbcType=VARCHAR}, #{DATEEXECUTED,jdbcType=TIMESTAMP}, ",
        "#{ORDEREXECUTED,jdbcType=INTEGER}, #{EXECTYPE,jdbcType=VARCHAR}, ",
        "#{MD5SUM,jdbcType=VARCHAR}, #{DESCRIPTION,jdbcType=VARCHAR}, ",
        "#{COMMENTS,jdbcType=VARCHAR}, #{TAG,jdbcType=VARCHAR}, #{LIQUIBASE,jdbcType=VARCHAR})"
    })
    int insert(Databasechangelog record);

    @InsertProvider(type=DatabasechangelogSqlProvider.class, method="insertSelective")
    int insertSelective(Databasechangelog record);

    @UpdateProvider(type=DatabasechangelogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Databasechangelog record, @Param("example") DatabasechangelogExample example);

    @UpdateProvider(type=DatabasechangelogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Databasechangelog record, @Param("example") DatabasechangelogExample example);
}