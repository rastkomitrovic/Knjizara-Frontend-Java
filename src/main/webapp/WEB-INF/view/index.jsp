<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Knjizara</title>
</head>

<body class="index-body">
<nav class="navigation">
    <div class="navigation-left">
        <p>
            <a href="${pageContext.request.contextPath}/mainPage">
                <img style="height:6vh; width: 18vh;"src="${pageContext.request.contextPath}/img/logo.png"/>
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
            <input type="text" id="search-field" placeholder="Pokušajte: Tolkin" >
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

<section class="index-wrapper">

    <section class="genres-wrapper">
        <h3>Pretražuj po žanrovima</h3>
        <c:forEach var="genre" items="${genres}">
            <a href="${pageContext.request.contextPath}/search/0/15/bookName/Genre/${genre.genreId}">${genre.genreName}</a>
        </c:forEach>
        <!--<a href="">Genre 1</a>
        <a href="">Genre 1</a>
        <a href="">Genre 1</a>
        <a href="">Genre 1</a>
        <a href="">Genre 1</a>
        <a href="">Genre 1</a>-->
    </section>

    <section class="products-wrapper">
        <c:forEach items="${books}" var="book">
            <div class="product-card">
                <c:if test="${book.images.size() ge 1}">
                    <img src="${book.images.get(0).imageUrl}" class="product-card-img"/>
                </c:if>
                <div class="product-card-name-review">
                    <h2 class="product-card-name">${book.bookName}</h2>
                    <p class="product-card-review"><i class="fa fa-star" aria-hidden="true"></i>${book.rating}</p>
                </div>
                <h4 class="product-card-author">
                    <c:forEach items="${book.authors}" var="author">
                        <p>${author.firstName} &nbsp; ${author.middleName} &nbsp; ${author.lastName}</p>
                        <br>
                    </c:forEach>
                </h4>
                <h6 class="product-card-isbn">${book.ISBN}</h6>
                <div class="product-card-price-details">
                    <p class="product-card-price">${book.price}</p>
                    <a href="${pageContext.request.contextPath}/p/${book.bookId}">
                        <button class="product-card-details">Detalji</button>
                    </a>
                </div>
            </div>
        </c:forEach>
    </section>

</section>



<footer class="web-footer">
    <i class="fa fa-instagram"></i>
    <i class="fa fa-facebook"></i>
    <i class="fa fa-linkedin"></i>
</footer>

<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
</body>
</html>


<!--
<section class="products-wrapper">
<div class="product-card">
<img src="https://www.laguna.rs/_img/korice/4175/zlocin_i_kazna-fjodor_mihailovic_dostojevski_v.jpg" class="product-card-img"/>
<div class="product-card-name-review">
<h2 class="product-card-name">Ime knjige</h2>
<p class="product-card-review">4.6</p>
</div>
<h4 class="product-card-author">Autor</h4>
<h6 class="product-card-isbn">ISBN broj</h6>
<div class="product-card-price-details">
<p class="product-card-price">499,99</p>
<button class="product-card-details">Detalji</button>
</div>
</div>
</section>
-->
