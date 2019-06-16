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
        .db1 {
            height: 100px;
        }

        .db1:hover {
            background-color: black;
            filter: alpha(opacity=50);
            moz-opacity: 0.5;
            opacity: 0.1;
        }
    </style>
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div class="row">
    <div class="col-sm-2" style="background: #46b8da; height: 100%">
        <img style="width: 100%;" src="/static/img/community/3213.jpg">
        <br>
        <p></p>

    </div>
    <div class="col-sm-10" style="height: 100%">
        <h1>剑网三攻略区</h1>
        <ul class="list-group">
            <li class="list-group-item db1">
                实例1
            </li>
            <li class="list-group-item db1">
                实例1
            </li>
            <li class="list-group-item db1">
                实例1
            </li>
            <li class="list-group-item db1">
                实例1
            </li>
            <li class="list-group-item db1">
                实例1
            </li>
            <li class="list-group-item db1">
                实例1
            </li>
            <li class="list-group-item db1">
                实例1
            </li>
        </ul>
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
    </div>
</div>
<div class="footer">
    <div class="container">
        <div class="footer-navbar">
            <a href="#">GitHub仓库</a>
            <a href="#">关于我们</a>
        </div>
        <p class="footer-content">
            CopyRight © 2019 jx3strategystation<br>
            All rights reserved. jx3strategystation 版权所有
        </p>
    </div>
</div>
</body>
</html>
