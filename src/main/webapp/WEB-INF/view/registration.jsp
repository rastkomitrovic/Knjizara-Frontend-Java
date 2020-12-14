<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 12/12/2020
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registracija</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/register" modelAttribute="user" method="POST" onsubmit="return check()">
        <label for="username">Korisnicko ime</label>
        <form:input path="username" id="username"/>
        <p id="errorUsername"></p>
        <br><br>
        <label for="password">Lozinka</label>
        <form:password path="password" showPassword="true" id="password" />
        <p id="errorPassword"></p>
        <br><br>
        <label for="repeatPassword">Ponovite lozinku</label>
        <input type="password" id="repeatPassword"/>
        <p id="errorRepeatPassword"></p>
        <br><br>
        <label for="name" >Ime</label>
        <form:input path="name" id="name"/>
        <p id="errorName"></p>
        <br><br>
        <label for="lastName">Prezime</label>
        <form:input path="lastName" id="lastName"/>
        <p id="errorLastName"></p>
        <br><br>
        <label for="email">Email</label>
        <form:input path="email"/>
        <p id="errorEmail"></p>
        <br><br>
        <label for="phone">Telefon</label>
        <form:input path="phone"/>
        <p id="errorPhone"></p>
        <br><br>
        <label for="address">Adresa</label>
        <form:input path="address"/>
        <p id="errorAddress"></p>
        <br><br>
        <label for="dateOfBirth">Datum rodjenja</label>
        <form:input type="date" path="dateOfBirth" cssClass="date-picker"/>
        <p id="errorDateOfBirth"></p>
        <br><br>
        <label for="city">Grad</label>
        <form:select path="city" items="${cities}" itemLabel="cityName" itemValue="cityId"/>
        <form:button type="submit">Registruj se</form:button>
    </form:form>
    <c:if test="${errorMessage ne null}">
        <p>${errorMessage}</p>
    </c:if>
    <script src="${pageContext.request.contextPath}/js/RegisterScript.js"></script>
</body>
</html>
