package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ProductPriceExample() {
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

        public Criteria andProduct_name_cnIsNull() {
            addCriterion("`product_name_cn` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnIsNotNull() {
            addCriterion("`product_name_cn` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnEqualTo(String value) {
            addCriterion("`product_name_cn` =", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnNotEqualTo(String value) {
            addCriterion("`product_name_cn` <>", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnGreaterThan(String value) {
            addCriterion("`product_name_cn` >", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnGreaterThanOrEqualTo(String value) {
            addCriterion("`product_name_cn` >=", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnLessThan(String value) {
            addCriterion("`product_name_cn` <", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnLessThanOrEqualTo(String value) {
            addCriterion("`product_name_cn` <=", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnLike(String value) {
            addCriterion("`product_name_cn` like", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnNotLike(String value) {
            addCriterion("`product_name_cn` not like", value, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnIn(List<String> values) {
            addCriterion("`product_name_cn` in", values, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnNotIn(List<String> values) {
            addCriterion("`product_name_cn` not in", values, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnBetween(String value1, String value2) {
            addCriterion("`product_name_cn` between", value1, value2, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andProduct_name_cnNotBetween(String value1, String value2) {
            addCriterion("`product_name_cn` not between", value1, value2, "product_name_cn");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("`source` is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("`source` is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("`source` =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("`source` <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("`source` >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("`source` >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("`source` <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("`source` <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("`source` like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("`source` not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("`source` in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("`source` not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("`source` between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("`source` not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceIsNull() {
            addCriterion("`overseas_price` is null");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceIsNotNull() {
            addCriterion("`overseas_price` is not null");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceEqualTo(Integer value) {
            addCriterion("`overseas_price` =", value, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceNotEqualTo(Integer value) {
            addCriterion("`overseas_price` <>", value, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceGreaterThan(Integer value) {
            addCriterion("`overseas_price` >", value, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceGreaterThanOrEqualTo(Integer value) {
            addCriterion("`overseas_price` >=", value, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceLessThan(Integer value) {
            addCriterion("`overseas_price` <", value, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceLessThanOrEqualTo(Integer value) {
            addCriterion("`overseas_price` <=", value, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceIn(List<Integer> values) {
            addCriterion("`overseas_price` in", values, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceNotIn(List<Integer> values) {
            addCriterion("`overseas_price` not in", values, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceBetween(Integer value1, Integer value2) {
            addCriterion("`overseas_price` between", value1, value2, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andOverseas_priceNotBetween(Integer value1, Integer value2) {
            addCriterion("`overseas_price` not between", value1, value2, "overseas_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceIsNull() {
            addCriterion("`domestic_price` is null");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceIsNotNull() {
            addCriterion("`domestic_price` is not null");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceEqualTo(Integer value) {
            addCriterion("`domestic_price` =", value, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceNotEqualTo(Integer value) {
            addCriterion("`domestic_price` <>", value, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceGreaterThan(Integer value) {
            addCriterion("`domestic_price` >", value, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceGreaterThanOrEqualTo(Integer value) {
            addCriterion("`domestic_price` >=", value, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceLessThan(Integer value) {
            addCriterion("`domestic_price` <", value, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceLessThanOrEqualTo(Integer value) {
            addCriterion("`domestic_price` <=", value, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceIn(List<Integer> values) {
            addCriterion("`domestic_price` in", values, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceNotIn(List<Integer> values) {
            addCriterion("`domestic_price` not in", values, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceBetween(Integer value1, Integer value2) {
            addCriterion("`domestic_price` between", value1, value2, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andDomestic_priceNotBetween(Integer value1, Integer value2) {
            addCriterion("`domestic_price` not between", value1, value2, "domestic_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIsNull() {
            addCriterion("`product_price` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIsNotNull() {
            addCriterion("`product_price` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_priceEqualTo(Integer value) {
            addCriterion("`product_price` =", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotEqualTo(Integer value) {
            addCriterion("`product_price` <>", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceGreaterThan(Integer value) {
            addCriterion("`product_price` >", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceGreaterThanOrEqualTo(Integer value) {
            addCriterion("`product_price` >=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceLessThan(Integer value) {
            addCriterion("`product_price` <", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceLessThanOrEqualTo(Integer value) {
            addCriterion("`product_price` <=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIn(List<Integer> values) {
            addCriterion("`product_price` in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotIn(List<Integer> values) {
            addCriterion("`product_price` not in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceBetween(Integer value1, Integer value2) {
            addCriterion("`product_price` between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotBetween(Integer value1, Integer value2) {
            addCriterion("`product_price` not between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andSource_idIsNull() {
            addCriterion("`source_id` is null");
            return (Criteria) this;
        }

        public Criteria andSource_idIsNotNull() {
            addCriterion("`source_id` is not null");
            return (Criteria) this;
        }

        public Criteria andSource_idEqualTo(Long value) {
            addCriterion("`source_id` =", value, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idNotEqualTo(Long value) {
            addCriterion("`source_id` <>", value, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idGreaterThan(Long value) {
            addCriterion("`source_id` >", value, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`source_id` >=", value, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idLessThan(Long value) {
            addCriterion("`source_id` <", value, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idLessThanOrEqualTo(Long value) {
            addCriterion("`source_id` <=", value, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idIn(List<Long> values) {
            addCriterion("`source_id` in", values, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idNotIn(List<Long> values) {
            addCriterion("`source_id` not in", values, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idBetween(Long value1, Long value2) {
            addCriterion("`source_id` between", value1, value2, "source_id");
            return (Criteria) this;
        }

        public Criteria andSource_idNotBetween(Long value1, Long value2) {
            addCriterion("`source_id` not between", value1, value2, "source_id");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleIsNull() {
            addCriterion("`price_on_sale` is null");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleIsNotNull() {
            addCriterion("`price_on_sale` is not null");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleEqualTo(Integer value) {
            addCriterion("`price_on_sale` =", value, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleNotEqualTo(Integer value) {
            addCriterion("`price_on_sale` <>", value, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleGreaterThan(Integer value) {
            addCriterion("`price_on_sale` >", value, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleGreaterThanOrEqualTo(Integer value) {
            addCriterion("`price_on_sale` >=", value, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleLessThan(Integer value) {
            addCriterion("`price_on_sale` <", value, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleLessThanOrEqualTo(Integer value) {
            addCriterion("`price_on_sale` <=", value, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleIn(List<Integer> values) {
            addCriterion("`price_on_sale` in", values, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleNotIn(List<Integer> values) {
            addCriterion("`price_on_sale` not in", values, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleBetween(Integer value1, Integer value2) {
            addCriterion("`price_on_sale` between", value1, value2, "price_on_sale");
            return (Criteria) this;
        }

        public Criteria andPrice_on_saleNotBetween(Integer value1, Integer value2) {
            addCriterion("`price_on_sale` not between", value1, value2, "price_on_sale");
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