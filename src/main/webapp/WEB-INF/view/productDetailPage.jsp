<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<section class="product-details">
    <section class="slideshow-container">
        <!-- Full-width images with number and caption text -->
        <c:forEach begin="0" end="${book.images.size()-1}" var="i">
            <div class="mySlides fade" id="${i}">
                <img src="${book.images.get(i).imageUrl}" style="width:100%;"/>
            </div>
        </c:forEach>
        <!-- Next and previous buttons -->
        <c:if test="${book.images.size()>1}">
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
            <br>
            <!-- The dots/circles -->
            <div style="text-align:center">
                <c:forEach var="i" begin="0" end="${book.images.size()-1}">
                    <span class="dot" onclick="currentSlide(${i}+1)"></span>
                </c:forEach>
            </div>
        </c:if>
    </section>

    <section class="product-details-info">
        <p class="details-info-name">Naziv: ${book.bookName}</p>
        <p class="details-info-publisher">ISBN: ${book.ISBN}</p>
        <div class="details-info-authors">
            <p style="color: var(--color-accent)">Autori:</p>
            <c:choose>
                <c:when test="${book.authors.size()>=2}">
                    <c:forEach var="author" items="${book.authors.subList(0,book.authors.size()-1)}">
                        <a href="${pageContext.request.contextPath}/search/0/15/bookName/Author/${author.authorId}"
                           class="details-info-author">
                            <p>${author.toString()}, </p>
                        </a>
                    </c:forEach>
                    <a href="${pageContext.request.contextPath}/search/0/15/bookName/Author/${book.authors.get(book.authors.size()-1).authorId}"
                       class="details-info-author">
                        <p>${book.authors.get(book.authors.size()-1).toString()}</p>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/search/0/15/bookName/Author/${book.authors.get(0).authorId}"
                       class="details-info-author">
                        <p>${book.authors.get(0).toString()}</p>
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
        <p class="details-info-publisher">
            <span style="color: var(--color-accent); font-size: 1.5rem">Izdavac:</span>
            <a href="${pageContext.request.contextPath}/search/0/15/bookName/Publisher/${book.publisher.publisherId}">${book.publisher.publisherName}</a>
        </p>
        <div class="details-info-genres">
            <p style="color: var(--color-accent)">Žanrovi: </p>
            <c:choose>
                <c:when test="${book.genres.size()>=2}">
                    <c:forEach var="genre" items="${book.genres.subList(0,book.genres.size()-1)}">
                        <a href="${pageContext.request.contextPath}/search/0/15/bookName/Genre/${genre.genreId}"
                           class="details-info-genre">
                            <p>${genre.toString()}, </p>
                        </a>
                    </c:forEach>
                    <a href="${pageContext.request.contextPath}/search/0/15/bookName/Genre/${book.genres.get(book.genres.size()-1).genreId}"
                       class="details-info-genre">
                        <p>${book.genres.get(book.genres.size()-1).toString()}</p>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/search/0/15/bookName/Genre/${book.genres.get(0).genreId}"
                       class="details-info-genre">
                        <p>${book.genres.get(0).toString()}</p>
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
        <p class="details-info-lang"><span
                style="color: var(--color-accent); font-size: 1.5rem">Jezik:</span> ${book.language.toString()}</p>
        <p class="details-info-about"><span
                style="color: var(--color-accent); font-size: 1.5rem">Opis:</span> ${book.description}</p>
        <p class="details-info-lang"><span
                style="color: var(--color-accent); font-size: 1.5rem">Cena:</span> ${book.price}</p>
        <p class="details-info-rating"><span
                style="color: var(--color-accent); font-size: 1.5rem">Ocena:</span> ${book.rating}</p>
        <label for="input-quantity" class="quantity-label">Količina:</label>
        <input id="input-quantity" value="1">
        <button class="details-info-cta" style="display: block;" onclick="addToBasket(${book.bookId})">Dodaj u korpu
        </button>
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

<button class="comments-load-more" onclick="loadMoreComments(${bookId})">Još komentara</button>

<section class="product-details-new-comment">
    <form:form cssClass="new-comment-form" method="post" modelAttribute="comment"
               action="${pageContext.request.contextPath}/p/postComment">
        <label for="new-comment" class="new-comment-label">Ostavi komentar:</label>
        <form:hidden path="bookId"/>
        <form:hidden path="username"/>
        <form:textarea path="text" cssClass="comment-text" rows="4" cols="50" id="new-comment"/>
        <form:select path="rating" cssClass="comment-review" items="${availableRatingsInts}"/>
        <button type="submit" class="details-info-cta">Postavi komentar</button>
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

<script>
    let numOfComments = ${book.comments.size()}
</script>
<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/Utils/checkAvailableQuantity.js"></script>
<script src="${pageContext.request.contextPath}/js/ProductDetailPageScript.js"></script>
</body>
</html>



