package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseProductBatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public PurchaseProductBatchExample() {
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

        public Criteria andPurchase_product_batch_idIsNull() {
            addCriterion("`purchase_product_batch_id` is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idIsNotNull() {
            addCriterion("`purchase_product_batch_id` is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idEqualTo(Long value) {
            addCriterion("`purchase_product_batch_id` =", value, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idNotEqualTo(Long value) {
            addCriterion("`purchase_product_batch_id` <>", value, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idGreaterThan(Long value) {
            addCriterion("`purchase_product_batch_id` >", value, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`purchase_product_batch_id` >=", value, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idLessThan(Long value) {
            addCriterion("`purchase_product_batch_id` <", value, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idLessThanOrEqualTo(Long value) {
            addCriterion("`purchase_product_batch_id` <=", value, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idIn(List<Long> values) {
            addCriterion("`purchase_product_batch_id` in", values, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idNotIn(List<Long> values) {
            addCriterion("`purchase_product_batch_id` not in", values, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idBetween(Long value1, Long value2) {
            addCriterion("`purchase_product_batch_id` between", value1, value2, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_batch_idNotBetween(Long value1, Long value2) {
            addCriterion("`purchase_product_batch_id` not between", value1, value2, "purchase_product_batch_id");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countIsNull() {
            addCriterion("`plan_product_count` is null");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countIsNotNull() {
            addCriterion("`plan_product_count` is not null");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countEqualTo(Integer value) {
            addCriterion("`plan_product_count` =", value, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countNotEqualTo(Integer value) {
            addCriterion("`plan_product_count` <>", value, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countGreaterThan(Integer value) {
            addCriterion("`plan_product_count` >", value, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`plan_product_count` >=", value, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countLessThan(Integer value) {
            addCriterion("`plan_product_count` <", value, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countLessThanOrEqualTo(Integer value) {
            addCriterion("`plan_product_count` <=", value, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countIn(List<Integer> values) {
            addCriterion("`plan_product_count` in", values, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countNotIn(List<Integer> values) {
            addCriterion("`plan_product_count` not in", values, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countBetween(Integer value1, Integer value2) {
            addCriterion("`plan_product_count` between", value1, value2, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_product_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`plan_product_count` not between", value1, value2, "plan_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countIsNull() {
            addCriterion("`actual_product_count` is null");
            return (Criteria) this;
        }

        public Criteria andActual_product_countIsNotNull() {
            addCriterion("`actual_product_count` is not null");
            return (Criteria) this;
        }

        public Criteria andActual_product_countEqualTo(Integer value) {
            addCriterion("`actual_product_count` =", value, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countNotEqualTo(Integer value) {
            addCriterion("`actual_product_count` <>", value, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countGreaterThan(Integer value) {
            addCriterion("`actual_product_count` >", value, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`actual_product_count` >=", value, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countLessThan(Integer value) {
            addCriterion("`actual_product_count` <", value, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countLessThanOrEqualTo(Integer value) {
            addCriterion("`actual_product_count` <=", value, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countIn(List<Integer> values) {
            addCriterion("`actual_product_count` in", values, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countNotIn(List<Integer> values) {
            addCriterion("`actual_product_count` not in", values, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countBetween(Integer value1, Integer value2) {
            addCriterion("`actual_product_count` between", value1, value2, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andActual_product_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`actual_product_count` not between", value1, value2, "actual_product_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countIsNull() {
            addCriterion("`plan_total_item_count` is null");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countIsNotNull() {
            addCriterion("`plan_total_item_count` is not null");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countEqualTo(Integer value) {
            addCriterion("`plan_total_item_count` =", value, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countNotEqualTo(Integer value) {
            addCriterion("`plan_total_item_count` <>", value, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countGreaterThan(Integer value) {
            addCriterion("`plan_total_item_count` >", value, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`plan_total_item_count` >=", value, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countLessThan(Integer value) {
            addCriterion("`plan_total_item_count` <", value, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countLessThanOrEqualTo(Integer value) {
            addCriterion("`plan_total_item_count` <=", value, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countIn(List<Integer> values) {
            addCriterion("`plan_total_item_count` in", values, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countNotIn(List<Integer> values) {
            addCriterion("`plan_total_item_count` not in", values, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countBetween(Integer value1, Integer value2) {
            addCriterion("`plan_total_item_count` between", value1, value2, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andPlan_total_item_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`plan_total_item_count` not between", value1, value2, "plan_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countIsNull() {
            addCriterion("`actual_total_item_count` is null");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countIsNotNull() {
            addCriterion("`actual_total_item_count` is not null");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countEqualTo(Integer value) {
            addCriterion("`actual_total_item_count` =", value, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countNotEqualTo(Integer value) {
            addCriterion("`actual_total_item_count` <>", value, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countGreaterThan(Integer value) {
            addCriterion("`actual_total_item_count` >", value, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`actual_total_item_count` >=", value, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countLessThan(Integer value) {
            addCriterion("`actual_total_item_count` <", value, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countLessThanOrEqualTo(Integer value) {
            addCriterion("`actual_total_item_count` <=", value, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countIn(List<Integer> values) {
            addCriterion("`actual_total_item_count` in", values, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countNotIn(List<Integer> values) {
            addCriterion("`actual_total_item_count` not in", values, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countBetween(Integer value1, Integer value2) {
            addCriterion("`actual_total_item_count` between", value1, value2, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andActual_total_item_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`actual_total_item_count` not between", value1, value2, "actual_total_item_count");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageIsNull() {
            addCriterion("`progress_percentage` is null");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageIsNotNull() {
            addCriterion("`progress_percentage` is not null");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageEqualTo(Integer value) {
            addCriterion("`progress_percentage` =", value, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageNotEqualTo(Integer value) {
            addCriterion("`progress_percentage` <>", value, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageGreaterThan(Integer value) {
            addCriterion("`progress_percentage` >", value, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageGreaterThanOrEqualTo(Integer value) {
            addCriterion("`progress_percentage` >=", value, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageLessThan(Integer value) {
            addCriterion("`progress_percentage` <", value, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageLessThanOrEqualTo(Integer value) {
            addCriterion("`progress_percentage` <=", value, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageIn(List<Integer> values) {
            addCriterion("`progress_percentage` in", values, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageNotIn(List<Integer> values) {
            addCriterion("`progress_percentage` not in", values, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageBetween(Integer value1, Integer value2) {
            addCriterion("`progress_percentage` between", value1, value2, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andProgress_percentageNotBetween(Integer value1, Integer value2) {
            addCriterion("`progress_percentage` not between", value1, value2, "progress_percentage");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeIsNull() {
            addCriterion("`purchase_time` is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeIsNotNull() {
            addCriterion("`purchase_time` is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeEqualTo(Integer value) {
            addCriterion("`purchase_time` =", value, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeNotEqualTo(Integer value) {
            addCriterion("`purchase_time` <>", value, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeGreaterThan(Integer value) {
            addCriterion("`purchase_time` >", value, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`purchase_time` >=", value, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeLessThan(Integer value) {
            addCriterion("`purchase_time` <", value, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeLessThanOrEqualTo(Integer value) {
            addCriterion("`purchase_time` <=", value, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeIn(List<Integer> values) {
            addCriterion("`purchase_time` in", values, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeNotIn(List<Integer> values) {
            addCriterion("`purchase_time` not in", values, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeBetween(Integer value1, Integer value2) {
            addCriterion("`purchase_time` between", value1, value2, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andPurchase_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("`purchase_time` not between", value1, value2, "purchase_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNull() {
            addCriterion("`start_time` is null");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNotNull() {
            addCriterion("`start_time` is not null");
            return (Criteria) this;
        }

        public Criteria andStart_timeEqualTo(Date value) {
            addCriterion("`start_time` =", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotEqualTo(Date value) {
            addCriterion("`start_time` <>", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThan(Date value) {
            addCriterion("`start_time` >", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("`start_time` >=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThan(Date value) {
            addCriterion("`start_time` <", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThanOrEqualTo(Date value) {
            addCriterion("`start_time` <=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIn(List<Date> values) {
            addCriterion("`start_time` in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotIn(List<Date> values) {
            addCriterion("`start_time` not in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeBetween(Date value1, Date value2) {
            addCriterion("`start_time` between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotBetween(Date value1, Date value2) {
            addCriterion("`start_time` not between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("`end_time` is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("`end_time` is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("`end_time` =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("`end_time` <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("`end_time` >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("`end_time` >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("`end_time` <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("`end_time` <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("`end_time` in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("`end_time` not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("`end_time` between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("`end_time` not between", value1, value2, "end_time");
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