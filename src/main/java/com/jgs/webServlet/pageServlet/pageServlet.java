package com.jgs.webServlet.pageServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.pojo.Department;
import com.jgs.service.impl.DeptPageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: com.jgs.webServlet.pageServlet.pageServelt
 * @author: likaixin
 * @create: 2022年10月17日 11:02
 * @description:
 */
@WebServlet("/page")
public class pageServlet extends HttpServlet {
   static DeptPageServiceImpl pageService = new DeptPageServiceImpl();
    String num=null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String num = request.getParameter("num");

        if (!"1".equals(num)){
            Integer pageNum = Integer.parseInt(request.getParameter("startIndex"));
            Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));


            PageHelper.startPage(pageNum,pageSize);
            List<Department> departments = pageService.selectAllPage(pageNum , pageSize);

            System.out.println(departments);

            PageInfo<Department> pageInfo = new PageInfo<>(departments);
            System.out.println(pageInfo);
            session.setAttribute("deptList", departments);
            session.setAttribute("page", pageInfo);
            response.getWriter().write(1);
            return;
        }
        PageHelper.startPage(1,5);
        List<Department> departments = pageService.selectAllPage(1 , 5);


        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        System.out.println(pageInfo);
        session.setAttribute("deptList", departments);
        session.setAttribute("page", pageInfo);
        response.getWriter().write(1);
    }

    @Override
    public void destroy() {
        num="2";
    }
}
