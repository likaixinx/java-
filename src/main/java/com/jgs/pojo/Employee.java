package com.jgs.pojo;



public class Employee {
    private Integer id;

    private String employeeName;

    private String employeeAge;

    private String employeeHobby;


    private String employeeSex;

    private String employeeDept;

    private String employeeBrief;

    private Integer employeeDid;
    private String employeeDate;

    public Employee() {
    }

    public Employee(Integer id, String employeeName, String employeeAge, String employeeHobby, String employeeSex, String employeeDept, String employeeBrief, String employeeDate) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeHobby = employeeHobby;
        this.employeeSex = employeeSex;
        this.employeeDept = employeeDept;
        this.employeeBrief = employeeBrief;

        this.employeeDate = employeeDate;
    }

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
        this.employeeName = employeeName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeHobby() {
        return employeeHobby;
    }

    public void setEmployeeHobby(String employeeHobby) {
        this.employeeHobby = employeeHobby;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public String getEmployeeBrief() {
        return employeeBrief;
    }

    public void setEmployeeBrief(String employeeBrief) {
        this.employeeBrief = employeeBrief;
    }

    public Integer getEmployeeDid() {
        return employeeDid;
    }

    public void setEmployeeDid(Integer employeeDid) {
        this.employeeDid = employeeDid;
    }

    public String getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(String employeeDate) {

        this.employeeDate = employeeDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeHobby='" + employeeHobby + '\'' +
                ", employeeSex='" + employeeSex + '\'' +
                ", employeeDept='" + employeeDept + '\'' +
                ", employeeBrief='" + employeeBrief + '\'' +
                ", employeeDid=" + employeeDid +
                ", employeeDate=" + employeeDate +
                '}';
    }
}