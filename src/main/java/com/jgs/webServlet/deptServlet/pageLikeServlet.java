package com.jgs.webServlet.deptServlet;

import com.jgs.pojo.Department;
import com.jgs.service.DeptSearchService;
import com.jgs.service.impl.DeptSearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: com.jgs.webServlet.pageServlet.pageLikeServlet
 * @author: likaixin
 * @create: 2022年10月18日 20:51
 * @description:
 */
@WebServlet("/pageLike")
public class pageLikeServlet extends HttpServlet {
    static DeptSearchService deptSearchService = new DeptSearchServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String search = request.getParameter("search");


            List<Department> departmentList = deptSearchService.search(search);


            session.setAttribute("deptList", departmentList);
            response.getWriter().write(departmentList.size());

    }
}
