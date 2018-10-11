package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.OrderDeliverRoutine;
import org.lynn.soop.entity.OrderDeliverRoutineExample.Criteria;
import org.lynn.soop.entity.OrderDeliverRoutineExample.Criterion;
import org.lynn.soop.entity.OrderDeliverRoutineExample;
import java.util.List;
import java.util.Map;

public class OrderDeliverRoutineSqlProvider {

    public String deleteByExample(OrderDeliverRoutineExample example) {
        BEGIN();
        DELETE_FROM("`order_deliver_routine`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderDeliverRoutine record) {
        BEGIN();
        INSERT_INTO("`order_deliver_routine`");
        
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
        
        if (record.getCategory_id() != null) {
            VALUES("`category_id`", "#{category_id,jdbcType=BIGINT}");
        }
        
        if (record.getRoutine_name() != null) {
            VALUES("`routine_name`", "#{routine_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutine_detail() != null) {
            VALUES("`routine_detail`", "#{routine_detail,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            VALUES("`priority`", "#{priority,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderDeliverRoutine record = (OrderDeliverRoutine) parameter.get("record");
        OrderDeliverRoutineExample example = (OrderDeliverRoutineExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`order_deliver_routine`");
        
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
        
        if (record.getCategory_id() != null) {
            SET("`category_id` = #{record.category_id,jdbcType=BIGINT}");
        }
        
        if (record.getRoutine_name() != null) {
            SET("`routine_name` = #{record.routine_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutine_detail() != null) {
            SET("`routine_detail` = #{record.routine_detail,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            SET("`priority` = #{record.priority,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`order_deliver_routine`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`category_id` = #{record.category_id,jdbcType=BIGINT}");
        SET("`routine_name` = #{record.routine_name,jdbcType=VARCHAR}");
        SET("`routine_detail` = #{record.routine_detail,jdbcType=VARCHAR}");
        SET("`priority` = #{record.priority,jdbcType=INTEGER}");
        
        OrderDeliverRoutineExample example = (OrderDeliverRoutineExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderDeliverRoutine record) {
        BEGIN();
        UPDATE("`order_deliver_routine`");
        
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
        
        if (record.getCategory_id() != null) {
            SET("`category_id` = #{category_id,jdbcType=BIGINT}");
        }
        
        if (record.getRoutine_name() != null) {
            SET("`routine_name` = #{routine_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRoutine_detail() != null) {
            SET("`routine_detail` = #{routine_detail,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            SET("`priority` = #{priority,jdbcType=INTEGER}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(OrderDeliverRoutineExample example, boolean includeExamplePhrase) {
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