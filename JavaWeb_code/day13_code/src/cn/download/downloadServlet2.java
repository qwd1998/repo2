package cn.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet2")
public class downloadServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        BufferedInputStream bis= new BufferedInputStream(fis);
        //设置response响应头
        //设置响应头类型content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //设置响应头打开方式content-disposition
       // response.setHeader("content-disposition","attachment,filename="+filename);//表示为下载模式

        byte a [] = new byte[1024];
        int len = 0;
        ServletOutputStream outputStream = response.getOutputStream();
        while((len = bis.read(a))!=-1){
            outputStream.write(a,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
