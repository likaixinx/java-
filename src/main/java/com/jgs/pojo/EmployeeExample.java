package com.jgs.pojo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeIsNull() {
            addCriterion("employee_age is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeIsNotNull() {
            addCriterion("employee_age is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeEqualTo(Integer value) {
            addCriterion("employee_age =", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeNotEqualTo(Integer value) {
            addCriterion("employee_age <>", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeGreaterThan(Integer value) {
            addCriterion("employee_age >", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_age >=", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeLessThan(Integer value) {
            addCriterion("employee_age <", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeLessThanOrEqualTo(Integer value) {
            addCriterion("employee_age <=", value, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeIn(List<Integer> values) {
            addCriterion("employee_age in", values, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeNotIn(List<Integer> values) {
            addCriterion("employee_age not in", values, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeBetween(Integer value1, Integer value2) {
            addCriterion("employee_age between", value1, value2, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_age not between", value1, value2, "employeeAge");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyIsNull() {
            addCriterion("employee_hobby is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyIsNotNull() {
            addCriterion("employee_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyEqualTo(String value) {
            addCriterion("employee_hobby =", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyNotEqualTo(String value) {
            addCriterion("employee_hobby <>", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyGreaterThan(String value) {
            addCriterion("employee_hobby >", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("employee_hobby >=", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyLessThan(String value) {
            addCriterion("employee_hobby <", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyLessThanOrEqualTo(String value) {
            addCriterion("employee_hobby <=", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyLike(String value) {
            addCriterion("employee_hobby like", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyNotLike(String value) {
            addCriterion("employee_hobby not like", value, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyIn(List<String> values) {
            addCriterion("employee_hobby in", values, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyNotIn(List<String> values) {
            addCriterion("employee_hobby not in", values, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyBetween(String value1, String value2) {
            addCriterion("employee_hobby between", value1, value2, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeHobbyNotBetween(String value1, String value2) {
            addCriterion("employee_hobby not between", value1, value2, "employeeHobby");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIsNull() {
            addCriterion("employee_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIsNotNull() {
            addCriterion("employee_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexEqualTo(String value) {
            addCriterion("employee_sex =", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotEqualTo(String value) {
            addCriterion("employee_sex <>", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexGreaterThan(String value) {
            addCriterion("employee_sex >", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexGreaterThanOrEqualTo(String value) {
            addCriterion("employee_sex >=", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLessThan(String value) {
            addCriterion("employee_sex <", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLessThanOrEqualTo(String value) {
            addCriterion("employee_sex <=", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLike(String value) {
            addCriterion("employee_sex like", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotLike(String value) {
            addCriterion("employee_sex not like", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIn(List<String> values) {
            addCriterion("employee_sex in", values, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotIn(List<String> values) {
            addCriterion("employee_sex not in", values, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexBetween(String value1, String value2) {
            addCriterion("employee_sex between", value1, value2, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotBetween(String value1, String value2) {
            addCriterion("employee_sex not between", value1, value2, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptIsNull() {
            addCriterion("employee_dept is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptIsNotNull() {
            addCriterion("employee_dept is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptEqualTo(String value) {
            addCriterion("employee_dept =", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptNotEqualTo(String value) {
            addCriterion("employee_dept <>", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptGreaterThan(String value) {
            addCriterion("employee_dept >", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptGreaterThanOrEqualTo(String value) {
            addCriterion("employee_dept >=", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptLessThan(String value) {
            addCriterion("employee_dept <", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptLessThanOrEqualTo(String value) {
            addCriterion("employee_dept <=", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptLike(String value) {
            addCriterion("employee_dept like", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptNotLike(String value) {
            addCriterion("employee_dept not like", value, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptIn(List<String> values) {
            addCriterion("employee_dept in", values, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptNotIn(List<String> values) {
            addCriterion("employee_dept not in", values, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptBetween(String value1, String value2) {
            addCriterion("employee_dept between", value1, value2, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeDeptNotBetween(String value1, String value2) {
            addCriterion("employee_dept not between", value1, value2, "employeeDept");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefIsNull() {
            addCriterion("employee_brief is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefIsNotNull() {
            addCriterion("employee_brief is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefEqualTo(String value) {
            addCriterion("employee_brief =", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefNotEqualTo(String value) {
            addCriterion("employee_brief <>", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefGreaterThan(String value) {
            addCriterion("employee_brief >", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefGreaterThanOrEqualTo(String value) {
            addCriterion("employee_brief >=", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefLessThan(String value) {
            addCriterion("employee_brief <", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefLessThanOrEqualTo(String value) {
            addCriterion("employee_brief <=", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefLike(String value) {
            addCriterion("employee_brief like", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefNotLike(String value) {
            addCriterion("employee_brief not like", value, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefIn(List<String> values) {
            addCriterion("employee_brief in", values, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefNotIn(List<String> values) {
            addCriterion("employee_brief not in", values, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefBetween(String value1, String value2) {
            addCriterion("employee_brief between", value1, value2, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeBriefNotBetween(String value1, String value2) {
            addCriterion("employee_brief not between", value1, value2, "employeeBrief");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidIsNull() {
            addCriterion("employee_did is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidIsNotNull() {
            addCriterion("employee_did is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidEqualTo(Integer value) {
            addCriterion("employee_did =", value, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidNotEqualTo(Integer value) {
            addCriterion("employee_did <>", value, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidGreaterThan(Integer value) {
            addCriterion("employee_did >", value, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_did >=", value, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidLessThan(Integer value) {
            addCriterion("employee_did <", value, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidLessThanOrEqualTo(Integer value) {
            addCriterion("employee_did <=", value, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidIn(List<Integer> values) {
            addCriterion("employee_did in", values, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidNotIn(List<Integer> values) {
            addCriterion("employee_did not in", values, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidBetween(Integer value1, Integer value2) {
            addCriterion("employee_did between", value1, value2, "employeeDid");
            return (Criteria) this;
        }

        public Criteria andEmployeeDidNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_did not between", value1, value2, "employeeDid");
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