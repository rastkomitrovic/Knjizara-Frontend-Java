<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 1/9/2021
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Dodaj autora</title>
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

<section style="width: 90%; margin: 0 auto; display: flex; flex-direction: column; align-items: center; min-height: 70vh">

    <form:form modelAttribute="author" method="post" cssClass="change-profile-info" action="/saveAuthor">
        <div class="form-control">
            <label for="name">Ime: </label>
            <form:input path="firstName" id="name"/>
        </div>
        <div class="form-control">
            <label for="middleName">Srednje ime:</label>
            <form:input path="middleName" id="middleName"/>
        </div>
        <div class="form-control">
            <label for="lastName">Prezime:</label>
            <form:input path="lastName" id="lastName"/>
        </div>
        <div class="form-control">
            <label for="dateOfBirth">Datum rodjenja:</label>
            <form:input type="date" path="dateOfBirth" id="dateOfBirth"/>
        </div>
        <div class="form-control">
            <label for="description">Opis: </label>
            <form:textarea path="description" id="description"/>
        </div>

        <div class="form-buttons">
            <form:button type="submit" class="register-form-btn">Dodaj autora</form:button>
        </div>
    </form:form>

</section>

<footer class="web-footer">
    <div class="footer-icons">
        <i class="fa fa-instagram"></i>
        <i class="fa fa-facebook"></i>
        <i class="fa fa-linkedin"></i>
    </div>
    <a href="${pageContext.request.contextPath}/stores">Voliš miris knjiga? Poseti naše radnje!</a>
</footer>

</body>
</html>