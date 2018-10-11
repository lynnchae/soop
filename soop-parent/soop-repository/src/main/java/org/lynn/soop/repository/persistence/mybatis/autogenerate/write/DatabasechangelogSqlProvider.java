package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.Databasechangelog;
import org.lynn.soop.entity.DatabasechangelogExample.Criteria;
import org.lynn.soop.entity.DatabasechangelogExample.Criterion;
import org.lynn.soop.entity.DatabasechangelogExample;
import java.util.List;
import java.util.Map;

public class DatabasechangelogSqlProvider {

    public String deleteByExample(DatabasechangelogExample example) {
        BEGIN();
        DELETE_FROM("`databasechangelog`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Databasechangelog record) {
        BEGIN();
        INSERT_INTO("`databasechangelog`");
        
        if (record.getID() != null) {
            VALUES("`ID`", "#{ID,jdbcType=VARCHAR}");
        }
        
        if (record.getAUTHOR() != null) {
            VALUES("`AUTHOR`", "#{AUTHOR,jdbcType=VARCHAR}");
        }
        
        if (record.getFILENAME() != null) {
            VALUES("`FILENAME`", "#{FILENAME,jdbcType=VARCHAR}");
        }
        
        if (record.getDATEEXECUTED() != null) {
            VALUES("`DATEEXECUTED`", "#{DATEEXECUTED,jdbcType=TIMESTAMP}");
        }
        
        if (record.getORDEREXECUTED() != null) {
            VALUES("`ORDEREXECUTED`", "#{ORDEREXECUTED,jdbcType=INTEGER}");
        }
        
        if (record.getEXECTYPE() != null) {
            VALUES("`EXECTYPE`", "#{EXECTYPE,jdbcType=VARCHAR}");
        }
        
        if (record.getMD5SUM() != null) {
            VALUES("`MD5SUM`", "#{MD5SUM,jdbcType=VARCHAR}");
        }
        
        if (record.getDESCRIPTION() != null) {
            VALUES("`DESCRIPTION`", "#{DESCRIPTION,jdbcType=VARCHAR}");
        }
        
        if (record.getCOMMENTS() != null) {
            VALUES("`COMMENTS`", "#{COMMENTS,jdbcType=VARCHAR}");
        }
        
        if (record.getTAG() != null) {
            VALUES("`TAG`", "#{TAG,jdbcType=VARCHAR}");
        }
        
        if (record.getLIQUIBASE() != null) {
            VALUES("`LIQUIBASE`", "#{LIQUIBASE,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Databasechangelog record = (Databasechangelog) parameter.get("record");
        DatabasechangelogExample example = (DatabasechangelogExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`databasechangelog`");
        
        if (record.getID() != null) {
            SET("`ID` = #{record.ID,jdbcType=VARCHAR}");
        }
        
        if (record.getAUTHOR() != null) {
            SET("`AUTHOR` = #{record.AUTHOR,jdbcType=VARCHAR}");
        }
        
        if (record.getFILENAME() != null) {
            SET("`FILENAME` = #{record.FILENAME,jdbcType=VARCHAR}");
        }
        
        if (record.getDATEEXECUTED() != null) {
            SET("`DATEEXECUTED` = #{record.DATEEXECUTED,jdbcType=TIMESTAMP}");
        }
        
        if (record.getORDEREXECUTED() != null) {
            SET("`ORDEREXECUTED` = #{record.ORDEREXECUTED,jdbcType=INTEGER}");
        }
        
        if (record.getEXECTYPE() != null) {
            SET("`EXECTYPE` = #{record.EXECTYPE,jdbcType=VARCHAR}");
        }
        
        if (record.getMD5SUM() != null) {
            SET("`MD5SUM` = #{record.MD5SUM,jdbcType=VARCHAR}");
        }
        
        if (record.getDESCRIPTION() != null) {
            SET("`DESCRIPTION` = #{record.DESCRIPTION,jdbcType=VARCHAR}");
        }
        
        if (record.getCOMMENTS() != null) {
            SET("`COMMENTS` = #{record.COMMENTS,jdbcType=VARCHAR}");
        }
        
        if (record.getTAG() != null) {
            SET("`TAG` = #{record.TAG,jdbcType=VARCHAR}");
        }
        
        if (record.getLIQUIBASE() != null) {
            SET("`LIQUIBASE` = #{record.LIQUIBASE,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`databasechangelog`");
        
        SET("`ID` = #{record.ID,jdbcType=VARCHAR}");
        SET("`AUTHOR` = #{record.AUTHOR,jdbcType=VARCHAR}");
        SET("`FILENAME` = #{record.FILENAME,jdbcType=VARCHAR}");
        SET("`DATEEXECUTED` = #{record.DATEEXECUTED,jdbcType=TIMESTAMP}");
        SET("`ORDEREXECUTED` = #{record.ORDEREXECUTED,jdbcType=INTEGER}");
        SET("`EXECTYPE` = #{record.EXECTYPE,jdbcType=VARCHAR}");
        SET("`MD5SUM` = #{record.MD5SUM,jdbcType=VARCHAR}");
        SET("`DESCRIPTION` = #{record.DESCRIPTION,jdbcType=VARCHAR}");
        SET("`COMMENTS` = #{record.COMMENTS,jdbcType=VARCHAR}");
        SET("`TAG` = #{record.TAG,jdbcType=VARCHAR}");
        SET("`LIQUIBASE` = #{record.LIQUIBASE,jdbcType=VARCHAR}");
        
        DatabasechangelogExample example = (DatabasechangelogExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    protected void applyWhere(DatabasechangelogExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}