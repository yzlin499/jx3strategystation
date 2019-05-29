<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/19
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/userCss/registerStyle.css"/>">
    <jsp:include page="../templates/base-lib.jsp"/>
</head>
<body>
<div class="main">
    <div class="nav ">
        <p>剑网三攻略网欢迎你</p>
        <ul>
            <li><a href=" ">休闲社区</a></li>
            <li><a href="">交易社区</a></li>
            <li><a href="">攻略社区</a></li>
            <li><a href="">公告社区</a></li>
            <li><a href="">资料站</a></li>
            <li><a href="">首页</a></li>
        </ul>
    </div>
    <div class="header">
        <h1>剑网三攻略注册</h1>
        <p>祝你游戏开心</p>
    </div>
    <div class="centers">
        <form>
            <div class="form-group">
                <input type="text" class="form-control" id="nickName" placeholder="网站呢称">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="userName" placeholder="用户名">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" placeholder="密码">
            </div>
            <div class="form-group">
                <button type="button" onclick="register()" class="btn btn-default">立即注册</button>
            </div>
        </form>
    </div>
    <div class="bottom">
        <div class="container">
            <div class="footer-navbar">
                <a href="#">GitHub仓库</a>
                <a href="#">关于我们</a>
            </div>
            <p class="footer-content">
                CopyRight © 2019 jx3strategystation<br>
                All rights reserved. jx3strategystation 版权所有
            </p>
        </div>
    </div>
</div>
<script>
    function register() {
        $.post("/v1/api/register", {
            "user.userName": $("#userName").val(),
            "user.nickName": $("#nickName").val(),
            "user.password": $("#password").val()
        }, function (data, status) {
            if (data.userId > 0) {
                alert("success");
            } else {
                alert("false");
            }
        });
    }

</script>
</body>
</html>
