package com.jgs.filter;




import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jgs.pojo.Department;
import com.jgs.service.impl.DeptPageServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: com.jgs.filter.MainFilter
 * @author: likaixin
 * @create: 2022年10月14日 16:49
 * @description:
 */
//@WebFilter("/dept/*")
public class MainFilter extends HttpFilter {
    static DeptPageServiceImpl pageService = new DeptPageServiceImpl();

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器执行了");
        String servletPath = request.getServletPath();// 获取目标项目地址
        StringBuffer url = request.getRequestURL();// 获取访问URL
        //过滤器如果访问css  jpg  do  png  js都会被拦截，所以要添加判断允许访问这些资源

        if ( url.toString().endsWith(".css")) {

            chain.doFilter(request, response);
            System.out.println(url.toString() + ": jpg css  js  png  do不用校验");
            return;
        }
        // 一些request请求不需要进行登录校验，比如请求登录页面，这时我们要放行这些request
        if (servletPath != null && (servletPath.contains("/login") || (servletPath.contains("/login.jsp")))) {
            chain.doFilter(request, response);
            System.out.println(servletPath + ":不用校验");
            return;
        } else {//否则就需要登录校验，判断用户是否登录，获取session对象
            HttpSession session = request.getSession();
            System.out.println(session.getAttribute("loginName"));
            String user = (String) session.getAttribute("loginName");

           String attribute = (String) request.getSession(false).getAttribute("dd");

            if (user == null) {
                System.out.println(servletPath + ":您尚未登录，禁止访问");

                request.getSession().setAttribute("msg", "您尚未登录，请您先登录");//存储错误信息
                if ("ok".equals(attribute)){
                    request.getSession().setAttribute("msg", "");//存储错误信息
                    request.getSession(false).setAttribute("dd","no");
                }
                //request.setAttribute("return_url", servletPath);
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                return;
            } else {
                //用户已登录则直接放行
                chain.doFilter(request, response);
                System.out.println(servletPath + ":" + user + "用户已登录,可以访问");
                return;
            }
        }

    }


}

