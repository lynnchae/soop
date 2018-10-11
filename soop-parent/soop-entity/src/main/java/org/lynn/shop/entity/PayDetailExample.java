package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PayDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public PayDetailExample() {
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

        public Criteria andOrder_idIsNull() {
            addCriterion("`order_id` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("`order_id` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(String value) {
            addCriterion("`order_id` =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(String value) {
            addCriterion("`order_id` <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(String value) {
            addCriterion("`order_id` >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(String value) {
            addCriterion("`order_id` >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(String value) {
            addCriterion("`order_id` <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(String value) {
            addCriterion("`order_id` <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLike(String value) {
            addCriterion("`order_id` like", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotLike(String value) {
            addCriterion("`order_id` not like", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<String> values) {
            addCriterion("`order_id` in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<String> values) {
            addCriterion("`order_id` not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(String value1, String value2) {
            addCriterion("`order_id` between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(String value1, String value2) {
            addCriterion("`order_id` not between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andInner_order_noIsNull() {
            addCriterion("`inner_order_no` is null");
            return (Criteria) this;
        }

        public Criteria andInner_order_noIsNotNull() {
            addCriterion("`inner_order_no` is not null");
            return (Criteria) this;
        }

        public Criteria andInner_order_noEqualTo(String value) {
            addCriterion("`inner_order_no` =", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noNotEqualTo(String value) {
            addCriterion("`inner_order_no` <>", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noGreaterThan(String value) {
            addCriterion("`inner_order_no` >", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noGreaterThanOrEqualTo(String value) {
            addCriterion("`inner_order_no` >=", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noLessThan(String value) {
            addCriterion("`inner_order_no` <", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noLessThanOrEqualTo(String value) {
            addCriterion("`inner_order_no` <=", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noLike(String value) {
            addCriterion("`inner_order_no` like", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noNotLike(String value) {
            addCriterion("`inner_order_no` not like", value, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noIn(List<String> values) {
            addCriterion("`inner_order_no` in", values, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noNotIn(List<String> values) {
            addCriterion("`inner_order_no` not in", values, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noBetween(String value1, String value2) {
            addCriterion("`inner_order_no` between", value1, value2, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andInner_order_noNotBetween(String value1, String value2) {
            addCriterion("`inner_order_no` not between", value1, value2, "inner_order_no");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNull() {
            addCriterion("`product_name` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNotNull() {
            addCriterion("`product_name` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameEqualTo(String value) {
            addCriterion("`product_name` =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotEqualTo(String value) {
            addCriterion("`product_name` <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThan(String value) {
            addCriterion("`product_name` >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`product_name` >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThan(String value) {
            addCriterion("`product_name` <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThanOrEqualTo(String value) {
            addCriterion("`product_name` <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLike(String value) {
            addCriterion("`product_name` like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotLike(String value) {
            addCriterion("`product_name` not like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIn(List<String> values) {
            addCriterion("`product_name` in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotIn(List<String> values) {
            addCriterion("`product_name` not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameBetween(String value1, String value2) {
            addCriterion("`product_name` between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotBetween(String value1, String value2) {
            addCriterion("`product_name` not between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("`amount` is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("`amount` is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("`amount` =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("`amount` <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("`amount` >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("`amount` >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("`amount` <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("`amount` <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("`amount` in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("`amount` not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("`amount` between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("`amount` not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPay_channelIsNull() {
            addCriterion("`pay_channel` is null");
            return (Criteria) this;
        }

        public Criteria andPay_channelIsNotNull() {
            addCriterion("`pay_channel` is not null");
            return (Criteria) this;
        }

        public Criteria andPay_channelEqualTo(String value) {
            addCriterion("`pay_channel` =", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotEqualTo(String value) {
            addCriterion("`pay_channel` <>", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelGreaterThan(String value) {
            addCriterion("`pay_channel` >", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelGreaterThanOrEqualTo(String value) {
            addCriterion("`pay_channel` >=", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelLessThan(String value) {
            addCriterion("`pay_channel` <", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelLessThanOrEqualTo(String value) {
            addCriterion("`pay_channel` <=", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelLike(String value) {
            addCriterion("`pay_channel` like", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotLike(String value) {
            addCriterion("`pay_channel` not like", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelIn(List<String> values) {
            addCriterion("`pay_channel` in", values, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotIn(List<String> values) {
            addCriterion("`pay_channel` not in", values, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelBetween(String value1, String value2) {
            addCriterion("`pay_channel` between", value1, value2, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotBetween(String value1, String value2) {
            addCriterion("`pay_channel` not between", value1, value2, "pay_channel");
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