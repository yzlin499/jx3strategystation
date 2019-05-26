<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <c:forEach items="${[
            {
                'title':'title1',
                'list':['title1-list1','title1-list2']
            },{
                'title':'title2',
                'list':['title2-list1','title2-list2','title2-list1','title2-list2','title2-list1','title2-list2']
            }
    ]}" var="i" varStatus="num">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse${num.index}">
                            ${i.title}
                    </a>
                </h4>
            </div>
            <div id="collapse${num.index}" class="panel-collapse collapse">
                <ul class="list-group">
                    <c:forEach items="${i.list}" var="item">
                        <li class="list-group-item">${item}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:forEach>
</div>