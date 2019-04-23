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
        <label class="h3">副本</label>
        <div class="input-group input-lg">
            <label class="input-group-addon" for="instance-kind">副本</label>
            <select id="instance-kind" class="form-control input-lg">
                <option>荒血路</option>
                <option>伊玛目</option>
                <option>猪猪山</option>
                <option>弹弹厅</option>
                <option>发财峰</option>
                <option>赚钱殿</option>
            </select>
            <label class="input-group-addon" for="instance-difficulty">难度</label>
            <select id="instance-difficulty" class="form-control input-lg">
                <option>25试炼</option>
                <option>5人普通</option>
                <option>5人英雄</option>
                <option>5人挑战</option>
                <option>10人普通</option>
                <option>25人英雄</option>
                <option>25人挑战</option>
            </select>
        </div>
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
