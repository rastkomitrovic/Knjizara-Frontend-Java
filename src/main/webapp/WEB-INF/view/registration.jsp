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
<body class="login-body">
<form:form cssClass="login-page" action="${pageContext.request.contextPath}/register" modelAttribute="user"
           method="POST" onsubmit="return check()">
    <div id="form-section-1">
        <div class="form-control">
            <label for="username">Korisnicko ime:</label>
            <form:input path="username" id="username"/>
        </div>
        <p id="errorUsername"></p>
        <div class="form-control">
            <label for="password">Lozinka:</label>
            <form:password path="password" showPassword="true" id="password"/>
        </div>
        <p id="errorPassword"></p>
        <div class="form-control">
            <label for="repeatPassword">Ponovite lozinku:</label>
            <input type="password" id="repeatPassword"/>
        </div>
        <p id="errorRepeatPassword"></p>
        <button type="button" onclick="showNext(2)" class="next-btn first-btn">Sledeće</button>
    </div>
    <div id="form-section-2">
        <div class="form-control">
            <label for="name">Ime:</label>
            <form:input path="name" id="name"/>
        </div>
        <p id="errorName"></p>
        <div class="form-control">
            <label for="lastName">Prezime:</label>
            <form:input path="lastName" id="lastName"/>
        </div>
        <p id="errorLastName"></p>
        <div class="form-control">
            <label for="email">Email:</label>
            <form:input path="email"/>
        </div>
        <p id="errorEmail"></p>
        <div class="form-buttons">
            <button type="button" onclick="showNext(1)" class="previous-btn">Prethodno</button>
            <button type="button" onclick="showNext(3)" class="next-btn">Sledeće</button>
        </div>
    </div>
    <div id="form-section-3">
        <div class="form-control">
            <label for="phone">Telefon:</label>
            <form:input path="phone"/>
        </div>
        <p id="errorPhone"></p>
        <div class="form-control">
            <label for="address">Adresa:</label>
            <form:input path="address"/>
        </div>
        <p id="errorAddress"></p>
        <div class="form-control">
            <label for="dateOfBirth">Datum rodjenja:</label>
            <form:input type="date" path="dateOfBirth" cssClass="date-picker"/>
        </div>
        <p id="errorDateOfBirth"></p>
        <div class="form-control">
            <label for="city">Grad:</label>
            <form:select cssClass="" path="city" items="${cities}" itemLabel="cityName" itemValue="cityId"/>
        </div>
        <div class="form-buttons">
            <button type="button" onclick="showNext(2)" class="previous-btn">Prethodno</button>
            <form:button type="submit" class="register-form-btn">Registruj se</form:button>
        </div>

    </div>
</form:form>
<c:if test="${errorMessage ne null}">
    <p>${errorMessage}</p>
</c:if>
<script src="${pageContext.request.contextPath}/js/RegisterScript.js"></script>
</body>
</html>
