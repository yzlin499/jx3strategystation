<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/19
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
</head>
<body>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <div>剑网三攻略网会员登录</div>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="uesrName">用户名</label>
                        <input type="email" class="form-control" id="uesrName" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="psw">密 码</label>
                        <input type="password" class="form-control" id="psw" placeholder="密码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a herf="register.jsp">账号注册</a>
                <button type="sumbit" class="sign in">登 录</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关 闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
