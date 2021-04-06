package com.qin.servlet.login;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*3秒刷新页面*/
        resp.setHeader("refresh","3");
        BufferedImage image = new BufferedImage(1920,1080,BufferedImage.TYPE_INT_RGB);
        /*这是一支笔*/
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        /*填充颜色*/
        graphics2D.setColor(Color.pink);
        /*描绘位置*/
        graphics2D.fillRect(0,0,1920,1080);
        graphics2D.setColor(Color.blue);
        graphics2D.setFont(new Font(null,Font.BOLD,100));
        graphics2D.drawString(number(),960,540);
        resp.setContentType("image/jpeg");
        /*设置缓存*/
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    /*生成随机数*/
    private String number(){
        Random random = new Random();
        /*设置有多少位验证码*/
        java.lang.String num = random.nextInt(999999)+"";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 6-num.length(); i++) {
            buffer.append(i);
        }
        java.lang.String s = buffer.toString()+num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
