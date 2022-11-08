package com.jgs.service;

import com.jgs.pojo.Employee;

import java.util.List;

/**
 * @author likaixin
 * @ClassName com.jgs.service.EmployeeService
 * @create 2022年10月24日 23:33
 * @desc:
 */
public interface EmployeeService {
    //对员工进行分页
    List<Employee> selectEmployeeAllLimit();
    //修改员工信息
    Integer modifyEmployee(Employee employee);

    Integer deleteByPrimaryKey(Integer id);
}
