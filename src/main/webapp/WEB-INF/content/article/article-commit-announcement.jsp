<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <jsp:include page="../templates/base-lib.jsp"/>
    <style type="text/css">
        .page-header {
            border-bottom: 1px solid #d7d7d7;
        }

        .ck-content {
            min-height: 700px;
            max-height: 700px;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>

<div class="container">
    <div class="page-header">
        <h1>公告
            <small>管理自嗨</small>
        </h1>
    </div>

    <div class="form-group">
        <label for="title" class="h3">标题</label>
        <input type="text" class="form-control input-lg" id="title" placeholder="你需要一个好标题">
    </div>

    <div class="form-group">
        <label class="h3" for="instance">内容</label>
        <select id="instance" class="form-control input-lg">
            <option value="最新">最新</option>
            <option value="新闻">新闻</option>
            <option value="活动">活动</option>
            <option value="更新">更新</option>
        </select>
    </div>

    <div class="form-group">
        <div id="content"></div>
    </div>
    <c:if test="${sessionScope.user != null}">
        <button class="btn btn-success" onclick="commitAnnouncementArticle()">提交</button>
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <button class="btn btn-danger" onclick="" disabled="disabled">登录后发帖哦！</button>
    </c:if>
</div>

<script src="<c:url value="/static/js/ckeditor.js"/>"></script>
<script src="<c:url value="/static/js/article/editor.js"/>"></script>
<script src="<c:url value="/static/js/article/commit.js"/>"></script>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
