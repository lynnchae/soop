package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.OrderDelivery;
import org.lynn.soop.entity.OrderDeliveryExample.Criteria;
import org.lynn.soop.entity.OrderDeliveryExample.Criterion;
import org.lynn.soop.entity.OrderDeliveryExample;
import java.util.List;
import java.util.Map;

public class OrderDeliverySqlProvider {

    public String deleteByExample(OrderDeliveryExample example) {
        BEGIN();
        DELETE_FROM("`order_delivery`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderDelivery record) {
        BEGIN();
        INSERT_INTO("`order_delivery`");
        
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
        
        if (record.getSource_delivery_route() != null) {
            VALUES("`source_delivery_route`", "#{source_delivery_route,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            VALUES("`order_id`", "#{order_id,jdbcType=CHAR}");
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
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_order_no() != null) {
            VALUES("`delivery_order_no`", "#{delivery_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_company() != null) {
            VALUES("`delivery_company`", "#{delivery_company,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch_id() != null) {
            VALUES("`batch_id`", "#{batch_id,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_info() != null) {
            VALUES("`product_info`", "#{product_info,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_fee() != null) {
            VALUES("`delivery_fee`", "#{delivery_fee,jdbcType=INTEGER}");
        }
        
        if (record.getBatch_no() != null) {
            VALUES("`batch_no`", "#{batch_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_detail_status_list() != null) {
            VALUES("`delivery_detail_status_list`", "#{delivery_detail_status_list,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderDelivery record = (OrderDelivery) parameter.get("record");
        OrderDeliveryExample example = (OrderDeliveryExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`order_delivery`");
        
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
        
        if (record.getSource_delivery_route() != null) {
            SET("`source_delivery_route` = #{record.source_delivery_route,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
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
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_order_no() != null) {
            SET("`delivery_order_no` = #{record.delivery_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_company() != null) {
            SET("`delivery_company` = #{record.delivery_company,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch_id() != null) {
            SET("`batch_id` = #{record.batch_id,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_info() != null) {
            SET("`product_info` = #{record.product_info,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_fee() != null) {
            SET("`delivery_fee` = #{record.delivery_fee,jdbcType=INTEGER}");
        }
        
        if (record.getBatch_no() != null) {
            SET("`batch_no` = #{record.batch_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_detail_status_list() != null) {
            SET("`delivery_detail_status_list` = #{record.delivery_detail_status_list,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`order_delivery`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`source_delivery_route` = #{record.source_delivery_route,jdbcType=VARCHAR}");
        SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
        SET("`delivery_address` = #{record.delivery_address,jdbcType=VARCHAR}");
        SET("`delivery_post_code` = #{record.delivery_post_code,jdbcType=VARCHAR}");
        SET("`delivery_contact_name` = #{record.delivery_contact_name,jdbcType=VARCHAR}");
        SET("`delivery_contact_phone` = #{record.delivery_contact_phone,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        SET("`delivery_order_no` = #{record.delivery_order_no,jdbcType=VARCHAR}");
        SET("`delivery_company` = #{record.delivery_company,jdbcType=VARCHAR}");
        SET("`batch_id` = #{record.batch_id,jdbcType=VARCHAR}");
        SET("`product_info` = #{record.product_info,jdbcType=VARCHAR}");
        SET("`delivery_fee` = #{record.delivery_fee,jdbcType=INTEGER}");
        SET("`batch_no` = #{record.batch_no,jdbcType=VARCHAR}");
        SET("`delivery_detail_status_list` = #{record.delivery_detail_status_list,jdbcType=LONGVARCHAR}");
        
        OrderDeliveryExample example = (OrderDeliveryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`order_delivery`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`source_delivery_route` = #{record.source_delivery_route,jdbcType=VARCHAR}");
        SET("`order_id` = #{record.order_id,jdbcType=CHAR}");
        SET("`delivery_address` = #{record.delivery_address,jdbcType=VARCHAR}");
        SET("`delivery_post_code` = #{record.delivery_post_code,jdbcType=VARCHAR}");
        SET("`delivery_contact_name` = #{record.delivery_contact_name,jdbcType=VARCHAR}");
        SET("`delivery_contact_phone` = #{record.delivery_contact_phone,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        SET("`delivery_order_no` = #{record.delivery_order_no,jdbcType=VARCHAR}");
        SET("`delivery_company` = #{record.delivery_company,jdbcType=VARCHAR}");
        SET("`batch_id` = #{record.batch_id,jdbcType=VARCHAR}");
        SET("`product_info` = #{record.product_info,jdbcType=VARCHAR}");
        SET("`delivery_fee` = #{record.delivery_fee,jdbcType=INTEGER}");
        SET("`batch_no` = #{record.batch_no,jdbcType=VARCHAR}");
        
        OrderDeliveryExample example = (OrderDeliveryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderDelivery record) {
        BEGIN();
        UPDATE("`order_delivery`");
        
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
        
        if (record.getSource_delivery_route() != null) {
            SET("`source_delivery_route` = #{source_delivery_route,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{order_id,jdbcType=CHAR}");
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
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_order_no() != null) {
            SET("`delivery_order_no` = #{delivery_order_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_company() != null) {
            SET("`delivery_company` = #{delivery_company,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch_id() != null) {
            SET("`batch_id` = #{batch_id,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_info() != null) {
            SET("`product_info` = #{product_info,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_fee() != null) {
            SET("`delivery_fee` = #{delivery_fee,jdbcType=INTEGER}");
        }
        
        if (record.getBatch_no() != null) {
            SET("`batch_no` = #{batch_no,jdbcType=VARCHAR}");
        }
        
        if (record.getDelivery_detail_status_list() != null) {
            SET("`delivery_detail_status_list` = #{delivery_detail_status_list,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(OrderDeliveryExample example, boolean includeExamplePhrase) {
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