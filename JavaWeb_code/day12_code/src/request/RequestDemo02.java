package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/*
演示request对象获取请求行数据
 */
@WebServlet( "/RequestDemo02")
public class RequestDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*    String username = request.getParameter("username");
        System.out.println(username);
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("--------------------");*/
        /*Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);*/
           // String value = request.getParameter(s);
            request.setCharacterEncoding("utf-8");
            Map<String, String[]> parameterMap = request.getParameterMap();
            Set<String> strings = parameterMap.keySet();
            for (String string : strings) {
                String[] strings1 = parameterMap.get(string);
                for (String s1 : strings1) {
                    System.out.println(s1);
                }
            }

        }
   /* }*//**/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
