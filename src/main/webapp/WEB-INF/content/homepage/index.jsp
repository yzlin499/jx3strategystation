<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/13
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/bootstarp-lib.jsp"/>
    <script src="<c:url value="/static/js/homepage/event.js"/>"></script>
    <style type="text/css">
        .page-header {
            border-bottom: 1px solid #d7d7d7;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<jsp:include page="carousel.jsp"/>
<div class="container">
    <div class="row">
        <c:forEach items="${[
            ['info','攻略区','king'],
            ['warning','交易区','yen'],
            ['danger','公告区','bullhorn'],
            ['success','休闲区','leaf']
        ]}" var="i">
            <div class="col-xs-3">
                <div class="panel panel-${i[0]}">
                    <div class="panel-heading text-center">
                        <h1 class="panel-title" style="font-size: 2em">${i[1]}</h1>
                    </div>
                    <div class="panel-body text-center">
                        <span class="glyphicon glyphicon-${i[2]} text-${i[0]}" style="font-size: 8em"
                              aria-hidden="true"></span>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div id="article">
        <jsp:include page="article.jsp"/>
    </div>
</div>

</body>
</html>
