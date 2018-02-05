<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
        session="false" %>
<html>
<head>
    <title>Spittle</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
<h1>Hollo World!The first ever Spittle</h1>
<div class="spittleMessage">
    <c:out value="${spittle.message}"/>
</div>
<div>
    <span class="spittleTime"><c:out value="${spittle.time}"/></span>
</div>
</body>
</html>
