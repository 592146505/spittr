<%--
  Created by IntelliJ IDEA.
  User: roamer_newtouch
  Date: 2018/1/13
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
        session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/style.css"/>">
</head>
<body>
<%--头部--%>
<div id="header">
    <t:insertAttribute name="header"/>
</div>
<%--主体--%>
<div id="content">
    <t:insertAttribute name="body"/>
</div>
<%--尾部--%>
<div id="footer">
    <t:insertAttribute name="footer"/>
</div>
</body>
</html>
