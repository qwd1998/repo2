<%@ page import="EL.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/8
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中的对象值</title>
</head>
<body>
<%
    User u = new User(1, "张三", "123", new Date());
    request.setAttribute("user", u);

    List list = new ArrayList<>();
    list.add("ddd");
    list.add("dd");
    list.add("d");
    list.add(u);
    request.setAttribute("list", list);

    Map map = new HashMap();
    map.put("dss", 18);
    map.put("ds", 12);
    map.put("d", 102);
    map.put("user", u);
    request.setAttribute("map", map);
%>
<h3>获取对象值</h3>
${requestScope.user}<br>
${user.birs}<br>

<h3>获取List值</h3>
${requestScope.list[1]}<br>
${requestScope.list}<br>

<h3>获取Map值</h3>
${requestScope.map}<br>
${requestScope.map.get("ds")}<br>
${requestScope.map.get("user")}<br>
${requestScope.map.ds}<br>
${requestScope.map["ds"]}<br>

<h3>获取Empty值</h3>
${empty list} <%--判断是否为空或者长度是否为0--%>

</body>
</html>
