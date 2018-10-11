package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.OrderProductList;
import org.lynn.soop.entity.OrderProductListExample.Criteria;
import org.lynn.soop.entity.OrderProductListExample.Criterion;
import org.lynn.soop.entity.OrderProductListExample;
import java.util.List;
import java.util.Map;

public class OrderProductListSqlProvider {

    public String deleteByExample(OrderProductListExample example) {
        BEGIN();
        DELETE_FROM("`order_product_list`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderProductList record) {
        BEGIN();
        INSERT_INTO("`order_product_list`");
        
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
        
        if (record.getProduct_id() != null) {
            VALUES("`product_id`", "#{product_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_price() != null) {
            VALUES("`product_price`", "#{product_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_name() != null) {
            VALUES("`product_name`", "#{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            VALUES("`quantity`", "#{quantity,jdbcType=INTEGER}");
        }
        
        if (record.getPurchase_status() != null) {
            VALUES("`purchase_status`", "#{purchase_status,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            VALUES("`order_status`", "#{order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getPay_complete_time() != null) {
            VALUES("`pay_complete_time`", "#{pay_complete_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPurchase_complete_time() != null) {
            VALUES("`purchase_complete_time`", "#{purchase_complete_time,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderProductList record = (OrderProductList) parameter.get("record");
        OrderProductListExample example = (OrderProductListExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`order_product_list`");
        
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
        
        if (record.getProduct_id() != null) {
            SET("`product_id` = #{record.product_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_price() != null) {
            SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            SET("`quantity` = #{record.quantity,jdbcType=INTEGER}");
        }
        
        if (record.getPurchase_status() != null) {
            SET("`purchase_status` = #{record.purchase_status,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            SET("`order_status` = #{record.order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getPay_complete_time() != null) {
            SET("`pay_complete_time` = #{record.pay_complete_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPurchase_complete_time() != null) {
            SET("`purchase_complete_time` = #{record.purchase_complete_time,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`order_product_list`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
        SET("`product_id` = #{record.product_id,jdbcType=BIGINT}");
        SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`quantity` = #{record.quantity,jdbcType=INTEGER}");
        SET("`purchase_status` = #{record.purchase_status,jdbcType=VARCHAR}");
        SET("`order_status` = #{record.order_status,jdbcType=VARCHAR}");
        SET("`pay_complete_time` = #{record.pay_complete_time,jdbcType=TIMESTAMP}");
        SET("`purchase_complete_time` = #{record.purchase_complete_time,jdbcType=TIMESTAMP}");
        
        OrderProductListExample example = (OrderProductListExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderProductList record) {
        BEGIN();
        UPDATE("`order_product_list`");
        
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
        
        if (record.getProduct_id() != null) {
            SET("`product_id` = #{product_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_price() != null) {
            SET("`product_price` = #{product_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            SET("`quantity` = #{quantity,jdbcType=INTEGER}");
        }
        
        if (record.getPurchase_status() != null) {
            SET("`purchase_status` = #{purchase_status,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            SET("`order_status` = #{order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getPay_complete_time() != null) {
            SET("`pay_complete_time` = #{pay_complete_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPurchase_complete_time() != null) {
            SET("`purchase_complete_time` = #{purchase_complete_time,jdbcType=TIMESTAMP}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(OrderProductListExample example, boolean includeExamplePhrase) {
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