package com.jgs.webServlet.exitServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: com.jgs.webServlet.exitServlet.exitServlet
 * @author: likaixin
 * @create: 2022年10月14日 20:58
 * @description:
 */
@WebServlet("/exitServlet")
public class exitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了退出");
        HttpSession session = request.getSession(false);
        session.removeAttribute("loginName");
        session.setAttribute("dd","ok");
    }
}
