<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/5/31
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <div class="panel-title">
            <h1>${requestScope.article.buySell}&nbsp;&nbsp;<small>${requestScope.article.district}</small>
            </h1>
        </div>
    </div>
    <table class="table">
        <tr>
            <th>比率</th>
            <th>最小金额</th>
            <th>最大金额</th>
        </tr>
        <tr>
            <th>￥1:G${requestScope.article.ratio}</th>
            <th>￥${requestScope.article.minGold}</th>
            <th>￥${requestScope.article.maxGold}</th>
        </tr>
    </table>
</div>