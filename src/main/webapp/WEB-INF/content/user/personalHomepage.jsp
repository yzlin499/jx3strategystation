<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        <div class="content-right ">
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
                                    <p class="form-control-static"
                                       style="color: #c0a16b">${sessionScope.user.nickName}</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static"
                                       style="color: #c0a16b">${sessionScope.user.userName}</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">邮箱:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static" style="color: #c0a16b">${sessionScope.user.mail}</p>
                                </div>
                            </div>
                        </form>
                        <div class="btn-group">
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#myModal3">修改
                            </button>
                        </div>
                        <div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <p>个人信息修改</p>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <input type="text" class="form-control " id="nnN" placeholder="昵称">
                                        </div>
                                        <div class="form-group" style="margin-top:35px">
                                            <input type="text" class="form-control " id="nuN" placeholder="用户名">
                                        </div>
                                        <div class="form-group" style="margin-top:35px">
                                            <input type="text" class="form-control " id="nM" placeholder="邮箱">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" id="submit_btn" class="btn btn-info">保存</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="posting">
                    <div class="show">
                        <jsp:include page="../user/tableModel.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
<script>
    $(function () {
        var errMsg;
        var nickC;
        var uNC;
        var mailC;
        $.each($("input"), function (i, val) {
            $(val).blur(function () {
                if ($(val).attr("id") === "nuN") {
                    $(".nuN").remove();
                    var nuN = val.value;
                    var regName = /[a-zA-Z]\w{4,16}/;
                    if (nuN === "" || nuN.trim() === "") {
                        errMsg = " ";
                        uNC = true;
                    } else if (!regName.test(nuN)) {
                        errMsg = "<span class='nuN label label-danger'>由英文字母和数字组成的4-16位字符，以字母开头</span>";
                    } else {
                        errMsg = "<span class='nuN label label-success'>OK！</span>";
                        uNC = true;
                    }
                    $(this).parent().append(errMsg);
                } else if ($(val).attr("id") === "nnN") {
                    $(".nnN").remove();
                    var nnN = val.value;
                    var regName = /[\u4e00-\u9fa5]{2,6}/;
                    if (nnN === "" || nnN.trim() === "") {
                        errMsg = " ";
                        nickC = true;
                    } else if (!regName.test(nnN)) {
                        errMsg = "<span class='nnN label label-danger'>由2-6个汉字组成</span>";
                    } else {
                        errMsg = "<span class='nnN label label-success' >OK！</span>";
                        nickC = true;
                    }
                    $(this).parent().append(errMsg);
                } else if ($(val).attr("id") == "nM") {
                    $(".nM").remove();
                    var nM = val.value;
                    var regEmail = /^\w+@\w+((\.\w+)+)$/;
                    if (nM == "" || nM.trim() == "") {
                        errMsg = " ";
                        mailC = true;
                    } else if (!regEmail.test(nM)) {
                        errMsg = "<span class='nM label label-danger' >邮箱账号@域名。如good@tom.com、whj@sina.com.cn</span>";
                    } else {
                        errMsg = "<span class='nM label label-success' >OK！</span>";
                        mailC = true;
                    }
                    $(this).parent().append(errMsg);
                }
            });
        });
        $('#submit_btn').on('click', function () {
            if (uNC === true && nickC === true && mailC === true) {
                $.post("/v1/api/updateUser", {
                    "nuN": $("#nuN").val(),
                    "nnN": $("#nnN").val(),
                    "nM": $("#nM").val()
                }, function (data, status) {
                    alert("修改成功！");
                    window.location.reload();
                });
            }
        });
    });
</script>
</body>
</html>
