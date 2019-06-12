<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/userCss/personalStyle.css">
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
</head>
<body>
<div class="main">
    <jsp:include page="../templates/navbar.jsp"/>
    <div class="content">
        <div class="content-left">
            <div class="avatar">
                <img src="" alt="">
            </div>
            <button type="button" onclick="" class="btn btn-default">写新贴子</button>
        </div>
        <div class="content-right">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="#posting" data-toggle="tab" role="tab">帖子管理</a></li>
                <li role="presentation"><a href="#profile" data-toggle="tab" role="tab">个人信息</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="posting">
                    <div class="show">
                        <table class="table table-hover" id="table">
                        </table>
                    </div>
                    <div class="form-group">
                        <button type="button" onclick="" class="btn btn-default">查询</button>
                        <button type="button" onclick="" class="btn btn-default">修改</button>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
                    123456s
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    window.onload = function () {
        var data = [{
            "BrandName": "ACES",
            "Modul": "91906-0227P",
            "Quantity": "3057",
            "Datecode": "W2Y",
            "Remark": "stock"
        },
            {"BrandName": "ADI", "Modul": "ADM706TARZ-REEL", "Quantity": "2145", "Datecode": "W2Y", "Remark": "stock"},
            {"BrandName": "ADI", "Modul": "ADR02AUJZ-REEL7", "Quantity": "2131", "Datecode": "W2Y", "Remark": "stock"}];


        var table = document.getElementById("table");


        for (var i = 0; i < data.length; i++) {
            var row = table.insertRow(table.rows.length);
            var c1 = row.insertCell(0);
            c1.innerHTML = data[i].BrandName;
            var c2 = row.insertCell(1);
            c2.innerHTML = data[i].Modul;
            var c3 = row.insertCell(2);
            c3.innerHTML = data[i].Quantity;
            var c4 = row.insertCell(3);
            c4.innerHTML = data[i].Datecode;
            var c5 = row.insertCell(4);
            c5.innerHTML = data[i].Remark;
        }
    }
</script>
</body>
</html>
