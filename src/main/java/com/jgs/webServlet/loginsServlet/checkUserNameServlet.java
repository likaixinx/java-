package com.jgs.webServlet.loginsServlet;


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
 * @Author: LiKaiXin
 * @Description: 此servlet检查用户名是否可用
 * @Date:  2022-10-02
 * @Time:  10:04
 * @Param:
 * @return:
 **/
@WebServlet("/checkUserNameServlet")
public class checkUserNameServlet extends HttpServlet {
    private static AdminLoginService adminLoginService=new AdminLoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        Admin admin = adminLoginService.selectAdminExist(username);
        if (admin!=null){

            response.getWriter().write("用户名已存在");
        }else{
            response.getWriter().write("用户名可用");
        }
    }


}
