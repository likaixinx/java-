package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.pojo.Department;
import com.jgs.service.DeptSearchService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName: com.jgs.service.impl.DeptSearchServiceImpl
 * @author: likaixin
 * @create: 2022年10月18日 20:58
 * @description:
 */
public class DeptSearchServiceImpl implements DeptSearchService {
    @Override
    public List<Department> search(String name) {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.searchByDepartmentName(name);
        return departments;


    }
}
