<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="EL.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Scanner" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/8
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Choose标签 </title>
</head>
<body>
<%--
完成数字编号对应星期几的案例
    1.域中存一个数字
    2.使用choose标签取出数字            相当于switch
    3.使用wen标签做数字判断             相当于case
    4.otherwise标签做其他情况的声明     相当于default
--%>

<%
    request.setAttribute("number",5);
%>
<c:choose>
    <c:when test="${number == 1 }">星期一</c:when>
    <c:when test="${number == 2 }">星期二</c:when>
    <c:when test="${number == 3 }">星期三</c:when>
    <c:when test="${number == 4 }">星期四</c:when>
    <c:when test="${number == 5 }">星期五</c:when>
    <c:when test="${number == 6 }">星期六</c:when>
    <c:when test="${number == 7 }">星期日</c:when>

    <c:otherwise>数字错误</c:otherwise>

</c:choose>

</body>
</html>
