<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/13
  Time: 0:46
  To change this template use File | Settings | File Templates.
  param
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-default  navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
                <img alt="JX3SS" src="${pageContext.request.contextPath}/static/img/logo_100x100.png">
            </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><s:a action="index" namespace="/">首页</s:a></li>
                <li><s:a action="skill" namespace="/gamedata">资料站</s:a></li>
                <li><s:a action="notice" namespace="/community">公告社区</s:a></li>
                <li><s:a action="strategy" namespace="/community">攻略社区</s:a></li>
                <li><s:a action="transaction" namespace="/community">交易社区</s:a></li>
                <li><s:a action="entertainment" namespace="/community">休闲社区</s:a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user == null}">
                    <li><a href="" data-toggle="modal" data-target="#myModal">登录</a></li>
                    <li><s:a action="register" namespace="/user">注册</s:a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <c:choose>
                        <c:when test="${requestScope.actionName eq 'CommonAction'}">
                            <li><s:a action="common" namespace="/commit">发帖</s:a></li>
                        </c:when>

                        <c:when test="${requestScope.actionName eq 'StrategyAction'}">
                            <li><s:a action="strategy" namespace="/commit">发帖</s:a></li>
                        </c:when>

                        <c:when test="${requestScope.actionName eq 'TradingAction'}">
                            <li><s:a action="trading" namespace="/commit">发帖</s:a></li>
                        </c:when>
                    </c:choose>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                                ${sessionScope.user.nickName}<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人信息</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#">消息</a></li>


                            <li role="separator" class="divider"></li>
                            <li><a href="" data-toggle="modal" data-target="#myModal1">修改密码</a></li>
                            <li><a onclick="logOut()">退出登录</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="查找">
                </div>
                <button type="submit" class="btn btn-default" style="font-size: 20px"><span
                        class="glyphicon glyphicon-zoom-in"></span></button>
            </form>
        </div>
    </div>
</nav>
<div style="height: 50px"></div>

<c:if test="${sessionScope.user == null}">
    <jsp:include page="../user/login.jsp"/>
</c:if>
<c:if test="${sessionScope.user !=null}">
    <jsp:include page="../user/changePasswords.jsp"/>
</c:if>

<c:if test="${sessionScope.user != null}">
    <script>
        function logOut() {
            $.get("/v1/api/logOut", {}, function (data, status) {
                    $(location).attr('href', '/');
                }
            );
        }
    </script>
</c:if>