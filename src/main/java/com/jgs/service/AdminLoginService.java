package com.jgs.service;


import com.jgs.Utils.SqlSessionUtils;


import com.jgs.mapper.AdminMapper;
import com.jgs.pojo.Admin;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName: com.jgs.service.AdminLoginService
 * @author: likaixin
 * @create: 2022年09月29日 21:37
 * @description: 处理登录业务的service
 */
public interface AdminLoginService {
    public Admin selectAdmin(Admin admin);


    public Integer addAdmin(Admin admin);


    public Admin selectAdminExist(String name);


}
