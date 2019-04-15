<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/15
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
    <style type="text/css">
        .page-header {
            border-bottom: 1px solid #d7d7d7;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>

<div class="container">
    <div class="page-header">
        <h1>休闲社区
            <small>吃瓜让我感到愉悦</small>
        </h1>
    </div>
    <form>
        <div class="form-group">
            <label for="title" class="h3">标题</label>
            <input type="text" class="form-control input-lg" id="title" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="content"></label>
            <textarea class="form-control" rows="10" id="content" style="font-size: 1.4em"></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>
</body>
</html>
