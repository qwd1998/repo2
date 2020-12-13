package cn.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("demo01.....");

        //访问demo01资源会自动跳转到demo02资源
        /*//1.设置状态码为302
        response.setStatus(302);
        //2.设置响应头
        response.setHeader("location","/day13_code_war_exploded/responseDemo02");
        //简单的重定向方法*/
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseDemo02");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
