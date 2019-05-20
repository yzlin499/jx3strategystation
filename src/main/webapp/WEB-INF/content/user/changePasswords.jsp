<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/15
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/static/css/userCss/changeStyle.css">
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <p>密码修改</p>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="password" class="form-control" id="oldPassword" placeholder="原密码">
                </div>
                <div class="form-group" style="margin-top:35px">
                    <input type="password" class="form-control" id="newPassword" placeholder="新密码">
                </div>
                <div id="errerMsg" class="text-warning"></div>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="updatePassword()" class="btn btn-info">确认修改</button>
            </div>
        </div>
    </div>
</div>
<script>
    function updatePassword() {
        $.post("/v1/api/updatePassword", {
            "oldPassword":
        })
    }
</script>