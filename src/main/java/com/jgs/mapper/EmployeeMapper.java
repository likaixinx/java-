package com.jgs.mapper;

import com.jgs.pojo.Employee;

import java.util.List;

/**
 * @author likaixin
 * @ClassName com.jgs.mapper.EmployeeMapper
 * @create 2022年10月24日 21:21
 * @desc: 持久层
 */
public interface EmployeeMapper {
     List<Employee> selectEmployeeAllLimit();
}
