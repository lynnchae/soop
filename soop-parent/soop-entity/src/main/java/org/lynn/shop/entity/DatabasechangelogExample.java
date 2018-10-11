package org.lynn.soop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabasechangelogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public DatabasechangelogExample() {
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

        public Criteria andIDEqualTo(String value) {
            addCriterion("`ID` =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(String value) {
            addCriterion("`ID` <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(String value) {
            addCriterion("`ID` >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(String value) {
            addCriterion("`ID` >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(String value) {
            addCriterion("`ID` <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(String value) {
            addCriterion("`ID` <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLike(String value) {
            addCriterion("`ID` like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotLike(String value) {
            addCriterion("`ID` not like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<String> values) {
            addCriterion("`ID` in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<String> values) {
            addCriterion("`ID` not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(String value1, String value2) {
            addCriterion("`ID` between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(String value1, String value2) {
            addCriterion("`ID` not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andAUTHORIsNull() {
            addCriterion("`AUTHOR` is null");
            return (Criteria) this;
        }

        public Criteria andAUTHORIsNotNull() {
            addCriterion("`AUTHOR` is not null");
            return (Criteria) this;
        }

        public Criteria andAUTHOREqualTo(String value) {
            addCriterion("`AUTHOR` =", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORNotEqualTo(String value) {
            addCriterion("`AUTHOR` <>", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORGreaterThan(String value) {
            addCriterion("`AUTHOR` >", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORGreaterThanOrEqualTo(String value) {
            addCriterion("`AUTHOR` >=", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORLessThan(String value) {
            addCriterion("`AUTHOR` <", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORLessThanOrEqualTo(String value) {
            addCriterion("`AUTHOR` <=", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORLike(String value) {
            addCriterion("`AUTHOR` like", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORNotLike(String value) {
            addCriterion("`AUTHOR` not like", value, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORIn(List<String> values) {
            addCriterion("`AUTHOR` in", values, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORNotIn(List<String> values) {
            addCriterion("`AUTHOR` not in", values, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORBetween(String value1, String value2) {
            addCriterion("`AUTHOR` between", value1, value2, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andAUTHORNotBetween(String value1, String value2) {
            addCriterion("`AUTHOR` not between", value1, value2, "AUTHOR");
            return (Criteria) this;
        }

        public Criteria andFILENAMEIsNull() {
            addCriterion("`FILENAME` is null");
            return (Criteria) this;
        }

        public Criteria andFILENAMEIsNotNull() {
            addCriterion("`FILENAME` is not null");
            return (Criteria) this;
        }

        public Criteria andFILENAMEEqualTo(String value) {
            addCriterion("`FILENAME` =", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotEqualTo(String value) {
            addCriterion("`FILENAME` <>", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEGreaterThan(String value) {
            addCriterion("`FILENAME` >", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEGreaterThanOrEqualTo(String value) {
            addCriterion("`FILENAME` >=", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMELessThan(String value) {
            addCriterion("`FILENAME` <", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMELessThanOrEqualTo(String value) {
            addCriterion("`FILENAME` <=", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMELike(String value) {
            addCriterion("`FILENAME` like", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotLike(String value) {
            addCriterion("`FILENAME` not like", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEIn(List<String> values) {
            addCriterion("`FILENAME` in", values, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotIn(List<String> values) {
            addCriterion("`FILENAME` not in", values, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEBetween(String value1, String value2) {
            addCriterion("`FILENAME` between", value1, value2, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotBetween(String value1, String value2) {
            addCriterion("`FILENAME` not between", value1, value2, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDIsNull() {
            addCriterion("`DATEEXECUTED` is null");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDIsNotNull() {
            addCriterion("`DATEEXECUTED` is not null");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDEqualTo(Date value) {
            addCriterion("`DATEEXECUTED` =", value, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDNotEqualTo(Date value) {
            addCriterion("`DATEEXECUTED` <>", value, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDGreaterThan(Date value) {
            addCriterion("`DATEEXECUTED` >", value, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDGreaterThanOrEqualTo(Date value) {
            addCriterion("`DATEEXECUTED` >=", value, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDLessThan(Date value) {
            addCriterion("`DATEEXECUTED` <", value, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDLessThanOrEqualTo(Date value) {
            addCriterion("`DATEEXECUTED` <=", value, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDIn(List<Date> values) {
            addCriterion("`DATEEXECUTED` in", values, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDNotIn(List<Date> values) {
            addCriterion("`DATEEXECUTED` not in", values, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDBetween(Date value1, Date value2) {
            addCriterion("`DATEEXECUTED` between", value1, value2, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andDATEEXECUTEDNotBetween(Date value1, Date value2) {
            addCriterion("`DATEEXECUTED` not between", value1, value2, "DATEEXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDIsNull() {
            addCriterion("`ORDEREXECUTED` is null");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDIsNotNull() {
            addCriterion("`ORDEREXECUTED` is not null");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDEqualTo(Integer value) {
            addCriterion("`ORDEREXECUTED` =", value, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDNotEqualTo(Integer value) {
            addCriterion("`ORDEREXECUTED` <>", value, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDGreaterThan(Integer value) {
            addCriterion("`ORDEREXECUTED` >", value, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDGreaterThanOrEqualTo(Integer value) {
            addCriterion("`ORDEREXECUTED` >=", value, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDLessThan(Integer value) {
            addCriterion("`ORDEREXECUTED` <", value, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDLessThanOrEqualTo(Integer value) {
            addCriterion("`ORDEREXECUTED` <=", value, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDIn(List<Integer> values) {
            addCriterion("`ORDEREXECUTED` in", values, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDNotIn(List<Integer> values) {
            addCriterion("`ORDEREXECUTED` not in", values, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDBetween(Integer value1, Integer value2) {
            addCriterion("`ORDEREXECUTED` between", value1, value2, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andORDEREXECUTEDNotBetween(Integer value1, Integer value2) {
            addCriterion("`ORDEREXECUTED` not between", value1, value2, "ORDEREXECUTED");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEIsNull() {
            addCriterion("`EXECTYPE` is null");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEIsNotNull() {
            addCriterion("`EXECTYPE` is not null");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEEqualTo(String value) {
            addCriterion("`EXECTYPE` =", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPENotEqualTo(String value) {
            addCriterion("`EXECTYPE` <>", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEGreaterThan(String value) {
            addCriterion("`EXECTYPE` >", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEGreaterThanOrEqualTo(String value) {
            addCriterion("`EXECTYPE` >=", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPELessThan(String value) {
            addCriterion("`EXECTYPE` <", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPELessThanOrEqualTo(String value) {
            addCriterion("`EXECTYPE` <=", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPELike(String value) {
            addCriterion("`EXECTYPE` like", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPENotLike(String value) {
            addCriterion("`EXECTYPE` not like", value, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEIn(List<String> values) {
            addCriterion("`EXECTYPE` in", values, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPENotIn(List<String> values) {
            addCriterion("`EXECTYPE` not in", values, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPEBetween(String value1, String value2) {
            addCriterion("`EXECTYPE` between", value1, value2, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andEXECTYPENotBetween(String value1, String value2) {
            addCriterion("`EXECTYPE` not between", value1, value2, "EXECTYPE");
            return (Criteria) this;
        }

        public Criteria andMD5SUMIsNull() {
            addCriterion("`MD5SUM` is null");
            return (Criteria) this;
        }

        public Criteria andMD5SUMIsNotNull() {
            addCriterion("`MD5SUM` is not null");
            return (Criteria) this;
        }

        public Criteria andMD5SUMEqualTo(String value) {
            addCriterion("`MD5SUM` =", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMNotEqualTo(String value) {
            addCriterion("`MD5SUM` <>", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMGreaterThan(String value) {
            addCriterion("`MD5SUM` >", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMGreaterThanOrEqualTo(String value) {
            addCriterion("`MD5SUM` >=", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMLessThan(String value) {
            addCriterion("`MD5SUM` <", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMLessThanOrEqualTo(String value) {
            addCriterion("`MD5SUM` <=", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMLike(String value) {
            addCriterion("`MD5SUM` like", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMNotLike(String value) {
            addCriterion("`MD5SUM` not like", value, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMIn(List<String> values) {
            addCriterion("`MD5SUM` in", values, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMNotIn(List<String> values) {
            addCriterion("`MD5SUM` not in", values, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMBetween(String value1, String value2) {
            addCriterion("`MD5SUM` between", value1, value2, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andMD5SUMNotBetween(String value1, String value2) {
            addCriterion("`MD5SUM` not between", value1, value2, "MD5SUM");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONIsNull() {
            addCriterion("`DESCRIPTION` is null");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONIsNotNull() {
            addCriterion("`DESCRIPTION` is not null");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONEqualTo(String value) {
            addCriterion("`DESCRIPTION` =", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotEqualTo(String value) {
            addCriterion("`DESCRIPTION` <>", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONGreaterThan(String value) {
            addCriterion("`DESCRIPTION` >", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONGreaterThanOrEqualTo(String value) {
            addCriterion("`DESCRIPTION` >=", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONLessThan(String value) {
            addCriterion("`DESCRIPTION` <", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONLessThanOrEqualTo(String value) {
            addCriterion("`DESCRIPTION` <=", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONLike(String value) {
            addCriterion("`DESCRIPTION` like", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotLike(String value) {
            addCriterion("`DESCRIPTION` not like", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONIn(List<String> values) {
            addCriterion("`DESCRIPTION` in", values, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotIn(List<String> values) {
            addCriterion("`DESCRIPTION` not in", values, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONBetween(String value1, String value2) {
            addCriterion("`DESCRIPTION` between", value1, value2, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotBetween(String value1, String value2) {
            addCriterion("`DESCRIPTION` not between", value1, value2, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSIsNull() {
            addCriterion("`COMMENTS` is null");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSIsNotNull() {
            addCriterion("`COMMENTS` is not null");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSEqualTo(String value) {
            addCriterion("`COMMENTS` =", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSNotEqualTo(String value) {
            addCriterion("`COMMENTS` <>", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSGreaterThan(String value) {
            addCriterion("`COMMENTS` >", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSGreaterThanOrEqualTo(String value) {
            addCriterion("`COMMENTS` >=", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSLessThan(String value) {
            addCriterion("`COMMENTS` <", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSLessThanOrEqualTo(String value) {
            addCriterion("`COMMENTS` <=", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSLike(String value) {
            addCriterion("`COMMENTS` like", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSNotLike(String value) {
            addCriterion("`COMMENTS` not like", value, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSIn(List<String> values) {
            addCriterion("`COMMENTS` in", values, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSNotIn(List<String> values) {
            addCriterion("`COMMENTS` not in", values, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSBetween(String value1, String value2) {
            addCriterion("`COMMENTS` between", value1, value2, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andCOMMENTSNotBetween(String value1, String value2) {
            addCriterion("`COMMENTS` not between", value1, value2, "COMMENTS");
            return (Criteria) this;
        }

        public Criteria andTAGIsNull() {
            addCriterion("`TAG` is null");
            return (Criteria) this;
        }

        public Criteria andTAGIsNotNull() {
            addCriterion("`TAG` is not null");
            return (Criteria) this;
        }

        public Criteria andTAGEqualTo(String value) {
            addCriterion("`TAG` =", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGNotEqualTo(String value) {
            addCriterion("`TAG` <>", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGGreaterThan(String value) {
            addCriterion("`TAG` >", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGGreaterThanOrEqualTo(String value) {
            addCriterion("`TAG` >=", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGLessThan(String value) {
            addCriterion("`TAG` <", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGLessThanOrEqualTo(String value) {
            addCriterion("`TAG` <=", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGLike(String value) {
            addCriterion("`TAG` like", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGNotLike(String value) {
            addCriterion("`TAG` not like", value, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGIn(List<String> values) {
            addCriterion("`TAG` in", values, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGNotIn(List<String> values) {
            addCriterion("`TAG` not in", values, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGBetween(String value1, String value2) {
            addCriterion("`TAG` between", value1, value2, "TAG");
            return (Criteria) this;
        }

        public Criteria andTAGNotBetween(String value1, String value2) {
            addCriterion("`TAG` not between", value1, value2, "TAG");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEIsNull() {
            addCriterion("`LIQUIBASE` is null");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEIsNotNull() {
            addCriterion("`LIQUIBASE` is not null");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEEqualTo(String value) {
            addCriterion("`LIQUIBASE` =", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASENotEqualTo(String value) {
            addCriterion("`LIQUIBASE` <>", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEGreaterThan(String value) {
            addCriterion("`LIQUIBASE` >", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEGreaterThanOrEqualTo(String value) {
            addCriterion("`LIQUIBASE` >=", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASELessThan(String value) {
            addCriterion("`LIQUIBASE` <", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASELessThanOrEqualTo(String value) {
            addCriterion("`LIQUIBASE` <=", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASELike(String value) {
            addCriterion("`LIQUIBASE` like", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASENotLike(String value) {
            addCriterion("`LIQUIBASE` not like", value, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEIn(List<String> values) {
            addCriterion("`LIQUIBASE` in", values, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASENotIn(List<String> values) {
            addCriterion("`LIQUIBASE` not in", values, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASEBetween(String value1, String value2) {
            addCriterion("`LIQUIBASE` between", value1, value2, "LIQUIBASE");
            return (Criteria) this;
        }

        public Criteria andLIQUIBASENotBetween(String value1, String value2) {
            addCriterion("`LIQUIBASE` not between", value1, value2, "LIQUIBASE");
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