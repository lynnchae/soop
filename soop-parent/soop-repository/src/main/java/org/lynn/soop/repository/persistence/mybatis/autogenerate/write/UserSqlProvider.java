package org.lynn.soop.repository.persistence.mybatis.autogenerate.write;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.lynn.soop.entity.User;
import org.lynn.soop.entity.UserExample.Criteria;
import org.lynn.soop.entity.UserExample.Criterion;
import org.lynn.soop.entity.UserExample;
import java.util.List;
import java.util.Map;

public class UserSqlProvider {

    public String deleteByExample(UserExample example) {
        BEGIN();
        DELETE_FROM("`user`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("`user`");
        
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
        
        if (record.getLogin_name() != null) {
            VALUES("`login_name`", "#{login_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUnique_token() != null) {
            VALUES("`unique_token`", "#{unique_token,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("`password`", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            VALUES("`user_name`", "#{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_group() != null) {
            VALUES("`user_group`", "#{user_group,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrent_membership_level() != null) {
            VALUES("`current_membership_level`", "#{current_membership_level,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile_no() != null) {
            VALUES("`mobile_no`", "#{mobile_no,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("`email`", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrent_status() != null) {
            VALUES("`current_status`", "#{current_status,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            VALUES("`avatar`", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getId_type() != null) {
            VALUES("`id_type`", "#{id_type,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no() != null) {
            VALUES("`id_no`", "#{id_no,jdbcType=VARCHAR}");
        }
        
        if (record.getOnline_status() != null) {
            VALUES("`online_status`", "#{online_status,jdbcType=BIT}");
        }
        
        if (record.getLast_login_time() != null) {
            VALUES("`last_login_time`", "#{last_login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenid() != null) {
            VALUES("`openid`", "#{openid,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`user`");
        
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
        
        if (record.getLogin_name() != null) {
            SET("`login_name` = #{record.login_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUnique_token() != null) {
            SET("`unique_token` = #{record.unique_token,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("`password` = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_group() != null) {
            SET("`user_group` = #{record.user_group,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrent_membership_level() != null) {
            SET("`current_membership_level` = #{record.current_membership_level,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile_no() != null) {
            SET("`mobile_no` = #{record.mobile_no,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("`email` = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrent_status() != null) {
            SET("`current_status` = #{record.current_status,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            SET("`avatar` = #{record.avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getId_type() != null) {
            SET("`id_type` = #{record.id_type,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no() != null) {
            SET("`id_no` = #{record.id_no,jdbcType=VARCHAR}");
        }
        
        if (record.getOnline_status() != null) {
            SET("`online_status` = #{record.online_status,jdbcType=BIT}");
        }
        
        if (record.getLast_login_time() != null) {
            SET("`last_login_time` = #{record.last_login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenid() != null) {
            SET("`openid` = #{record.openid,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`user`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`date_created` = #{record.date_created,jdbcType=TIMESTAMP}");
        SET("`created_by` = #{record.created_by,jdbcType=VARCHAR}");
        SET("`date_updated` = #{record.date_updated,jdbcType=TIMESTAMP}");
        SET("`updated_by` = #{record.updated_by,jdbcType=VARCHAR}");
        SET("`login_name` = #{record.login_name,jdbcType=VARCHAR}");
        SET("`unique_token` = #{record.unique_token,jdbcType=VARCHAR}");
        SET("`password` = #{record.password,jdbcType=VARCHAR}");
        SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        SET("`user_group` = #{record.user_group,jdbcType=VARCHAR}");
        SET("`current_membership_level` = #{record.current_membership_level,jdbcType=VARCHAR}");
        SET("`mobile_no` = #{record.mobile_no,jdbcType=VARCHAR}");
        SET("`email` = #{record.email,jdbcType=VARCHAR}");
        SET("`current_status` = #{record.current_status,jdbcType=VARCHAR}");
        SET("`avatar` = #{record.avatar,jdbcType=VARCHAR}");
        SET("`id_type` = #{record.id_type,jdbcType=VARCHAR}");
        SET("`id_no` = #{record.id_no,jdbcType=VARCHAR}");
        SET("`online_status` = #{record.online_status,jdbcType=BIT}");
        SET("`last_login_time` = #{record.last_login_time,jdbcType=TIMESTAMP}");
        SET("`openid` = #{record.openid,jdbcType=VARCHAR}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("`user`");
        
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
        
        if (record.getLogin_name() != null) {
            SET("`login_name` = #{login_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUnique_token() != null) {
            SET("`unique_token` = #{unique_token,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("`password` = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_group() != null) {
            SET("`user_group` = #{user_group,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrent_membership_level() != null) {
            SET("`current_membership_level` = #{current_membership_level,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile_no() != null) {
            SET("`mobile_no` = #{mobile_no,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("`email` = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrent_status() != null) {
            SET("`current_status` = #{current_status,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            SET("`avatar` = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getId_type() != null) {
            SET("`id_type` = #{id_type,jdbcType=VARCHAR}");
        }
        
        if (record.getId_no() != null) {
            SET("`id_no` = #{id_no,jdbcType=VARCHAR}");
        }
        
        if (record.getOnline_status() != null) {
            SET("`online_status` = #{online_status,jdbcType=BIT}");
        }
        
        if (record.getLast_login_time() != null) {
            SET("`last_login_time` = #{last_login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenid() != null) {
            SET("`openid` = #{openid,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(UserExample example, boolean includeExamplePhrase) {
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