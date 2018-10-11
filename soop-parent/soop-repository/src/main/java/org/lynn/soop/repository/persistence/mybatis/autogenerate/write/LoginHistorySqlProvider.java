package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.LoginHistory;
import org.lynn.soop.entity.LoginHistoryExample.Criteria;
import org.lynn.soop.entity.LoginHistoryExample.Criterion;
import org.lynn.soop.entity.LoginHistoryExample;
import java.util.List;
import java.util.Map;

public class LoginHistorySqlProvider {

    public String deleteByExample(LoginHistoryExample example) {
        BEGIN();
        DELETE_FROM("`login_history`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(LoginHistory record) {
        BEGIN();
        INSERT_INTO("`login_history`");
        
        if (record.getDate_created() != null) {
            VALUES("`date_created`", "#{date_created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated_by() != null) {
            VALUES("`created_by`", "#{created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getDate_updated() != null) {
            VALUES("`date_updated`", "#{date_updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_by() != null) {
            VALUES("`updated_by`", "#{updated_by,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_name() != null) {
            VALUES("`login_name`", "#{login_name,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_ip() != null) {
            VALUES("`login_ip`", "#{login_ip,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_success() != null) {
            VALUES("`is_success`", "#{is_success,jdbcType=BIT}");
        }
        
        if (record.getError_message() != null) {
            VALUES("`error_message`", "#{error_message,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        LoginHistory record = (LoginHistory) parameter.get("record");
        LoginHistoryExample example = (LoginHistoryExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`login_history`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getDate_created() != null) {
            SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated_by() != null) {
            SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getDate_updated() != null) {
            SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_by() != null) {
            SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_name() != null) {
            SET("`login_name` = #{record.login_name,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_ip() != null) {
            SET("`login_ip` = #{record.login_ip,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_success() != null) {
            SET("`is_success` = #{record.is_success,jdbcType=BIT}");
        }
        
        if (record.getError_message() != null) {
            SET("`error_message` = #{record.error_message,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`login_history`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`user_id` = #{record.user_id,jdbcType=BIGINT}");
        SET("`login_name` = #{record.login_name,jdbcType=BIGINT}");
        SET("`login_ip` = #{record.login_ip,jdbcType=VARCHAR}");
        SET("`is_success` = #{record.is_success,jdbcType=BIT}");
        SET("`error_message` = #{record.error_message,jdbcType=VARCHAR}");
        
        LoginHistoryExample example = (LoginHistoryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(LoginHistory record) {
        BEGIN();
        UPDATE("`login_history`");
        
        if (record.getDate_created() != null) {
            SET("`date_created` = #{date_created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated_by() != null) {
            SET("`created_by` = #{created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getDate_updated() != null) {
            SET("`date_updated` = #{date_updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_by() != null) {
            SET("`updated_by` = #{updated_by,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_name() != null) {
            SET("`login_name` = #{login_name,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_ip() != null) {
            SET("`login_ip` = #{login_ip,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_success() != null) {
            SET("`is_success` = #{is_success,jdbcType=BIT}");
        }
        
        if (record.getError_message() != null) {
            SET("`error_message` = #{error_message,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(LoginHistoryExample example, boolean includeExamplePhrase) {
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