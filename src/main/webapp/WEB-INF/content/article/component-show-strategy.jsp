<%@ page import="top.yzlin.jx3strategystation.entity.community.StrategyArticle" %>
<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/5/30
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] instance = ((StrategyArticle) request.getAttribute("article")).getInstance().split("-");
%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">
            <%= instance[0] %>
        </h3>
    </div>
    <div class="panel-body">
        <%= instance[1] %>
    </div>
</div>
