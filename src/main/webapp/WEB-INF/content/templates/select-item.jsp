<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzlin499
  Date: 2019/4/24
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="static org.apache.struts2.ServletActionContext.getServletContext" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="top.yzlin.jx3strategystation.entity.templates.SelectItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    SelectItem[] selectItems = ctx.getBean(request.getParameter("selectList"), SelectItem[].class);
%>
<c:forEach items="<%=selectItems%>" var="i">
    <optgroup label="${i.name}">
        <c:forEach items="${i.children}" var="s">
            <option value="${s}">${s}</option>
        </c:forEach>
    </optgroup>
</c:forEach>
