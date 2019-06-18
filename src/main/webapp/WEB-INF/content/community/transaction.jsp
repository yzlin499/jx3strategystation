<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="/assets/css/site.min.css?v=9e0a081675" rel="stylesheet" type="text/css">
    <link href="https://staff.bootcss.com/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>交易区</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
    <style>
        .view {
            background: black;
        }

        .ssfont {
            word-wrap: break-word;
            font-size: larger
        }

        .font {
            padding-top: 20px;
            font-family: 华文行楷;
            font-size: 60px;
        }

        .sfont {
            background-color: white;
            filter: alpha(opacity=50);
            moz-opacity: 0.5;
            opacity: 0.7;
        );
        }

        .img1 {
            overflow: hidden;
        }

        .header1 {

            height: 200px;
            width: 100%;
            background-size: 100%, 100%;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .body1 {
            background: white;
            filter: alpha(opacity=50);
            moz-opacity: 0.6;
            opacity: 0.7;
        }
    </style>
</head>
<body class="">
<jsp:include page="../templates/navbar.jsp"/>

<div class="carousel-inner" role="listbox">
    <div class="item active">
        <img src="${pageContext.request.contextPath}/static/img/community/timg1.jpg" class="header1" alt="header">
        <div class="carousel-caption">
            <h1>
                <a style="text-shadow: black 1.5px 1.5px 1.5px; color: white; font-size: 70px;">剑网三交易市场</a>
            </h1>
        </div>
    </div>
</div>
<br>
<main class="main" role="main">
    <div class="container">
        <div class="row" id="post-list" style="background:white">
            <c:forEach items="${requestScope.tradingList}" var="article">
                <div class="col-xs-12 col-sm-6">
                    <article class="post tag-foreign-website tag-bootstrap-v3">
                        <div class="post-featured-image">
                            <a class="thumbnail loaded"
                               href="${'/'+=article.user.userName+='/article/'+=article.articleId}" target="_blank"
                               style="">
                                <div class="row">
                                    <img class="img1 col-sm-4" width="50%" style="height: 200px"
                                         src="${article.imgPath}">
                                    <div class=" col-sm-8">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <div class="panel-title">
                                                    <h1>${article.buySell}&nbsp;&nbsp;<small>${article.district}</small>
                                                    </h1>
                                                </div>
                                            </div>
                                            <table class="table">
                                                <tr>
                                                    <th>比率</th>
                                                    <th>最小金额</th>
                                                    <th>最大金额</th>
                                                </tr>
                                                <tr>
                                                    <td>￥1:G${article.ratio}</td>
                                                    <td>￥${article.minGold}</td>
                                                    <td>￥${article.maxGold}</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <p style="font-size: 20px;text-align: right">剑网三交易市场</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </article>
                </div>
            </c:forEach>
        </div>
    </div>
</main>
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
