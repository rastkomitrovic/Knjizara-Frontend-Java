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
    <title>Login stranica</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<form:form action="${pageContext.request.contextPath}/performLogin" modelAttribute="user" method="POST">
    Korisnicko ime <form:input path="username" id="username"/>
    <br><br>
    Sifra <form:password showPassword="true" path="password" id="password"/>
    <button type="submit" disabled id="loginButton">Uloguj se</button>
</form:form>
<c:if test="${message ne null}">
    <p class="loginErrorMessage">${message}</p>
</c:if>
<script>
    let user = ${userJSON};
</script>
<script type="application/javascript" lang="javascript" src="${pageContext.request.contextPath}/js/LoginScript.js"></script>
</body>

</html>
