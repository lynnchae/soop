package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.Databasechangeloglock;
import org.lynn.soop.entity.DatabasechangeloglockExample.Criteria;
import org.lynn.soop.entity.DatabasechangeloglockExample.Criterion;
import org.lynn.soop.entity.DatabasechangeloglockExample;
import java.util.List;
import java.util.Map;

public class DatabasechangeloglockSqlProvider {

    public String deleteByExample(DatabasechangeloglockExample example) {
        BEGIN();
        DELETE_FROM("`databasechangeloglock`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Databasechangeloglock record) {
        BEGIN();
        INSERT_INTO("`databasechangeloglock`");
        
        if (record.getID() != null) {
            VALUES("`ID`", "#{ID,jdbcType=INTEGER}");
        }
        
        if (record.getLOCKED() != null) {
            VALUES("`LOCKED`", "#{LOCKED,jdbcType=BIT}");
        }
        
        if (record.getLOCKGRANTED() != null) {
            VALUES("`LOCKGRANTED`", "#{LOCKGRANTED,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLOCKEDBY() != null) {
            VALUES("`LOCKEDBY`", "#{LOCKEDBY,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Databasechangeloglock record = (Databasechangeloglock) parameter.get("record");
        DatabasechangeloglockExample example = (DatabasechangeloglockExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`databasechangeloglock`");
        
        if (record.getID() != null) {
            SET("`ID` = #{record.ID,jdbcType=INTEGER}");
        }
        
        if (record.getLOCKED() != null) {
            SET("`LOCKED` = #{record.LOCKED,jdbcType=BIT}");
        }
        
        if (record.getLOCKGRANTED() != null) {
            SET("`LOCKGRANTED` = #{record.LOCKGRANTED,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLOCKEDBY() != null) {
            SET("`LOCKEDBY` = #{record.LOCKEDBY,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`databasechangeloglock`");
        
        SET("`ID` = #{record.ID,jdbcType=INTEGER}");
        SET("`LOCKED` = #{record.LOCKED,jdbcType=BIT}");
        SET("`LOCKGRANTED` = #{record.LOCKGRANTED,jdbcType=TIMESTAMP}");
        SET("`LOCKEDBY` = #{record.LOCKEDBY,jdbcType=VARCHAR}");
        
        DatabasechangeloglockExample example = (DatabasechangeloglockExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Databasechangeloglock record) {
        BEGIN();
        UPDATE("`databasechangeloglock`");
        
        if (record.getLOCKED() != null) {
            SET("`LOCKED` = #{LOCKED,jdbcType=BIT}");
        }
        
        if (record.getLOCKGRANTED() != null) {
            SET("`LOCKGRANTED` = #{LOCKGRANTED,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLOCKEDBY() != null) {
            SET("`LOCKEDBY` = #{LOCKEDBY,jdbcType=VARCHAR}");
        }
        
        WHERE("`ID` = #{ID,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(DatabasechangeloglockExample example, boolean includeExamplePhrase) {
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