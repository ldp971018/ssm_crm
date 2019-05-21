package com.ldp.ssm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitExample() {
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNull() {
            addCriterion("visit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Date value) {
            addCriterion("visit_time =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Date value) {
            addCriterion("visit_time <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Date value) {
            addCriterion("visit_time >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_time >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Date value) {
            addCriterion("visit_time <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Date value) {
            addCriterion("visit_time <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(List<Date> values) {
            addCriterion("visit_time in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(List<Date> values) {
            addCriterion("visit_time not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Date value1, Date value2) {
            addCriterion("visit_time between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Date value1, Date value2) {
            addCriterion("visit_time not between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitAddrIsNull() {
            addCriterion("visit_addr is null");
            return (Criteria) this;
        }

        public Criteria andVisitAddrIsNotNull() {
            addCriterion("visit_addr is not null");
            return (Criteria) this;
        }

        public Criteria andVisitAddrEqualTo(String value) {
            addCriterion("visit_addr =", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotEqualTo(String value) {
            addCriterion("visit_addr <>", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrGreaterThan(String value) {
            addCriterion("visit_addr >", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrGreaterThanOrEqualTo(String value) {
            addCriterion("visit_addr >=", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrLessThan(String value) {
            addCriterion("visit_addr <", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrLessThanOrEqualTo(String value) {
            addCriterion("visit_addr <=", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrLike(String value) {
            addCriterion("visit_addr like", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotLike(String value) {
            addCriterion("visit_addr not like", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrIn(List<String> values) {
            addCriterion("visit_addr in", values, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotIn(List<String> values) {
            addCriterion("visit_addr not in", values, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrBetween(String value1, String value2) {
            addCriterion("visit_addr between", value1, value2, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotBetween(String value1, String value2) {
            addCriterion("visit_addr not between", value1, value2, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitDetailIsNull() {
            addCriterion("visit_detail is null");
            return (Criteria) this;
        }

        public Criteria andVisitDetailIsNotNull() {
            addCriterion("visit_detail is not null");
            return (Criteria) this;
        }

        public Criteria andVisitDetailEqualTo(String value) {
            addCriterion("visit_detail =", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotEqualTo(String value) {
            addCriterion("visit_detail <>", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailGreaterThan(String value) {
            addCriterion("visit_detail >", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailGreaterThanOrEqualTo(String value) {
            addCriterion("visit_detail >=", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailLessThan(String value) {
            addCriterion("visit_detail <", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailLessThanOrEqualTo(String value) {
            addCriterion("visit_detail <=", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailLike(String value) {
            addCriterion("visit_detail like", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotLike(String value) {
            addCriterion("visit_detail not like", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailIn(List<String> values) {
            addCriterion("visit_detail in", values, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotIn(List<String> values) {
            addCriterion("visit_detail not in", values, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailBetween(String value1, String value2) {
            addCriterion("visit_detail between", value1, value2, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotBetween(String value1, String value2) {
            addCriterion("visit_detail not between", value1, value2, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeIsNull() {
            addCriterion("visit_nexttime is null");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeIsNotNull() {
            addCriterion("visit_nexttime is not null");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeEqualTo(Date value) {
            addCriterion("visit_nexttime =", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeNotEqualTo(Date value) {
            addCriterion("visit_nexttime <>", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeGreaterThan(Date value) {
            addCriterion("visit_nexttime >", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_nexttime >=", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeLessThan(Date value) {
            addCriterion("visit_nexttime <", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeLessThanOrEqualTo(Date value) {
            addCriterion("visit_nexttime <=", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeIn(List<Date> values) {
            addCriterion("visit_nexttime in", values, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeNotIn(List<Date> values) {
            addCriterion("visit_nexttime not in", values, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeBetween(Date value1, Date value2) {
            addCriterion("visit_nexttime between", value1, value2, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeNotBetween(Date value1, Date value2) {
            addCriterion("visit_nexttime not between", value1, value2, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdIsNull() {
            addCriterion("visit_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdIsNotNull() {
            addCriterion("visit_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdEqualTo(Integer value) {
            addCriterion("visit_admin_id =", value, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdNotEqualTo(Integer value) {
            addCriterion("visit_admin_id <>", value, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdGreaterThan(Integer value) {
            addCriterion("visit_admin_id >", value, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_admin_id >=", value, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdLessThan(Integer value) {
            addCriterion("visit_admin_id <", value, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("visit_admin_id <=", value, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdIn(List<Integer> values) {
            addCriterion("visit_admin_id in", values, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdNotIn(List<Integer> values) {
            addCriterion("visit_admin_id not in", values, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("visit_admin_id between", value1, value2, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_admin_id not between", value1, value2, "visitAdminId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdIsNull() {
            addCriterion("visit_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdIsNotNull() {
            addCriterion("visit_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdEqualTo(Integer value) {
            addCriterion("visit_employee_id =", value, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdNotEqualTo(Integer value) {
            addCriterion("visit_employee_id <>", value, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdGreaterThan(Integer value) {
            addCriterion("visit_employee_id >", value, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_employee_id >=", value, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdLessThan(Integer value) {
            addCriterion("visit_employee_id <", value, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("visit_employee_id <=", value, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdIn(List<Integer> values) {
            addCriterion("visit_employee_id in", values, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdNotIn(List<Integer> values) {
            addCriterion("visit_employee_id not in", values, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("visit_employee_id between", value1, value2, "visitEmployeeId");
            return (Criteria) this;
        }

        public Criteria andVisitEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_employee_id not between", value1, value2, "visitEmployeeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
    }
}