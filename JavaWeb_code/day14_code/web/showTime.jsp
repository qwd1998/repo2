<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    /*
    cookie的快速入门：
    1.创建cookie  Cookie c = new Cookie();
    2.发送cookie response.addCookie（）
     */
    //获取所有的,判断cookie是否存在
    Cookie[] cookies = request.getCookies();
        /*for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"--"+cookie.getValue());
        }*/
    boolean flag = false;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            if ("lastTime".equals(cookie.getName())) {//存在的话，打印欢迎回来+上次的时间
                flag = true;
                String value = cookie.getValue();
                out.print("欢迎回来" + value);
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                String format = simpleDateFormat.format(date);
                cookie.setValue(format);
                response.addCookie(cookie);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                break;
            }
        }
    }
    if (cookies == null || cookies.length == 0 || flag == false) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd---HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Cookie cookie = new Cookie("lastTime", format);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
        out.print("第一次访问");
    }
%>

</body>
</html>