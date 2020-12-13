package cn.response2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/contextServlet3")
public class contextServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ServletContext对象获取，
            1.通过request对象获取
                request.getServleContext（）；
             2.通过HttpServlet方法获取
             this.getServleContext（）
         */
        request.setCharacterEncoding("utf-8");
        ServletContext c2 = this.getServletContext();
        //获取文件的服务器路径
        String realPath = c2.getRealPath("/a.txt");
        System.out.println(realPath);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
