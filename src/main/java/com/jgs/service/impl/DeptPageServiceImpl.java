package com.jgs.service.impl;

import com.github.pagehelper.PageHelper;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.pojo.Department;
import com.jgs.service.DeptPageService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName: com.jgs.service.impl.DeptPageServiceImpl
 * @author: likaixin
 * @create: 2022年10月17日 11:09
 * @description:
 */
public class DeptPageServiceImpl implements DeptPageService {
    @Override
    public List<Department> selectAllPage(Integer startIndex,Integer pageSize) {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = mapper.selectAllDept();

        return departments;


    }
}
