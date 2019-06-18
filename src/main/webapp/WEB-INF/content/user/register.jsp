<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/19
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/userCss/registerStyle.css"/>">
    <jsp:include page="../templates/base-lib.jsp"/>
</head>
<body>
<div class="main">
    <div class="nav ">
        <p>剑网三攻略网欢迎你</p>
        <ul>
            <li><s:a action="entertainment" namespace="/community">休闲社区</s:a></li>
            <li><s:a action="transaction" namespace="/community">交易社区</s:a></li>
            <li><s:a action="strategy" namespace="/community">攻略社区</s:a></li>
            <li><s:a action="notice" namespace="/community">公告社区</s:a></li>
            <li><s:a action="skill" namespace="/gamedata">资料站</s:a></li>
            <li><s:a action="index" namespace="/">首页</s:a></li>
        </ul>
    </div>
    <div class="header">
        <h1>剑网三攻略注册</h1>
        <p>祝你游戏开心</p>
    </div>
    <div class="centers">
        <form>
            <div class="form-group">
                <input type="text" class="form-control" id="nickName" placeholder="网站呢称">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="userName" placeholder="用户名">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" placeholder="密码">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="mail" placeholder="邮箱">
            </div>
            <div class="btn-group">
                <button type="button" id="submit_btn" class="btn btn-info">立即注册</button>
            </div>
        </form>
    </div>
    <div class="bottom">
        <div class="container">
            <div class="footer-navbar">
                <a href="https://github.com/yzlin499/jx3strategystation">GitHub仓库</a>
                <a href="#">关于我们</a>
            </div>
            <p class="footer-content">
                CopyRight © 2019 jx3strategystation<br>
                All rights reserved. jx3strategystation 版权所有
            </p>
        </div>
    </div>
</div>
<script>

    $(function () {
        var errMsg;
        var nickC;
        var uNC;
        var pwdC;
        $.each($("input"), function (i, val) {
            $(val).blur(function () {
                if ($(val).attr("id") === "userName") {
                    $(".nameMsg").remove();
                    var userName = val.value;
                    var regName = /[a-zA-Z]\w{4,16}/;
                    if (userName === "" || userName.trim() === "") {
                        errMsg = "<span class='nameMsg label label-danger' >用户名不能为空</span>";
                    } else if (!regName.test(userName)) {
                        errMsg = "<span class='nameMsg label label-danger'>由英文字母和数字组成的4-16位字符，以字母开头</span>";
                    } else {
                        errMsg = "<span class='nameMsg label label-success'>OK！</span>";
                        uNC = true;
                    }
                    $(this).parent().append(errMsg);
                } else if ($(val).attr("id") === "nickName") {
                    $(".nickMsg").remove();
                    var nickName = val.value;
                    if (nickName === "" || nickName.trim() === "") {
                        errMsg = "<span class='nickMsg label label-danger'>昵称不能为空</span>";
                    } else if (!/^[\u4e00-\u9fa5a-zA-Z0-9]{2,6}$/.test(nickName)) {
                        errMsg = "<span class='nickMsg label label-danger'>由2-6个汉字组成</span>";
                    } else {
                        errMsg = "<span class='nickMsg label label-success' >OK！</span>";
                        nickC = true;
                    }
                    $(this).parent().append(errMsg);
                } else if ($(val).attr("id") === "password") {
                    $(".pwdMsg").remove();
                    var pwd = val.value;
                    var regPwd = /^\w{4,10}$/;
                    if (pwd === "" || pwd.trim() === "") {
                        errMsg = "<span class='pwdMsg label label-danger' >密码不能为空</span>";
                    } else if (!regPwd.test(pwd)) {
                        errMsg = "<span class='pwdMsg label label-danger' >格式错误</span>";
                    } else {
                        errMsg = "<span class='pwdMsg label label-success' >OK！</span>";
                        pwdC = true;
                    }
                    $(this).parent().append(errMsg);
                }
            });
        });
        $('#submit_btn').on('click', function () {
            if (uNC === true && pwdC === true && nickC === true) {
                $.post("/v1/api/register", {
                    "user.userName": $("#userName").val(),
                    "user.nickName": $("#nickName").val(),
                    "user.password": $("#password").val(),
                    "user.mail": $("#mail").val()
                }, function (data, status) {
                    if (data.userId > 0) {
                        alert("注册成功！");
                        window.location.href = "/index";
                    }
                    else {
                        alert("注册失败！")
                    }
                });
            }
        });
    });
</script>
</body>
</html>