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
    private  SqlSession sqlSession;
    @Override
    public List<Employee> selectEmployeeAllLimit() {
        sqlSession= SqlSessionUtils.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeAllLimit();

        return employees;
    }

    @Override
    public Integer modifyEmployee(Employee employee) {
        sqlSession = SqlSessionUtils.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Integer count = mapper.updateByPrimaryKey(employee);
        sqlSession.commit();
        return count;
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        sqlSession = SqlSessionUtils.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Integer count = mapper.deleteByPrimaryKey(id);
        sqlSession.commit();
        return count;
    }

    public void close(){
        sqlSession.close();
    }
}
