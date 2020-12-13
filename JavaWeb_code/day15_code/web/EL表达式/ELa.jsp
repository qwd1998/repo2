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
    <title>EL表达式</title>
</head>
<body>
${3>4}


${3+4}
${3*4}
${3/4}
<%--EL表达式获取值
    语法：1.${域名城，键名}从指定域中，获取指定键的值
            域名城：pageScope -->  pageContext
                  requesrScope -->requset
                  sessionScope -->session
                  applicationScope -->application(ServletContext)
         2.${}，从最小的域中查找是否有该键对应的值，直到找到为止

         3.获取对象，list集合，Map集合
            对象：${域名城，键名.属性名}
            list集合：${域名城，键名[索引]}
            Map集合：${域名城，键名.key名称}
                    ${域名城，键名.get("key名称")}
                    ${域名城，键名["key名称"]}
        4.隐式对象
              ${pageContext.request.contextPath}  动态获取虚拟目录


    --%>


</body>
</html>
