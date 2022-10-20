package com.jgs.service;

import com.jgs.pojo.Admin;

/**
 * @ClassName: com.jgs.service.AdminForGetService
 * @author: likaixin
 * @create: 2022年10月02日 23:02
 * @description: 处理忘记密码业务的service
 */

public interface AdminForGetService {
    Admin forGetService(String name);

    Integer UpdatePasswordService(String password, String name);

    Admin selectOldPassword(String name, String pwd);
}
