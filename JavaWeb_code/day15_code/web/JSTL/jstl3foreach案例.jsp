<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="EL.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    <title>foreach标签 </title>
</head>
<body>
<%--
需求：将request域中存有user的list集合，展示到页面的表格中
--%>
<c:forEach begin="0" end="10" step="1" var="i">
    ${i}<br>
</c:forEach>
<hr height="20px">
<%
    User u1 = new User(1, "张三", "55", new Date());
    User u2 = new User(2, "张四", "66", new Date());
    User u3 = new User(3, "张五", "77", new Date());
    User u4 = new User(4, "张六", "88", new Date());
    List list = new ArrayList();
    list.add(u1);
    list.add(u2);
    list.add(u3);
    list.add(u4);
    request.setAttribute("list", list);
%>
<table align="center" border="1px" height="80px" width="50%">
    <tr align="center">
        <th>编号</th>
        <th>姓名</th>
        <th>什么吊</th>
        <th>日期</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${user.id %2==0}">
            <tr align="center" bgcolor="#ffd700">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.birs}</td>
            </tr>
        </c:if>
        <c:if test="${user.id %2!=0}">
            <tr align="center" bgcolor="#ffc0cb">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.birs}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
