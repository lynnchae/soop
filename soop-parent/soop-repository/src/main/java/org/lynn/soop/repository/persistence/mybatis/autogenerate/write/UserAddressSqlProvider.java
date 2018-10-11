package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.UserAddressExample.Criteria;
import org.lynn.soop.entity.UserAddressExample.Criterion;
import org.lynn.soop.entity.UserAddressExample;
import java.util.List;
import java.util.Map;

public class UserAddressSqlProvider {

    public String deleteByExample(UserAddressExample example) {
        BEGIN();
        DELETE_FROM("`user_address`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(UserAddress record) {
        BEGIN();
        INSERT_INTO("`user_address`");
        
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
        
        if (record.getContact_name() != null) {
            VALUES("`contact_name`", "#{contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_phone() != null) {
            VALUES("`contact_phone`", "#{contact_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            VALUES("`province`", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("`city`", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            VALUES("`district`", "#{district,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail_address() != null) {
            VALUES("`detail_address`", "#{detail_address,jdbcType=VARCHAR}");
        }
        
        if (record.getPost_code() != null) {
            VALUES("`post_code`", "#{post_code,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_no() != null) {
            VALUES("`id_no_no`", "#{id_no_no,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_scan_front() != null) {
            VALUES("`id_no_scan_front`", "#{id_no_scan_front,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_scan_back() != null) {
            VALUES("`id_no_scan_back`", "#{id_no_scan_back,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_default() != null) {
            VALUES("`is_default`", "#{is_default,jdbcType=BIT}");
        }
        
        if (record.getUser_identify_image_id() != null) {
            VALUES("`user_identify_image_id`", "#{user_identify_image_id,jdbcType=BIGINT}");
        }
        
        if (record.getProvince_id() != null) {
            VALUES("`province_id`", "#{province_id,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserAddress record = (UserAddress) parameter.get("record");
        UserAddressExample example = (UserAddressExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`user_address`");
        
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
        
        if (record.getContact_name() != null) {
            SET("`contact_name` = #{record.contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_phone() != null) {
            SET("`contact_phone` = #{record.contact_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("`province` = #{record.province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("`city` = #{record.city,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            SET("`district` = #{record.district,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail_address() != null) {
            SET("`detail_address` = #{record.detail_address,jdbcType=VARCHAR}");
        }
        
        if (record.getPost_code() != null) {
            SET("`post_code` = #{record.post_code,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_no() != null) {
            SET("`id_no_no` = #{record.id_no_no,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_scan_front() != null) {
            SET("`id_no_scan_front` = #{record.id_no_scan_front,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_scan_back() != null) {
            SET("`id_no_scan_back` = #{record.id_no_scan_back,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_default() != null) {
            SET("`is_default` = #{record.is_default,jdbcType=BIT}");
        }
        
        if (record.getUser_identify_image_id() != null) {
            SET("`user_identify_image_id` = #{record.user_identify_image_id,jdbcType=BIGINT}");
        }
        
        if (record.getProvince_id() != null) {
            SET("`province_id` = #{record.province_id,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`user_address`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`user_id` = #{record.user_id,jdbcType=BIGINT}");
        SET("`contact_name` = #{record.contact_name,jdbcType=VARCHAR}");
        SET("`contact_phone` = #{record.contact_phone,jdbcType=VARCHAR}");
        SET("`province` = #{record.province,jdbcType=VARCHAR}");
        SET("`city` = #{record.city,jdbcType=VARCHAR}");
        SET("`district` = #{record.district,jdbcType=VARCHAR}");
        SET("`detail_address` = #{record.detail_address,jdbcType=VARCHAR}");
        SET("`post_code` = #{record.post_code,jdbcType=VARCHAR}");
        SET("`id_no_no` = #{record.id_no_no,jdbcType=VARCHAR}");
        SET("`id_no_scan_front` = #{record.id_no_scan_front,jdbcType=VARCHAR}");
        SET("`id_no_scan_back` = #{record.id_no_scan_back,jdbcType=VARCHAR}");
        SET("`is_default` = #{record.is_default,jdbcType=BIT}");
        SET("`user_identify_image_id` = #{record.user_identify_image_id,jdbcType=BIGINT}");
        SET("`province_id` = #{record.province_id,jdbcType=INTEGER}");
        
        UserAddressExample example = (UserAddressExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserAddress record) {
        BEGIN();
        UPDATE("`user_address`");
        
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
        
        if (record.getContact_name() != null) {
            SET("`contact_name` = #{contact_name,jdbcType=VARCHAR}");
        }
        
        if (record.getContact_phone() != null) {
            SET("`contact_phone` = #{contact_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("`province` = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("`city` = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            SET("`district` = #{district,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail_address() != null) {
            SET("`detail_address` = #{detail_address,jdbcType=VARCHAR}");
        }
        
        if (record.getPost_code() != null) {
            SET("`post_code` = #{post_code,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_no() != null) {
            SET("`id_no_no` = #{id_no_no,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_scan_front() != null) {
            SET("`id_no_scan_front` = #{id_no_scan_front,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no_scan_back() != null) {
            SET("`id_no_scan_back` = #{id_no_scan_back,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_default() != null) {
            SET("`is_default` = #{is_default,jdbcType=BIT}");
        }
        
        if (record.getUser_identify_image_id() != null) {
            SET("`user_identify_image_id` = #{user_identify_image_id,jdbcType=BIGINT}");
        }
        
        if (record.getProvince_id() != null) {
            SET("`province_id` = #{province_id,jdbcType=INTEGER}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(UserAddressExample example, boolean includeExamplePhrase) {
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