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

<section class="product-details">
        <section class="slideshow-container">
            <!-- Full-width images with number and caption text -->
            <c:forEach begin="0" end="${book.images.size()}" var="i">
                <div class="mySlides fade" id="${i}">
                    <div class="numbertext">${i}/${book.images.size()}</div>
                    <img src="${book.images.get(i)}" style="width:100%;"/>
                </div>
            </c:forEach>
            <!-- Next and previous buttons -->
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
        <br>
        <!-- The dots/circles -->
        <div style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
        </div>
    </section>

    <section class="product-details-info">
        <p class="details-info-name">Naziv: Ime knjige</p>
        <div class="details-info-authors">
            <p>Autori:</p>
            <c:choose>
                <c:when test="${book.authors.size()>=2}">
                    <c:forEach var="author" items="${book.authors.subList(0,book.authors.size()-1)}">
                        <a href="" class="details-info-author">
                            <p>${author.toString()}, </p>
                        </a>
                    </c:forEach>
                        <a href="" class="details-info-author">
                            <p>${book.authors.get(book.authors.size()-1).toString()}</p>
                        </a>
                </c:when>
                <c:otherwise>
                    <a href="" class="details-info-author">
                        <p>${book.authors.get(0).toString()}</p>
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="details-info-genres">
            <p>Žanrovi: </p>
            <c:choose>
                <c:when test="${book.genres.size()>=2}">
                    <c:forEach var="genre" items="${book.genres.subList(0,book.genres.size()-1)}">
                        <a href="" class="details-info-genre">
                            <p>${genre.toString()}, </p>
                        </a>
                    </c:forEach>
                    <a href="" class="details-info-genre">
                        <p>${book.genre.get(book.genres.size()-1).toString()}</p>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="" class="details-info-genre">
                        <p>${book.genres.get(0).toString()}</p>
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
        <p class="details-info-lang">Jezik: ${book.language.toString()}</p>
        <p class="details-info-about">${book.description}</p>
        <p class="details-info-rating">Ocena: ${book.rating}</p>
        <button class="details-info-cta">Dodaj u korpu</button>
    </section>
</section>

<section class="product-details-comments">
    <c:forEach var="comment" items="${book.comments}">
        <div class="details-single-comment">
            <p class="single-comment-user">${comment.user.username}</p>
            <p class="single-comment-stars">${comment.rating}<i class="fa fa-star"></i></p>
            <p class="single-comment-review">${comment.text}</p>
        </div>
    </c:forEach>
</section>

<script src="${pageContext.request.contextPath}/js/ProductDetailPageScript.js"></script>
<script src="${pageContext.request.contextPath}/js/SearchResultPageScript.js"></script>
</body>
</html>



