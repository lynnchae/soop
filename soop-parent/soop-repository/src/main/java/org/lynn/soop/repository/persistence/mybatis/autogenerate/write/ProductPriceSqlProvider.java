package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.ProductPrice;
import org.lynn.soop.entity.ProductPriceExample.Criteria;
import org.lynn.soop.entity.ProductPriceExample.Criterion;
import org.lynn.soop.entity.ProductPriceExample;
import java.util.List;
import java.util.Map;

public class ProductPriceSqlProvider {

    public String deleteByExample(ProductPriceExample example) {
        BEGIN();
        DELETE_FROM("`product_price`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ProductPrice record) {
        BEGIN();
        INSERT_INTO("`product_price`");
        
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
        
        if (record.getProduct_id() != null) {
            VALUES("`product_id`", "#{product_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_name_cn() != null) {
            VALUES("`product_name_cn`", "#{product_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            VALUES("`source`", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getOverseas_price() != null) {
            VALUES("`overseas_price`", "#{overseas_price,jdbcType=INTEGER}");
        }
        
        if (record.getDomestic_price() != null) {
            VALUES("`domestic_price`", "#{domestic_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_price() != null) {
            VALUES("`product_price`", "#{product_price,jdbcType=INTEGER}");
        }
        
        if (record.getSource_id() != null) {
            VALUES("`source_id`", "#{source_id,jdbcType=BIGINT}");
        }
        
        if (record.getPrice_on_sale() != null) {
            VALUES("`price_on_sale`", "#{price_on_sale,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProductPrice record = (ProductPrice) parameter.get("record");
        ProductPriceExample example = (ProductPriceExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`product_price`");
        
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
        
        if (record.getProduct_id() != null) {
            SET("`product_id` = #{record.product_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_name_cn() != null) {
            SET("`product_name_cn` = #{record.product_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            SET("`source` = #{record.source,jdbcType=VARCHAR}");
        }
        
        if (record.getOverseas_price() != null) {
            SET("`overseas_price` = #{record.overseas_price,jdbcType=INTEGER}");
        }
        
        if (record.getDomestic_price() != null) {
            SET("`domestic_price` = #{record.domestic_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_price() != null) {
            SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        }
        
        if (record.getSource_id() != null) {
            SET("`source_id` = #{record.source_id,jdbcType=BIGINT}");
        }
        
        if (record.getPrice_on_sale() != null) {
            SET("`price_on_sale` = #{record.price_on_sale,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`product_price`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`product_id` = #{record.product_id,jdbcType=BIGINT}");
        SET("`product_name_cn` = #{record.product_name_cn,jdbcType=VARCHAR}");
        SET("`source` = #{record.source,jdbcType=VARCHAR}");
        SET("`overseas_price` = #{record.overseas_price,jdbcType=INTEGER}");
        SET("`domestic_price` = #{record.domestic_price,jdbcType=INTEGER}");
        SET("`product_price` = #{record.product_price,jdbcType=INTEGER}");
        SET("`source_id` = #{record.source_id,jdbcType=BIGINT}");
        SET("`price_on_sale` = #{record.price_on_sale,jdbcType=INTEGER}");
        
        ProductPriceExample example = (ProductPriceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ProductPrice record) {
        BEGIN();
        UPDATE("`product_price`");
        
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
        
        if (record.getProduct_id() != null) {
            SET("`product_id` = #{product_id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct_name_cn() != null) {
            SET("`product_name_cn` = #{product_name_cn,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            SET("`source` = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getOverseas_price() != null) {
            SET("`overseas_price` = #{overseas_price,jdbcType=INTEGER}");
        }
        
        if (record.getDomestic_price() != null) {
            SET("`domestic_price` = #{domestic_price,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_price() != null) {
            SET("`product_price` = #{product_price,jdbcType=INTEGER}");
        }
        
        if (record.getSource_id() != null) {
            SET("`source_id` = #{source_id,jdbcType=BIGINT}");
        }
        
        if (record.getPrice_on_sale() != null) {
            SET("`price_on_sale` = #{price_on_sale,jdbcType=INTEGER}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ProductPriceExample example, boolean includeExamplePhrase) {
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