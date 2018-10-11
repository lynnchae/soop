package org.lynn.soop.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    protected Integer pageStart;

    protected String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public ProductExample() {
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

        public Criteria andBrand_name_cnIsNull() {
            addCriterion("`brand_name_cn` is null");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnIsNotNull() {
            addCriterion("`brand_name_cn` is not null");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnEqualTo(String value) {
            addCriterion("`brand_name_cn` =", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnNotEqualTo(String value) {
            addCriterion("`brand_name_cn` <>", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnGreaterThan(String value) {
            addCriterion("`brand_name_cn` >", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnGreaterThanOrEqualTo(String value) {
            addCriterion("`brand_name_cn` >=", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnLessThan(String value) {
            addCriterion("`brand_name_cn` <", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnLessThanOrEqualTo(String value) {
            addCriterion("`brand_name_cn` <=", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnLike(String value) {
            addCriterion("`brand_name_cn` like", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnNotLike(String value) {
            addCriterion("`brand_name_cn` not like", value, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnIn(List<String> values) {
            addCriterion("`brand_name_cn` in", values, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnNotIn(List<String> values) {
            addCriterion("`brand_name_cn` not in", values, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnBetween(String value1, String value2) {
            addCriterion("`brand_name_cn` between", value1, value2, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_cnNotBetween(String value1, String value2) {
            addCriterion("`brand_name_cn` not between", value1, value2, "brand_name_cn");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enIsNull() {
            addCriterion("`brand_name_en` is null");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enIsNotNull() {
            addCriterion("`brand_name_en` is not null");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enEqualTo(String value) {
            addCriterion("`brand_name_en` =", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enNotEqualTo(String value) {
            addCriterion("`brand_name_en` <>", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enGreaterThan(String value) {
            addCriterion("`brand_name_en` >", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enGreaterThanOrEqualTo(String value) {
            addCriterion("`brand_name_en` >=", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enLessThan(String value) {
            addCriterion("`brand_name_en` <", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enLessThanOrEqualTo(String value) {
            addCriterion("`brand_name_en` <=", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enLike(String value) {
            addCriterion("`brand_name_en` like", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enNotLike(String value) {
            addCriterion("`brand_name_en` not like", value, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enIn(List<String> values) {
            addCriterion("`brand_name_en` in", values, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enNotIn(List<String> values) {
            addCriterion("`brand_name_en` not in", values, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enBetween(String value1, String value2) {
            addCriterion("`brand_name_en` between", value1, value2, "brand_name_en");
            return (Criteria) this;
        }

        public Criteria andBrand_name_enNotBetween(String value1, String value2) {
            addCriterion("`brand_name_en` not between", value1, value2, "brand_name_en");
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

        public Criteria andProduct_name_enIsNull() {
            addCriterion("`product_name_en` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enIsNotNull() {
            addCriterion("`product_name_en` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enEqualTo(String value) {
            addCriterion("`product_name_en` =", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enNotEqualTo(String value) {
            addCriterion("`product_name_en` <>", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enGreaterThan(String value) {
            addCriterion("`product_name_en` >", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enGreaterThanOrEqualTo(String value) {
            addCriterion("`product_name_en` >=", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enLessThan(String value) {
            addCriterion("`product_name_en` <", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enLessThanOrEqualTo(String value) {
            addCriterion("`product_name_en` <=", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enLike(String value) {
            addCriterion("`product_name_en` like", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enNotLike(String value) {
            addCriterion("`product_name_en` not like", value, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enIn(List<String> values) {
            addCriterion("`product_name_en` in", values, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enNotIn(List<String> values) {
            addCriterion("`product_name_en` not in", values, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enBetween(String value1, String value2) {
            addCriterion("`product_name_en` between", value1, value2, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andProduct_name_enNotBetween(String value1, String value2) {
            addCriterion("`product_name_en` not between", value1, value2, "product_name_en");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexIsNull() {
            addCriterion("`recommend_index` is null");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexIsNotNull() {
            addCriterion("`recommend_index` is not null");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexEqualTo(Integer value) {
            addCriterion("`recommend_index` =", value, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexNotEqualTo(Integer value) {
            addCriterion("`recommend_index` <>", value, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexGreaterThan(Integer value) {
            addCriterion("`recommend_index` >", value, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexGreaterThanOrEqualTo(Integer value) {
            addCriterion("`recommend_index` >=", value, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexLessThan(Integer value) {
            addCriterion("`recommend_index` <", value, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexLessThanOrEqualTo(Integer value) {
            addCriterion("`recommend_index` <=", value, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexIn(List<Integer> values) {
            addCriterion("`recommend_index` in", values, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexNotIn(List<Integer> values) {
            addCriterion("`recommend_index` not in", values, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexBetween(Integer value1, Integer value2) {
            addCriterion("`recommend_index` between", value1, value2, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andRecommend_indexNotBetween(Integer value1, Integer value2) {
            addCriterion("`recommend_index` not between", value1, value2, "recommend_index");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1IsNull() {
            addCriterion("`product_category_l1` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1IsNotNull() {
            addCriterion("`product_category_l1` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1EqualTo(String value) {
            addCriterion("`product_category_l1` =", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1NotEqualTo(String value) {
            addCriterion("`product_category_l1` <>", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1GreaterThan(String value) {
            addCriterion("`product_category_l1` >", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1GreaterThanOrEqualTo(String value) {
            addCriterion("`product_category_l1` >=", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1LessThan(String value) {
            addCriterion("`product_category_l1` <", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1LessThanOrEqualTo(String value) {
            addCriterion("`product_category_l1` <=", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1Like(String value) {
            addCriterion("`product_category_l1` like", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1NotLike(String value) {
            addCriterion("`product_category_l1` not like", value, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1In(List<String> values) {
            addCriterion("`product_category_l1` in", values, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1NotIn(List<String> values) {
            addCriterion("`product_category_l1` not in", values, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1Between(String value1, String value2) {
            addCriterion("`product_category_l1` between", value1, value2, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1NotBetween(String value1, String value2) {
            addCriterion("`product_category_l1` not between", value1, value2, "product_category_l1");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2IsNull() {
            addCriterion("`product_category_l2` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2IsNotNull() {
            addCriterion("`product_category_l2` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2EqualTo(String value) {
            addCriterion("`product_category_l2` =", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2NotEqualTo(String value) {
            addCriterion("`product_category_l2` <>", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2GreaterThan(String value) {
            addCriterion("`product_category_l2` >", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2GreaterThanOrEqualTo(String value) {
            addCriterion("`product_category_l2` >=", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2LessThan(String value) {
            addCriterion("`product_category_l2` <", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2LessThanOrEqualTo(String value) {
            addCriterion("`product_category_l2` <=", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2Like(String value) {
            addCriterion("`product_category_l2` like", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2NotLike(String value) {
            addCriterion("`product_category_l2` not like", value, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2In(List<String> values) {
            addCriterion("`product_category_l2` in", values, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2NotIn(List<String> values) {
            addCriterion("`product_category_l2` not in", values, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2Between(String value1, String value2) {
            addCriterion("`product_category_l2` between", value1, value2, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2NotBetween(String value1, String value2) {
            addCriterion("`product_category_l2` not between", value1, value2, "product_category_l2");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3IsNull() {
            addCriterion("`product_category_l3` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3IsNotNull() {
            addCriterion("`product_category_l3` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3EqualTo(String value) {
            addCriterion("`product_category_l3` =", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3NotEqualTo(String value) {
            addCriterion("`product_category_l3` <>", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3GreaterThan(String value) {
            addCriterion("`product_category_l3` >", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3GreaterThanOrEqualTo(String value) {
            addCriterion("`product_category_l3` >=", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3LessThan(String value) {
            addCriterion("`product_category_l3` <", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3LessThanOrEqualTo(String value) {
            addCriterion("`product_category_l3` <=", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3Like(String value) {
            addCriterion("`product_category_l3` like", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3NotLike(String value) {
            addCriterion("`product_category_l3` not like", value, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3In(List<String> values) {
            addCriterion("`product_category_l3` in", values, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3NotIn(List<String> values) {
            addCriterion("`product_category_l3` not in", values, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3Between(String value1, String value2) {
            addCriterion("`product_category_l3` between", value1, value2, "product_category_l3");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l3NotBetween(String value1, String value2) {
            addCriterion("`product_category_l3` not between", value1, value2, "product_category_l3");
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

        public Criteria andIs_onlineIsNull() {
            addCriterion("`is_online` is null");
            return (Criteria) this;
        }

        public Criteria andIs_onlineIsNotNull() {
            addCriterion("`is_online` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_onlineEqualTo(Boolean value) {
            addCriterion("`is_online` =", value, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineNotEqualTo(Boolean value) {
            addCriterion("`is_online` <>", value, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineGreaterThan(Boolean value) {
            addCriterion("`is_online` >", value, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_online` >=", value, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineLessThan(Boolean value) {
            addCriterion("`is_online` <", value, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_online` <=", value, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineIn(List<Boolean> values) {
            addCriterion("`is_online` in", values, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineNotIn(List<Boolean> values) {
            addCriterion("`is_online` not in", values, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_online` between", value1, value2, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_onlineNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_online` not between", value1, value2, "is_online");
            return (Criteria) this;
        }

        public Criteria andIs_newIsNull() {
            addCriterion("`is_new` is null");
            return (Criteria) this;
        }

        public Criteria andIs_newIsNotNull() {
            addCriterion("`is_new` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_newEqualTo(String value) {
            addCriterion("`is_new` =", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newNotEqualTo(String value) {
            addCriterion("`is_new` <>", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newGreaterThan(String value) {
            addCriterion("`is_new` >", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newGreaterThanOrEqualTo(String value) {
            addCriterion("`is_new` >=", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newLessThan(String value) {
            addCriterion("`is_new` <", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newLessThanOrEqualTo(String value) {
            addCriterion("`is_new` <=", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newIn(List<String> values) {
            addCriterion("`is_new` in", values, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newNotIn(List<String> values) {
            addCriterion("`is_new` not in", values, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newBetween(String value1, String value2) {
            addCriterion("`is_new` between", value1, value2, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_newNotBetween(String value1, String value2) {
            addCriterion("`is_new` not between", value1, value2, "is_new");
            return (Criteria) this;
        }

        public Criteria andIs_hotIsNull() {
            addCriterion("`is_hot` is null");
            return (Criteria) this;
        }

        public Criteria andIs_hotIsNotNull() {
            addCriterion("`is_hot` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_hotEqualTo(Boolean value) {
            addCriterion("`is_hot` =", value, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotNotEqualTo(Boolean value) {
            addCriterion("`is_hot` <>", value, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotGreaterThan(Boolean value) {
            addCriterion("`is_hot` >", value, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_hot` >=", value, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotLessThan(Boolean value) {
            addCriterion("`is_hot` <", value, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_hot` <=", value, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotIn(List<Boolean> values) {
            addCriterion("`is_hot` in", values, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotNotIn(List<Boolean> values) {
            addCriterion("`is_hot` not in", values, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_hot` between", value1, value2, "is_hot");
            return (Criteria) this;
        }

        public Criteria andIs_hotNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_hot` not between", value1, value2, "is_hot");
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

        public Criteria andProduct_weightIsNull() {
            addCriterion("`product_weight` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_weightIsNotNull() {
            addCriterion("`product_weight` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_weightEqualTo(Integer value) {
            addCriterion("`product_weight` =", value, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightNotEqualTo(Integer value) {
            addCriterion("`product_weight` <>", value, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightGreaterThan(Integer value) {
            addCriterion("`product_weight` >", value, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightGreaterThanOrEqualTo(Integer value) {
            addCriterion("`product_weight` >=", value, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightLessThan(Integer value) {
            addCriterion("`product_weight` <", value, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightLessThanOrEqualTo(Integer value) {
            addCriterion("`product_weight` <=", value, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightIn(List<Integer> values) {
            addCriterion("`product_weight` in", values, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightNotIn(List<Integer> values) {
            addCriterion("`product_weight` not in", values, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightBetween(Integer value1, Integer value2) {
            addCriterion("`product_weight` between", value1, value2, "product_weight");
            return (Criteria) this;
        }

        public Criteria andProduct_weightNotBetween(Integer value1, Integer value2) {
            addCriterion("`product_weight` not between", value1, value2, "product_weight");
            return (Criteria) this;
        }

        public Criteria andBrand_idIsNull() {
            addCriterion("`brand_id` is null");
            return (Criteria) this;
        }

        public Criteria andBrand_idIsNotNull() {
            addCriterion("`brand_id` is not null");
            return (Criteria) this;
        }

        public Criteria andBrand_idEqualTo(Long value) {
            addCriterion("`brand_id` =", value, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idNotEqualTo(Long value) {
            addCriterion("`brand_id` <>", value, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idGreaterThan(Long value) {
            addCriterion("`brand_id` >", value, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`brand_id` >=", value, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idLessThan(Long value) {
            addCriterion("`brand_id` <", value, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idLessThanOrEqualTo(Long value) {
            addCriterion("`brand_id` <=", value, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idIn(List<Long> values) {
            addCriterion("`brand_id` in", values, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idNotIn(List<Long> values) {
            addCriterion("`brand_id` not in", values, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idBetween(Long value1, Long value2) {
            addCriterion("`brand_id` between", value1, value2, "brand_id");
            return (Criteria) this;
        }

        public Criteria andBrand_idNotBetween(Long value1, Long value2) {
            addCriterion("`brand_id` not between", value1, value2, "brand_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idIsNull() {
            addCriterion("`product_category_l1_id` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idIsNotNull() {
            addCriterion("`product_category_l1_id` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idEqualTo(Long value) {
            addCriterion("`product_category_l1_id` =", value, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idNotEqualTo(Long value) {
            addCriterion("`product_category_l1_id` <>", value, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idGreaterThan(Long value) {
            addCriterion("`product_category_l1_id` >", value, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`product_category_l1_id` >=", value, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idLessThan(Long value) {
            addCriterion("`product_category_l1_id` <", value, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idLessThanOrEqualTo(Long value) {
            addCriterion("`product_category_l1_id` <=", value, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idIn(List<Long> values) {
            addCriterion("`product_category_l1_id` in", values, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idNotIn(List<Long> values) {
            addCriterion("`product_category_l1_id` not in", values, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idBetween(Long value1, Long value2) {
            addCriterion("`product_category_l1_id` between", value1, value2, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l1_idNotBetween(Long value1, Long value2) {
            addCriterion("`product_category_l1_id` not between", value1, value2, "product_category_l1_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idIsNull() {
            addCriterion("`product_category_l2_id` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idIsNotNull() {
            addCriterion("`product_category_l2_id` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idEqualTo(Long value) {
            addCriterion("`product_category_l2_id` =", value, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idNotEqualTo(Long value) {
            addCriterion("`product_category_l2_id` <>", value, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idGreaterThan(Long value) {
            addCriterion("`product_category_l2_id` >", value, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`product_category_l2_id` >=", value, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idLessThan(Long value) {
            addCriterion("`product_category_l2_id` <", value, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idLessThanOrEqualTo(Long value) {
            addCriterion("`product_category_l2_id` <=", value, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idIn(List<Long> values) {
            addCriterion("`product_category_l2_id` in", values, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idNotIn(List<Long> values) {
            addCriterion("`product_category_l2_id` not in", values, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idBetween(Long value1, Long value2) {
            addCriterion("`product_category_l2_id` between", value1, value2, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_category_l2_idNotBetween(Long value1, Long value2) {
            addCriterion("`product_category_l2_id` not between", value1, value2, "product_category_l2_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameIsNull() {
            addCriterion("`product_sub_name` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameIsNotNull() {
            addCriterion("`product_sub_name` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameEqualTo(String value) {
            addCriterion("`product_sub_name` =", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameNotEqualTo(String value) {
            addCriterion("`product_sub_name` <>", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameGreaterThan(String value) {
            addCriterion("`product_sub_name` >", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`product_sub_name` >=", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameLessThan(String value) {
            addCriterion("`product_sub_name` <", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameLessThanOrEqualTo(String value) {
            addCriterion("`product_sub_name` <=", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameLike(String value) {
            addCriterion("`product_sub_name` like", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameNotLike(String value) {
            addCriterion("`product_sub_name` not like", value, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameIn(List<String> values) {
            addCriterion("`product_sub_name` in", values, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameNotIn(List<String> values) {
            addCriterion("`product_sub_name` not in", values, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameBetween(String value1, String value2) {
            addCriterion("`product_sub_name` between", value1, value2, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andProduct_sub_nameNotBetween(String value1, String value2) {
            addCriterion("`product_sub_name` not between", value1, value2, "product_sub_name");
            return (Criteria) this;
        }

        public Criteria andSpecsIsNull() {
            addCriterion("`specs` is null");
            return (Criteria) this;
        }

        public Criteria andSpecsIsNotNull() {
            addCriterion("`specs` is not null");
            return (Criteria) this;
        }

        public Criteria andSpecsEqualTo(String value) {
            addCriterion("`specs` =", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotEqualTo(String value) {
            addCriterion("`specs` <>", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsGreaterThan(String value) {
            addCriterion("`specs` >", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsGreaterThanOrEqualTo(String value) {
            addCriterion("`specs` >=", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLessThan(String value) {
            addCriterion("`specs` <", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLessThanOrEqualTo(String value) {
            addCriterion("`specs` <=", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLike(String value) {
            addCriterion("`specs` like", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotLike(String value) {
            addCriterion("`specs` not like", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsIn(List<String> values) {
            addCriterion("`specs` in", values, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotIn(List<String> values) {
            addCriterion("`specs` not in", values, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsBetween(String value1, String value2) {
            addCriterion("`specs` between", value1, value2, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotBetween(String value1, String value2) {
            addCriterion("`specs` not between", value1, value2, "specs");
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

        public Criteria andProduct_numberIsNull() {
            addCriterion("`product_number` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_numberIsNotNull() {
            addCriterion("`product_number` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_numberEqualTo(String value) {
            addCriterion("`product_number` =", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotEqualTo(String value) {
            addCriterion("`product_number` <>", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberGreaterThan(String value) {
            addCriterion("`product_number` >", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberGreaterThanOrEqualTo(String value) {
            addCriterion("`product_number` >=", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberLessThan(String value) {
            addCriterion("`product_number` <", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberLessThanOrEqualTo(String value) {
            addCriterion("`product_number` <=", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberLike(String value) {
            addCriterion("`product_number` like", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotLike(String value) {
            addCriterion("`product_number` not like", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberIn(List<String> values) {
            addCriterion("`product_number` in", values, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotIn(List<String> values) {
            addCriterion("`product_number` not in", values, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberBetween(String value1, String value2) {
            addCriterion("`product_number` between", value1, value2, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotBetween(String value1, String value2) {
            addCriterion("`product_number` not between", value1, value2, "product_number");
            return (Criteria) this;
        }

        public Criteria andSource_channelIsNull() {
            addCriterion("`source_channel` is null");
            return (Criteria) this;
        }

        public Criteria andSource_channelIsNotNull() {
            addCriterion("`source_channel` is not null");
            return (Criteria) this;
        }

        public Criteria andSource_channelEqualTo(String value) {
            addCriterion("`source_channel` =", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelNotEqualTo(String value) {
            addCriterion("`source_channel` <>", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelGreaterThan(String value) {
            addCriterion("`source_channel` >", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelGreaterThanOrEqualTo(String value) {
            addCriterion("`source_channel` >=", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelLessThan(String value) {
            addCriterion("`source_channel` <", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelLessThanOrEqualTo(String value) {
            addCriterion("`source_channel` <=", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelLike(String value) {
            addCriterion("`source_channel` like", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelNotLike(String value) {
            addCriterion("`source_channel` not like", value, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelIn(List<String> values) {
            addCriterion("`source_channel` in", values, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelNotIn(List<String> values) {
            addCriterion("`source_channel` not in", values, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelBetween(String value1, String value2) {
            addCriterion("`source_channel` between", value1, value2, "source_channel");
            return (Criteria) this;
        }

        public Criteria andSource_channelNotBetween(String value1, String value2) {
            addCriterion("`source_channel` not between", value1, value2, "source_channel");
            return (Criteria) this;
        }

        public Criteria andStock_countIsNull() {
            addCriterion("`stock_count` is null");
            return (Criteria) this;
        }

        public Criteria andStock_countIsNotNull() {
            addCriterion("`stock_count` is not null");
            return (Criteria) this;
        }

        public Criteria andStock_countEqualTo(Integer value) {
            addCriterion("`stock_count` =", value, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countNotEqualTo(Integer value) {
            addCriterion("`stock_count` <>", value, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countGreaterThan(Integer value) {
            addCriterion("`stock_count` >", value, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("`stock_count` >=", value, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countLessThan(Integer value) {
            addCriterion("`stock_count` <", value, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countLessThanOrEqualTo(Integer value) {
            addCriterion("`stock_count` <=", value, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countIn(List<Integer> values) {
            addCriterion("`stock_count` in", values, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countNotIn(List<Integer> values) {
            addCriterion("`stock_count` not in", values, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countBetween(Integer value1, Integer value2) {
            addCriterion("`stock_count` between", value1, value2, "stock_count");
            return (Criteria) this;
        }

        public Criteria andStock_countNotBetween(Integer value1, Integer value2) {
            addCriterion("`stock_count` not between", value1, value2, "stock_count");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesIsNull() {
            addCriterion("`product_properties` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesIsNotNull() {
            addCriterion("`product_properties` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesEqualTo(String value) {
            addCriterion("`product_properties` =", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesNotEqualTo(String value) {
            addCriterion("`product_properties` <>", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesGreaterThan(String value) {
            addCriterion("`product_properties` >", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesGreaterThanOrEqualTo(String value) {
            addCriterion("`product_properties` >=", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesLessThan(String value) {
            addCriterion("`product_properties` <", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesLessThanOrEqualTo(String value) {
            addCriterion("`product_properties` <=", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesLike(String value) {
            addCriterion("`product_properties` like", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesNotLike(String value) {
            addCriterion("`product_properties` not like", value, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesIn(List<String> values) {
            addCriterion("`product_properties` in", values, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesNotIn(List<String> values) {
            addCriterion("`product_properties` not in", values, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesBetween(String value1, String value2) {
            addCriterion("`product_properties` between", value1, value2, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_propertiesNotBetween(String value1, String value2) {
            addCriterion("`product_properties` not between", value1, value2, "product_properties");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listIsNull() {
            addCriterion("`product_image_list` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listIsNotNull() {
            addCriterion("`product_image_list` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listEqualTo(String value) {
            addCriterion("`product_image_list` =", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listNotEqualTo(String value) {
            addCriterion("`product_image_list` <>", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listGreaterThan(String value) {
            addCriterion("`product_image_list` >", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listGreaterThanOrEqualTo(String value) {
            addCriterion("`product_image_list` >=", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listLessThan(String value) {
            addCriterion("`product_image_list` <", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listLessThanOrEqualTo(String value) {
            addCriterion("`product_image_list` <=", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listLike(String value) {
            addCriterion("`product_image_list` like", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listNotLike(String value) {
            addCriterion("`product_image_list` not like", value, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listIn(List<String> values) {
            addCriterion("`product_image_list` in", values, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listNotIn(List<String> values) {
            addCriterion("`product_image_list` not in", values, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listBetween(String value1, String value2) {
            addCriterion("`product_image_list` between", value1, value2, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andProduct_image_listNotBetween(String value1, String value2) {
            addCriterion("`product_image_list` not between", value1, value2, "product_image_list");
            return (Criteria) this;
        }

        public Criteria andRoutine_idIsNull() {
            addCriterion("`routine_id` is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_idIsNotNull() {
            addCriterion("`routine_id` is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_idEqualTo(Integer value) {
            addCriterion("`routine_id` =", value, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idNotEqualTo(Integer value) {
            addCriterion("`routine_id` <>", value, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idGreaterThan(Integer value) {
            addCriterion("`routine_id` >", value, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("`routine_id` >=", value, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idLessThan(Integer value) {
            addCriterion("`routine_id` <", value, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idLessThanOrEqualTo(Integer value) {
            addCriterion("`routine_id` <=", value, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idIn(List<Integer> values) {
            addCriterion("`routine_id` in", values, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idNotIn(List<Integer> values) {
            addCriterion("`routine_id` not in", values, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idBetween(Integer value1, Integer value2) {
            addCriterion("`routine_id` between", value1, value2, "routine_id");
            return (Criteria) this;
        }

        public Criteria andRoutine_idNotBetween(Integer value1, Integer value2) {
            addCriterion("`routine_id` not between", value1, value2, "routine_id");
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

        public Criteria andDelivery_freeIsNull() {
            addCriterion("`delivery_free` is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeIsNotNull() {
            addCriterion("`delivery_free` is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeEqualTo(Boolean value) {
            addCriterion("`delivery_free` =", value, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeNotEqualTo(Boolean value) {
            addCriterion("`delivery_free` <>", value, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeGreaterThan(Boolean value) {
            addCriterion("`delivery_free` >", value, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`delivery_free` >=", value, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeLessThan(Boolean value) {
            addCriterion("`delivery_free` <", value, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeLessThanOrEqualTo(Boolean value) {
            addCriterion("`delivery_free` <=", value, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeIn(List<Boolean> values) {
            addCriterion("`delivery_free` in", values, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeNotIn(List<Boolean> values) {
            addCriterion("`delivery_free` not in", values, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeBetween(Boolean value1, Boolean value2) {
            addCriterion("`delivery_free` between", value1, value2, "delivery_free");
            return (Criteria) this;
        }

        public Criteria andDelivery_freeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`delivery_free` not between", value1, value2, "delivery_free");
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