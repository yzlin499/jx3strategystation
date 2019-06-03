<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/userCss/personalStyle.css">
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
</head>
<body>
<div class="main">
    <jsp:include page="../templates/navbar.jsp"/>
    <div class="content">
        <div class="content-left">
            <div class="avatar">
                <img src="" alt="">
            </div>
        </div>
        <div class="content-right">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="#posting" data-toggle="tab" role="tab">帖子管理</a></li>
                <li role="presentation"><a href="#profile" data-toggle="tab" role="tab">个人信息</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
