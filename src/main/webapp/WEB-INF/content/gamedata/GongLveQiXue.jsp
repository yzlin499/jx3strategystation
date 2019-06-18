<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        }

        #left {
            width: 15%;
            height: 100%;
            float: left;
        }

        #right {
            width: 85%;
            height: 100%;
            float: left;
        }

        #Lrighthead {
            width: 80%;
            height: 54px;
            float: left;
        }

        #Rrighthead {
            width: 20%;
            height: 54px;
            float: left;
            text-align: right;
            font-size: 18px;
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
        <h2>门派列表</h2>
        <c:forEach items="${requestScope.menPaiList}" var="menPai">
            <p>
                <a href="?xinFaName=${menPai.xinFas[0].name}" role="button"
                   class="btn btn-default btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;${menPai.name}&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </p>
        </c:forEach>

    </div>
    <div id="right">
        <div id="Lrighthead">
            &nbsp;&nbsp;
            <c:forEach items="${requestScope.xinFaList}" var="xinfa">
                <a href="?xinFaName=${xinfa}" role="button"
                   class="btn btn-default" style="float: left">${xinfa}</a>
            </c:forEach>
        </div>
        <div id="Rrighthead">
            <s:a namespace="/gamedata" action="skill"><h3>查看技能</h3>
                <s:param name="xinFaName">${requestScope.xinFaName}</s:param>
            </s:a>
        </div>
        <div id="rightbody">
            <h4 align="left">当前位置：${xinFaName}&nbsp;&nbsp;奇穴页面</h4>
            <c:forEach items="${['一','二','三','四','五','六','七','八','九','十','十一','十二']}" begin="0" var="num"
                       varStatus="numS">
                <h3 align="center">
                    第${num}层&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:forEach items="${requestScope.qiXueGroupList[numS.index].qiXues}" var="qixue">
                        <c:if test="${qixue.skill!=null}">
                            <a tabindex="0" data-toggle="popover" data-trigger="focus" title="<h4>${qixue.name}</h4>"
                               data-placement="left"
                               data-content="<h4>${qixue.describe}</h4>" role="button">
                                <img src="data:image/png;base64,${qixue.imgBase64}" alt="${qixue.name}"
                                     class="img-rounded" width=64px height=64px></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${qixue.skill==null}">
                            <a tabindex="0" data-toggle="popover" data-trigger="focus" title="<h4>${qixue.name}</h4>"
                               data-placement="left"
                               data-content="<h4>${qixue.describe}</h4>" role="button">
                                <img src="data:image/png;base64,${qixue.imgBase64}" alt="${qixue.name}"
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