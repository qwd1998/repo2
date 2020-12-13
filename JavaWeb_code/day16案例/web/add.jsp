<!-- HTML5文档-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style>

        .ziti {
            color: red;
        }
    </style>
    <%--<script>
       window.onload = function () {
                document.getElementById("form").onsubmit=function () {

                         return checkuser3() &&checkuser2() && checkuser1();
                }
               document.getElementById("name").onblur = checkuser3;
               document.getElementById("age").onblur = checkuser1;
               document.getElementById("qq").onblur = checkuser2;
        }


        function checkuser3() {
            var name = document.getElementById("name").value;
            var reg_user=/^\w{3,12}$/;
            var flag = reg_user.test(name);
            var s_name = document.getElementById("s_name");
            if(flag){
                s_name.innerHTML="正确";
            }else{
                s_name.innerHTML="输入的格式有误";
            }
            return flag;
        }
        function checkuser2() {
            var qq = document.getElementById("qq").value;
            var reg_user=/^\w{6,12}$/;
            var flag = reg_user.test(qq);
            var s_qq = document.getElementById("s_qq");
            if(flag){
                s_qq.innerHTML="正确";
            }else{
                s_qq.innerHTML="输入的格式有误";
            }
            return flag;
        }
        function checkuser1() {
            var age = document.getElementById("age").value;
            var reg_user=/^\w{1,2}$/;
            var flag = reg_user.test(age);
            var s_age = document.getElementById("s_age");
            if(flag){
                s_age.innerHTML="正确";
            }else{
                s_age.innerHTML="输入的格式有误";
            }
            return flag;
        }
    </script>--%>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post" id="form">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            <span class="ziti" id="s_name"> </span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            <span class="ziti" id="s_age"></span>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码" id="qq"/>
            <span class="ziti" id="s_qq"> </span>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址" id="email"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/userListServlet">返回</a>
        </div>
    </form>
</div>
</body>
</html>