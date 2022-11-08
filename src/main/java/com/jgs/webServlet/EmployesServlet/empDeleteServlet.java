package com.jgs.webServlet.EmployesServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.pojo.Employee;
import com.jgs.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: com.jgs.webServlet.EmployesServlet.empDeleteServlet
 * @author: likaixin
 * @create: 2022年10月26日 12:43
 * @description:
 */
@WebServlet("/empDeleteServlet")
public class empDeleteServlet extends HttpServlet {
    private EmployeeServiceImpl service=new EmployeeServiceImpl();
    private static EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        Integer pageNum =Integer.parseInt( request.getParameter("pageNum"));

        Integer count = service.deleteByPrimaryKey(Integer.parseInt(id));
        service.close();
        PageHelper.startPage(pageNum,5);
        List<Employee> employees = employeeService.selectEmployeeAllLimit();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        session.setAttribute("empList",employees);
        session.setAttribute("empPage",pageInfo);
        response.getWriter().write(count>0?"删除成功！":"删除失败");

    }
}
