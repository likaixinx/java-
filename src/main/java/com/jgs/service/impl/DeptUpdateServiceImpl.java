package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.service.DeptUpdateService;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName: com.jgs.service.impl.DeptUpdateServiceImpl
 * @author: likaixin
 * @create: 2022年10月19日 9:39
 * @description:
 */
public class DeptUpdateServiceImpl implements DeptUpdateService {
    @Override
    public Integer updateDeptMsg(String deptName, String deptAddress, Integer id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Integer count = mapper.updateDeptMsg( deptName,deptAddress,id);
        sqlSession.commit();

        return count;
    }
}
