<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交易区</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
    <style>
        .font{
            font-family: 华文行楷;
            font-size: 60px;
        }
        .sfont{
            font-family: 华文行楷;
            font-size: 40px;
            color: gray;
            filter: alpha(opacity=50);moz-opacity:0.5;opacity: 0.7;);
        }

    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div class="font">
    <p>剑网三<small class="sfont">交易市场</small></p>
    <input type="text">
    <input type="button" class="glyphicon glyphicon-search">
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
