<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-striped table-hover">
    <tr>
        <th>帖子标题</th>
        <th>发帖人</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <c:forEach var="reviewArticle" items="${requestScope.reviewArticleList}">
        <tr>
            <td>
                <a href="/${reviewArticle.article.user.userName}/article/${reviewArticle.article.articleId}"
                   target="view_window">
                        ${reviewArticle.article.title}
                </a>
            </td>
            <td>${reviewArticle.article.user.nickName}</td>
            <td>
                <button class="btn btn-success" onclick="pass(${reviewArticle.reviewId})">通过</button>
            </td>
            <td>
                <button class="btn btn-warning" onclick="deleteA(${reviewArticle.reviewId})">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>


<script>
    function pass(reviewId) {
        $.post("/v1/api/passArticle",
            {'reviewId': reviewId},
            function (data, status) {
                window.location.reload();
            }
        );
    }

    function deleteA(reviewId) {
        $.post("/v1/api/deleteArticle",
            {'reviewId': reviewId},
            function (data, status) {
                window.location.reload();
            }
        );
    }
</script>