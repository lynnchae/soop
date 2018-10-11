package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public AdminStatisticExample() {
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

        public Criteria andTotal_product_countIsNull() {
            addCriterion("`total_product_count` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countIsNotNull() {
            addCriterion("`total_product_count` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countEqualTo(Integer value) {
            addCriterion("`total_product_count` =", value, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countNotEqualTo(Integer value) {
            addCriterion("`total_product_count` <>", value, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countGreaterThan(Integer value) {
            addCriterion("`total_product_count` >", value, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_product_count` >=", value, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countLessThan(Integer value) {
            addCriterion("`total_product_count` <", value, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countLessThanOrEqualTo(Integer value) {
            addCriterion("`total_product_count` <=", value, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countIn(List<Integer> values) {
            addCriterion("`total_product_count` in", values, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countNotIn(List<Integer> values) {
            addCriterion("`total_product_count` not in", values, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_count` between", value1, value2, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_count` not between", value1, value2, "total_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockIsNull() {
            addCriterion("`total_product_count_in_stock` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockIsNotNull() {
            addCriterion("`total_product_count_in_stock` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockEqualTo(Integer value) {
            addCriterion("`total_product_count_in_stock` =", value, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockNotEqualTo(Integer value) {
            addCriterion("`total_product_count_in_stock` <>", value, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockGreaterThan(Integer value) {
            addCriterion("`total_product_count_in_stock` >", value, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_product_count_in_stock` >=", value, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockLessThan(Integer value) {
            addCriterion("`total_product_count_in_stock` <", value, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockLessThanOrEqualTo(Integer value) {
            addCriterion("`total_product_count_in_stock` <=", value, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockIn(List<Integer> values) {
            addCriterion("`total_product_count_in_stock` in", values, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockNotIn(List<Integer> values) {
            addCriterion("`total_product_count_in_stock` not in", values, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_count_in_stock` between", value1, value2, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_product_count_in_stockNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_count_in_stock` not between", value1, value2, "total_product_count_in_stock");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countIsNull() {
            addCriterion("`total_hot_product_count` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countIsNotNull() {
            addCriterion("`total_hot_product_count` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countEqualTo(Integer value) {
            addCriterion("`total_hot_product_count` =", value, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countNotEqualTo(Integer value) {
            addCriterion("`total_hot_product_count` <>", value, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countGreaterThan(Integer value) {
            addCriterion("`total_hot_product_count` >", value, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_hot_product_count` >=", value, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countLessThan(Integer value) {
            addCriterion("`total_hot_product_count` <", value, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countLessThanOrEqualTo(Integer value) {
            addCriterion("`total_hot_product_count` <=", value, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countIn(List<Integer> values) {
            addCriterion("`total_hot_product_count` in", values, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countNotIn(List<Integer> values) {
            addCriterion("`total_hot_product_count` not in", values, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countBetween(Integer value1, Integer value2) {
            addCriterion("`total_hot_product_count` between", value1, value2, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_hot_product_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_hot_product_count` not between", value1, value2, "total_hot_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countIsNull() {
            addCriterion("`total_new_product_count` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countIsNotNull() {
            addCriterion("`total_new_product_count` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countEqualTo(Integer value) {
            addCriterion("`total_new_product_count` =", value, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countNotEqualTo(Integer value) {
            addCriterion("`total_new_product_count` <>", value, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countGreaterThan(Integer value) {
            addCriterion("`total_new_product_count` >", value, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_new_product_count` >=", value, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countLessThan(Integer value) {
            addCriterion("`total_new_product_count` <", value, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countLessThanOrEqualTo(Integer value) {
            addCriterion("`total_new_product_count` <=", value, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countIn(List<Integer> values) {
            addCriterion("`total_new_product_count` in", values, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countNotIn(List<Integer> values) {
            addCriterion("`total_new_product_count` not in", values, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countBetween(Integer value1, Integer value2) {
            addCriterion("`total_new_product_count` between", value1, value2, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_new_product_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_new_product_count` not between", value1, value2, "total_new_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countIsNull() {
            addCriterion("`total_promo_product_count` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countIsNotNull() {
            addCriterion("`total_promo_product_count` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countEqualTo(Integer value) {
            addCriterion("`total_promo_product_count` =", value, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countNotEqualTo(Integer value) {
            addCriterion("`total_promo_product_count` <>", value, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countGreaterThan(Integer value) {
            addCriterion("`total_promo_product_count` >", value, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_promo_product_count` >=", value, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countLessThan(Integer value) {
            addCriterion("`total_promo_product_count` <", value, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countLessThanOrEqualTo(Integer value) {
            addCriterion("`total_promo_product_count` <=", value, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countIn(List<Integer> values) {
            addCriterion("`total_promo_product_count` in", values, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countNotIn(List<Integer> values) {
            addCriterion("`total_promo_product_count` not in", values, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countBetween(Integer value1, Integer value2) {
            addCriterion("`total_promo_product_count` between", value1, value2, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_promo_product_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_promo_product_count` not between", value1, value2, "total_promo_product_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countIsNull() {
            addCriterion("`total_order_count` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countIsNotNull() {
            addCriterion("`total_order_count` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countEqualTo(Integer value) {
            addCriterion("`total_order_count` =", value, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countNotEqualTo(Integer value) {
            addCriterion("`total_order_count` <>", value, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countGreaterThan(Integer value) {
            addCriterion("`total_order_count` >", value, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_order_count` >=", value, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countLessThan(Integer value) {
            addCriterion("`total_order_count` <", value, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countLessThanOrEqualTo(Integer value) {
            addCriterion("`total_order_count` <=", value, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countIn(List<Integer> values) {
            addCriterion("`total_order_count` in", values, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countNotIn(List<Integer> values) {
            addCriterion("`total_order_count` not in", values, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countBetween(Integer value1, Integer value2) {
            addCriterion("`total_order_count` between", value1, value2, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_order_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_order_count` not between", value1, value2, "total_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countIsNull() {
            addCriterion("`pending_delivery_order_count` is null");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countIsNotNull() {
            addCriterion("`pending_delivery_order_count` is not null");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countEqualTo(Integer value) {
            addCriterion("`pending_delivery_order_count` =", value, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countNotEqualTo(Integer value) {
            addCriterion("`pending_delivery_order_count` <>", value, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countGreaterThan(Integer value) {
            addCriterion("`pending_delivery_order_count` >", value, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`pending_delivery_order_count` >=", value, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countLessThan(Integer value) {
            addCriterion("`pending_delivery_order_count` <", value, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countLessThanOrEqualTo(Integer value) {
            addCriterion("`pending_delivery_order_count` <=", value, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countIn(List<Integer> values) {
            addCriterion("`pending_delivery_order_count` in", values, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countNotIn(List<Integer> values) {
            addCriterion("`pending_delivery_order_count` not in", values, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countBetween(Integer value1, Integer value2) {
            addCriterion("`pending_delivery_order_count` between", value1, value2, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_delivery_order_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`pending_delivery_order_count` not between", value1, value2, "pending_delivery_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countIsNull() {
            addCriterion("`pending_pay_order_count` is null");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countIsNotNull() {
            addCriterion("`pending_pay_order_count` is not null");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countEqualTo(Integer value) {
            addCriterion("`pending_pay_order_count` =", value, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countNotEqualTo(Integer value) {
            addCriterion("`pending_pay_order_count` <>", value, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countGreaterThan(Integer value) {
            addCriterion("`pending_pay_order_count` >", value, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`pending_pay_order_count` >=", value, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countLessThan(Integer value) {
            addCriterion("`pending_pay_order_count` <", value, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countLessThanOrEqualTo(Integer value) {
            addCriterion("`pending_pay_order_count` <=", value, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countIn(List<Integer> values) {
            addCriterion("`pending_pay_order_count` in", values, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countNotIn(List<Integer> values) {
            addCriterion("`pending_pay_order_count` not in", values, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countBetween(Integer value1, Integer value2) {
            addCriterion("`pending_pay_order_count` between", value1, value2, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andPending_pay_order_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`pending_pay_order_count` not between", value1, value2, "pending_pay_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countIsNull() {
            addCriterion("`done_order_count` is null");
            return (Criteria) this;
        }

        public Criteria andDone_order_countIsNotNull() {
            addCriterion("`done_order_count` is not null");
            return (Criteria) this;
        }

        public Criteria andDone_order_countEqualTo(Integer value) {
            addCriterion("`done_order_count` =", value, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countNotEqualTo(Integer value) {
            addCriterion("`done_order_count` <>", value, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countGreaterThan(Integer value) {
            addCriterion("`done_order_count` >", value, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`done_order_count` >=", value, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countLessThan(Integer value) {
            addCriterion("`done_order_count` <", value, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countLessThanOrEqualTo(Integer value) {
            addCriterion("`done_order_count` <=", value, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countIn(List<Integer> values) {
            addCriterion("`done_order_count` in", values, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countNotIn(List<Integer> values) {
            addCriterion("`done_order_count` not in", values, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countBetween(Integer value1, Integer value2) {
            addCriterion("`done_order_count` between", value1, value2, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andDone_order_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`done_order_count` not between", value1, value2, "done_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countIsNull() {
            addCriterion("`refund_order_count` is null");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countIsNotNull() {
            addCriterion("`refund_order_count` is not null");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countEqualTo(Integer value) {
            addCriterion("`refund_order_count` =", value, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countNotEqualTo(Integer value) {
            addCriterion("`refund_order_count` <>", value, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countGreaterThan(Integer value) {
            addCriterion("`refund_order_count` >", value, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`refund_order_count` >=", value, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countLessThan(Integer value) {
            addCriterion("`refund_order_count` <", value, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countLessThanOrEqualTo(Integer value) {
            addCriterion("`refund_order_count` <=", value, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countIn(List<Integer> values) {
            addCriterion("`refund_order_count` in", values, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countNotIn(List<Integer> values) {
            addCriterion("`refund_order_count` not in", values, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countBetween(Integer value1, Integer value2) {
            addCriterion("`refund_order_count` between", value1, value2, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andRefund_order_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`refund_order_count` not between", value1, value2, "refund_order_count");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineIsNull() {
            addCriterion("`total_user_online` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineIsNotNull() {
            addCriterion("`total_user_online` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineEqualTo(Integer value) {
            addCriterion("`total_user_online` =", value, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineNotEqualTo(Integer value) {
            addCriterion("`total_user_online` <>", value, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineGreaterThan(Integer value) {
            addCriterion("`total_user_online` >", value, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_user_online` >=", value, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineLessThan(Integer value) {
            addCriterion("`total_user_online` <", value, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineLessThanOrEqualTo(Integer value) {
            addCriterion("`total_user_online` <=", value, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineIn(List<Integer> values) {
            addCriterion("`total_user_online` in", values, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineNotIn(List<Integer> values) {
            addCriterion("`total_user_online` not in", values, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineBetween(Integer value1, Integer value2) {
            addCriterion("`total_user_online` between", value1, value2, "total_user_online");
            return (Criteria) this;
        }

        public Criteria andTotal_user_onlineNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_user_online` not between", value1, value2, "total_user_online");
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