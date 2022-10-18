package com.jgs.service;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.pojo.Department;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName: com.jgs.service.DeptSearchServiceImpl
 * @author: likaixin
 * @create: 2022年10月18日 20:58
 * @description:
 */
public class DeptSearchServiceImpl implements DeptSearchService {
    @Override
    public List<Department> search(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.searchByDepartmentName(name);
        return departments;


    }
}