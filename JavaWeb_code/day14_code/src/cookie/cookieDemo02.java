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
 */
@WebServlet("/cookieDemo02")
public class cookieDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+"---+++---"+value);
        }
        Map<String, String[]> map = request.getParameterMap();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            String[] values = map.get(key);
            for (String value : values) {
                System.out.println(key+"-*****-"+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
