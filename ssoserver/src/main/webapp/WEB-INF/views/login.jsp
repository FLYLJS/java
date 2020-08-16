<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>统一认证中心</title>
</head>
<body>
<form id="slick-login" method="post" action="/login">
    <input type="hidden" name="redirectUrl" value="${redirectUrl}">
    <label>username</label><input type="text" class="placeholder" placeholder="账号" name = "username">
    <label>password</label><input type="password" name="password" class="placeholder" placeholder="密码">
    <input type="submit" value="登录">
</form>
</body>
</html>
