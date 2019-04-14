<%@ page import="top.yzlin.jx3strategystation.entity.templates.CarouselItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/13
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
<%
    CarouselItem carouselItem1=new CarouselItem();
    CarouselItem carouselItem2=new CarouselItem();
    CarouselItem carouselItem3=new CarouselItem();
    carouselItem1.setImgPath("/static/img/carousel/1.png");
    carouselItem2.setImgPath("/static/img/carousel/2.png");
    carouselItem3.setImgPath("/static/img/carousel/3.png");
    carouselItem1.setTitle("123");
    carouselItem1.setContent("123");
    carouselItem2.setTitle("123");
    carouselItem2.setContent("123");
    carouselItem3.setTitle("123");
    carouselItem3.setContent("123");
    List<CarouselItem> carouselList=new ArrayList<>();
    carouselList.add(carouselItem1);
    carouselList.add(carouselItem2);
    carouselList.add(carouselItem3);
    request.setAttribute("carouselId","carousel");
    request.setAttribute("carouselList",carouselList);
%>
<jsp:include page="header.jsp"/>
<jsp:include page="carousel.jsp"/>

</body>
</html>
