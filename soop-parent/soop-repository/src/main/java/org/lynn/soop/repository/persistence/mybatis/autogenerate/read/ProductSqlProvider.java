package org.lynn.soop.repository.persistence.mybatis.autogenerate.read;

import org.lynn.soop.entity.ProductExample;
import org.lynn.soop.entity.ProductExample.Criteria;
import org.lynn.soop.entity.ProductExample.Criterion;

import java.util.List;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductSqlProvider {

    public String countByExample(ProductExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`product`");
        applyWhere(example, false);
        return SQL();
    }

    public String selectByExampleWithBLOBs(ProductExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`date_created`");
        SELECT("`created_by`");
        SELECT("`date_updated`");
        SELECT("`updated_by`");
        SELECT("`brand_name_cn`");
        SELECT("`brand_name_en`");
        SELECT("`product_name_cn`");
        SELECT("`product_name_en`");
        SELECT("`recommend_index`");
        SELECT("`product_category_l1`");
        SELECT("`product_category_l2`");
        SELECT("`product_category_l3`");
        SELECT("`product_category_id`");
        SELECT("`is_online`");
        SELECT("`is_new`");
        SELECT("`is_hot`");
        SELECT("`source`");
        SELECT("`product_weight`");
        SELECT("`brand_id`");
        SELECT("`product_category_l1_id`");
        SELECT("`product_category_l2_id`");
        SELECT("`product_sub_name`");
        SELECT("`specs`");
        SELECT("`overseas_price`");
        SELECT("`product_price`");
        SELECT("`product_number`");
        SELECT("`source_channel`");
        SELECT("`stock_count`");
        SELECT("`product_properties`");
        SELECT("`product_image_list`");
        SELECT("`routine_id`");
        SELECT("`price_on_sale`");
        SELECT("`delivery_free`");
        SELECT("`goods_id`");
        SELECT("`is_zero_interest`");
        SELECT("`is_zero_downpayment`");
        SELECT("`product_attr`");
        SELECT("`product_images`");
        SELECT("`merchants_code`");
        FROM("`product`");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ProductExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`date_created`");
        SELECT("`created_by`");
        SELECT("`date_updated`");
        SELECT("`updated_by`");
        SELECT("`brand_name_cn`");
        SELECT("`brand_name_en`");
        SELECT("`product_name_cn`");
        SELECT("`product_name_en`");
        SELECT("`recommend_index`");
        SELECT("`product_category_l1`");
        SELECT("`product_category_l2`");
        SELECT("`product_category_l3`");
        SELECT("`product_category_id`");
        SELECT("`is_online`");
        SELECT("`is_new`");
        SELECT("`is_hot`");
        SELECT("`source`");
        SELECT("`product_weight`");
        SELECT("`brand_id`");
        SELECT("`product_category_l1_id`");
        SELECT("`product_category_l2_id`");
        SELECT("`product_sub_name`");
        SELECT("`specs`");
        SELECT("`overseas_price`");
        SELECT("`product_price`");
        SELECT("`product_number`");
        SELECT("`source_channel`");
        SELECT("`stock_count`");
        SELECT("`product_properties`");
        SELECT("`product_image_list`");
        SELECT("`product_images`");
        SELECT("`routine_id`");
        SELECT("`price_on_sale`");
        SELECT("`delivery_free`");
        SELECT("`goods_id`");
        SELECT("`is_zero_interest`");
        SELECT("`is_zero_downpayment`");
        SELECT("`merchants_code`");
        FROM("`product`");
        applyWhere(example, false);


        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        String returnValue=SQL();
        if(example != null && example.getPageIndex()!=null && example.getPageCount() != null){
            int pageCount = example.getPageCount();
            int pageStart = (example.getPageIndex() - 1)*pageCount;
            returnValue += String.format(" limit %1$d,%2$d", pageStart, pageCount);
        }
        return returnValue;
    }

    protected void applyWhere(ProductExample example, boolean includeExamplePhrase) {
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

    public String selectProductDtoExample(ProductExample example) {
        BEGIN();
        SELECT("p.`id`");
        SELECT("p.`date_created`");
        SELECT("p.`created_by`");
        SELECT("p.`date_updated`");
        SELECT("p.`updated_by`");
        SELECT("p.`brand_name_cn`");
        SELECT("p.`brand_name_en`");
        SELECT("p.`product_name_cn`");
        SELECT("p.`product_name_en`");
        SELECT("p.`recommend_index`");
        SELECT("p.`product_category_l1`");
        SELECT("p.`product_category_l2`");
        SELECT("p.`product_category_l3`");
        SELECT("p.`product_category_id`");
        SELECT("p.`is_online`");
        SELECT("p.`is_new`");
        SELECT("p.`is_hot`");
        SELECT("p.`source`");
        SELECT("p.`product_weight`");
        SELECT("p.`brand_id`");
        SELECT("p.`product_category_l1_id`");
        SELECT("p.`product_category_l2_id`");
        SELECT("p.`product_sub_name`");
        SELECT("p.`specs`");
        SELECT("p.`overseas_price`");
        SELECT("p.`product_price`");
        SELECT("p.`product_number`");
        SELECT("p.`source_channel`");
        SELECT("p.`stock_count`");
        SELECT("p.`product_properties`");
        SELECT("p.`product_image_list`");
        SELECT("p.`routine_id`");
        SELECT("p.`price_on_sale`");
        SELECT("p.`delivery_free`");
        SELECT("p.`goods_id`");
        SELECT("p.`product_attr`");
        SELECT("p.`merchants_code`");

        SELECT("p.`product_images`");
        SELECT("p.`is_zero_interest`");
        SELECT("p.`is_zero_downpayment`");
        SELECT("GROUP_CONCAT(sp.`sp_name`,':', spv.sp_value SEPARATOR ' | ') properties");
        FROM("`product` p LEFT JOIN product_sales_property psp ON p.`id`=psp.`product_id` LEFT JOIN sales_property_values spv ON psp.spv_id = spv.`id` LEFT JOIN sales_property sp ON spv.sp_id = sp.id");
        applyWhere(example, false);

        GROUP_BY("p.`id`");

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        String returnValue=SQL();
        if(example != null && example.getPageIndex()!=null && example.getPageCount() != null){
            int pageCount = example.getPageCount();
            int pageStart = (example.getPageIndex() - 1)*pageCount;
            returnValue += String.format(" limit %1$d,%2$d", pageStart, pageCount);
        }
        return returnValue;
    }
}