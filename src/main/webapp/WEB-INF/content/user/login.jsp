<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/19
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/static/css/userCss/loginStyle.css"/>">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content login-modal-content">
            <div class="modal-header">
                <p><b>剑网三攻略网会员登录</b></p>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="email" class="form-control" id="uesrName" placeholder="用户名">
                </div>
                <div class="form-group" style="margin-top:35px">
                    <input type="password" class="form-control" id="password" placeholder="密码">
                </div>
                <div id="errerMsg" class="text-warning"></div>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="login()" class="btn btn-info">立即登录</button>
                <br>
                <a href="/user/register">账号注册</a>
            </div>
        </div>
    </div>
</div>

<script>
    function login() {
        $.post("/v1/api/login", {
                "user.userName": $("#uesrName").val(),
                "user.password": $("#password").val()
            }, function (data, status) {
                if (data.loginStatic) {
                    window.location.reload()
                } else {
                    $("#errerMsg").text('用户名或密码错误')
                }
            }
        );
    }
</script>