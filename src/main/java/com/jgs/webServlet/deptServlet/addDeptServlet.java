package com.jgs.webServlet.deptServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.pojo.Department;
import com.jgs.service.DeptUpdateService;
import com.jgs.service.impl.DeptPageServiceImpl;
import com.jgs.service.impl.DeptUpdateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: com.jgs.webServlet.deptServlet.addDeptServlet
 * @author: likaixin
 * @create: 2022年10月19日 22:21
 * @description:
 */
@WebServlet("/addDept")
public class addDeptServlet extends HttpServlet {
    private static DeptUpdateService service=new DeptUpdateServiceImpl();
    private static DeptPageServiceImpl pageService = new DeptPageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        String deptName = request.getParameter("deptName");
        String deptAddr = request.getParameter("deptAddr");
        Integer count = service.addDept(deptName, deptAddr);

        PageHelper.startPage(1,5);
        List<Department> departments = pageService.selectAllPage();

        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        System.out.println(pageInfo);
        session.setAttribute("deptList", departments);
        session.setAttribute("page", pageInfo);
        response.getWriter().write(count>0?"添加部门成功！":"添加部门失败！");

    }
}
