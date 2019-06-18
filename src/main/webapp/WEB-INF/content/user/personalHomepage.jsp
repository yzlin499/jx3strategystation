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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userCss/personalStyle.css">
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
</head>
<body>
<div class="main">
    <jsp:include page="../templates/navbar.jsp"/>
    <div class="content">
        <div class="content-left">
            <div class="avatar">
                <img src="${sessionScope.user.portrait}" alt="">
            </div>
        </div>
        <div class="content-right">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="#profile" data-toggle="tab" role="tab">个人信息</a></li>
                <li role="presentation"><a href="#posting" data-toggle="tab" role="tab">帖子管理</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="profile">
                    <div class="show2">
                        <form class="form-horizontal ">

                            <div class="form-group">
                                <label class="col-sm-2 control-label">昵称:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${sessionScope.user.nickName}</p>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${sessionScope.user.userName}</p>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">邮箱:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${sessionScope.user.mail}</p>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="posting">
                    <div>
                        <jsp:include page="../user/tableModel.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
