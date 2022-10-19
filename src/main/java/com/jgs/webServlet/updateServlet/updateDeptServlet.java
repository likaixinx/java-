package com.jgs.webServlet.updateServlet;

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
 * @ClassName: com.jgs.webServlet.updateServlet.updateDeptServlet
 * @author: likaixin
 * @create: 2022年10月18日 22:13
 * @description:
 */
@WebServlet("/updateDeptServlet")
public class updateDeptServlet extends HttpServlet {
    private static DeptUpdateService deptUpdateService=new DeptUpdateServiceImpl();
    private static DeptPageServiceImpl pageService = new DeptPageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        String deptName = request.getParameter("deptName");
        String deptAttr = request.getParameter("deptAttr");
        String id = request.getParameter("id");
        String pageNum = request.getParameter("pageNum");
        System.out.println("id = " + id);

        Integer count = deptUpdateService.updateDeptMsg(deptName, deptAttr, Integer.parseInt(id));

        PageHelper.startPage(Integer.parseInt(pageNum),5);
        List<Department> departments = pageService.selectAllPage(Integer.parseInt(pageNum) , 5);

        System.out.println(departments);

        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        System.out.println(pageInfo);
        session.setAttribute("deptList", departments);
        session.setAttribute("page", pageInfo);
        if (count>0){
            response.getWriter().write("修改成功");
        }else{
            response.getWriter().write("修改失败");
        }
    }
}
