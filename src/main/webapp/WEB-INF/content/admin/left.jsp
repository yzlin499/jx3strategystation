<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <c:forEach items="${[
            {
                'title':'社区管理',
                'list':[
                    {
                        'name':'帖子审核',
                        'link':'/admin/reviewArticle'
                    }
                ]
            },{
                'title':'审核记录',
                'list':[
                    {
                        'name':'审核通过',
                        'link':'#'
                    },
                    {
                        'name':'黑名单',
                        'link':'/admin/showBanedUser'
                    }
                ]
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
                        <li class="list-group-item"><a href="${item.link}">${item.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:forEach>
</div>