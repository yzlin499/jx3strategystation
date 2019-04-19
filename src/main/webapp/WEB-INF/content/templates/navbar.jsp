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
<nav class="navbar navbar-default  navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
                <img alt="JX3SS" src="${pageContext.request.contextPath}/static/img/logo_100x100.png">
            </a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
                <li><a href="#">资料站</a></li>
                <li><a href="#">公告社区</a></li>
                <li><a href="#">攻略社区</a></li>
                <li><a href="#">交易社区</a></li>
                <li><a href="#">休闲社区</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user == null}">
                    <li><a href="" data-toggle="modal" data-target="#myModal">登录</a></li>
                    <li><a href="#">注册</a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                                ${sessionScope.user.name}<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人信息</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#">消息</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">修改密码</a></li>
                            <li><a href="#">退出登录</a></li>
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
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2>剑网三攻略网会员登录</h2>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="uesrName">用户名</label>
                            <input type="text" class="form-control input-lg" id="uesrName" placeholder="用户名">
                        </div>
                        <div class="form-group">
                            <label for="psw">密 码</label>
                            <input type="password" class="form-control input-lg" id="psw" placeholder="密码">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info">登 录</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关 闭</button>
                </div>
            </div>
        </div>
    </div>
</c:if>