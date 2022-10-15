package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.AdminMapper;
import com.jgs.pojo.Admin;
import com.jgs.service.AdminLoginService;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName: com.jgs.service.impl.AdminLoginServiceImpl
 * @author: likaixin
 * @create: 2022年10月15日 13:04
 * @description:
 */
public class AdminLoginServiceImpl implements AdminLoginService {
    @Override
    public Admin selectAdmin(Admin admin) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);


        Admin selectAdmin = mapper.selectAdmin(admin.getName(),admin.getPwd());
        return  selectAdmin;
    }

    @Override
    public Integer addAdmin(Admin admin) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Integer count = mapper.addAdmin(admin.getName(),admin.getPwd());
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    @Override
    public Admin selectAdminExist(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.selectAdminExist(name);
        return admin;
    }
}
