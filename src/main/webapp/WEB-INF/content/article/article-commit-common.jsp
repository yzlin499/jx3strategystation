<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/4/15
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/base-lib.jsp"/>
    <style type="text/css">
        .page-header {
            border-bottom: 1px solid #d7d7d7;
        }

        .ck-content {
            min-height: 700px;
            max-height: 700px;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>

<div class="container">
    <div class="page-header">
        <h1>休闲社区
            <small>吃瓜让我感到愉悦</small>
        </h1>
    </div>

    <div class="form-group">
        <label for="title" class="h3">标题</label>
        <input type="text" class="form-control input-lg" id="title" placeholder="你需要一个好标题">
    </div>
    <div class="form-group">
        <div id="content"></div>
    </div>

    <button onclick="showa()" class="btn btn-success">Submit</button>

    <div id="show" class="ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline"
         contenteditable="true">
        <p>asdadsdsadsaasdsadas</p>
        <p>&nbsp;</p>
        <blockquote><p>asdasda</p>
            <figure class="image image-style-side"><img
                    src="/upload/image/777755440e7e44edc4970235215fccaacf2ccbd51.jpg"></figure>
            <h2>asdasdasd.</h2>
            <p><strong>asbkjg</strong></p>
            <p>dssdsfdsfd</p>
            <p>
                fsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssssfsdfdsfdsassssssssssssssssssssss</p>
            <p>sdffdsfdsdfs</p>
            <p>fjkhfgjk</p></blockquote>
    </div>
</div>
<script src="<c:url value="/static/js/ckeditor.js"/>"></script>
<script src="<c:url value="/static/js/article/editor.js"/>"></script>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
