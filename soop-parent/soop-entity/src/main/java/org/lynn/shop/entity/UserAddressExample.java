package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public UserAddressExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("`user_id` is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("`user_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("`user_id` =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("`user_id` <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("`user_id` >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`user_id` >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("`user_id` <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("`user_id` <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("`user_id` in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("`user_id` not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("`user_id` between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("`user_id` not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andContact_nameIsNull() {
            addCriterion("`contact_name` is null");
            return (Criteria) this;
        }

        public Criteria andContact_nameIsNotNull() {
            addCriterion("`contact_name` is not null");
            return (Criteria) this;
        }

        public Criteria andContact_nameEqualTo(String value) {
            addCriterion("`contact_name` =", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotEqualTo(String value) {
            addCriterion("`contact_name` <>", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameGreaterThan(String value) {
            addCriterion("`contact_name` >", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`contact_name` >=", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameLessThan(String value) {
            addCriterion("`contact_name` <", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameLessThanOrEqualTo(String value) {
            addCriterion("`contact_name` <=", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameLike(String value) {
            addCriterion("`contact_name` like", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotLike(String value) {
            addCriterion("`contact_name` not like", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameIn(List<String> values) {
            addCriterion("`contact_name` in", values, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotIn(List<String> values) {
            addCriterion("`contact_name` not in", values, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameBetween(String value1, String value2) {
            addCriterion("`contact_name` between", value1, value2, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotBetween(String value1, String value2) {
            addCriterion("`contact_name` not between", value1, value2, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_phoneIsNull() {
            addCriterion("`contact_phone` is null");
            return (Criteria) this;
        }

        public Criteria andContact_phoneIsNotNull() {
            addCriterion("`contact_phone` is not null");
            return (Criteria) this;
        }

        public Criteria andContact_phoneEqualTo(String value) {
            addCriterion("`contact_phone` =", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotEqualTo(String value) {
            addCriterion("`contact_phone` <>", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneGreaterThan(String value) {
            addCriterion("`contact_phone` >", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("`contact_phone` >=", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneLessThan(String value) {
            addCriterion("`contact_phone` <", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneLessThanOrEqualTo(String value) {
            addCriterion("`contact_phone` <=", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneLike(String value) {
            addCriterion("`contact_phone` like", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotLike(String value) {
            addCriterion("`contact_phone` not like", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneIn(List<String> values) {
            addCriterion("`contact_phone` in", values, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotIn(List<String> values) {
            addCriterion("`contact_phone` not in", values, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneBetween(String value1, String value2) {
            addCriterion("`contact_phone` between", value1, value2, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotBetween(String value1, String value2) {
            addCriterion("`contact_phone` not between", value1, value2, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("`province` is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("`province` is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("`province` =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("`province` <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("`province` >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("`province` >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("`province` <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("`province` <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("`province` like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("`province` not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("`province` in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("`province` not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("`province` between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("`province` not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("`city` is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("`city` is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("`city` =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("`city` <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("`city` >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("`city` >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("`city` <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("`city` <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("`city` like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("`city` not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("`city` in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("`city` not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("`city` between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("`city` not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("`district` is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("`district` is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("`district` =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("`district` <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("`district` >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("`district` >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("`district` <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("`district` <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("`district` like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("`district` not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("`district` in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("`district` not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("`district` between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("`district` not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDetail_addressIsNull() {
            addCriterion("`detail_address` is null");
            return (Criteria) this;
        }

        public Criteria andDetail_addressIsNotNull() {
            addCriterion("`detail_address` is not null");
            return (Criteria) this;
        }

        public Criteria andDetail_addressEqualTo(String value) {
            addCriterion("`detail_address` =", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressNotEqualTo(String value) {
            addCriterion("`detail_address` <>", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressGreaterThan(String value) {
            addCriterion("`detail_address` >", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressGreaterThanOrEqualTo(String value) {
            addCriterion("`detail_address` >=", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressLessThan(String value) {
            addCriterion("`detail_address` <", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressLessThanOrEqualTo(String value) {
            addCriterion("`detail_address` <=", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressLike(String value) {
            addCriterion("`detail_address` like", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressNotLike(String value) {
            addCriterion("`detail_address` not like", value, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressIn(List<String> values) {
            addCriterion("`detail_address` in", values, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressNotIn(List<String> values) {
            addCriterion("`detail_address` not in", values, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressBetween(String value1, String value2) {
            addCriterion("`detail_address` between", value1, value2, "detail_address");
            return (Criteria) this;
        }

        public Criteria andDetail_addressNotBetween(String value1, String value2) {
            addCriterion("`detail_address` not between", value1, value2, "detail_address");
            return (Criteria) this;
        }

        public Criteria andPost_codeIsNull() {
            addCriterion("`post_code` is null");
            return (Criteria) this;
        }

        public Criteria andPost_codeIsNotNull() {
            addCriterion("`post_code` is not null");
            return (Criteria) this;
        }

        public Criteria andPost_codeEqualTo(String value) {
            addCriterion("`post_code` =", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotEqualTo(String value) {
            addCriterion("`post_code` <>", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeGreaterThan(String value) {
            addCriterion("`post_code` >", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`post_code` >=", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeLessThan(String value) {
            addCriterion("`post_code` <", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeLessThanOrEqualTo(String value) {
            addCriterion("`post_code` <=", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeLike(String value) {
            addCriterion("`post_code` like", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotLike(String value) {
            addCriterion("`post_code` not like", value, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeIn(List<String> values) {
            addCriterion("`post_code` in", values, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotIn(List<String> values) {
            addCriterion("`post_code` not in", values, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeBetween(String value1, String value2) {
            addCriterion("`post_code` between", value1, value2, "post_code");
            return (Criteria) this;
        }

        public Criteria andPost_codeNotBetween(String value1, String value2) {
            addCriterion("`post_code` not between", value1, value2, "post_code");
            return (Criteria) this;
        }

        public Criteria andId_no_noIsNull() {
            addCriterion("`id_no_no` is null");
            return (Criteria) this;
        }

        public Criteria andId_no_noIsNotNull() {
            addCriterion("`id_no_no` is not null");
            return (Criteria) this;
        }

        public Criteria andId_no_noEqualTo(String value) {
            addCriterion("`id_no_no` =", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noNotEqualTo(String value) {
            addCriterion("`id_no_no` <>", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noGreaterThan(String value) {
            addCriterion("`id_no_no` >", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noGreaterThanOrEqualTo(String value) {
            addCriterion("`id_no_no` >=", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noLessThan(String value) {
            addCriterion("`id_no_no` <", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noLessThanOrEqualTo(String value) {
            addCriterion("`id_no_no` <=", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noLike(String value) {
            addCriterion("`id_no_no` like", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noNotLike(String value) {
            addCriterion("`id_no_no` not like", value, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noIn(List<String> values) {
            addCriterion("`id_no_no` in", values, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noNotIn(List<String> values) {
            addCriterion("`id_no_no` not in", values, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noBetween(String value1, String value2) {
            addCriterion("`id_no_no` between", value1, value2, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_noNotBetween(String value1, String value2) {
            addCriterion("`id_no_no` not between", value1, value2, "id_no_no");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontIsNull() {
            addCriterion("`id_no_scan_front` is null");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontIsNotNull() {
            addCriterion("`id_no_scan_front` is not null");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontEqualTo(String value) {
            addCriterion("`id_no_scan_front` =", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontNotEqualTo(String value) {
            addCriterion("`id_no_scan_front` <>", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontGreaterThan(String value) {
            addCriterion("`id_no_scan_front` >", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontGreaterThanOrEqualTo(String value) {
            addCriterion("`id_no_scan_front` >=", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontLessThan(String value) {
            addCriterion("`id_no_scan_front` <", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontLessThanOrEqualTo(String value) {
            addCriterion("`id_no_scan_front` <=", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontLike(String value) {
            addCriterion("`id_no_scan_front` like", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontNotLike(String value) {
            addCriterion("`id_no_scan_front` not like", value, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontIn(List<String> values) {
            addCriterion("`id_no_scan_front` in", values, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontNotIn(List<String> values) {
            addCriterion("`id_no_scan_front` not in", values, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontBetween(String value1, String value2) {
            addCriterion("`id_no_scan_front` between", value1, value2, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_frontNotBetween(String value1, String value2) {
            addCriterion("`id_no_scan_front` not between", value1, value2, "id_no_scan_front");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backIsNull() {
            addCriterion("`id_no_scan_back` is null");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backIsNotNull() {
            addCriterion("`id_no_scan_back` is not null");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backEqualTo(String value) {
            addCriterion("`id_no_scan_back` =", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backNotEqualTo(String value) {
            addCriterion("`id_no_scan_back` <>", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backGreaterThan(String value) {
            addCriterion("`id_no_scan_back` >", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backGreaterThanOrEqualTo(String value) {
            addCriterion("`id_no_scan_back` >=", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backLessThan(String value) {
            addCriterion("`id_no_scan_back` <", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backLessThanOrEqualTo(String value) {
            addCriterion("`id_no_scan_back` <=", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backLike(String value) {
            addCriterion("`id_no_scan_back` like", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backNotLike(String value) {
            addCriterion("`id_no_scan_back` not like", value, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backIn(List<String> values) {
            addCriterion("`id_no_scan_back` in", values, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backNotIn(List<String> values) {
            addCriterion("`id_no_scan_back` not in", values, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backBetween(String value1, String value2) {
            addCriterion("`id_no_scan_back` between", value1, value2, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andId_no_scan_backNotBetween(String value1, String value2) {
            addCriterion("`id_no_scan_back` not between", value1, value2, "id_no_scan_back");
            return (Criteria) this;
        }

        public Criteria andIs_defaultIsNull() {
            addCriterion("`is_default` is null");
            return (Criteria) this;
        }

        public Criteria andIs_defaultIsNotNull() {
            addCriterion("`is_default` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_defaultEqualTo(Boolean value) {
            addCriterion("`is_default` =", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultNotEqualTo(Boolean value) {
            addCriterion("`is_default` <>", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultGreaterThan(Boolean value) {
            addCriterion("`is_default` >", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_default` >=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultLessThan(Boolean value) {
            addCriterion("`is_default` <", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_default` <=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultIn(List<Boolean> values) {
            addCriterion("`is_default` in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultNotIn(List<Boolean> values) {
            addCriterion("`is_default` not in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_default` between", value1, value2, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_default` not between", value1, value2, "is_default");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idIsNull() {
            addCriterion("`user_identify_image_id` is null");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idIsNotNull() {
            addCriterion("`user_identify_image_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idEqualTo(Long value) {
            addCriterion("`user_identify_image_id` =", value, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idNotEqualTo(Long value) {
            addCriterion("`user_identify_image_id` <>", value, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idGreaterThan(Long value) {
            addCriterion("`user_identify_image_id` >", value, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`user_identify_image_id` >=", value, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idLessThan(Long value) {
            addCriterion("`user_identify_image_id` <", value, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idLessThanOrEqualTo(Long value) {
            addCriterion("`user_identify_image_id` <=", value, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idIn(List<Long> values) {
            addCriterion("`user_identify_image_id` in", values, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idNotIn(List<Long> values) {
            addCriterion("`user_identify_image_id` not in", values, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idBetween(Long value1, Long value2) {
            addCriterion("`user_identify_image_id` between", value1, value2, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andUser_identify_image_idNotBetween(Long value1, Long value2) {
            addCriterion("`user_identify_image_id` not between", value1, value2, "user_identify_image_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idIsNull() {
            addCriterion("`province_id` is null");
            return (Criteria) this;
        }

        public Criteria andProvince_idIsNotNull() {
            addCriterion("`province_id` is not null");
            return (Criteria) this;
        }

        public Criteria andProvince_idEqualTo(Integer value) {
            addCriterion("`province_id` =", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idNotEqualTo(Integer value) {
            addCriterion("`province_id` <>", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idGreaterThan(Integer value) {
            addCriterion("`province_id` >", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("`province_id` >=", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idLessThan(Integer value) {
            addCriterion("`province_id` <", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idLessThanOrEqualTo(Integer value) {
            addCriterion("`province_id` <=", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idIn(List<Integer> values) {
            addCriterion("`province_id` in", values, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idNotIn(List<Integer> values) {
            addCriterion("`province_id` not in", values, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idBetween(Integer value1, Integer value2) {
            addCriterion("`province_id` between", value1, value2, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvince_idNotBetween(Integer value1, Integer value2) {
            addCriterion("`province_id` not between", value1, value2, "province_id");
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