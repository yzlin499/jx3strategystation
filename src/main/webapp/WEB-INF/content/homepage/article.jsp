<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${requestScope.articleList}" var="i">
    <div class="page-header">
        <div class="row">
            <c:if test="${i.imgPath!=null && !empty i.imgPath }">
                <div class="col-md-3">
                    <a href="#" class="thumbnail">
                        <img src="${i.imgPath}" alt="...">
                    </a>
                </div>
            </c:if>
            <div class="col-md-${(i.imgPath!=null && !empty i.imgPath) ? 9 : 12}">
                <h1>${i.title}</h1>
            </div>
        </div>
    </div>
</c:forEach>