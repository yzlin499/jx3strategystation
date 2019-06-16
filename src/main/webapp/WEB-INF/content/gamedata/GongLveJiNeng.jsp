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
            /*width: 15%;*/
            /*height: 100%;*/
            /*float: left;*/
            background-color: beige;
        }

        #right {
            /*width: 85%;*/
            /*height: 100%;*/
            /*float: left;*/
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
            /*width: 100%;*/
            /*height: 100%;*/
            /*float: left;*/
        }

        .skill-item {
            margin-top: 5px;
            margin-bottom: 5px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="GongLveZhuYe.css"/>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div id="page" class="container" style="margin-top: 10px">
    <div class="row">
        <div id="left" align="center" class="col-xs-2">

            <c:forEach items="${requestScope.menPaiList}" var="menPai">
                <p>
                    <a href="?xinFaName=${menPai.xinFas[0].name}" role="button"
                       class="btn btn-default btn-lg">${menPai.name}</a>
                </p>
            </c:forEach>

        </div>
        <div id="right" class="col-xs-10">
            <div id="Lrighthead">
                &nbsp;&nbsp;<img src="../../../static/img/test.jpg" alt="此处应该有文字" class="img-circle" width=48px
                                 height=48px>
                <img src="../../../static/img/test.jpg" alt="此处应该有文字" class="img-circle" width=48px height=48px>
            </div>
            <div id="Rrighthead">
                <a href="GongLveQiXue.jsp"><br>查看奇穴</a>&nbsp;&nbsp;
            </div>
            <div id="rightbody">
                <h3 align="center">
                    门派武学<br>
                </h3>
                <div class="row">
                    <c:forEach items="${requestScope.skillList}" var="skill">
                        <div class="skill-item text-center col-xs-3 col-md-2">
                            <img src="data:image/png;base64,${skill.imgBase64}" alt="${skill.name}" data-toggle="modal"
                                 data-target="#skill-${skill.name}" class="img-rounded"
                                 width=64px height=64px>
                        </div>

                        <%--&nbsp;&nbsp;&nbsp;&nbsp;--%>

                        <div class="modal fade" id="skill-${skill.name}" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close"><span
                                                aria-hidden="true">&times;</span></button>
                                    </div>
                                    <div class="modal-body" align="left">
                                        <h3><b>${skill.name}<br></b></h3>
                                        <h4>武器：${skill.arm}<br>
                                            施法距离：${skill.distance}尺<br>
                                            内力消耗：${skill.consumption}<br>
                                            调息时间：${skill.coolDownTime}秒<br><br>
                                                ${skill.describe}<br></h4>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>


            </div>
        </div>
    </div>

</div>
<script src="http://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</body>
</html>