package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/*
cookie的快速入门：
1.创建cookie  Cookie c = new Cookie();
2.发送cookie response.addCookie（）
 */
@WebServlet("/cookieDemo03")
public class cookietext extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的,判断cookie是否存在
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        /*for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"--"+cookie.getValue());
        }*/
        boolean flag =false;
        if(cookies!=null && cookies.length > 0 ){
            for (Cookie cookie : cookies) {
                if("lastTime".equals(cookie.getName())){//存在的话，打印欢迎回来+上次的时间
                    flag = true;
                    String value = cookie.getValue();
                    response.getWriter().write("欢迎回来"+value);
                    Date  date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                    String format = simpleDateFormat.format(date);
                    cookie.setValue(format);
                    response.addCookie(cookie);
                    cookie.setMaxAge(60*60*24*30);
                    break;
                }
            }
        }
        if(cookies==null || cookies.length==0 || flag == false){
            Date  date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd---HH:mm:ss");
            String format = simpleDateFormat.format(date);
            Cookie cookie = new Cookie("lastTime",format);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            response.getWriter().write("第一次访问");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
