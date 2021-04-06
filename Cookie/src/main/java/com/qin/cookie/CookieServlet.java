package com.qin.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            writer.print("您上次进入的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("time")){
                    long l = Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    writer.print(date.toLocaleString());
                }
            }
        }else {
            writer.print("这是您第一次进入该地址...");
        }
        /*设置cookie*/
        Cookie cookie = new Cookie("time",System.currentTimeMillis()+"");
        /*设置有效期（一天）*/
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
        /*编码*/
        URLEncoder.encode("time","utf-8");
        /*解码*/
        URLDecoder.decode("time","utf-8");
        resp.setCharacterEncoding("utf-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
