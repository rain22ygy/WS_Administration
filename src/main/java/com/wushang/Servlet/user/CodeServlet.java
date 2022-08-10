package com.wushang.Servlet.user;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "CodeServlet", value = "/vcode")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");


        //创建空白图片
        BufferedImage img = new BufferedImage(100, 35, BufferedImage.TYPE_3BYTE_BGR);
       //获取图片画笔
        Graphics g= img.getGraphics();
        Random r=new Random();
        //设置画笔颜色
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        //绘制背景
        g.fillRect(0,0,100,30);
        //绘制干扰线
       for (int i=0;i<12;i++){
           g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
           g.drawLine(r.nextInt(100),r.nextInt(30),r.nextInt(100),r.nextInt(30));
       }
       //生成随机数
       String randomNum="";
       String str="QWERTYUIOPASDFGHJKLZXCVBNM123456789qwertyuiopasdfghjklzxcvbnm";
       for (int i=0;i<5;i++){
           char c=str.charAt(r.nextInt(str.length()));
           randomNum=randomNum+c;

       }
        System.out.println(randomNum);

       //session缓存
        HttpSession session= request.getSession();
        session.setAttribute("rvcode",randomNum);


       //设置字体的大小；
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        g.setFont(new Font(null,Font.BOLD+Font.ITALIC,24));
        g.drawString(randomNum,15,25);
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        ImageIO.write(img,"jpeg", out);
        out.close();

    }
}
