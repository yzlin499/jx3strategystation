<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>攻略区</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <style>
        .imgm1 {
            width: 100%;
            padding-left: 10px;
            height: 100%;
        }

        .db1 {
            height: 9.5%;
        }

        .db1:hover {
            background-color: lightgray;
            color: black;
        }

        .linkl {
            font-size: 35px;
            text-align: center;
            padding-bottom: 0px;
            width: 100%;
            color: white;
        }

        .linkl:hover {
            background-color: white;
            color: #46b8da;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2" style="background: #46b8da; height: 100%">
            <div align="center" style="">
                <p style="width: 100%;font-size: 40px;color: white">剑三攻略站</p>
            </div>
            <hr>
            <div style="height: 55%">
                <img class="imgm1" src="/static/img/community/3213.jpg">
            </div>

            <hr>
            <div align="center">
                <a class="linkl" href="http://jx3.xoyo.com">官网首页</a>
            </div>
            <hr>
            <div align="center">
                <a class="linkl" href="http://jx3.xoyo.com/gl/">更多攻略</a>
            </div>
            <hr>
        </div>

        <div class="col-sm-10" style="height: 100%; background-color: #edefea">
            <img src="${pageContext.request.contextPath}/static/img/community/glz.png" alt="攻略站">
            <ul class="list-group">
                <c:forEach items="${requestScope.strategyList}" var="article">
                    <li class="list-group-item db1">
                        <div class="row">
                            <div class="col-sm-9">
                                <a href="${'/'+=article.user.userName+='/article/'+=article.articleId}"
                                   style="font-size: 20px">${article.title}</a>
                            </div>
                            <div class="col-sm-3">
                                <a href="" style="text-align: right">${article.user.nickName}</a>
                            </div>
                            <div class="col-sm-12">
                                    ${article.instance}
                            </div>
                        </div>
                    </li>
                </c:forEach>

            </ul>
            <div align="center" style="padding-top: 440px">
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
        </div>
    </div>
</div>

<jsp:include page="../templates/footer.jsp">
    <jsp:param name="footerMarginTop" value="''"/>
</jsp:include>


</body>
</html>
