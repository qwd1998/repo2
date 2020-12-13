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
    <title>标签 </title>
</head>
<body>
 <%--
 c:if 标签
    1.属性，text ,里面为Boolean表达式，如果为真，则显示标签的内容，如果为false，则什么都不显示
 --%>
 <c:if test="true">
     我是真的<br>
 </c:if>
<%--
   需求：判断requset域中的list是否存在，存在则遍历
--%>
 <%
     User u = new User(1,"张三","123", new Date());
    List list = new ArrayList();
    list.add("ddd");
    list.add(u);
    request.setAttribute("list",list);
 %>
<c:if test="${not empty requestScope.list}">
    ${requestScope.list}<br>
</c:if>
</body>
</html>
