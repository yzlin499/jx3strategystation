<%@ page import="top.yzlin.jx3strategystation.entity.community.AnnouncementArticle" %>
<%@ page import="top.yzlin.jx3strategystation.entity.community.CommonArticle" %>
<%@ page import="top.yzlin.jx3strategystation.entity.community.StrategyArticle" %>
<%@ page import="top.yzlin.jx3strategystation.entity.community.TradingArticle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:forEach items="${requestScope.articleList}" var="i">
    <div class="page-header">
        <div class="row">
            <c:if test="${i.imgPath!=null && !empty i.imgPath }">
                <div class="col-md-3">
                    <a href="${'/'+=i.user.userName+='/article/'+=i.articleId}" class="thumbnail">
                        <img src="${i.imgPath}" alt="...">
                    </a>
                </div>
            </c:if>
            <div class="col-md-${(i.imgPath!=null && !empty i.imgPath) ? 9 : 12}">
                <h1>
                    <a href="${'/'+=i.user.userName+='/article/'+=i.articleId}" class="h1">${i.title}</a>
                    <c:set var="item" value="${i}" scope="request"/>
                    <c:choose>
                        <c:when test='<%= request.getAttribute("item") instanceof TradingArticle%>'>
                            <s:a action="transaction" namespace="/community" class="small">交易区</s:a>
                        </c:when>
                        <c:when test='<%= request.getAttribute("item") instanceof StrategyArticle%>'>
                            <s:a action="strategy" namespace="/community" class="small">攻略区</s:a>
                        </c:when>
                        <c:when test='<%= request.getAttribute("item") instanceof CommonArticle%>'>
                            <s:a action="entertainment" namespace="/community" class="small">休闲区</s:a>
                        </c:when>
                        <c:when test='<%= request.getAttribute("item") instanceof AnnouncementArticle%>'>
                            <s:a action="notice" namespace="/community" class="small">公告区</s:a>
                        </c:when>
                    </c:choose>
                </h1>
            </div>
        </div>
    </div>
</c:forEach>