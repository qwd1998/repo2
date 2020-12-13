<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/8
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中的值</title>
</head>
<body>
<%
         request.setAttribute("name","张三");
         session.setAttribute("age","18");
         application.setAttribute("sex","man");
         pageContext.setAttribute("tell","180");
%>
<h3>获取值</h3>
${requestScope.name}
${applicationScope.sex}
${sessionScope.age}
${pageScope.tell}
</body>
</html>
