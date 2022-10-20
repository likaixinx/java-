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
 * @ClassName: com.jgs.webServlet.deptServlet.deleteDept
 * @author: likaixin
 * @create: 2022年10月20日 12:38
 * @description:
 */
@WebServlet("/deleteId")
public class deleteDept extends HttpServlet {
    private static DeptUpdateServiceImpl service=new DeptUpdateServiceImpl();
    private static DeptPageServiceImpl pageService = new DeptPageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer count = service.delDeptId(id);
        Integer pageNum = Integer.parseInt(request.getParameter("startIndex"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));


        PageHelper.startPage(pageNum,pageSize);
        List<Department> departments = pageService.selectAllPage();

        System.out.println(departments);

        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        System.out.println(pageInfo);
        session.setAttribute("deptList", departments);
        session.setAttribute("page", pageInfo);
        service.close();
        response.getWriter().write(count>0?"删除成功！":"删除失败");
    }
}
