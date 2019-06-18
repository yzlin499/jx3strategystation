<%@ page import="top.yzlin.jx3strategystation.entity.community.AnnouncementArticle" %>
<%@ page import="top.yzlin.jx3strategystation.entity.community.CommonArticle" %>
<%@ page import="top.yzlin.jx3strategystation.entity.community.StrategyArticle" %>
<%@ page import="top.yzlin.jx3strategystation.entity.community.TradingArticle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table">
        <tr>
            <th>标题</th>
            <th>社区</th>
        </tr>
        <c:forEach items="${requestScope.articleList}" var="article">
            <tr>
                <td><a href="${'/'+=article.user.userName+='/article/'+=article.articleId}">${article.title}</a></td>
                <td>
                    <c:set var="item" value="${article}" scope="request"/>
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
                </td>
            </tr>
        </c:forEach>
    </table>
