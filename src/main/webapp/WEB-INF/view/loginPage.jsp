<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 12/8/2020
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<form:form action="${pageContext.request.contextPath}/performLogin" modelAttribute="user" method="POST" onsubmit="return check()">
    <label for="username">Korisnicko ime</label>
    <form:input path="username" id="username"/>
    <br><br>
    <label for="password">Lozinka</label>
    <form:password showPassword="true" path="password" id="password"/>
    <button type="submit" id="loginButton">Uloguj se</button>
    <br><br>
</form:form>

<a href="${pageContext.request.contextPath}/newUser">Nov korisnik? Registrujte se!</a>

<label id="errorMessage" class="loginErrorMessage">
    <c:if test="${message ne null}">
        <p>${message}</p>
    </c:if>
</label>

<script type="application/javascript" lang="javascript" src="${pageContext.request.contextPath}/js/LoginScript.js"></script>
</body>

</html>
