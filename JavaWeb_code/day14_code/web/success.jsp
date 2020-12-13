<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <%= request.getSession().getAttribute("user")%>,欢迎你

</h1>
</body>
</html>
