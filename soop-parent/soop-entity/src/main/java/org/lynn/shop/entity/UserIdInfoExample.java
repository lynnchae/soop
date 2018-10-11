package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIdInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public UserIdInfoExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("`user_id` is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("`user_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("`user_id` =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("`user_id` <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("`user_id` >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`user_id` >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("`user_id` <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("`user_id` <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("`user_id` in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("`user_id` not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("`user_id` between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("`user_id` not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andId_front_imageIsNull() {
            addCriterion("`id_front_image` is null");
            return (Criteria) this;
        }

        public Criteria andId_front_imageIsNotNull() {
            addCriterion("`id_front_image` is not null");
            return (Criteria) this;
        }

        public Criteria andId_front_imageEqualTo(String value) {
            addCriterion("`id_front_image` =", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageNotEqualTo(String value) {
            addCriterion("`id_front_image` <>", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageGreaterThan(String value) {
            addCriterion("`id_front_image` >", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageGreaterThanOrEqualTo(String value) {
            addCriterion("`id_front_image` >=", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageLessThan(String value) {
            addCriterion("`id_front_image` <", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageLessThanOrEqualTo(String value) {
            addCriterion("`id_front_image` <=", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageLike(String value) {
            addCriterion("`id_front_image` like", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageNotLike(String value) {
            addCriterion("`id_front_image` not like", value, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageIn(List<String> values) {
            addCriterion("`id_front_image` in", values, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageNotIn(List<String> values) {
            addCriterion("`id_front_image` not in", values, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageBetween(String value1, String value2) {
            addCriterion("`id_front_image` between", value1, value2, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_front_imageNotBetween(String value1, String value2) {
            addCriterion("`id_front_image` not between", value1, value2, "id_front_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageIsNull() {
            addCriterion("`id_back_image` is null");
            return (Criteria) this;
        }

        public Criteria andId_back_imageIsNotNull() {
            addCriterion("`id_back_image` is not null");
            return (Criteria) this;
        }

        public Criteria andId_back_imageEqualTo(String value) {
            addCriterion("`id_back_image` =", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageNotEqualTo(String value) {
            addCriterion("`id_back_image` <>", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageGreaterThan(String value) {
            addCriterion("`id_back_image` >", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageGreaterThanOrEqualTo(String value) {
            addCriterion("`id_back_image` >=", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageLessThan(String value) {
            addCriterion("`id_back_image` <", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageLessThanOrEqualTo(String value) {
            addCriterion("`id_back_image` <=", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageLike(String value) {
            addCriterion("`id_back_image` like", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageNotLike(String value) {
            addCriterion("`id_back_image` not like", value, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageIn(List<String> values) {
            addCriterion("`id_back_image` in", values, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageNotIn(List<String> values) {
            addCriterion("`id_back_image` not in", values, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageBetween(String value1, String value2) {
            addCriterion("`id_back_image` between", value1, value2, "id_back_image");
            return (Criteria) this;
        }

        public Criteria andId_back_imageNotBetween(String value1, String value2) {
            addCriterion("`id_back_image` not between", value1, value2, "id_back_image");
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