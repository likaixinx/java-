package com.jgs.webServlet.loginsServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.Utils.MD5Util;
import com.jgs.Utils.Music;
import com.jgs.pojo.Admin;
import com.jgs.pojo.Department;
import com.jgs.pojo.Page;
import com.jgs.service.AdminLoginService;
import com.jgs.service.impl.AdminLoginServiceImpl;
import com.jgs.service.impl.DeptPageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//登录逻辑处理
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    DeptPageServiceImpl pageService=new DeptPageServiceImpl();

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
                Integer pageNum= 1;
                Integer pageSize=5;

                PageHelper.startPage(pageNum, pageSize);//开启分页
                List<Department> departments = pageService.selectAllPage((pageNum - 1) * pageSize, pageSize);
                System.out.println(departments);

                PageInfo<Department> pageInfo = new PageInfo<>(departments,4);
                System.out.println(pageInfo);
                session.setAttribute("deptList",departments);
                session.setAttribute("page",pageInfo);

                session.setAttribute("loginName",username);
                session.removeAttribute("msg");
                response.getWriter().write("跳转");

            }
        }




}
