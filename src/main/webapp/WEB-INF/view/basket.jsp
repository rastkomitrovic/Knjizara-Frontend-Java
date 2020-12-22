<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 12/22/2020
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body class="basket-body">

<nav class="navigation">
    <div class="navigation-left">
        <p>
            <a href="${pageContext.request.contextPath}/mainPage">
                <img style="height:6vh; width: 18vh;" src="${pageContext.request.contextPath}/img/logo.png"/>
            </a>
        </p>
        <p class="navigation-element">
            <a href="">Autori</a>
        </p>
        <p class="navigation-element">
            <a href="">Knjige</a>
        </p>
        <p class="navigation-element">
            <a href="">Žanrovi</a>
        </p>
        <p class="navigation-element">
            <a href="">Prodavnice</a>
        </p>
        <p class="navigation-element">
            <a href="">O nama</a>
        </p>
        <p class="navigation-element">
            <a href="">Dodavanje korisnika</a>
        </p>
    </div>
    <div class="navigation-right">
        <div class="navigation-right-search">
            <input type="text" id="search-field" placeholder="Pokušajte: Tolkin">
            <button>
                <i class="fa fa-search"></i>
            </button>
            <div class="navigation-right-suggestions">

            </div>
        </div>
        <button class="navigation-right-toggle">
            <i class="fa fa-user"></i>
        </button>
        <section class="navigation-user-dropdown">
            <a href="${pageContext.request.contextPath}/basket">
                <i class="fa fa-shopping-cart"></i>
                <p>Korpa</p>
            </a>
            <a href="${pageContext.request.contextPath}/userProfile">
                <i class="fa fa-wrench"></i>
                <p>Podešavanja</p>
            </a>
            <a href="${pageContext.request.contextPath}/logout">
                <i class="fa fa-arrow-right"></i>
                <p>Izloguj se</p>
            </a>

        </section>
    </div>
</nav>


<section class="basket-wrapper">

</section>

<button class="basket-finalize">Naruči</button>

<footer class="web-footer">
    <i class="fa fa-instagram"></i>
    <i class="fa fa-facebook"></i>
    <i class="fa fa-linkedin"></i>
</footer>

</body>

<script src="${pageContext.request.contextPath}/js/Utils/checkAvailableQuantity.js"></script>
<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/basketPage.js"></script>

</html>
