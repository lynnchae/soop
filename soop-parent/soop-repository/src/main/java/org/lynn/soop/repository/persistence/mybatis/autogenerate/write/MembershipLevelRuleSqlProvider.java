package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.MembershipLevelRule;
import org.lynn.soop.entity.MembershipLevelRuleExample.Criteria;
import org.lynn.soop.entity.MembershipLevelRuleExample.Criterion;
import org.lynn.soop.entity.MembershipLevelRuleExample;
import java.util.List;
import java.util.Map;

public class MembershipLevelRuleSqlProvider {

    public String deleteByExample(MembershipLevelRuleExample example) {
        BEGIN();
        DELETE_FROM("`membership_level_rule`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(MembershipLevelRule record) {
        BEGIN();
        INSERT_INTO("`membership_level_rule`");
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            VALUES("`level`", "#{level,jdbcType=VARCHAR}");
        }
        
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
        
        if (record.getPoint_floor() != null) {
            VALUES("`point_floor`", "#{point_floor,jdbcType=INTEGER}");
        }
        
        if (record.getPoint_ceiling() != null) {
            VALUES("`point_ceiling`", "#{point_ceiling,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount_percentage() != null) {
            VALUES("`discount_percentage`", "#{discount_percentage,jdbcType=INTEGER}");
        }
        
        if (record.getUser_group() != null) {
            VALUES("`user_group`", "#{user_group,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MembershipLevelRule record = (MembershipLevelRule) parameter.get("record");
        MembershipLevelRuleExample example = (MembershipLevelRuleExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`membership_level_rule`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            SET("`level` = #{record.level,jdbcType=VARCHAR}");
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
        
        if (record.getPoint_floor() != null) {
            SET("`point_floor` = #{record.point_floor,jdbcType=INTEGER}");
        }
        
        if (record.getPoint_ceiling() != null) {
            SET("`point_ceiling` = #{record.point_ceiling,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount_percentage() != null) {
            SET("`discount_percentage` = #{record.discount_percentage,jdbcType=INTEGER}");
        }
        
        if (record.getUser_group() != null) {
            SET("`user_group` = #{record.user_group,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`membership_level_rule`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`name` = #{record.name,jdbcType=VARCHAR}");
        SET("`level` = #{record.level,jdbcType=VARCHAR}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`point_floor` = #{record.point_floor,jdbcType=INTEGER}");
        SET("`point_ceiling` = #{record.point_ceiling,jdbcType=INTEGER}");
        SET("`discount_percentage` = #{record.discount_percentage,jdbcType=INTEGER}");
        SET("`user_group` = #{record.user_group,jdbcType=VARCHAR}");
        
        MembershipLevelRuleExample example = (MembershipLevelRuleExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(MembershipLevelRule record) {
        BEGIN();
        UPDATE("`membership_level_rule`");
        
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
        
        if (record.getPoint_floor() != null) {
            SET("`point_floor` = #{point_floor,jdbcType=INTEGER}");
        }
        
        if (record.getPoint_ceiling() != null) {
            SET("`point_ceiling` = #{point_ceiling,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount_percentage() != null) {
            SET("`discount_percentage` = #{discount_percentage,jdbcType=INTEGER}");
        }
        
        if (record.getUser_group() != null) {
            SET("`user_group` = #{user_group,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        WHERE("`name` = #{name,jdbcType=VARCHAR}");
        WHERE("`level` = #{level,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(MembershipLevelRuleExample example, boolean includeExamplePhrase) {
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