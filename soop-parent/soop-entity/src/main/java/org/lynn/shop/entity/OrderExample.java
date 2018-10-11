package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public OrderExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("`id` like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("`id` not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountIsNull() {
            addCriterion("`total_product_amount` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountIsNotNull() {
            addCriterion("`total_product_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountEqualTo(Integer value) {
            addCriterion("`total_product_amount` =", value, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountNotEqualTo(Integer value) {
            addCriterion("`total_product_amount` <>", value, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountGreaterThan(Integer value) {
            addCriterion("`total_product_amount` >", value, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_product_amount` >=", value, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountLessThan(Integer value) {
            addCriterion("`total_product_amount` <", value, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountLessThanOrEqualTo(Integer value) {
            addCriterion("`total_product_amount` <=", value, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountIn(List<Integer> values) {
            addCriterion("`total_product_amount` in", values, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountNotIn(List<Integer> values) {
            addCriterion("`total_product_amount` not in", values, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_amount` between", value1, value2, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_product_amountNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_amount` not between", value1, value2, "total_product_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountIsNull() {
            addCriterion("`total_order_amount` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountIsNotNull() {
            addCriterion("`total_order_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountEqualTo(Integer value) {
            addCriterion("`total_order_amount` =", value, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountNotEqualTo(Integer value) {
            addCriterion("`total_order_amount` <>", value, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountGreaterThan(Integer value) {
            addCriterion("`total_order_amount` >", value, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_order_amount` >=", value, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountLessThan(Integer value) {
            addCriterion("`total_order_amount` <", value, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountLessThanOrEqualTo(Integer value) {
            addCriterion("`total_order_amount` <=", value, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountIn(List<Integer> values) {
            addCriterion("`total_order_amount` in", values, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountNotIn(List<Integer> values) {
            addCriterion("`total_order_amount` not in", values, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountBetween(Integer value1, Integer value2) {
            addCriterion("`total_order_amount` between", value1, value2, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_order_amountNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_order_amount` not between", value1, value2, "total_order_amount");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorIsNull() {
            addCriterion("`post_delivery_factor` is null");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorIsNotNull() {
            addCriterion("`post_delivery_factor` is not null");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorEqualTo(Integer value) {
            addCriterion("`post_delivery_factor` =", value, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorNotEqualTo(Integer value) {
            addCriterion("`post_delivery_factor` <>", value, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorGreaterThan(Integer value) {
            addCriterion("`post_delivery_factor` >", value, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorGreaterThanOrEqualTo(Integer value) {
            addCriterion("`post_delivery_factor` >=", value, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorLessThan(Integer value) {
            addCriterion("`post_delivery_factor` <", value, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorLessThanOrEqualTo(Integer value) {
            addCriterion("`post_delivery_factor` <=", value, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorIn(List<Integer> values) {
            addCriterion("`post_delivery_factor` in", values, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorNotIn(List<Integer> values) {
            addCriterion("`post_delivery_factor` not in", values, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorBetween(Integer value1, Integer value2) {
            addCriterion("`post_delivery_factor` between", value1, value2, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_factorNotBetween(Integer value1, Integer value2) {
            addCriterion("`post_delivery_factor` not between", value1, value2, "post_delivery_factor");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noIsNull() {
            addCriterion("`post_delivery_order_no` is null");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noIsNotNull() {
            addCriterion("`post_delivery_order_no` is not null");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noEqualTo(String value) {
            addCriterion("`post_delivery_order_no` =", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noNotEqualTo(String value) {
            addCriterion("`post_delivery_order_no` <>", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noGreaterThan(String value) {
            addCriterion("`post_delivery_order_no` >", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noGreaterThanOrEqualTo(String value) {
            addCriterion("`post_delivery_order_no` >=", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noLessThan(String value) {
            addCriterion("`post_delivery_order_no` <", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noLessThanOrEqualTo(String value) {
            addCriterion("`post_delivery_order_no` <=", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noLike(String value) {
            addCriterion("`post_delivery_order_no` like", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noNotLike(String value) {
            addCriterion("`post_delivery_order_no` not like", value, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noIn(List<String> values) {
            addCriterion("`post_delivery_order_no` in", values, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noNotIn(List<String> values) {
            addCriterion("`post_delivery_order_no` not in", values, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noBetween(String value1, String value2) {
            addCriterion("`post_delivery_order_no` between", value1, value2, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andPost_delivery_order_noNotBetween(String value1, String value2) {
            addCriterion("`post_delivery_order_no` not between", value1, value2, "post_delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressIsNull() {
            addCriterion("`delivery_address` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressIsNotNull() {
            addCriterion("`delivery_address` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressEqualTo(String value) {
            addCriterion("`delivery_address` =", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressNotEqualTo(String value) {
            addCriterion("`delivery_address` <>", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressGreaterThan(String value) {
            addCriterion("`delivery_address` >", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressGreaterThanOrEqualTo(String value) {
            addCriterion("`delivery_address` >=", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressLessThan(String value) {
            addCriterion("`delivery_address` <", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressLessThanOrEqualTo(String value) {
            addCriterion("`delivery_address` <=", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressLike(String value) {
            addCriterion("`delivery_address` like", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressNotLike(String value) {
            addCriterion("`delivery_address` not like", value, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressIn(List<String> values) {
            addCriterion("`delivery_address` in", values, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressNotIn(List<String> values) {
            addCriterion("`delivery_address` not in", values, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressBetween(String value1, String value2) {
            addCriterion("`delivery_address` between", value1, value2, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_addressNotBetween(String value1, String value2) {
            addCriterion("`delivery_address` not between", value1, value2, "delivery_address");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeIsNull() {
            addCriterion("`delivery_post_code` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeIsNotNull() {
            addCriterion("`delivery_post_code` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeEqualTo(String value) {
            addCriterion("`delivery_post_code` =", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeNotEqualTo(String value) {
            addCriterion("`delivery_post_code` <>", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeGreaterThan(String value) {
            addCriterion("`delivery_post_code` >", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`delivery_post_code` >=", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeLessThan(String value) {
            addCriterion("`delivery_post_code` <", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeLessThanOrEqualTo(String value) {
            addCriterion("`delivery_post_code` <=", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeLike(String value) {
            addCriterion("`delivery_post_code` like", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeNotLike(String value) {
            addCriterion("`delivery_post_code` not like", value, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeIn(List<String> values) {
            addCriterion("`delivery_post_code` in", values, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeNotIn(List<String> values) {
            addCriterion("`delivery_post_code` not in", values, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeBetween(String value1, String value2) {
            addCriterion("`delivery_post_code` between", value1, value2, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_post_codeNotBetween(String value1, String value2) {
            addCriterion("`delivery_post_code` not between", value1, value2, "delivery_post_code");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameIsNull() {
            addCriterion("`delivery_contact_name` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameIsNotNull() {
            addCriterion("`delivery_contact_name` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameEqualTo(String value) {
            addCriterion("`delivery_contact_name` =", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameNotEqualTo(String value) {
            addCriterion("`delivery_contact_name` <>", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameGreaterThan(String value) {
            addCriterion("`delivery_contact_name` >", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`delivery_contact_name` >=", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameLessThan(String value) {
            addCriterion("`delivery_contact_name` <", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameLessThanOrEqualTo(String value) {
            addCriterion("`delivery_contact_name` <=", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameLike(String value) {
            addCriterion("`delivery_contact_name` like", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameNotLike(String value) {
            addCriterion("`delivery_contact_name` not like", value, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameIn(List<String> values) {
            addCriterion("`delivery_contact_name` in", values, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameNotIn(List<String> values) {
            addCriterion("`delivery_contact_name` not in", values, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameBetween(String value1, String value2) {
            addCriterion("`delivery_contact_name` between", value1, value2, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_nameNotBetween(String value1, String value2) {
            addCriterion("`delivery_contact_name` not between", value1, value2, "delivery_contact_name");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneIsNull() {
            addCriterion("`delivery_contact_phone` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneIsNotNull() {
            addCriterion("`delivery_contact_phone` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneEqualTo(String value) {
            addCriterion("`delivery_contact_phone` =", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneNotEqualTo(String value) {
            addCriterion("`delivery_contact_phone` <>", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneGreaterThan(String value) {
            addCriterion("`delivery_contact_phone` >", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("`delivery_contact_phone` >=", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneLessThan(String value) {
            addCriterion("`delivery_contact_phone` <", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneLessThanOrEqualTo(String value) {
            addCriterion("`delivery_contact_phone` <=", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneLike(String value) {
            addCriterion("`delivery_contact_phone` like", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneNotLike(String value) {
            addCriterion("`delivery_contact_phone` not like", value, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneIn(List<String> values) {
            addCriterion("`delivery_contact_phone` in", values, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneNotIn(List<String> values) {
            addCriterion("`delivery_contact_phone` not in", values, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneBetween(String value1, String value2) {
            addCriterion("`delivery_contact_phone` between", value1, value2, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andDelivery_contact_phoneNotBetween(String value1, String value2) {
            addCriterion("`delivery_contact_phone` not between", value1, value2, "delivery_contact_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionIsNull() {
            addCriterion("`order_description` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionIsNotNull() {
            addCriterion("`order_description` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionEqualTo(String value) {
            addCriterion("`order_description` =", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionNotEqualTo(String value) {
            addCriterion("`order_description` <>", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionGreaterThan(String value) {
            addCriterion("`order_description` >", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionGreaterThanOrEqualTo(String value) {
            addCriterion("`order_description` >=", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionLessThan(String value) {
            addCriterion("`order_description` <", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionLessThanOrEqualTo(String value) {
            addCriterion("`order_description` <=", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionLike(String value) {
            addCriterion("`order_description` like", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionNotLike(String value) {
            addCriterion("`order_description` not like", value, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionIn(List<String> values) {
            addCriterion("`order_description` in", values, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionNotIn(List<String> values) {
            addCriterion("`order_description` not in", values, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionBetween(String value1, String value2) {
            addCriterion("`order_description` between", value1, value2, "order_description");
            return (Criteria) this;
        }

        public Criteria andOrder_descriptionNotBetween(String value1, String value2) {
            addCriterion("`order_description` not between", value1, value2, "order_description");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberIsNull() {
            addCriterion("`total_product_number` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberIsNotNull() {
            addCriterion("`total_product_number` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberEqualTo(Integer value) {
            addCriterion("`total_product_number` =", value, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberNotEqualTo(Integer value) {
            addCriterion("`total_product_number` <>", value, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberGreaterThan(Integer value) {
            addCriterion("`total_product_number` >", value, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_product_number` >=", value, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberLessThan(Integer value) {
            addCriterion("`total_product_number` <", value, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberLessThanOrEqualTo(Integer value) {
            addCriterion("`total_product_number` <=", value, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberIn(List<Integer> values) {
            addCriterion("`total_product_number` in", values, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberNotIn(List<Integer> values) {
            addCriterion("`total_product_number` not in", values, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_number` between", value1, value2, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_product_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_product_number` not between", value1, value2, "total_product_number");
            return (Criteria) this;
        }

        public Criteria andTotal_weightIsNull() {
            addCriterion("`total_weight` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_weightIsNotNull() {
            addCriterion("`total_weight` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_weightEqualTo(Integer value) {
            addCriterion("`total_weight` =", value, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightNotEqualTo(Integer value) {
            addCriterion("`total_weight` <>", value, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightGreaterThan(Integer value) {
            addCriterion("`total_weight` >", value, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightGreaterThanOrEqualTo(Integer value) {
            addCriterion("`total_weight` >=", value, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightLessThan(Integer value) {
            addCriterion("`total_weight` <", value, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightLessThanOrEqualTo(Integer value) {
            addCriterion("`total_weight` <=", value, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightIn(List<Integer> values) {
            addCriterion("`total_weight` in", values, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightNotIn(List<Integer> values) {
            addCriterion("`total_weight` not in", values, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightBetween(Integer value1, Integer value2) {
            addCriterion("`total_weight` between", value1, value2, "total_weight");
            return (Criteria) this;
        }

        public Criteria andTotal_weightNotBetween(Integer value1, Integer value2) {
            addCriterion("`total_weight` not between", value1, value2, "total_weight");
            return (Criteria) this;
        }

        public Criteria andAddress_idIsNull() {
            addCriterion("`address_id` is null");
            return (Criteria) this;
        }

        public Criteria andAddress_idIsNotNull() {
            addCriterion("`address_id` is not null");
            return (Criteria) this;
        }

        public Criteria andAddress_idEqualTo(Long value) {
            addCriterion("`address_id` =", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotEqualTo(Long value) {
            addCriterion("`address_id` <>", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThan(Long value) {
            addCriterion("`address_id` >", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`address_id` >=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThan(Long value) {
            addCriterion("`address_id` <", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThanOrEqualTo(Long value) {
            addCriterion("`address_id` <=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idIn(List<Long> values) {
            addCriterion("`address_id` in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotIn(List<Long> values) {
            addCriterion("`address_id` not in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idBetween(Long value1, Long value2) {
            addCriterion("`address_id` between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotBetween(Long value1, Long value2) {
            addCriterion("`address_id` not between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("`freight` is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("`freight` is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Integer value) {
            addCriterion("`freight` =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Integer value) {
            addCriterion("`freight` <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Integer value) {
            addCriterion("`freight` >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Integer value) {
            addCriterion("`freight` >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Integer value) {
            addCriterion("`freight` <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Integer value) {
            addCriterion("`freight` <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Integer> values) {
            addCriterion("`freight` in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Integer> values) {
            addCriterion("`freight` not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Integer value1, Integer value2) {
            addCriterion("`freight` between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Integer value1, Integer value2) {
            addCriterion("`freight` not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountIsNull() {
            addCriterion("`discount_amount` is null");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountIsNotNull() {
            addCriterion("`discount_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountEqualTo(Integer value) {
            addCriterion("`discount_amount` =", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotEqualTo(Integer value) {
            addCriterion("`discount_amount` <>", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountGreaterThan(Integer value) {
            addCriterion("`discount_amount` >", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountGreaterThanOrEqualTo(Integer value) {
            addCriterion("`discount_amount` >=", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountLessThan(Integer value) {
            addCriterion("`discount_amount` <", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountLessThanOrEqualTo(Integer value) {
            addCriterion("`discount_amount` <=", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountIn(List<Integer> values) {
            addCriterion("`discount_amount` in", values, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotIn(List<Integer> values) {
            addCriterion("`discount_amount` not in", values, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountBetween(Integer value1, Integer value2) {
            addCriterion("`discount_amount` between", value1, value2, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotBetween(Integer value1, Integer value2) {
            addCriterion("`discount_amount` not between", value1, value2, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightIsNull() {
            addCriterion("`delivery_freight` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightIsNotNull() {
            addCriterion("`delivery_freight` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightEqualTo(Integer value) {
            addCriterion("`delivery_freight` =", value, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightNotEqualTo(Integer value) {
            addCriterion("`delivery_freight` <>", value, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightGreaterThan(Integer value) {
            addCriterion("`delivery_freight` >", value, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightGreaterThanOrEqualTo(Integer value) {
            addCriterion("`delivery_freight` >=", value, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightLessThan(Integer value) {
            addCriterion("`delivery_freight` <", value, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightLessThanOrEqualTo(Integer value) {
            addCriterion("`delivery_freight` <=", value, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightIn(List<Integer> values) {
            addCriterion("`delivery_freight` in", values, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightNotIn(List<Integer> values) {
            addCriterion("`delivery_freight` not in", values, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightBetween(Integer value1, Integer value2) {
            addCriterion("`delivery_freight` between", value1, value2, "delivery_freight");
            return (Criteria) this;
        }

        public Criteria andDelivery_freightNotBetween(Integer value1, Integer value2) {
            addCriterion("`delivery_freight` not between", value1, value2, "delivery_freight");
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