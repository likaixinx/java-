package com.jgs.pojo;

public class Department {
    private Integer id;

    private String departmentName;

    private String departmentAddress;

    private Integer departmentEid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress == null ? null : departmentAddress.trim();
    }

    public Integer getDepartmentEid() {
        return departmentEid;
    }

    public void setDepartmentEid(Integer departmentEid) {
        this.departmentEid = departmentEid;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentEid=" + departmentEid +
                '}';
    }
}