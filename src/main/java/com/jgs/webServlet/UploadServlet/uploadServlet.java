package com.jgs.webServlet.UploadServlet;

import com.jgs.Utils.FileUtil;
import com.jgs.Utils.SqlSessionUtils;
import com.jgs.mapper.DepartmentMapper;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@MultipartConfig
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    private String str="";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SqlSession sqlSession = SqlSessionUtils.openSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        String s = mapper.selectHead();
        if (Optional.ofNullable(s).isPresent()) {
            System.out.println(s);
            sqlSession.close();
            resp.getWriter().write(s);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        Part part = request.getPart("file");
        System.out.println(part.getSize());
        if (part.getSize()<=0){
            response.getWriter().write("请上传文件！<a href='/java_thesis_project/dept/userInfo.jsp'>点击返回</a>");
            return;
        }
        if (part.getSize()>150000){
            response.getWriter().write("上传文件不于过大！<a href='/java_thesis_project/dept/userInfo.jsp'>点击返回</a>");
            return;
        }

//        String str="Q:\\java-thesis-project\\out\\artifacts\\java_thesis_project_war_exploded\\dept\\images\\"
//                +UUID.randomUUID()+part.getSubmittedFileName();
        String str="D:\\mybatis\\images\\"
                +UUID.randomUUID()+part.getSubmittedFileName();
        try(FileOutputStream stream = new FileOutputStream(str)){

            IOUtils.copy(part.getInputStream(), stream);
            SqlSession sqlSession = SqlSessionUtils.openSession();
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Integer count = mapper.modifyHead(UUID.randomUUID()+part.getSubmittedFileName());
            System.out.println(count);
            sqlSession.commit();
            sqlSession.close();
            response.getWriter().write("<script>" +"alert('上传文件成功！');"+"\n"+
                    "location.href='/java_thesis_project/dept/userInfo.jsp'" +
                    "</script>");
        }

    }
}
