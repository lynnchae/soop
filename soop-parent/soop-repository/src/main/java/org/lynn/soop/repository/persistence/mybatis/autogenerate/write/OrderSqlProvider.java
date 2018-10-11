package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderExample.Criteria;
import org.lynn.soop.entity.OrderExample.Criterion;
import org.lynn.soop.entity.OrderExample;
import java.util.List;
import java.util.Map;

public class OrderSqlProvider {

    public String deleteByExample(OrderExample example) {
        BEGIN();
        DELETE_FROM("`order`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Order record) {
        BEGIN();
        INSERT_INTO("`order`");
        
        if (record.getId() != null) {
            VALUES("`id`", "#{id,jdbcType=CHAR}");
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
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_product_amount() != null) {
            VALUES("`total_product_amount`", "#{total_product_amount,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_order_amount() != null) {
            VALUES("`total_order_amount`", "#{total_order_amount,jdbcType=INTEGER}");
        }
        
        if (record.getPost_delivery_factor() != null) {
            VALUES("`post_delivery_factor`", "#{post_delivery_factor,jdbcType=INTEGER}");
        }
        
        if (record.getPost_delivery_order_no() != null) {
            VALUES("`post_delivery_order_no`", "#{post_delivery_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_address() != null) {
            VALUES("`delivery_address`", "#{delivery_address,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_post_code() != null) {
            VALUES("`delivery_post_code`", "#{delivery_post_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_contact_name() != null) {
            VALUES("`delivery_contact_name`", "#{delivery_contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_contact_phone() != null) {
            VALUES("`delivery_contact_phone`", "#{delivery_contact_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_description() != null) {
            VALUES("`order_description`", "#{order_description,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_product_number() != null) {
            VALUES("`total_product_number`", "#{total_product_number,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_weight() != null) {
            VALUES("`total_weight`", "#{total_weight,jdbcType=INTEGER}");
        }
        
        if (record.getAddress_id() != null) {
            VALUES("`address_id`", "#{address_id,jdbcType=BIGINT}");
        }
        
        if (record.getFreight() != null) {
            VALUES("`freight`", "#{freight,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount_amount() != null) {
            VALUES("`discount_amount`", "#{discount_amount,jdbcType=INTEGER}");
        }
        
        if (record.getDelivery_freight() != null) {
            VALUES("`delivery_freight`", "#{delivery_freight,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Order record = (Order) parameter.get("record");
        OrderExample example = (OrderExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`order`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=CHAR}");
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
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_product_amount() != null) {
            SET("`total_product_amount` = #{record.total_product_amount,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_order_amount() != null) {
            SET("`total_order_amount` = #{record.total_order_amount,jdbcType=INTEGER}");
        }
        
        if (record.getPost_delivery_factor() != null) {
            SET("`post_delivery_factor` = #{record.post_delivery_factor,jdbcType=INTEGER}");
        }
        
        if (record.getPost_delivery_order_no() != null) {
            SET("`post_delivery_order_no` = #{record.post_delivery_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_address() != null) {
            SET("`delivery_address` = #{record.delivery_address,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_post_code() != null) {
            SET("`delivery_post_code` = #{record.delivery_post_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_contact_name() != null) {
            SET("`delivery_contact_name` = #{record.delivery_contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_contact_phone() != null) {
            SET("`delivery_contact_phone` = #{record.delivery_contact_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_description() != null) {
            SET("`order_description` = #{record.order_description,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_product_number() != null) {
            SET("`total_product_number` = #{record.total_product_number,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_weight() != null) {
            SET("`total_weight` = #{record.total_weight,jdbcType=INTEGER}");
        }
        
        if (record.getAddress_id() != null) {
            SET("`address_id` = #{record.address_id,jdbcType=BIGINT}");
        }
        
        if (record.getFreight() != null) {
            SET("`freight` = #{record.freight,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount_amount() != null) {
            SET("`discount_amount` = #{record.discount_amount,jdbcType=INTEGER}");
        }
        
        if (record.getDelivery_freight() != null) {
            SET("`delivery_freight` = #{record.delivery_freight,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`order`");
        
        SET("`id` = #{record.id,jdbcType=CHAR}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        SET("`total_product_amount` = #{record.total_product_amount,jdbcType=INTEGER}");
        SET("`total_order_amount` = #{record.total_order_amount,jdbcType=INTEGER}");
        SET("`post_delivery_factor` = #{record.post_delivery_factor,jdbcType=INTEGER}");
        SET("`post_delivery_order_no` = #{record.post_delivery_order_no,jdbcType=VARCHAR}");
        SET("`delivery_address` = #{record.delivery_address,jdbcType=VARCHAR}");
        SET("`delivery_post_code` = #{record.delivery_post_code,jdbcType=VARCHAR}");
        SET("`delivery_contact_name` = #{record.delivery_contact_name,jdbcType=VARCHAR}");
        SET("`delivery_contact_phone` = #{record.delivery_contact_phone,jdbcType=VARCHAR}");
        SET("`order_description` = #{record.order_description,jdbcType=VARCHAR}");
        SET("`total_product_number` = #{record.total_product_number,jdbcType=INTEGER}");
        SET("`total_weight` = #{record.total_weight,jdbcType=INTEGER}");
        SET("`address_id` = #{record.address_id,jdbcType=BIGINT}");
        SET("`freight` = #{record.freight,jdbcType=INTEGER}");
        SET("`discount_amount` = #{record.discount_amount,jdbcType=INTEGER}");
        SET("`delivery_freight` = #{record.delivery_freight,jdbcType=INTEGER}");
        
        OrderExample example = (OrderExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Order record) {
        BEGIN();
        UPDATE("`order`");
        
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
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_product_amount() != null) {
            SET("`total_product_amount` = #{total_product_amount,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_order_amount() != null) {
            SET("`total_order_amount` = #{total_order_amount,jdbcType=INTEGER}");
        }
        
        if (record.getPost_delivery_factor() != null) {
            SET("`post_delivery_factor` = #{post_delivery_factor,jdbcType=INTEGER}");
        }
        
        if (record.getPost_delivery_order_no() != null) {
            SET("`post_delivery_order_no` = #{post_delivery_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_address() != null) {
            SET("`delivery_address` = #{delivery_address,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_post_code() != null) {
            SET("`delivery_post_code` = #{delivery_post_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_contact_name() != null) {
            SET("`delivery_contact_name` = #{delivery_contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_contact_phone() != null) {
            SET("`delivery_contact_phone` = #{delivery_contact_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_description() != null) {
            SET("`order_description` = #{order_description,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal_product_number() != null) {
            SET("`total_product_number` = #{total_product_number,jdbcType=INTEGER}");
        }
        
        if (record.getTotal_weight() != null) {
            SET("`total_weight` = #{total_weight,jdbcType=INTEGER}");
        }
        
        if (record.getAddress_id() != null) {
            SET("`address_id` = #{address_id,jdbcType=BIGINT}");
        }
        
        if (record.getFreight() != null) {
            SET("`freight` = #{freight,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount_amount() != null) {
            SET("`discount_amount` = #{discount_amount,jdbcType=INTEGER}");
        }
        
        if (record.getDelivery_freight() != null) {
            SET("`delivery_freight` = #{delivery_freight,jdbcType=INTEGER}");
        }
        
        WHERE("`id` = #{id,jdbcType=CHAR}");
        
        return SQL();
    }

    protected void applyWhere(OrderExample example, boolean includeExamplePhrase) {
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