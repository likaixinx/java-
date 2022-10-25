package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.EmployeeMapper;
import com.jgs.pojo.Employee;
import com.jgs.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName: com.jgs.service.impl.EmployeeServiceImpl
 * @author: likaixin
 * @create: 2022年10月24日 23:33
 * @description:
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> selectEmployeeAllLimit() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeAllLimit();
        return employees;
    }
}
