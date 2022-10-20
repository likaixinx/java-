package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.service.DeptUpdateService;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: com.jgs.service.impl.DeptUpdateServiceImpl
 * @author: likaixin
 * @create: 2022年10月19日 9:39
 * @description:
 */
public class DeptUpdateServiceImpl implements DeptUpdateService {
    private  SqlSession sqlSession=null;
    @Override
    public Integer updateDeptMsg(String deptName, String deptAddress, Integer id) {
        sqlSession = SqlSessionUtils.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Integer count = mapper.updateDeptMsg( deptName,deptAddress,id);
        sqlSession.commit();

        return count;
    }

    @Override
    public Integer addDept(String deptName, String deptAddress) {
         sqlSession = SqlSessionUtils.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
       List<Integer> ids = mapper.selectByAllDid();
        Random random = new Random();
        int i = random.nextInt(ids.size());

        Integer count = mapper.addDept(deptName, deptAddress, ids.get(i));
        sqlSession.commit();
        return count;
    }

    @Override
    public Integer delDeptId(Integer id) {
        sqlSession = SqlSessionUtils.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Integer count = mapper.deleteById(id);
        sqlSession.commit();
        return count;
    }
    public void close(){
        sqlSession.close();
    }
}
