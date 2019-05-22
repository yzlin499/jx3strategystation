<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/21
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <style type="text/css">
        .page-header {
            border-bottom: 1px solid #d7d7d7;
        }

        .ck-content {
            min-height: 600px;
            max-height: 600px;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>

<div class="container">
    <div class="page-header">
        <h1>交易社区
            <small>最近要吃土</small>
        </h1>
    </div>

    <div class="form-group">
        <label for="title" class="h3">标题</label>
        <input type="text" class="form-control input-lg" id="title" placeholder="你需要一个好标题">
    </div>
    <div class="form-group">
        <label class="h3" for="instance">内容</label>
        <select id="instance" class="form-control input-lg">
            <jsp:include page="../templates/select-item.jsp">
                <jsp:param name="selectList" value="strategy"/>
            </jsp:include>
        </select>
    </div>

    <div class="form-group">
        <div id="content"></div>
    </div>
    <button onclick="commit()" class="btn btn-success">Submit</button>
</div>

<script src="<c:url value="/static/js/ckeditor.js"/>"></script>
<script src="<c:url value="/static/js/article/editor.js"/>"></script>
<script src="<c:url value="/static/js/article/commit.js"/>"></script>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
