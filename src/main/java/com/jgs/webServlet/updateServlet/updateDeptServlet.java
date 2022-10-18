package com.jgs.webServlet.updateServlet;

import org.apache.ibatis.annotations.Param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: com.jgs.webServlet.updateServlet.updateDeptServlet
 * @author: likaixin
 * @create: 2022年10月18日 22:13
 * @description:
 */
@WebServlet("/updateDeptServlet")
public class updateDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String deptName = request.getParameter("deptName");
        String deptAttr = request.getParameter("deptAttr");
        request.getParameter("");
        System.out.println(deptName);
        System.out.println(deptAttr);
    }
}
