package com.jgs.webServlet.loginsServlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: com.jgs.webServlet.verificationServlet
 * @author: likaixin
 * @create: 2022年09月29日 15:52
 * @description: 验证码工具
 */
@WebServlet("/verification")
public class verificationServlet extends HttpServlet{
    private static final char[] chars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','c','a'};//自定义验证码池
    private final static Random random = new Random();

    //获取6位随机数，放在图片里
    private static String getRandomString(){
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < 4; i++){
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        return buffer.toString();
    }

    //获取随机的颜色
    private static Color getRandomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    //返回某颜色的反色
    private static Color getReverseColor(Color c){
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //设置输出类型
        response.setContentType("image/jpeg");

        //随机字符串
        String verification = getRandomString();
        request.getSession(true).setAttribute("verification", verification);//放到session里

        //图片宽度
        int width = 70;
        //图片高度
        int height = 30;

        //随机颜色，用于背景色
        Color color = getRandomColor();
        //反色，用于前景色
        Color reverse = getReverseColor(color);
        //创建一个彩色图片
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘图对象
        Graphics2D g = bi.createGraphics();
        //设置字体
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        //设置颜色
        g.setColor(color);
        //绘制背景
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        //绘制随机字符
        g.drawString(verification, 18, 20);
        //画100个噪音点
        for(int i = 0; i < 50;i++){
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
        //转成JPEG格式
        ServletOutputStream out= response.getOutputStream();
        //编码器
        JPEGImageEncoder encoder= JPEGCodec.createJPEGEncoder(out);
        //对图片进行编码
        encoder.encode(bi);
        out.flush();
    }

}
