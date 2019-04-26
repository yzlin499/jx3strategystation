<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/26
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/base-lib.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-1">
            <img src="/static/img/" alt="">
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
                    aria-expanded="false" aria-controls="collapseExample">
                Button with data-target
            </button>
            <div class="collapse" id="collapseExample">
                <div class="well">
                    ...
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
