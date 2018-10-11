package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ProductAttributeExample() {
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

        public Criteria andAttr_nameIsNull() {
            addCriterion("`attr_name` is null");
            return (Criteria) this;
        }

        public Criteria andAttr_nameIsNotNull() {
            addCriterion("`attr_name` is not null");
            return (Criteria) this;
        }

        public Criteria andAttr_nameEqualTo(String value) {
            addCriterion("`attr_name` =", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameNotEqualTo(String value) {
            addCriterion("`attr_name` <>", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameGreaterThan(String value) {
            addCriterion("`attr_name` >", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`attr_name` >=", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameLessThan(String value) {
            addCriterion("`attr_name` <", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameLessThanOrEqualTo(String value) {
            addCriterion("`attr_name` <=", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameLike(String value) {
            addCriterion("`attr_name` like", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameNotLike(String value) {
            addCriterion("`attr_name` not like", value, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameIn(List<String> values) {
            addCriterion("`attr_name` in", values, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameNotIn(List<String> values) {
            addCriterion("`attr_name` not in", values, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameBetween(String value1, String value2) {
            addCriterion("`attr_name` between", value1, value2, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_nameNotBetween(String value1, String value2) {
            addCriterion("`attr_name` not between", value1, value2, "attr_name");
            return (Criteria) this;
        }

        public Criteria andAttr_valueIsNull() {
            addCriterion("`attr_value` is null");
            return (Criteria) this;
        }

        public Criteria andAttr_valueIsNotNull() {
            addCriterion("`attr_value` is not null");
            return (Criteria) this;
        }

        public Criteria andAttr_valueEqualTo(String value) {
            addCriterion("`attr_value` =", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueNotEqualTo(String value) {
            addCriterion("`attr_value` <>", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueGreaterThan(String value) {
            addCriterion("`attr_value` >", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueGreaterThanOrEqualTo(String value) {
            addCriterion("`attr_value` >=", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueLessThan(String value) {
            addCriterion("`attr_value` <", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueLessThanOrEqualTo(String value) {
            addCriterion("`attr_value` <=", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueLike(String value) {
            addCriterion("`attr_value` like", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueNotLike(String value) {
            addCriterion("`attr_value` not like", value, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueIn(List<String> values) {
            addCriterion("`attr_value` in", values, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueNotIn(List<String> values) {
            addCriterion("`attr_value` not in", values, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueBetween(String value1, String value2) {
            addCriterion("`attr_value` between", value1, value2, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_valueNotBetween(String value1, String value2) {
            addCriterion("`attr_value` not between", value1, value2, "attr_value");
            return (Criteria) this;
        }

        public Criteria andAttr_typeIsNull() {
            addCriterion("`attr_type` is null");
            return (Criteria) this;
        }

        public Criteria andAttr_typeIsNotNull() {
            addCriterion("`attr_type` is not null");
            return (Criteria) this;
        }

        public Criteria andAttr_typeEqualTo(String value) {
            addCriterion("`attr_type` =", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeNotEqualTo(String value) {
            addCriterion("`attr_type` <>", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeGreaterThan(String value) {
            addCriterion("`attr_type` >", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`attr_type` >=", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeLessThan(String value) {
            addCriterion("`attr_type` <", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeLessThanOrEqualTo(String value) {
            addCriterion("`attr_type` <=", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeLike(String value) {
            addCriterion("`attr_type` like", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeNotLike(String value) {
            addCriterion("`attr_type` not like", value, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeIn(List<String> values) {
            addCriterion("`attr_type` in", values, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeNotIn(List<String> values) {
            addCriterion("`attr_type` not in", values, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeBetween(String value1, String value2) {
            addCriterion("`attr_type` between", value1, value2, "attr_type");
            return (Criteria) this;
        }

        public Criteria andAttr_typeNotBetween(String value1, String value2) {
            addCriterion("`attr_type` not between", value1, value2, "attr_type");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idIsNull() {
            addCriterion("`product_category_id` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idIsNotNull() {
            addCriterion("`product_category_id` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idEqualTo(Long value) {
            addCriterion("`product_category_id` =", value, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idNotEqualTo(Long value) {
            addCriterion("`product_category_id` <>", value, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idGreaterThan(Long value) {
            addCriterion("`product_category_id` >", value, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`product_category_id` >=", value, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idLessThan(Long value) {
            addCriterion("`product_category_id` <", value, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idLessThanOrEqualTo(Long value) {
            addCriterion("`product_category_id` <=", value, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idIn(List<Long> values) {
            addCriterion("`product_category_id` in", values, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idNotIn(List<Long> values) {
            addCriterion("`product_category_id` not in", values, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idBetween(Long value1, Long value2) {
            addCriterion("`product_category_id` between", value1, value2, "product_category_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_idNotBetween(Long value1, Long value2) {
            addCriterion("`product_category_id` not between", value1, value2, "product_category_id");
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