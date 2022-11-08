package com.jgs.mapper;

import com.jgs.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author likaixin
 * @ClassName com.jgs.mapper.EmployeeMapper
 * @create 2022年10月24日 21:21
 * @desc: 持久层
 */
public interface EmployeeMapper {
     List<Employee> selectEmployeeAllLimit();

    Integer updateByPrimaryKey(Employee employee);

    Integer deleteByPrimaryKey(@Param("id") Integer id);
}
