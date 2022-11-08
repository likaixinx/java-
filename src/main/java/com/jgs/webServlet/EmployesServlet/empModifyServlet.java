package com.jgs.webServlet.EmployesServlet;

import com.jgs.pojo.Employee;
import com.jgs.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: com.jgs.webServlet.EmployesServlet.empModifyServlet
 * @author: likaixin
 * @create: 2022年10月25日 19:41
 * @description: 员工修改servlet
 */
@WebServlet("/empModifyServlet")
public class empModifyServlet extends HttpServlet {
    private EmployeeServiceImpl service=new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String hobby = request.getParameter("hobby");
        String sex = request.getParameter("sex");
        String date = request.getParameter("date");
        String select = request.getParameter("select");
        String text = request.getParameter("text");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee employee = new Employee(id,name,age,hobby,sex,select,text,date);

        Integer count = service.modifyEmployee(employee);
        service.close();
        if (count>0){
            response.getWriter().write("修改信息成功！");
        }

    }
}
