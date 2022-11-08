package com.jgs.webServlet.EmployesServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.pojo.Department;
import com.jgs.pojo.Employee;
import com.jgs.service.EmployeeService;
import com.jgs.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName: com.jgs.webServlet.EmployesServlet.employesServlet
 * @author: likaixin
 * @create: 2022年10月24日 23:37
 * @description:
 */
@WebServlet("/empLimitServlet")
public class empServlet extends HttpServlet {
    private static EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(6666);
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
        if (pageNum!=null&&pageSize!=null) {
            PageHelper.startPage(pageNum,pageSize);
            List<Employee> employees = employeeService.selectEmployeeAllLimit();
            PageInfo<Employee> pageInfo = new PageInfo<>(employees);

            session.setAttribute("empList",employees);
            session.setAttribute("empPage",pageInfo);
            System.out.println(pageInfo);
            System.out.println(employees);
            employeeService.close();
        }

    }
}
