<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userCss/testCss/bootstrap-table.min.css">
<div class="container">
    <table id="table"
           data-toggle="table"
           data-url="data/data1.json"
           data-show-columns="true"
           data-search="true"
           data-show-refresh="true"
           data-show-toggle="true"
           data-pagination="true"
           data-height="500">
        <thead>
        <tr>
            <th data-field="id" data-formatter="idFormatter">ID</th>
            <th data-field="name">Item Name</th>
            <th data-field="price">Item Price</th>
        </tr>
        </thead>
    </table>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/user/table/tableExport.js"></script>
<script src="${pageContext.request.contextPath}/static/js/user/table/jquery.base64.js"></script>
<script src="${pageContext.request.contextPath}/static/js/user/table/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/static/js/user/table/bootstrap-table-export.js"></script>
<script>
    function idFormatter(value) {
        return value + 100;
    }
</script>
