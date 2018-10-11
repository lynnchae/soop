package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex=pageIndex;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount=pageCount;
    }

    public Integer getPageCount() {
        return this.pageCount;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        @JsonIgnore
        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDate_createdIsNull() {
            addCriterion("`date_created` is null");
            return (Criteria) this;
        }

        public Criteria andDate_createdIsNotNull() {
            addCriterion("`date_created` is not null");
            return (Criteria) this;
        }

        public Criteria andDate_createdEqualTo(Date value) {
            addCriterion("`date_created` =", value, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdNotEqualTo(Date value) {
            addCriterion("`date_created` <>", value, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdGreaterThan(Date value) {
            addCriterion("`date_created` >", value, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdGreaterThanOrEqualTo(Date value) {
            addCriterion("`date_created` >=", value, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdLessThan(Date value) {
            addCriterion("`date_created` <", value, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdLessThanOrEqualTo(Date value) {
            addCriterion("`date_created` <=", value, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdIn(List<Date> values) {
            addCriterion("`date_created` in", values, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdNotIn(List<Date> values) {
            addCriterion("`date_created` not in", values, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdBetween(Date value1, Date value2) {
            addCriterion("`date_created` between", value1, value2, "date_created");
            return (Criteria) this;
        }

        public Criteria andDate_createdNotBetween(Date value1, Date value2) {
            addCriterion("`date_created` not between", value1, value2, "date_created");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNull() {
            addCriterion("`created_by` is null");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNotNull() {
            addCriterion("`created_by` is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_byEqualTo(String value) {
            addCriterion("`created_by` =", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotEqualTo(String value) {
            addCriterion("`created_by` <>", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThan(String value) {
            addCriterion("`created_by` >", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThanOrEqualTo(String value) {
            addCriterion("`created_by` >=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThan(String value) {
            addCriterion("`created_by` <", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThanOrEqualTo(String value) {
            addCriterion("`created_by` <=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLike(String value) {
            addCriterion("`created_by` like", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotLike(String value) {
            addCriterion("`created_by` not like", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byIn(List<String> values) {
            addCriterion("`created_by` in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotIn(List<String> values) {
            addCriterion("`created_by` not in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byBetween(String value1, String value2) {
            addCriterion("`created_by` between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotBetween(String value1, String value2) {
            addCriterion("`created_by` not between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andDate_updatedIsNull() {
            addCriterion("`date_updated` is null");
            return (Criteria) this;
        }

        public Criteria andDate_updatedIsNotNull() {
            addCriterion("`date_updated` is not null");
            return (Criteria) this;
        }

        public Criteria andDate_updatedEqualTo(Date value) {
            addCriterion("`date_updated` =", value, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedNotEqualTo(Date value) {
            addCriterion("`date_updated` <>", value, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedGreaterThan(Date value) {
            addCriterion("`date_updated` >", value, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedGreaterThanOrEqualTo(Date value) {
            addCriterion("`date_updated` >=", value, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedLessThan(Date value) {
            addCriterion("`date_updated` <", value, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedLessThanOrEqualTo(Date value) {
            addCriterion("`date_updated` <=", value, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedIn(List<Date> values) {
            addCriterion("`date_updated` in", values, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedNotIn(List<Date> values) {
            addCriterion("`date_updated` not in", values, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedBetween(Date value1, Date value2) {
            addCriterion("`date_updated` between", value1, value2, "date_updated");
            return (Criteria) this;
        }

        public Criteria andDate_updatedNotBetween(Date value1, Date value2) {
            addCriterion("`date_updated` not between", value1, value2, "date_updated");
            return (Criteria) this;
        }

        public Criteria andUpdated_byIsNull() {
            addCriterion("`updated_by` is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_byIsNotNull() {
            addCriterion("`updated_by` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_byEqualTo(String value) {
            addCriterion("`updated_by` =", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotEqualTo(String value) {
            addCriterion("`updated_by` <>", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byGreaterThan(String value) {
            addCriterion("`updated_by` >", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byGreaterThanOrEqualTo(String value) {
            addCriterion("`updated_by` >=", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byLessThan(String value) {
            addCriterion("`updated_by` <", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byLessThanOrEqualTo(String value) {
            addCriterion("`updated_by` <=", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byLike(String value) {
            addCriterion("`updated_by` like", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotLike(String value) {
            addCriterion("`updated_by` not like", value, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byIn(List<String> values) {
            addCriterion("`updated_by` in", values, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotIn(List<String> values) {
            addCriterion("`updated_by` not in", values, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byBetween(String value1, String value2) {
            addCriterion("`updated_by` between", value1, value2, "updated_by");
            return (Criteria) this;
        }

        public Criteria andUpdated_byNotBetween(String value1, String value2) {
            addCriterion("`updated_by` not between", value1, value2, "updated_by");
            return (Criteria) this;
        }

        public Criteria andLogin_nameIsNull() {
            addCriterion("`login_name` is null");
            return (Criteria) this;
        }

        public Criteria andLogin_nameIsNotNull() {
            addCriterion("`login_name` is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_nameEqualTo(String value) {
            addCriterion("`login_name` =", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotEqualTo(String value) {
            addCriterion("`login_name` <>", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameGreaterThan(String value) {
            addCriterion("`login_name` >", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`login_name` >=", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameLessThan(String value) {
            addCriterion("`login_name` <", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameLessThanOrEqualTo(String value) {
            addCriterion("`login_name` <=", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameLike(String value) {
            addCriterion("`login_name` like", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotLike(String value) {
            addCriterion("`login_name` not like", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameIn(List<String> values) {
            addCriterion("`login_name` in", values, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotIn(List<String> values) {
            addCriterion("`login_name` not in", values, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameBetween(String value1, String value2) {
            addCriterion("`login_name` between", value1, value2, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotBetween(String value1, String value2) {
            addCriterion("`login_name` not between", value1, value2, "login_name");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenIsNull() {
            addCriterion("`unique_token` is null");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenIsNotNull() {
            addCriterion("`unique_token` is not null");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenEqualTo(String value) {
            addCriterion("`unique_token` =", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenNotEqualTo(String value) {
            addCriterion("`unique_token` <>", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenGreaterThan(String value) {
            addCriterion("`unique_token` >", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenGreaterThanOrEqualTo(String value) {
            addCriterion("`unique_token` >=", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenLessThan(String value) {
            addCriterion("`unique_token` <", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenLessThanOrEqualTo(String value) {
            addCriterion("`unique_token` <=", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenLike(String value) {
            addCriterion("`unique_token` like", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenNotLike(String value) {
            addCriterion("`unique_token` not like", value, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenIn(List<String> values) {
            addCriterion("`unique_token` in", values, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenNotIn(List<String> values) {
            addCriterion("`unique_token` not in", values, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenBetween(String value1, String value2) {
            addCriterion("`unique_token` between", value1, value2, "unique_token");
            return (Criteria) this;
        }

        public Criteria andUnique_tokenNotBetween(String value1, String value2) {
            addCriterion("`unique_token` not between", value1, value2, "unique_token");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNull() {
            addCriterion("`user_name` is null");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNotNull() {
            addCriterion("`user_name` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nameEqualTo(String value) {
            addCriterion("`user_name` =", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotEqualTo(String value) {
            addCriterion("`user_name` <>", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThan(String value) {
            addCriterion("`user_name` >", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`user_name` >=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThan(String value) {
            addCriterion("`user_name` <", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThanOrEqualTo(String value) {
            addCriterion("`user_name` <=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLike(String value) {
            addCriterion("`user_name` like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotLike(String value) {
            addCriterion("`user_name` not like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIn(List<String> values) {
            addCriterion("`user_name` in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotIn(List<String> values) {
            addCriterion("`user_name` not in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameBetween(String value1, String value2) {
            addCriterion("`user_name` between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotBetween(String value1, String value2) {
            addCriterion("`user_name` not between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_groupIsNull() {
            addCriterion("`user_group` is null");
            return (Criteria) this;
        }

        public Criteria andUser_groupIsNotNull() {
            addCriterion("`user_group` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_groupEqualTo(String value) {
            addCriterion("`user_group` =", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupNotEqualTo(String value) {
            addCriterion("`user_group` <>", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupGreaterThan(String value) {
            addCriterion("`user_group` >", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupGreaterThanOrEqualTo(String value) {
            addCriterion("`user_group` >=", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupLessThan(String value) {
            addCriterion("`user_group` <", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupLessThanOrEqualTo(String value) {
            addCriterion("`user_group` <=", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupLike(String value) {
            addCriterion("`user_group` like", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupNotLike(String value) {
            addCriterion("`user_group` not like", value, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupIn(List<String> values) {
            addCriterion("`user_group` in", values, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupNotIn(List<String> values) {
            addCriterion("`user_group` not in", values, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupBetween(String value1, String value2) {
            addCriterion("`user_group` between", value1, value2, "user_group");
            return (Criteria) this;
        }

        public Criteria andUser_groupNotBetween(String value1, String value2) {
            addCriterion("`user_group` not between", value1, value2, "user_group");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelIsNull() {
            addCriterion("`current_membership_level` is null");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelIsNotNull() {
            addCriterion("`current_membership_level` is not null");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelEqualTo(String value) {
            addCriterion("`current_membership_level` =", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelNotEqualTo(String value) {
            addCriterion("`current_membership_level` <>", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelGreaterThan(String value) {
            addCriterion("`current_membership_level` >", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelGreaterThanOrEqualTo(String value) {
            addCriterion("`current_membership_level` >=", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelLessThan(String value) {
            addCriterion("`current_membership_level` <", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelLessThanOrEqualTo(String value) {
            addCriterion("`current_membership_level` <=", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelLike(String value) {
            addCriterion("`current_membership_level` like", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelNotLike(String value) {
            addCriterion("`current_membership_level` not like", value, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelIn(List<String> values) {
            addCriterion("`current_membership_level` in", values, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelNotIn(List<String> values) {
            addCriterion("`current_membership_level` not in", values, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelBetween(String value1, String value2) {
            addCriterion("`current_membership_level` between", value1, value2, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_membership_levelNotBetween(String value1, String value2) {
            addCriterion("`current_membership_level` not between", value1, value2, "current_membership_level");
            return (Criteria) this;
        }

        public Criteria andMobile_noIsNull() {
            addCriterion("`mobile_no` is null");
            return (Criteria) this;
        }

        public Criteria andMobile_noIsNotNull() {
            addCriterion("`mobile_no` is not null");
            return (Criteria) this;
        }

        public Criteria andMobile_noEqualTo(String value) {
            addCriterion("`mobile_no` =", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noNotEqualTo(String value) {
            addCriterion("`mobile_no` <>", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noGreaterThan(String value) {
            addCriterion("`mobile_no` >", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noGreaterThanOrEqualTo(String value) {
            addCriterion("`mobile_no` >=", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noLessThan(String value) {
            addCriterion("`mobile_no` <", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noLessThanOrEqualTo(String value) {
            addCriterion("`mobile_no` <=", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noLike(String value) {
            addCriterion("`mobile_no` like", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noNotLike(String value) {
            addCriterion("`mobile_no` not like", value, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noIn(List<String> values) {
            addCriterion("`mobile_no` in", values, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noNotIn(List<String> values) {
            addCriterion("`mobile_no` not in", values, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noBetween(String value1, String value2) {
            addCriterion("`mobile_no` between", value1, value2, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andMobile_noNotBetween(String value1, String value2) {
            addCriterion("`mobile_no` not between", value1, value2, "mobile_no");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("`email` is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("`email` is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("`email` =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("`email` <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("`email` >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`email` >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("`email` <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("`email` <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("`email` like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("`email` not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("`email` in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("`email` not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("`email` between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("`email` not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusIsNull() {
            addCriterion("`current_status` is null");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusIsNotNull() {
            addCriterion("`current_status` is not null");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusEqualTo(String value) {
            addCriterion("`current_status` =", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusNotEqualTo(String value) {
            addCriterion("`current_status` <>", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusGreaterThan(String value) {
            addCriterion("`current_status` >", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`current_status` >=", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusLessThan(String value) {
            addCriterion("`current_status` <", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusLessThanOrEqualTo(String value) {
            addCriterion("`current_status` <=", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusLike(String value) {
            addCriterion("`current_status` like", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusNotLike(String value) {
            addCriterion("`current_status` not like", value, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusIn(List<String> values) {
            addCriterion("`current_status` in", values, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusNotIn(List<String> values) {
            addCriterion("`current_status` not in", values, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusBetween(String value1, String value2) {
            addCriterion("`current_status` between", value1, value2, "current_status");
            return (Criteria) this;
        }

        public Criteria andCurrent_statusNotBetween(String value1, String value2) {
            addCriterion("`current_status` not between", value1, value2, "current_status");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("`avatar` is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("`avatar` is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("`avatar` =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("`avatar` <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("`avatar` >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("`avatar` >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("`avatar` <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("`avatar` <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("`avatar` like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("`avatar` not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("`avatar` in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("`avatar` not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("`avatar` between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("`avatar` not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andId_typeIsNull() {
            addCriterion("`id_type` is null");
            return (Criteria) this;
        }

        public Criteria andId_typeIsNotNull() {
            addCriterion("`id_type` is not null");
            return (Criteria) this;
        }

        public Criteria andId_typeEqualTo(String value) {
            addCriterion("`id_type` =", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeNotEqualTo(String value) {
            addCriterion("`id_type` <>", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeGreaterThan(String value) {
            addCriterion("`id_type` >", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`id_type` >=", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeLessThan(String value) {
            addCriterion("`id_type` <", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeLessThanOrEqualTo(String value) {
            addCriterion("`id_type` <=", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeLike(String value) {
            addCriterion("`id_type` like", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeNotLike(String value) {
            addCriterion("`id_type` not like", value, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeIn(List<String> values) {
            addCriterion("`id_type` in", values, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeNotIn(List<String> values) {
            addCriterion("`id_type` not in", values, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeBetween(String value1, String value2) {
            addCriterion("`id_type` between", value1, value2, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_typeNotBetween(String value1, String value2) {
            addCriterion("`id_type` not between", value1, value2, "id_type");
            return (Criteria) this;
        }

        public Criteria andId_noIsNull() {
            addCriterion("`id_no` is null");
            return (Criteria) this;
        }

        public Criteria andId_noIsNotNull() {
            addCriterion("`id_no` is not null");
            return (Criteria) this;
        }

        public Criteria andId_noEqualTo(String value) {
            addCriterion("`id_no` =", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotEqualTo(String value) {
            addCriterion("`id_no` <>", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noGreaterThan(String value) {
            addCriterion("`id_no` >", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noGreaterThanOrEqualTo(String value) {
            addCriterion("`id_no` >=", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noLessThan(String value) {
            addCriterion("`id_no` <", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noLessThanOrEqualTo(String value) {
            addCriterion("`id_no` <=", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noLike(String value) {
            addCriterion("`id_no` like", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotLike(String value) {
            addCriterion("`id_no` not like", value, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noIn(List<String> values) {
            addCriterion("`id_no` in", values, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotIn(List<String> values) {
            addCriterion("`id_no` not in", values, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noBetween(String value1, String value2) {
            addCriterion("`id_no` between", value1, value2, "id_no");
            return (Criteria) this;
        }

        public Criteria andId_noNotBetween(String value1, String value2) {
            addCriterion("`id_no` not between", value1, value2, "id_no");
            return (Criteria) this;
        }

        public Criteria andOnline_statusIsNull() {
            addCriterion("`online_status` is null");
            return (Criteria) this;
        }

        public Criteria andOnline_statusIsNotNull() {
            addCriterion("`online_status` is not null");
            return (Criteria) this;
        }

        public Criteria andOnline_statusEqualTo(Boolean value) {
            addCriterion("`online_status` =", value, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusNotEqualTo(Boolean value) {
            addCriterion("`online_status` <>", value, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusGreaterThan(Boolean value) {
            addCriterion("`online_status` >", value, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`online_status` >=", value, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusLessThan(Boolean value) {
            addCriterion("`online_status` <", value, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusLessThanOrEqualTo(Boolean value) {
            addCriterion("`online_status` <=", value, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusIn(List<Boolean> values) {
            addCriterion("`online_status` in", values, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusNotIn(List<Boolean> values) {
            addCriterion("`online_status` not in", values, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusBetween(Boolean value1, Boolean value2) {
            addCriterion("`online_status` between", value1, value2, "online_status");
            return (Criteria) this;
        }

        public Criteria andOnline_statusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`online_status` not between", value1, value2, "online_status");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeIsNull() {
            addCriterion("`last_login_time` is null");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeIsNotNull() {
            addCriterion("`last_login_time` is not null");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeEqualTo(Date value) {
            addCriterion("`last_login_time` =", value, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeNotEqualTo(Date value) {
            addCriterion("`last_login_time` <>", value, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeGreaterThan(Date value) {
            addCriterion("`last_login_time` >", value, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("`last_login_time` >=", value, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeLessThan(Date value) {
            addCriterion("`last_login_time` <", value, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeLessThanOrEqualTo(Date value) {
            addCriterion("`last_login_time` <=", value, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeIn(List<Date> values) {
            addCriterion("`last_login_time` in", values, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeNotIn(List<Date> values) {
            addCriterion("`last_login_time` not in", values, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeBetween(Date value1, Date value2) {
            addCriterion("`last_login_time` between", value1, value2, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andLast_login_timeNotBetween(Date value1, Date value2) {
            addCriterion("`last_login_time` not between", value1, value2, "last_login_time");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("`openid` is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("`openid` is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("`openid` =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("`openid` <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("`openid` >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("`openid` >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("`openid` <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("`openid` <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("`openid` like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("`openid` not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("`openid` in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("`openid` not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("`openid` between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("`openid` not between", value1, value2, "openid");
            return (Criteria) this;
        }

        void setCriteria(List<Criterion> criteria) {
            this.criteria=criteria;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public Criterion() {
            super();
        }
    }
}