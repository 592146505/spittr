<%--
  Created by IntelliJ IDEA.
  User: roamer_newtouch
  Date: 2018/1/13
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
        session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
<a href="<s:url value="/"/>">
    <img src="<s:url value="/images"/>/spittr_logo_50.jpg" height="260px" width="1080px" border="0"/>
</a>
</body>
</html>
