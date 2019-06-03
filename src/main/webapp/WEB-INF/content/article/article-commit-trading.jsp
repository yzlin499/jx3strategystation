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
    <form class="form-inline">
        <div class="form-group">
            <label for="selectItem">服区</label>
            <select id="selectItem" class="form-control">
                <jsp:include page="../templates/select-item.jsp">
                    <jsp:param name="selectList" value="district"/>
                </jsp:include>
            </select>
        </div>

        <div class="form-group">
            <label for="ratio">比率</label>
            <div class="input-group">
                <div class="input-group-addon">￥ 1:</div>
                <input type="number" class="form-control" id="ratio" value="670" max="2000" min="200" step="10"
                       placeholder="Amount">
            </div>
        </div>

        <div class="form-group">
            <label for="minGold">最低交易金额</label>
            <div class="input-group">
                <div class="input-group-addon">￥</div>
                <input type="number" class="form-control" id="minGold" value="0" max="2000" min="0" step="10"
                       placeholder="最低金额">
            </div>
        </div>

        <div class="form-group">
            <label for="maxGold">最高交易金额</label>
            <div class="input-group">
                <div class="input-group-addon">￥</div>
                <input type="number" class="form-control" id="maxGold" value="0" max="10000" min="0" step="10"
                       placeholder="最高金额">
            </div>
        </div>

        <div class="form-group">
            <label for="buySell">买卖方</label>
            <select id="buySell" class="form-control">
                <option>收金</option>
                <option>出金</option>
            </select>
        </div>


    </form>
    <div class="form-group">
        <div id="content"></div>
    </div>
    <c:if test="${sessionScope.user != null}">
        <button class="btn btn-success" onclick="commitTradingArticle()">提交</button>
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
