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
                <a href="${pageContext.request.contextPath}/orders/0/5/dateCreated">Pregledaj narudzbine</a>
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

<section class="index-wrapper">

    <section class="genres-wrapper">
        <h3>Pretražuj po:
            <select id="genres-or-authors">
                <option value="1" selected="selected">žanru</option>
                <option value="2">autorima</option>
            </select>
        </h3>
        <div id="main-genres">
            <c:forEach var="genre" items="${genres}">
                <a href="${pageContext.request.contextPath}/search/0/15/bookName/Genre/${genre.genreId}">${genre.genreName}</a>
            </c:forEach>
        </div>
       <div id="main-authors">
           <sec:authorize access="hasAuthority('ADMIN')">
               <c:forEach var="author" items="${authors}">
                   <a onclick="openModal(${author.authorId} , '${author.firstName}' , '${author.lastName}')">${author.firstName} ${author.middleName} ${author.lastName}</a>
               </c:forEach>
           </sec:authorize>
           <sec:authorize access="hasAuthority('USER')">
               <c:forEach var="author" items="${authors}">
                   <a href="${pageContext.request.contextPath}/search/0/15/bookName/Author/${author.authorId}">${author.firstName} ${author.middleName} ${author.lastName}</a>
               </c:forEach>
           </sec:authorize>
       </div>

    </section>

    <section class="products-wrapper products-wrapper-main">
        <c:forEach items="${books}" var="book">
            <div class="product-card product-card-main">
                <c:if test="${book.images.size() ge 1}">
                    <img src="${book.images.get(0).imageUrl}" class="product-card-img"/>
                </c:if>
                <div class="product-card-name-review">
                    <h2 class="product-card-name">${book.bookName}</h2>
                    <p class="product-card-review"><i class="fa fa-star" aria-hidden="true"></i>${book.rating}</p>
                </div>
                <h4 class="product-card-author">
                    <c:forEach items="${book.authors}" var="author">
                        <p>${author.firstName} ${author.middleName} ${author.lastName}</p>
                        <br>
                    </c:forEach>
                </h4>
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
    <div class="footer-icons">
        <i class="fa fa-instagram"></i>
        <i class="fa fa-facebook"></i>
        <i class="fa fa-linkedin"></i>
    </div>
    <a href="${pageContext.request.contextPath}/stores">Voliš miris knjiga? Poseti naše radnje!</a>
</footer>

<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/GenresAuthorNavigationScript.js"></script>
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
