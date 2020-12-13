<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/5
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    System.out.println("Hello JSP"); //定义在service中。service方法可以定义什么，改可以定义什么
%>
<%! int i = 3; //定义的java代码，在jsp中会转换为java类的成员变量和成员方法
%>
<%= i    //定义的java代码，会输出到页面
%>
<%

%>
</body>
</html>
