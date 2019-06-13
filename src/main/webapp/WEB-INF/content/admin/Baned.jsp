<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-striped table-hover">
    <tr>
        <th>黑名单用户</th>
    </tr>
    <c:forEach var="banedUser" items="${requestScope.banedUserList}">
        <tr>
            <td>
                <a href="#" target="view_window">
                        ${banedUser.user.nickName}
                </a>
            </td>
                <%--<td>${reviewArticle.article.user.nickName}</td>--%>
                <%--<td>--%>
                <%--<button class="btn btn-success" onclick="pass(${reviewArticle.reviewId})">通过</button>--%>
                <%--</td>--%>
                <%--<td>--%>
                <%--<button class="btn btn-warning" onclick="deleteA(${reviewArticle.reviewId})">删除</button>--%>
                <%--</td>--%>
        </tr>
    </c:forEach>
</table>

<%--<script>--%>

<%--function deleteA(reviewId) {--%>
<%--$.post("/v1/api/deleteArticle",--%>
<%--{'reviewId': reviewId},--%>
<%--function (data, status) {--%>
<%--window.location.reload();--%>
<%--}--%>
<%--);--%>
<%--}--%>
<%--</script>--%>