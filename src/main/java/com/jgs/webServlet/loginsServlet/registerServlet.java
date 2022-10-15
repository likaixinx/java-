package com.jgs.webServlet.loginsServlet;

import com.jgs.Utils.MD5Util;
import com.jgs.pojo.Admin;
import com.jgs.service.AdminLoginService;
import com.jgs.service.impl.AdminLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: com.jgs.webServlet.registerServlet
 * @author: likaixin
 * @create: 2022年09月30日 16:20
 * @description: 注册逻辑处理
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {

     private static AdminLoginService adminRegisterService=new AdminLoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");

        String affPwd = req.getParameter("affPwd");
        String digest = MD5Util.digest(affPwd);

        Admin admin = new Admin(null,username,digest);

        Integer count = adminRegisterService.addAdmin(admin);
        if (count>0){
            resp.getWriter().write("注册成功！");

        }else{

            resp.getWriter().write("注册失败！");
        }

    }
}
