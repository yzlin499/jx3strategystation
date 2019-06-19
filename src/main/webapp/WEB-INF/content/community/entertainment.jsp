<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>休闲区</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <style>
        .bimg {
            background-image: url('/static/img/community/234.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            background-attachment: fixed
        }

        .bg1 {
            background: black;
            filter: alpha(opacity=50);
            moz-opacity: 0.5;
            opacity: 0.7;
        );
        }

        .panel panel-primary p {;
            word-wrap: break-word;
            word-break: break-all;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            background-color: white;
            filter: alpha(opacity=50);
            moz-opacity: 0.5;
            opacity: 0.7;
        );
        }
    </style>
</head>
<body class="bimg">
<jsp:include page="../templates/navbar.jsp"/>
<div class="jumbotron bg1">
    <h1 style="color: white;font-family: 楷体">剑三休闲板块</h1>
    <img src="\static\img\community\333.jpeg" alt="" style="width: 100%">
</div>
<div class="navbar">
    <div class="navbar-inverse">
        <div class="">

        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <c:forEach items="${requestScope.commonArticle}" var="article">
            <div class="col-sm-3">
                <div class="panel panel-primary">
                    <img src="${article.imgPath}" alt="..." style="width: 100%; height: 55%">
                    <h3 class="panel-heading">${article.title}</h3>
                    <p class="panel-body"
                       style=" word-wrap:break-word; word-break:break-all;overflow: hidden;width:250px;text-overflow:ellipsis; white-space:nowrap;">
                            ${article.content}

                    </p>
                    <p class="panel-footer"><a href="${'/'+=article.user.userName+='/article/'+=article.articleId}"
                                               class="btn btn-primary" role="button">进入</a></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div align="center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
