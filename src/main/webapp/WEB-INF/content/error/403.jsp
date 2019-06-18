<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/6/18
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有权限，跳转主页</title>
</head>
<body>
你没有权限访问该页面,即将跳转到主页
<script>
    setTimeout(function () {
        window.location.href = "/index";
    }, 2000);

</script>
</body>
</html>
