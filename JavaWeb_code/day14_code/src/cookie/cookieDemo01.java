package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/*
cookie的快速入门：
1.创建cookie  Cookie c = new Cookie();
2.发送cookie response.addCookie（）
3.(客户端)获取cooike  request.getcookie

注意：cookie可以多个一起传输
    cookie的存储时间 setMaxAge（int time）  time为正数，就为存活多少秒
                                         time为负数，就是默认值，关闭浏览器就删除cookie
                                         time为0就是删除cookie
    tomcat8之后cookie可以存储中文
 */
@WebServlet("/cookieDemo01")
public class cookieDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c = new Cookie("msg","hello");
        response.addCookie(c);
        Map<String, String[]> map = request.getParameterMap();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            String[] values = map.get(key);
            for (String value : values) {
                System.out.println(key+"--"+value);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
