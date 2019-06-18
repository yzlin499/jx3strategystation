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
                <li role="presentation"><a href="#profile" data-toggle="tab" role="tab">个人信息</a></li>
                <li role="presentation"><a href="#posting" data-toggle="tab" role="tab">帖子管理</a></li>
                <li role="presentation"><a href="#message" data-toggle="tab" role="tab">消息管理</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="profile">
                    <div class="show2">
                        <form class="form-horizontal ">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">昵称:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">email@example.com</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">email@example.com</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">邮箱:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">email@example.com</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系方式:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">email@example.com</p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="posting">
                    <div>

                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="message">

                </div>
            </div>
        </div>
    </div>
</div>
<script>
    /*window.onload = function () {
        var data = [{
            "BrandName": "ACES",
            "Modul": "91906-0227P",
            "Quantity": "3057",
            "Datecode": "W2Y",
            "Remark": "stock"
        },
            {"BrandName": "ADI", "Modul": "ADM706TARZ-REEL", "Quantity": "2145", "Datecode": "W2Y", "Remark": "stock"},
            {"BrandName": "ADI", "Modul": "ADR02AUJZ-REEL7", "Quantity": "2131", "Datecode": "W2Y", "Remark": "stock"}];


        var table = document.getElementById("table1");
        for (var i = 0; i < data.length; i++) {
            var row = table.insertRow(table.rows.length);
            var c1 = row.insertCell(0);
            c1.innerHTML = data[i].BrandName;
            var c2 = row.insertCell(1);
            c2.innerHTML = data[i].Modul;
            var c3 = row.insertCell(2);
            c3.innerHTML = data[i].Quantity;
        }
    }*/
</script>
</body>
</html>
