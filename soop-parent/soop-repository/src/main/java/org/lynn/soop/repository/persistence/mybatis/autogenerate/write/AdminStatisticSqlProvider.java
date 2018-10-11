package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.AdminStatistic;
import org.lynn.soop.entity.AdminStatisticExample.Criteria;
import org.lynn.soop.entity.AdminStatisticExample.Criterion;
import org.lynn.soop.entity.AdminStatisticExample;
import java.util.List;
import java.util.Map;

public class AdminStatisticSqlProvider {

    public String deleteByExample(AdminStatisticExample example) {
        BEGIN();
        DELETE_FROM("`admin_statistic`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AdminStatistic record) {
        BEGIN();
        INSERT_INTO("`admin_statistic`");
        
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
        
        if (record.getTotal_product_count() != null) {
            VALUES("`total_product_count`", "#{total_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_product_count_in_stock() != null) {
            VALUES("`total_product_count_in_stock`", "#{total_product_count_in_stock,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_hot_product_count() != null) {
            VALUES("`total_hot_product_count`", "#{total_hot_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_new_product_count() != null) {
            VALUES("`total_new_product_count`", "#{total_new_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_promo_product_count() != null) {
            VALUES("`total_promo_product_count`", "#{total_promo_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_order_count() != null) {
            VALUES("`total_order_count`", "#{total_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getPending_delivery_order_count() != null) {
            VALUES("`pending_delivery_order_count`", "#{pending_delivery_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getPending_pay_order_count() != null) {
            VALUES("`pending_pay_order_count`", "#{pending_pay_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getDone_order_count() != null) {
            VALUES("`done_order_count`", "#{done_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getRefund_order_count() != null) {
            VALUES("`refund_order_count`", "#{refund_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_user_online() != null) {
            VALUES("`total_user_online`", "#{total_user_online,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AdminStatistic record = (AdminStatistic) parameter.get("record");
        AdminStatisticExample example = (AdminStatisticExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`admin_statistic`");
        
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
        
        if (record.getTotal_product_count() != null) {
            SET("`total_product_count` = #{record.total_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_product_count_in_stock() != null) {
            SET("`total_product_count_in_stock` = #{record.total_product_count_in_stock,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_hot_product_count() != null) {
            SET("`total_hot_product_count` = #{record.total_hot_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_new_product_count() != null) {
            SET("`total_new_product_count` = #{record.total_new_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_promo_product_count() != null) {
            SET("`total_promo_product_count` = #{record.total_promo_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_order_count() != null) {
            SET("`total_order_count` = #{record.total_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getPending_delivery_order_count() != null) {
            SET("`pending_delivery_order_count` = #{record.pending_delivery_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getPending_pay_order_count() != null) {
            SET("`pending_pay_order_count` = #{record.pending_pay_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getDone_order_count() != null) {
            SET("`done_order_count` = #{record.done_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getRefund_order_count() != null) {
            SET("`refund_order_count` = #{record.refund_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_user_online() != null) {
            SET("`total_user_online` = #{record.total_user_online,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`admin_statistic`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`total_product_count` = #{record.total_product_count,jdbcType=INTEGER}");
        SET("`total_product_count_in_stock` = #{record.total_product_count_in_stock,jdbcType=INTEGER}");
        SET("`total_hot_product_count` = #{record.total_hot_product_count,jdbcType=INTEGER}");
        SET("`total_new_product_count` = #{record.total_new_product_count,jdbcType=INTEGER}");
        SET("`total_promo_product_count` = #{record.total_promo_product_count,jdbcType=INTEGER}");
        SET("`total_order_count` = #{record.total_order_count,jdbcType=INTEGER}");
        SET("`pending_delivery_order_count` = #{record.pending_delivery_order_count,jdbcType=INTEGER}");
        SET("`pending_pay_order_count` = #{record.pending_pay_order_count,jdbcType=INTEGER}");
        SET("`done_order_count` = #{record.done_order_count,jdbcType=INTEGER}");
        SET("`refund_order_count` = #{record.refund_order_count,jdbcType=INTEGER}");
        SET("`total_user_online` = #{record.total_user_online,jdbcType=INTEGER}");
        
        AdminStatisticExample example = (AdminStatisticExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AdminStatistic record) {
        BEGIN();
        UPDATE("`admin_statistic`");
        
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
        
        if (record.getTotal_product_count() != null) {
            SET("`total_product_count` = #{total_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_product_count_in_stock() != null) {
            SET("`total_product_count_in_stock` = #{total_product_count_in_stock,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_hot_product_count() != null) {
            SET("`total_hot_product_count` = #{total_hot_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_new_product_count() != null) {
            SET("`total_new_product_count` = #{total_new_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_promo_product_count() != null) {
            SET("`total_promo_product_count` = #{total_promo_product_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_order_count() != null) {
            SET("`total_order_count` = #{total_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getPending_delivery_order_count() != null) {
            SET("`pending_delivery_order_count` = #{pending_delivery_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getPending_pay_order_count() != null) {
            SET("`pending_pay_order_count` = #{pending_pay_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getDone_order_count() != null) {
            SET("`done_order_count` = #{done_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getRefund_order_count() != null) {
            SET("`refund_order_count` = #{refund_order_count,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_user_online() != null) {
            SET("`total_user_online` = #{total_user_online,jdbcType=INTEGER}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(AdminStatisticExample example, boolean includeExamplePhrase) {
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