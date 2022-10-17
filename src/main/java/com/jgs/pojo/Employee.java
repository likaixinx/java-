package com.jgs.pojo;

public class Employee {
    private Integer id;

    private String employeeName;

    private Integer employeeAge;

    private String employeeHobby;

    private String employeeSex;

    private String employeeDept;

    private String employeeBrief;

    private Integer employeeDid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeHobby() {
        return employeeHobby;
    }

    public void setEmployeeHobby(String employeeHobby) {
        this.employeeHobby = employeeHobby == null ? null : employeeHobby.trim();
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex == null ? null : employeeSex.trim();
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept == null ? null : employeeDept.trim();
    }

    public String getEmployeeBrief() {
        return employeeBrief;
    }

    public void setEmployeeBrief(String employeeBrief) {
        this.employeeBrief = employeeBrief == null ? null : employeeBrief.trim();
    }

    public Integer getEmployeeDid() {
        return employeeDid;
    }

    public void setEmployeeDid(Integer employeeDid) {
        this.employeeDid = employeeDid;
    }
}