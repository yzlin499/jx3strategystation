<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% String carouselId= Objects.toString(request.getAttribute("carouselId"),"myCarousel");%>
<div id="<%=carouselId%>" class="carousel slide" style="margin-top: 50px">
    <ol class="carousel-indicators">
        <c:forEach begin="0" end="${fn:length(requestScope.carouselList)-1}" var="i">
            <li data-target="#<%=carouselId%>" data-slide-to="${i}" class="${i==0? "active":""}"></li>
        </c:forEach>
    </ol>
    <div class="carousel-inner">
        <c:forEach items="${requestScope.carouselList}" var="item" varStatus="i">
            <div class="item ${i.index==0? "active":""}">
                <img src="${item.imgPath}" alt="img fail">
                <div class="carousel-caption">
                    <h3>${item.title}</h3>
                    <p>${item.content}</p>
                </div>
            </div>
        </c:forEach>
    </div>
    <a class="left carousel-control" href="#<%=carouselId%>" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#<%=carouselId%>" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>