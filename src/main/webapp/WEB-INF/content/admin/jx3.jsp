<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JX3攻略站管理页面</title>
    <jsp:include page="../templates/base-lib.jsp"/>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div class="container-fluid" style="margin-top: 8px">
    <div class="col-md-3" style="height: 100%">
        <jsp:include page="left.jsp"/>
    </div>
    <div class="col-md-9">
        <jsp:include page="ticket-list.jsp"/>
    </div>
    <div class="">

    </div>


</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>