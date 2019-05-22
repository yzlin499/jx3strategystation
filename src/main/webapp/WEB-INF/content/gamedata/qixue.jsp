<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/26
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/base-lib.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-md-12">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active col-md-1 text-center" style="padding: 0">
                    <a href="#qixue0" aria-controls="home" role="tab" data-toggle="tab">第一重</a>
                </li>
                <c:forEach items="${['一','二','三','四','五','六','七','八','九','十','十一','十二']}" begin="1" var="num"
                           varStatus="numS">
                    <li role="presentation" class="col-md-1 text-center" style="padding: 0">
                        <a href="#qixue${numS.index}" aria-controls="profile" role="tab" data-toggle="tab">
                            第${num}重
                        </a>
                    </li>
                </c:forEach>
            </ul>

            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="qixue0">0</div>
                <c:forEach begin="1" end="11" var="i">
                    <div role="tabpanel" class="tab-pane" id="qixue${i}">

                        <div class="panel-group" id="accordion">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse"
                                           href="#collapseOne">
                                            第一奇穴
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in">
                                    <div class="panel-body">
                                        第一奇穴
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseTwo">第二奇穴</a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse">
                                    <div class="panel-body">第二奇穴</div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseThree">第三描述</a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse">
                                    <div class="panel-body">第三描述</div>
                                </div>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>

        </div>


    </div>
</div>
</body>
</html>
