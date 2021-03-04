<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Izmena naloga</title>
</head>

<body class="index-body">
<nav class="navigation">
    <div class="navigation-left">
        <p>
            <a href="${pageContext.request.contextPath}/mainPage">
                <img style="height:6vh; width: 18vh;" src="${pageContext.request.contextPath}/img/logo.png"/>
            </a>
        </p>
        <p class="navigation-element">
            <a href="${pageContext.request.contextPath}/search/0/15/bookName/All/all">Knjige</a>
        </p>
        <p class="navigation-element">
            <a href="${pageContext.request.contextPath}/aboutUs">O nama</a>
        </p>
        <sec:authorize access="hasAuthority('ADMIN')">
            <p class="navigation-element">
                <a href="${pageContext.request.contextPath}/addNewUser">Dodaj korisnika</a>
            </p>
        </sec:authorize>
        <sec:authorize access="hasAuthority('ADMIN')">
            <p class="navigation-element">
                <a href="${pageContext.request.contextPath}/newBook">Dodaj knjigu</a>
            </p>
        </sec:authorize>
        <sec:authorize access="hasAuthority('ADMIN')">
            <p class="navigation-element">
                <a href="${pageContext.request.contextPath}/newAuthor">Dodaj autora</a>
            </p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p class="navigation-element">
                <a href="${pageContext.request.contextPath}/orders/0/15/dateCreated">Pregledaj narudzbine</a>
            </p>
        </sec:authorize>
    </div>
    <div class="navigation-right">
        <div class="navigation-right-search">
            <input type="text" id="search-field" placeholder="Pokušajte: Tolkin" >
            <a href="" id="search-results-page-link">
                <button>
                    <i class="fa fa-search"></i>
                </button>
            </a>
            <div class="navigation-right-suggestions">

            </div>
        </div>
        <button class="navigation-right-toggle">
            <i class="fa fa-user"></i>
        </button>
        <section class="navigation-user-dropdown">
            <a href="${pageContext.request.contextPath}/basket">
                <i class="fa fa-shopping-cart"></i> <p>Korpa</p>
            </a>
            <a href="${pageContext.request.contextPath}/userProfile">
                <i class="fa fa-wrench"></i> <p>Podešavanja</p>
            </a>
            <a href="${pageContext.request.contextPath}/logout">
                <i class="fa fa-arrow-right"></i> <p>Izloguj se</p>
            </a>

        </section>
    </div>
</nav>

<section style="width: 90%; margin: 0 auto; display: flex; flex-direction: column; align-items: center">
    <section>
        <form:form modelAttribute="user" cssClass="change-profile-info" action="/changeUserInfo" onsubmit="return check()">
                <div class="form-control">
                    <label for="username">Korisnicko ime:</label>
                    <form:input path="username" id="username" readonly="true"/>
                </div>
                <p id="errorUsername"></p>
                <div class="form-control">
                    <label for="oldPassword">Stara lozinka:</label>
                    <form:password path="oldPassword" showPassword="true" id="oldPassword"/>
                </div>
                <p class="oldPasswordError">${errorPasswordMessage}</p>
                <div class="form-control">
                    <label for="password">Nova lozinka:</label>
                    <form:password path="password" showPassword="true" id="password"/>
                </div>
                <p id="errorPassword"></p>
                <div class="form-control">
                    <label for="repeatPassword">Ponovite lozinku:</label>
                    <input type="password" id="repeatPassword"/>
                </div>
                <p id="errorRepeatPassword"></p>
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
                    <label for="city">Grad:</label>
                    <form:select cssClass="" path="city" items="${cities}" itemLabel="cityName" itemValue="cityId"/>
                </div>
                <div class="form-buttons">
                    <form:button type="submit" class="register-form-btn">Izmeni podatke</form:button>
                </div>
        </form:form>
    </section>

</section>



<footer class="web-footer">
    <div class="footer-icons">
        <i class="fa fa-instagram"></i>
        <i class="fa fa-facebook"></i>
        <i class="fa fa-linkedin"></i>
    </div>
    <a href="${pageContext.request.contextPath}/stores">Voliš miris knjiga? Poseti naše radnje!</a>
</footer>

<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/UserProfileInfoScript.js"></script>
</body>
</html>


