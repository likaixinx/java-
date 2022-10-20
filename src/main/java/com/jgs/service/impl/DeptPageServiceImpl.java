package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import com.jgs.pojo.Department;
import com.jgs.service.DeptPageService;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: com.jgs.service.impl.DeptPageServiceImpl
 * @author: likaixin
 * @create: 2022年10月17日 11:09
 * @description:
 */
public class DeptPageServiceImpl implements DeptPageService {
    private SqlSession sqlSession = null;

    @Override
    public List<Department> selectAllPage() throws IOException {

        sqlSession = SqlSessionUtils.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        return mapper.selectAllDept();


    }

    public void close() {
        sqlSession.close();
    }
}
