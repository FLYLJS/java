<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<html>
<head>

</head>
<body>
<a href="/say">用户列表</a>
<div style="margin:0 auto">
    <form action="/save" method="post">
        姓名：<input type="text" placeholder="请输入用户名" name="username" value=""><br/>
        年龄：<input type="text" placeholder="" name="age" value="">
        金额：<input type="text" placeholder="" name="money" value="">
        地址：<input type="text" placeholder="" name="address" value="">
        电话：<input type="text" placeholder="" name="phone" value="">
        <input type="submit" class="btn btn-default" value="提交">
    </form>
    <hr color="red"/>

    <form method="post" action="/saveStudent">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        生日:<input type="text" name="date">
        <input type="submit" value="提交">
    </form>

    <a href="/testForward">转发</a>
    <button id="btn">发送Ajax请求</button>
</div>

<script>

    $(function () {
        $("#btn").click(function () {
            alert("hello");
        });
    });

    // btn.onclick = function () {
    //     alert("123")
    // };
</script>
</body>



</html>
