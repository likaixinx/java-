package com.jgs.webServlet.pageServlet;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.pojo.Department;
import com.jgs.pojo.Page;
import com.jgs.service.DeptPageService;
import com.jgs.service.impl.DeptPageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    DeptPageServiceImpl pageService=new DeptPageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer pageNum= Integer.parseInt(request.getParameter("startIndex"));
        Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));

//            PageHelper.startPage(pageNum, pageSize);//开启分页
//            List<Department> departments = pageService.selectAllPage((pageNum - 1) * pageSize, pageSize);
//            System.out.println(departments);
//            PageInfo<Department> pageInfo = new PageInfo<>(departments,4);
//            System.out.println(pageInfo);
//            Page page = new Page();
//            request.setAttribute("page",page);




    }
}
