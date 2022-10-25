package com.jgs.Utils;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName: utils.FileUtil
 * @author: 李凯信
 *  学号： 202003274
 * @create: 2022年09月22日 8:53
 * @description:
 */
public class FileUtil {

    //返回 byte[]
    public static byte[] readReqAsByte(HttpServletRequest req) {
        //输出流：创建一个字节的缓冲区（32字节）
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            //DiskFileItemFactory 上传文件的缓存区
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            //解析请求对象
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            fileUpload.setHeaderEncoding("utf-8");
            //ServletRequestContext 转换请求对象的类型，满足参数类型
            List<FileItem> fileItems = fileUpload.parseRequest(new ServletRequestContext(req));
            //1、普通表单 2、file表单
            for (FileItem fileItem : fileItems) {
                //isFormField() 判断是否是普通表单，true是，false不是
                if (!fileItem.isFormField()) {
                    //输入流
                    InputStream is = fileItem.getInputStream();
                    //搬运工，缓冲器
                    byte[] buffer = new byte[1024];
                    //保持读取和写入长度一置
                    int len = 0;
                    while ((len = is.read(buffer)) !=-1) {
                        os.write(buffer, 0, len);
                    }

                    //先关输出，再关输入
                    os.close();
                    is.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return os.toByteArray();//返回byte数组
    }


    //返回 String[]

}
