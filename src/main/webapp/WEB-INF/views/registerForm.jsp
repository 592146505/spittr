<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
        session="false" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
<sf:form method="post" commandName="spitter">
    <sf:errors path="*" element="div" cssClass="errors"/>

    <sf:label path="firstName" cssErrorClass="error"> First Name</sf:label>:
    <sf:input path="firstName" cssErrorClass="error"/>
    <sf:errors path="firstName" cssClass="error"/><br/>

    <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="lastName" cssErrorClass="error"/>
    <sf:errors path="lastName" cssClass="error"/><br/>

    <sf:label path="email" cssErrorClass="error">Email</sf:label>:
    <sf:input type="email" path="email" cssErrorClass="error"/>
    <sf:errors path="email" cssClass="error"/><br/>

    <sf:label path="username" cssErrorClass="error">Username</sf:label>:
    <sf:input path="username" cssErrorClass="error"/>
    <sf:errors path="username" cssClass="error"/><br/>

    <sf:label path="password" cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/>
    <sf:errors path="password" cssClass="error"/><br/>

    <input type="submit" value="Register">
</sf:form>
</body>
</html>
