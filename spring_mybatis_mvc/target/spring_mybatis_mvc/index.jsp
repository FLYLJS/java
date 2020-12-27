<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
</head>
<body >
<a href="/say">用户列表</a>

<div style="margin:0 auto">
    <form action="/save" method="post">
        姓名：<input type="text" placeholder="请输入用户名" name="username" value="" ><br/>
        年龄：<input type="text" placeholder="" name="age" value="">
        金额：<input type="text" placeholder="" name="money" value="">
        地址：<input type="text" placeholder="" name="address" value="">
        电话：<input type="text" placeholder="" name="phone" value="">
        <input type="submit" class="btn btn-default" value="提交" >
    </form>
<hr color="red" />

    <form method="post" action="/saveStudent">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        生日:<input type="text" name="date">
        <input type="submit" value="提交">
    </form>
</div>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</html>
