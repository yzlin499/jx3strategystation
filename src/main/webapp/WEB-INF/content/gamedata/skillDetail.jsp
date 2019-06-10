<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <title>技能详细页面</title>
    <style type="text/css">
        #page {
            background-color: white;
        }

        #top {
            width: 100%;
            height: 128px;
        }

        #png {
            background-color: aliceblue;
            float: left;
            width: 128px;
            height: 128px;
        }

        #skillInfo {
            background-color: bisque;
            float: left;
            width: 65%;
            height: 128px;
        }

        #skillDetail {
            background-color: beige;
            height: 65%;
            float: left;
        }
    </style>
</head>
<body>
<div id="page" class="container">
    <div id="top">
        <div id="png">
            <img src="test.jpg" width="128px" height="128px">
        </div>
        <div id="skillInfo">
            <p>（此处为技能名称）</p>
            <p>（此处为施法距离）</p>
            <p>（此处为运功时间）</p>
            <p>（此处为技能类型，可多个）</p>
        </div>
    </div>
    <div id="skillDetail">
        <p>此处为技能描述此处为技能描述此处为技能描述此处为技能描述此处为技能描述此处为技能描述此处为技能描述此处为技能描述</p>
        <p>此处为秘籍</p>
        <p>此处为秘籍</p>
        <p>此处为秘籍</p>
        <p>此处为秘籍</p>
        <p>此处为秘籍</p>
        <p>此处为秘籍</p>
        <p>此处为秘籍</p>
    </div>
</div>
<script src="http://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</body>
</html>
