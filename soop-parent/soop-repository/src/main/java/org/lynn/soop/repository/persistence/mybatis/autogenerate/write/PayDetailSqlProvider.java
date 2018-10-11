package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.PayDetail;
import org.lynn.soop.entity.PayDetailExample.Criteria;
import org.lynn.soop.entity.PayDetailExample.Criterion;
import org.lynn.soop.entity.PayDetailExample;
import java.util.List;
import java.util.Map;

public class PayDetailSqlProvider {

    public String deleteByExample(PayDetailExample example) {
        BEGIN();
        DELETE_FROM("`pay_detail`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PayDetail record) {
        BEGIN();
        INSERT_INTO("`pay_detail`");
        
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
        
        if (record.getOrder_id() != null) {
            VALUES("`order_id`", "#{order_id,jdbcType=CHAR}");
        }
        
        if (record.getInner_order_no() != null) {
            VALUES("`inner_order_no`", "#{inner_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            VALUES("`product_name`", "#{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            VALUES("`amount`", "#{amount,jdbcType=INTEGER}");
        }
        
        if (record.getPay_channel() != null) {
            VALUES("`pay_channel`", "#{pay_channel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getRequest() != null) {
            VALUES("`request`", "#{request,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getResponse() != null) {
            VALUES("`response`", "#{response,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PayDetail record = (PayDetail) parameter.get("record");
        PayDetailExample example = (PayDetailExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`pay_detail`");
        
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
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
        }
        
        if (record.getInner_order_no() != null) {
            SET("`inner_order_no` = #{record.inner_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("`amount` = #{record.amount,jdbcType=INTEGER}");
        }
        
        if (record.getPay_channel() != null) {
            SET("`pay_channel` = #{record.pay_channel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getRequest() != null) {
            SET("`request` = #{record.request,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getResponse() != null) {
            SET("`response` = #{record.response,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`pay_detail`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
        SET("`inner_order_no` = #{record.inner_order_no,jdbcType=VARCHAR}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`amount` = #{record.amount,jdbcType=INTEGER}");
        SET("`pay_channel` = #{record.pay_channel,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        SET("`request` = #{record.request,jdbcType=LONGVARCHAR}");
        SET("`response` = #{record.response,jdbcType=LONGVARCHAR}");
        
        PayDetailExample example = (PayDetailExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`pay_detail`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
        SET("`inner_order_no` = #{record.inner_order_no,jdbcType=VARCHAR}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`amount` = #{record.amount,jdbcType=INTEGER}");
        SET("`pay_channel` = #{record.pay_channel,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        
        PayDetailExample example = (PayDetailExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PayDetail record) {
        BEGIN();
        UPDATE("`pay_detail`");
        
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
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{order_id,jdbcType=CHAR}");
        }
        
        if (record.getInner_order_no() != null) {
            SET("`inner_order_no` = #{inner_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("`amount` = #{amount,jdbcType=INTEGER}");
        }
        
        if (record.getPay_channel() != null) {
            SET("`pay_channel` = #{pay_channel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getRequest() != null) {
            SET("`request` = #{request,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getResponse() != null) {
            SET("`response` = #{response,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(PayDetailExample example, boolean includeExamplePhrase) {
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