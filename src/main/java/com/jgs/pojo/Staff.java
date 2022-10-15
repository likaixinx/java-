package com.jgs.pojo;

/**
 * @ClassName: com.jgs.pojo.Staff
 * @author: likaixin
 * @create: 2022年09月29日 15:34
 * @description: 普通员工的实体类
 */
public class Staff {
    private String name;//员工姓名
    private Integer job_number;//员工工号
    private String position; //职位
    private double salary; //工资
    private String dept;  //部门

    public Staff() {
    }

    public Staff(String name, Integer job_number, String position, double salary, String dept) {
        this.name = name;
        this.job_number = job_number;
        this.position = position;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJob_number() {
        return job_number;
    }

    public void setJob_number(Integer job_number) {
        this.job_number = job_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", job_number=" + job_number +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}
