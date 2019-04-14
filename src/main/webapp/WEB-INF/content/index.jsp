<%@ page import="top.yzlin.jx3strategystation.entity.templates.CarouselItem" %>
<%@ page import="top.yzlin.jx3strategystation.entity.user.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/13
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    CarouselItem carouselItem1 = new CarouselItem();
    CarouselItem carouselItem2 = new CarouselItem();
    CarouselItem carouselItem3 = new CarouselItem();
    carouselItem1.setImgPath("/static/img/carousel/1.png");
    carouselItem2.setImgPath("/static/img/carousel/2.png");
    carouselItem3.setImgPath("/static/img/carousel/3.png");
    carouselItem1.setTitle("123");
    carouselItem1.setContent("123");
    carouselItem2.setTitle("123");
    carouselItem2.setContent("123");
    carouselItem3.setTitle("123");
    carouselItem3.setContent("123");
    List<CarouselItem> carouselList = new ArrayList<>();
    carouselList.add(carouselItem1);
    carouselList.add(carouselItem2);
    carouselList.add(carouselItem3);
    request.setAttribute("carouselId", "carousel");
    request.setAttribute("carouselList", carouselList);
    User user = new User();
    user.setName("一个名字");
    session.setAttribute("user", user);
%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="templates/bootstarp-lib.jsp"/>
</head>
<body>
<jsp:include page="templates/navbar.jsp"/>
<jsp:include page="templates/carousel.jsp"/>
<div class="container" style="margin-top: 50px">
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
</div>

</body>
</html>
