package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabasechangeloglockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public DatabasechangeloglockExample() {
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

        public Criteria andIDIsNull() {
            addCriterion("`ID` is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("`ID` is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("`ID` =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("`ID` <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("`ID` >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("`ID` >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("`ID` <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("`ID` <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("`ID` in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("`ID` not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("`ID` between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("`ID` not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andLOCKEDIsNull() {
            addCriterion("`LOCKED` is null");
            return (Criteria) this;
        }

        public Criteria andLOCKEDIsNotNull() {
            addCriterion("`LOCKED` is not null");
            return (Criteria) this;
        }

        public Criteria andLOCKEDEqualTo(Boolean value) {
            addCriterion("`LOCKED` =", value, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDNotEqualTo(Boolean value) {
            addCriterion("`LOCKED` <>", value, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDGreaterThan(Boolean value) {
            addCriterion("`LOCKED` >", value, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`LOCKED` >=", value, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDLessThan(Boolean value) {
            addCriterion("`LOCKED` <", value, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDLessThanOrEqualTo(Boolean value) {
            addCriterion("`LOCKED` <=", value, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDIn(List<Boolean> values) {
            addCriterion("`LOCKED` in", values, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDNotIn(List<Boolean> values) {
            addCriterion("`LOCKED` not in", values, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBetween(Boolean value1, Boolean value2) {
            addCriterion("`LOCKED` between", value1, value2, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`LOCKED` not between", value1, value2, "LOCKED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDIsNull() {
            addCriterion("`LOCKGRANTED` is null");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDIsNotNull() {
            addCriterion("`LOCKGRANTED` is not null");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDEqualTo(Date value) {
            addCriterion("`LOCKGRANTED` =", value, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDNotEqualTo(Date value) {
            addCriterion("`LOCKGRANTED` <>", value, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDGreaterThan(Date value) {
            addCriterion("`LOCKGRANTED` >", value, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDGreaterThanOrEqualTo(Date value) {
            addCriterion("`LOCKGRANTED` >=", value, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDLessThan(Date value) {
            addCriterion("`LOCKGRANTED` <", value, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDLessThanOrEqualTo(Date value) {
            addCriterion("`LOCKGRANTED` <=", value, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDIn(List<Date> values) {
            addCriterion("`LOCKGRANTED` in", values, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDNotIn(List<Date> values) {
            addCriterion("`LOCKGRANTED` not in", values, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDBetween(Date value1, Date value2) {
            addCriterion("`LOCKGRANTED` between", value1, value2, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKGRANTEDNotBetween(Date value1, Date value2) {
            addCriterion("`LOCKGRANTED` not between", value1, value2, "LOCKGRANTED");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYIsNull() {
            addCriterion("`LOCKEDBY` is null");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYIsNotNull() {
            addCriterion("`LOCKEDBY` is not null");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYEqualTo(String value) {
            addCriterion("`LOCKEDBY` =", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYNotEqualTo(String value) {
            addCriterion("`LOCKEDBY` <>", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYGreaterThan(String value) {
            addCriterion("`LOCKEDBY` >", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYGreaterThanOrEqualTo(String value) {
            addCriterion("`LOCKEDBY` >=", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYLessThan(String value) {
            addCriterion("`LOCKEDBY` <", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYLessThanOrEqualTo(String value) {
            addCriterion("`LOCKEDBY` <=", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYLike(String value) {
            addCriterion("`LOCKEDBY` like", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYNotLike(String value) {
            addCriterion("`LOCKEDBY` not like", value, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYIn(List<String> values) {
            addCriterion("`LOCKEDBY` in", values, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYNotIn(List<String> values) {
            addCriterion("`LOCKEDBY` not in", values, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYBetween(String value1, String value2) {
            addCriterion("`LOCKEDBY` between", value1, value2, "LOCKEDBY");
            return (Criteria) this;
        }

        public Criteria andLOCKEDBYNotBetween(String value1, String value2) {
            addCriterion("`LOCKEDBY` not between", value1, value2, "LOCKEDBY");
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