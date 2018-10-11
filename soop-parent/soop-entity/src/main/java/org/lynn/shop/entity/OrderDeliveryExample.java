package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDeliveryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public OrderDeliveryExample() {
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

        public Criteria andSource_delivery_routeIsNull() {
            addCriterion("`source_delivery_route` is null");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeIsNotNull() {
            addCriterion("`source_delivery_route` is not null");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeEqualTo(String value) {
            addCriterion("`source_delivery_route` =", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeNotEqualTo(String value) {
            addCriterion("`source_delivery_route` <>", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeGreaterThan(String value) {
            addCriterion("`source_delivery_route` >", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeGreaterThanOrEqualTo(String value) {
            addCriterion("`source_delivery_route` >=", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeLessThan(String value) {
            addCriterion("`source_delivery_route` <", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeLessThanOrEqualTo(String value) {
            addCriterion("`source_delivery_route` <=", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeLike(String value) {
            addCriterion("`source_delivery_route` like", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeNotLike(String value) {
            addCriterion("`source_delivery_route` not like", value, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeIn(List<String> values) {
            addCriterion("`source_delivery_route` in", values, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeNotIn(List<String> values) {
            addCriterion("`source_delivery_route` not in", values, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeBetween(String value1, String value2) {
            addCriterion("`source_delivery_route` between", value1, value2, "source_delivery_route");
            return (Criteria) this;
        }

        public Criteria andSource_delivery_routeNotBetween(String value1, String value2) {
            addCriterion("`source_delivery_route` not between", value1, value2, "source_delivery_route");
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

        public Criteria andDelivery_order_noIsNull() {
            addCriterion("`delivery_order_no` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noIsNotNull() {
            addCriterion("`delivery_order_no` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noEqualTo(String value) {
            addCriterion("`delivery_order_no` =", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noNotEqualTo(String value) {
            addCriterion("`delivery_order_no` <>", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noGreaterThan(String value) {
            addCriterion("`delivery_order_no` >", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noGreaterThanOrEqualTo(String value) {
            addCriterion("`delivery_order_no` >=", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noLessThan(String value) {
            addCriterion("`delivery_order_no` <", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noLessThanOrEqualTo(String value) {
            addCriterion("`delivery_order_no` <=", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noLike(String value) {
            addCriterion("`delivery_order_no` like", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noNotLike(String value) {
            addCriterion("`delivery_order_no` not like", value, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noIn(List<String> values) {
            addCriterion("`delivery_order_no` in", values, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noNotIn(List<String> values) {
            addCriterion("`delivery_order_no` not in", values, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noBetween(String value1, String value2) {
            addCriterion("`delivery_order_no` between", value1, value2, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_order_noNotBetween(String value1, String value2) {
            addCriterion("`delivery_order_no` not between", value1, value2, "delivery_order_no");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyIsNull() {
            addCriterion("`delivery_company` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyIsNotNull() {
            addCriterion("`delivery_company` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyEqualTo(String value) {
            addCriterion("`delivery_company` =", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyNotEqualTo(String value) {
            addCriterion("`delivery_company` <>", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyGreaterThan(String value) {
            addCriterion("`delivery_company` >", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyGreaterThanOrEqualTo(String value) {
            addCriterion("`delivery_company` >=", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyLessThan(String value) {
            addCriterion("`delivery_company` <", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyLessThanOrEqualTo(String value) {
            addCriterion("`delivery_company` <=", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyLike(String value) {
            addCriterion("`delivery_company` like", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyNotLike(String value) {
            addCriterion("`delivery_company` not like", value, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyIn(List<String> values) {
            addCriterion("`delivery_company` in", values, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyNotIn(List<String> values) {
            addCriterion("`delivery_company` not in", values, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyBetween(String value1, String value2) {
            addCriterion("`delivery_company` between", value1, value2, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andDelivery_companyNotBetween(String value1, String value2) {
            addCriterion("`delivery_company` not between", value1, value2, "delivery_company");
            return (Criteria) this;
        }

        public Criteria andBatch_idIsNull() {
            addCriterion("`batch_id` is null");
            return (Criteria) this;
        }

        public Criteria andBatch_idIsNotNull() {
            addCriterion("`batch_id` is not null");
            return (Criteria) this;
        }

        public Criteria andBatch_idEqualTo(String value) {
            addCriterion("`batch_id` =", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotEqualTo(String value) {
            addCriterion("`batch_id` <>", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idGreaterThan(String value) {
            addCriterion("`batch_id` >", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idGreaterThanOrEqualTo(String value) {
            addCriterion("`batch_id` >=", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idLessThan(String value) {
            addCriterion("`batch_id` <", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idLessThanOrEqualTo(String value) {
            addCriterion("`batch_id` <=", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idLike(String value) {
            addCriterion("`batch_id` like", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotLike(String value) {
            addCriterion("`batch_id` not like", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idIn(List<String> values) {
            addCriterion("`batch_id` in", values, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotIn(List<String> values) {
            addCriterion("`batch_id` not in", values, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idBetween(String value1, String value2) {
            addCriterion("`batch_id` between", value1, value2, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotBetween(String value1, String value2) {
            addCriterion("`batch_id` not between", value1, value2, "batch_id");
            return (Criteria) this;
        }

        public Criteria andProduct_infoIsNull() {
            addCriterion("`product_info` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_infoIsNotNull() {
            addCriterion("`product_info` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_infoEqualTo(String value) {
            addCriterion("`product_info` =", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoNotEqualTo(String value) {
            addCriterion("`product_info` <>", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoGreaterThan(String value) {
            addCriterion("`product_info` >", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoGreaterThanOrEqualTo(String value) {
            addCriterion("`product_info` >=", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoLessThan(String value) {
            addCriterion("`product_info` <", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoLessThanOrEqualTo(String value) {
            addCriterion("`product_info` <=", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoLike(String value) {
            addCriterion("`product_info` like", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoNotLike(String value) {
            addCriterion("`product_info` not like", value, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoIn(List<String> values) {
            addCriterion("`product_info` in", values, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoNotIn(List<String> values) {
            addCriterion("`product_info` not in", values, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoBetween(String value1, String value2) {
            addCriterion("`product_info` between", value1, value2, "product_info");
            return (Criteria) this;
        }

        public Criteria andProduct_infoNotBetween(String value1, String value2) {
            addCriterion("`product_info` not between", value1, value2, "product_info");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeIsNull() {
            addCriterion("`delivery_fee` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeIsNotNull() {
            addCriterion("`delivery_fee` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeEqualTo(Integer value) {
            addCriterion("`delivery_fee` =", value, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeNotEqualTo(Integer value) {
            addCriterion("`delivery_fee` <>", value, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeGreaterThan(Integer value) {
            addCriterion("`delivery_fee` >", value, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`delivery_fee` >=", value, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeLessThan(Integer value) {
            addCriterion("`delivery_fee` <", value, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeLessThanOrEqualTo(Integer value) {
            addCriterion("`delivery_fee` <=", value, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeIn(List<Integer> values) {
            addCriterion("`delivery_fee` in", values, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeNotIn(List<Integer> values) {
            addCriterion("`delivery_fee` not in", values, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeBetween(Integer value1, Integer value2) {
            addCriterion("`delivery_fee` between", value1, value2, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andDelivery_feeNotBetween(Integer value1, Integer value2) {
            addCriterion("`delivery_fee` not between", value1, value2, "delivery_fee");
            return (Criteria) this;
        }

        public Criteria andBatch_noIsNull() {
            addCriterion("`batch_no` is null");
            return (Criteria) this;
        }

        public Criteria andBatch_noIsNotNull() {
            addCriterion("`batch_no` is not null");
            return (Criteria) this;
        }

        public Criteria andBatch_noEqualTo(String value) {
            addCriterion("`batch_no` =", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noNotEqualTo(String value) {
            addCriterion("`batch_no` <>", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noGreaterThan(String value) {
            addCriterion("`batch_no` >", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noGreaterThanOrEqualTo(String value) {
            addCriterion("`batch_no` >=", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noLessThan(String value) {
            addCriterion("`batch_no` <", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noLessThanOrEqualTo(String value) {
            addCriterion("`batch_no` <=", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noLike(String value) {
            addCriterion("`batch_no` like", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noNotLike(String value) {
            addCriterion("`batch_no` not like", value, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noIn(List<String> values) {
            addCriterion("`batch_no` in", values, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noNotIn(List<String> values) {
            addCriterion("`batch_no` not in", values, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noBetween(String value1, String value2) {
            addCriterion("`batch_no` between", value1, value2, "batch_no");
            return (Criteria) this;
        }

        public Criteria andBatch_noNotBetween(String value1, String value2) {
            addCriterion("`batch_no` not between", value1, value2, "batch_no");
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