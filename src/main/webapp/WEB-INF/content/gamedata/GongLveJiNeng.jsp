<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../templates/base-lib.jsp"/>
    <title>剑网三攻略站</title>
    <style type="text/css">
        #page {
            background-color: white;
        }

        #left {
            width: 15%;
            height: 100%;
            float: left;
            background-color: beige;
        }

        #right {
            width: 85%;
            height: 100%;
            float: left;
            background-color: aliceblue;
        }

        #Lrighthead {
            width: 80%;
            height: 54px;
            float: left;
            background-color: antiquewhite;
        }

        #Rrighthead {
            width: 20%;
            height: 54px;
            float: left;
            text-align: right;
            font-size: 18px;
            background-color: aquamarine;
        }

        #rightbody {
            width: 100%;
            height: 100%;
            float: left;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="GongLveZhuYe.css"/>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div id="page" class="container" style="margin-top: 10px">
    <div id="left" align="center">
        <c:forEach items="${requestScope.menPailist}" var="menpai">
            <p>
                <a href="/gamedata/skill?xinFaName=${menpai.xinFas[0].name}" type="button"
                   class="btn btn-defualt btn-lg">${menpai.name}</a>
            </p>
        </c:forEach>

    </div>
    <div id="right">
        <div id="Lrighthead">
            &nbsp;&nbsp;<img src="../../../static/img/test.jpg" alt="此处应该有文字" class="img-circle" width=48px height=48px>
            <img src="../../../static/img/test.jpg" alt="此处应该有文字" class="img-circle" width=48px height=48px>
        </div>
        <div id="Rrighthead">
            <s:a action="qixue" namespace="/gamedata"><br>查看奇穴</s:a>&nbsp;&nbsp;
        </div>
        <div id="rightbody">
            <c:forEach items="${requestScope.skillList}" var="skill">
                <h3 align="center">
                    <img src="${skill.imgBase64}" class="img-circle" width=64px height=64px>&nbsp;&nbsp;
                    <p>${skill.name}</p>
                </h3>
            </c:forEach>
        </div>
    </div>
</div>
<script src="http://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</body>
</html>