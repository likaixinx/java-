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
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登录逻辑处理
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println(666);
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String digest = MD5Util.digest(pwd);

        System.out.println(digest);
        String yzm = request.getParameter("yzm");

            if (yzm != null) {
                HttpSession session = request.getSession();
                String newYzm = (String) session.getAttribute("randStr");
                System.out.println(newYzm);
                if (!yzm.equalsIgnoreCase(newYzm)){
                    response.getWriter().write("验证码输入错误");
                    //response.sendRedirect("login.jsp");
                    return;
                }
                Admin admin=null;
                AdminLoginService loginService = new AdminLoginServiceImpl();
                if (digest.length()>16){
                     admin = new Admin(null, username, digest);
                }else{
                    admin = new Admin(null, username, pwd);
                }


                Admin selectAdmin = loginService.selectAdmin(admin);
                if (selectAdmin == null  ) {
                    response.getWriter().write("账号或密码输入错误");
                    //response.sendRedirect("login.jsp");
                    return;
                }
                session.setAttribute("loginName",username);
                session.removeAttribute("msg");
                response.getWriter().write("跳转");


            }
        }




}
