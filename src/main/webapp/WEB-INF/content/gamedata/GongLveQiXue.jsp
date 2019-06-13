<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../templates/base-lib.jsp"/>
    <title>剑网三攻略站</title>
    <style type="text/css">
        #page {
            background-color: white;
        }

        #left {
            width: 15%;
            height: 100%;
            float: left;
            background-color: beige;
        }

        #right {
            width: 85%;
            height: 100%;
            float: left;
            background-color: aliceblue;
        }

        #Lrighthead {
            width: 80%;
            height: 54px;
            float: left;
            background-color: antiquewhite;
        }

        #Rrighthead {
            width: 20%;
            height: 54px;
            float: left;
            text-align: right;
            font-size: 18px;
            background-color: aquamarine;
        }

        #rightbody {
            width: 100%;
            height: 100%;
            float: left;
        }
    </style>
    <!--!link rel="stylesheet" type="text/css" href="GongLveZhuYe.css"/-->
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div id="page" class="container" style="margin-top: 10px">
    <div id="left" align="center">
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
        <p>
            <button type="button" class="btn btn-defualt btn-lg">门派</button>
        </p>
    </div>
    <div id="right">
        <div id="Lrighthead">
            &nbsp;&nbsp;<img src="/static/img/test.jpg" alt="此处应该有文字" class="img-circle" width=48px height=48px>
            <img src="/static/img/test.jpg" alt="此处应该有文字" class="img-circle" width=48px height=48px>
        </div>
        <div id="Rrighthead">
            <a href="GongLveJiNeng.jsp"><br>查看技能</a>&nbsp;&nbsp;
        </div>
        <div id="rightbody">
            <c:forEach items="${['一','二','三','四','五','六','七','八','九','十','十一','十二']}" begin="0" var="num"
                       varStatus="numS">
                <h3 align="center">
                    第${num}层&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:forEach items="${requestScope.qiXueGroupList[numS.index].qiXues}" var="qixue">
                        <c:if test="${qixue.skill!=null}">
                            <img src="data:image/png;base64,${qixue.imgBase64}" alt="${qixue.name}" data-toggle="modal"
                                 data-target="#skill-${qixue.skill.name}" class="img-rounded"
                                 width=64px height=64px>&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="modal fade bs-example-modal-sm" id="skill-${qixue.skill.name}"
                                 tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                                <div class="modal-dialog modal-sm" role="document">
                                    <div class="modal-content">
                                        <b>${qixue.skill.name}:</b>${qixue.skill.describe}
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${qixue.skill==null}">
                            <a tabindex="0" data-toggle="popover" data-trigger="focus" title="<h4>${qixue.name}</h4>"
                               data-placement="left"
                               data-content="<h4>${qixue.describe}</h4>"><img
                                    src="data:image/png;base64,${qixue.imgBase64}" alt="${qixue.name}"
                                    class="img-circle" width=64px height=64px></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                    </c:forEach>
                </h3>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="../templates/footer.jsp"/>
<script src="http://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
<script>
    $(function () {
        $("[data-toggle='popover']").popover({html: true});
    });
</script>
</body>
</html>