package com.jgs.service.impl;

import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.AdminMapper;
import com.jgs.pojo.Admin;
import com.jgs.service.AdminForGetService;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName: com.jgs.service.impl.AdminForGetServiceImpl
 * @author: likaixin
 * @create: 2022年10月15日 13:02
 * @description:
 */
public class AdminForGetServiceImpl implements AdminForGetService {
    @Override
    public Admin forGetService(String name) {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.SelectForget(name);
        return admin;
    }

    @Override
    public Integer UpdatePasswordService(String password, String name) {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Integer count = mapper.updatePassword(password,name);
        sqlSession.commit();
        return count;
    }

    @Override
    public Admin selectOldPassword(String name, String pwd) {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        return mapper.selectOldPassword(name, pwd);

    }


}
