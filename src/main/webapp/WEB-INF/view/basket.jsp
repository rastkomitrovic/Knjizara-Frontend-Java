<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 12/22/2020
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- Ensures optimal rendering on mobile devices. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Korpa</title>
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

<section class="basket-wrapper">

</section>
<section class="order-checkout">
    <div id="paypal-button-container"></div>
</section>

<button class="basket-finalize">Naruči</button>

<footer class="web-footer">
    <div class="footer-icons">
        <i class="fa fa-instagram"></i>
        <i class="fa fa-facebook"></i>
        <i class="fa fa-linkedin"></i>
    </div>
    <a href="${pageContext.request.contextPath}/stores">Voliš miris knjiga? Poseti naše radnje!</a>
</footer>

<script src="https://www.paypal.com/sdk/js?client-id=ASCfT8ZkLed2x1tBOjsjHza0z7vTj2zkaw5nMeEbufNY5LF4zmY7mMpQKTEuvI8mE1o7Bah3Q1O3lx2I"></script>

<script>
    paypal.Buttons({
        createOrder: function(data, actions) {
            let price= JSON.parse(localStorage.getItem("totalSum"))
            return actions.order.create({
                purchase_units: [{
                    amount: {
                        value: price
                    }
                }]
            });
        },
        onApprove: function(data, actions) {
            // This function captures the funds from the transaction.
            return actions.order.capture().then(function(details) {
                // This function shows a transaction success message to your buyer.
                localStorage.setItem("details", JSON.stringify(details))
                window.location = "http://localhost:9099/mainPage"
                alert('Transaction completed by ' + details.payer.name.given_name + " amount "+details.amount);
            });
        }
    }).render('#paypal-button-container');
    //This function displays Smart Payment Buttons on your web page.
</script>
</body>
<script src="${pageContext.request.contextPath}/js/Utils/checkAvailableQuantity.js"></script>
<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/basketPage.js"></script>

</html>
