<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>公告区</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <style>
        .headr {
            width: 100%;
            height: auto;
            margin: 0;
            padding-right: 0px;
            padding-top: 50px;
        }

        .wenzi {
            font-size: 25px;
            font-family: 微软雅黑;
            color: black;

        }

        .img {
            background-image: url('/static/img/community/1.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .img1 {
            font-family: 华文行楷;
            font-size: 58px;;
            background-image: url('/static/img/community/1副本.png');
            width: 533px;
            height: 93px;
            background-repeat: no-repeat;
        }

        .img2 li {
            background-color: white;
            filter: alpha(opacity=50);
            moz-opacity: 0.5;
            opacity: 0.7;
        );
        }
    </style>
</head>
<body class="img">
<jsp:include page="../templates/navbar.jsp"/>
<div class="container">

    <p class="img1">剑网三公告区</p>

    <ul class="nav nav-tabs" role="tablsit">
        <li role="presentation" class=" ${requestScope.instance eq '最新' ?'active':''}">
            <a class="wenzi" href="?instance=最新" aria-controls="home" role="tab">最新</a>
        </li>
        <li role="presentation" class="${requestScope.instance eq '新闻' ?'active':''}">
            <a class="wenzi" href="?instance=新闻" aria-controls="profile" role="tab">新闻</a>
        </li>
        <li role="presentation" class=" ${requestScope.instance eq '活动' ?'active':''}">
            <a class="wenzi" href="?instance=活动" aria-controls="messages" role="tab">活动</a>
        </li>
        <li role="presentation" class=" ${requestScope.instance eq '更新' ?'active':''}">
            <a class="wenzi" href="?instance=更新" aria-controls="settings" role="tab">更新</a>
        </li>
    </ul>

    <div class="tab-content">
        <c:forEach items="${['最新','新闻','活动','更新']}" var="instance">
            <div role="tabpanel" class="tab-pane ${requestScope.instance eq instance ?'active':''}">
                <div class="panel-primary">
                    <div class="panel-heading">
                        <h3>${instance}</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group img2">
                            <c:forEach items="${requestScope.announcementArticleList}" var="article">
                                <li class="list-group-item">
                                    <a class="h3"
                                       href="${'/'+=article.user.userName+='/article/'+=article.articleId}">${article.title}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div style="margin-top: ${fn:length(requestScope.announcementArticleList)>8?90:((8-fn:length(requestScope.announcementArticleList))*37+90)}">
    <jsp:include page="../templates/footer.jsp"/>
</div>

</body>
</html>
