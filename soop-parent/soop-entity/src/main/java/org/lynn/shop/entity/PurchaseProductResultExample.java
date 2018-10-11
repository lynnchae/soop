package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseProductResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public PurchaseProductResultExample() {
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

        public Criteria andPurchase_product_requestIsNull() {
            addCriterion("`purchase_product_request` is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestIsNotNull() {
            addCriterion("`purchase_product_request` is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestEqualTo(Long value) {
            addCriterion("`purchase_product_request` =", value, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestNotEqualTo(Long value) {
            addCriterion("`purchase_product_request` <>", value, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestGreaterThan(Long value) {
            addCriterion("`purchase_product_request` >", value, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestGreaterThanOrEqualTo(Long value) {
            addCriterion("`purchase_product_request` >=", value, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestLessThan(Long value) {
            addCriterion("`purchase_product_request` <", value, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestLessThanOrEqualTo(Long value) {
            addCriterion("`purchase_product_request` <=", value, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestIn(List<Long> values) {
            addCriterion("`purchase_product_request` in", values, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestNotIn(List<Long> values) {
            addCriterion("`purchase_product_request` not in", values, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestBetween(Long value1, Long value2) {
            addCriterion("`purchase_product_request` between", value1, value2, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andPurchase_product_requestNotBetween(Long value1, Long value2) {
            addCriterion("`purchase_product_request` not between", value1, value2, "purchase_product_request");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNull() {
            addCriterion("`product_id` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNotNull() {
            addCriterion("`product_id` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_idEqualTo(Long value) {
            addCriterion("`product_id` =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotEqualTo(Long value) {
            addCriterion("`product_id` <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThan(Long value) {
            addCriterion("`product_id` >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`product_id` >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThan(Long value) {
            addCriterion("`product_id` <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThanOrEqualTo(Long value) {
            addCriterion("`product_id` <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIn(List<Long> values) {
            addCriterion("`product_id` in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotIn(List<Long> values) {
            addCriterion("`product_id` not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idBetween(Long value1, Long value2) {
            addCriterion("`product_id` between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotBetween(Long value1, Long value2) {
            addCriterion("`product_id` not between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityIsNull() {
            addCriterion("`plan_quantity` is null");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityIsNotNull() {
            addCriterion("`plan_quantity` is not null");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityEqualTo(Integer value) {
            addCriterion("`plan_quantity` =", value, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityNotEqualTo(Integer value) {
            addCriterion("`plan_quantity` <>", value, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityGreaterThan(Integer value) {
            addCriterion("`plan_quantity` >", value, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("`plan_quantity` >=", value, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityLessThan(Integer value) {
            addCriterion("`plan_quantity` <", value, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityLessThanOrEqualTo(Integer value) {
            addCriterion("`plan_quantity` <=", value, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityIn(List<Integer> values) {
            addCriterion("`plan_quantity` in", values, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityNotIn(List<Integer> values) {
            addCriterion("`plan_quantity` not in", values, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityBetween(Integer value1, Integer value2) {
            addCriterion("`plan_quantity` between", value1, value2, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andPlan_quantityNotBetween(Integer value1, Integer value2) {
            addCriterion("`plan_quantity` not between", value1, value2, "plan_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityIsNull() {
            addCriterion("`actual_quantity` is null");
            return (Criteria) this;
        }

        public Criteria andActual_quantityIsNotNull() {
            addCriterion("`actual_quantity` is not null");
            return (Criteria) this;
        }

        public Criteria andActual_quantityEqualTo(Integer value) {
            addCriterion("`actual_quantity` =", value, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityNotEqualTo(Integer value) {
            addCriterion("`actual_quantity` <>", value, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityGreaterThan(Integer value) {
            addCriterion("`actual_quantity` >", value, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("`actual_quantity` >=", value, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityLessThan(Integer value) {
            addCriterion("`actual_quantity` <", value, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityLessThanOrEqualTo(Integer value) {
            addCriterion("`actual_quantity` <=", value, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityIn(List<Integer> values) {
            addCriterion("`actual_quantity` in", values, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityNotIn(List<Integer> values) {
            addCriterion("`actual_quantity` not in", values, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityBetween(Integer value1, Integer value2) {
            addCriterion("`actual_quantity` between", value1, value2, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andActual_quantityNotBetween(Integer value1, Integer value2) {
            addCriterion("`actual_quantity` not between", value1, value2, "actual_quantity");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceIsNull() {
            addCriterion("`purchase_price` is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceIsNotNull() {
            addCriterion("`purchase_price` is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceEqualTo(Integer value) {
            addCriterion("`purchase_price` =", value, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceNotEqualTo(Integer value) {
            addCriterion("`purchase_price` <>", value, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceGreaterThan(Integer value) {
            addCriterion("`purchase_price` >", value, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceGreaterThanOrEqualTo(Integer value) {
            addCriterion("`purchase_price` >=", value, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceLessThan(Integer value) {
            addCriterion("`purchase_price` <", value, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceLessThanOrEqualTo(Integer value) {
            addCriterion("`purchase_price` <=", value, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceIn(List<Integer> values) {
            addCriterion("`purchase_price` in", values, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceNotIn(List<Integer> values) {
            addCriterion("`purchase_price` not in", values, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceBetween(Integer value1, Integer value2) {
            addCriterion("`purchase_price` between", value1, value2, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andPurchase_priceNotBetween(Integer value1, Integer value2) {
            addCriterion("`purchase_price` not between", value1, value2, "purchase_price");
            return (Criteria) this;
        }

        public Criteria andExchange_rateIsNull() {
            addCriterion("`exchange_rate` is null");
            return (Criteria) this;
        }

        public Criteria andExchange_rateIsNotNull() {
            addCriterion("`exchange_rate` is not null");
            return (Criteria) this;
        }

        public Criteria andExchange_rateEqualTo(Integer value) {
            addCriterion("`exchange_rate` =", value, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateNotEqualTo(Integer value) {
            addCriterion("`exchange_rate` <>", value, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateGreaterThan(Integer value) {
            addCriterion("`exchange_rate` >", value, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`exchange_rate` >=", value, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateLessThan(Integer value) {
            addCriterion("`exchange_rate` <", value, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateLessThanOrEqualTo(Integer value) {
            addCriterion("`exchange_rate` <=", value, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateIn(List<Integer> values) {
            addCriterion("`exchange_rate` in", values, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateNotIn(List<Integer> values) {
            addCriterion("`exchange_rate` not in", values, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateBetween(Integer value1, Integer value2) {
            addCriterion("`exchange_rate` between", value1, value2, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andExchange_rateNotBetween(Integer value1, Integer value2) {
            addCriterion("`exchange_rate` not between", value1, value2, "exchange_rate");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdIsNull() {
            addCriterion("`purchase_price_in_usd` is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdIsNotNull() {
            addCriterion("`purchase_price_in_usd` is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdEqualTo(Integer value) {
            addCriterion("`purchase_price_in_usd` =", value, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdNotEqualTo(Integer value) {
            addCriterion("`purchase_price_in_usd` <>", value, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdGreaterThan(Integer value) {
            addCriterion("`purchase_price_in_usd` >", value, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`purchase_price_in_usd` >=", value, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdLessThan(Integer value) {
            addCriterion("`purchase_price_in_usd` <", value, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdLessThanOrEqualTo(Integer value) {
            addCriterion("`purchase_price_in_usd` <=", value, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdIn(List<Integer> values) {
            addCriterion("`purchase_price_in_usd` in", values, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdNotIn(List<Integer> values) {
            addCriterion("`purchase_price_in_usd` not in", values, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdBetween(Integer value1, Integer value2) {
            addCriterion("`purchase_price_in_usd` between", value1, value2, "purchase_price_in_usd");
            return (Criteria) this;
        }

        public Criteria andPurchase_price_in_usdNotBetween(Integer value1, Integer value2) {
            addCriterion("`purchase_price_in_usd` not between", value1, value2, "purchase_price_in_usd");
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