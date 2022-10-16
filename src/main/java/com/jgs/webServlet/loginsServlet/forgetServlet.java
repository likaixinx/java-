package com.jgs.webServlet.loginsServlet;

import com.jgs.Utils.MD5Util;
import com.jgs.pojo.Admin;
import com.jgs.service.AdminForGetService;
import com.jgs.service.impl.AdminForGetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forgetServlet")
public class forgetServlet extends HttpServlet {

    private static AdminForGetService adminForGetService=new AdminForGetServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");

        String pwd2 = request.getParameter("pwd2");
        String oldPwd = request.getParameter("oldPwd");

        Admin admin = adminForGetService.forGetService(username);
        if (admin==null){
            response.getWriter().write("用户名不存在");
            return;
        }
        String digestOld = MD5Util.digest(oldPwd);
        Admin admin2 = adminForGetService.selectOldPassword(username, digestOld);

        if (admin2==null) {
            response.getWriter().write("旧密码输入错误");
            return;
        }
        String digest = MD5Util.digest(pwd2);

        Integer count= adminForGetService.UpdatePasswordService(digest,username);
        if (count>0){
            response.getWriter().write("修改密码成功");
        }

    }
}
