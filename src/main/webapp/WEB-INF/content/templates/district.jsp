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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    ctx.getBean("")
%>
