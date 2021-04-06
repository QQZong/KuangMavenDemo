package com.qin.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*获取文件路径*/
        String realPath = "D:\\IntelliJ_IDEA\\KuangMavenDemo\\Download\\target\\classes\\wallhaven.png";
        System.out.println("文件下载路径："+realPath);
        /*获取文件名*/
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        FileInputStream inputStream = new FileInputStream(realPath);
        int len=0;
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len=inputStream.read())>0){
            outputStream.write(buffer,0,len);
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
