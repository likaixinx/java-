package com.jgs.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.pojo.Department;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: com.jgs.test.test
 * @author: likaixin
 * @create: 2022年10月16日 21:53
 * @description:
 */
public class test {

    @Test
    public void t1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
        List<int[]> array=new ArrayList<>();
        array.add(new int[10]);
    }
    @Test
    public void t2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        PageHelper.startPage(1, 3);//开启分页

        List<Department> selectByExample = mapper.selectByExample(null);

        PageInfo<Department> pageInfo = new PageInfo<>(selectByExample);
        System.out.println(pageInfo);
        System.out.println("department = " + selectByExample);
        sqlSession.close();
    }

}
