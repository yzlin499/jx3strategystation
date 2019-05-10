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
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
</head>
<body>
<div class="nav">
    <p>剑网三攻略网欢迎你</p>
    <ul>
        <li><a href="">1234567</a></li>
        <li><a href="">1234567</a></li>
        <li><a href="">1234567</a></li>
        <li><a href="">1234567</a></li>
        <li><a href="">1234567</a></li>
    </ul>
</div>
<div class="main">
    <div class="header">
        <h1>剑网三攻略网欢迎你</h1>
    </div>
    <div class="centers">
        <form>
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">File input</label>
                <input type="file" id="exampleInputFile">
                <p class="help-block">Example block-level help text here.</p>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Check me out
                </label>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div class="footer">5</div>
</div>
</body>
</html>
