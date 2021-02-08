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

<c:choose>
    <c:when test="${!isEmpty}">
        <h1 class="search-result-heading">Pronadjeno je ukupno: ${totalNumberOfFoundElements}</h1>
        <section class="products-wrapper products-wrapper-search">
            <c:forEach items="${books}" var="book">
                <div class="product-card product-card-search">
                    <c:if test="${book.images.size() ge 1}">
                        <img src="${book.images.get(0).imageUrl}" class="product-card-img"/>
                    </c:if>
                    <div class="product-card-name-review">
                        <h2 class="product-card-name">${book.bookName}</h2>
                        <p class="product-card-review"><i class="fa fa-star" aria-hidden="true"></i>${book.rating}</p>
                    </div>
                    <h4 class="product-card-author">
                        <p>${book.authors.get(0).firstName} ${book.authors.get(0).middleName} ${book.authors.get(0).lastName}
                            <c:if test="${book.authors.size()>1}">
                                i drugi
                            </c:if>
                        </p>
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
        <div class="pages-navigation">
            <c:if test="${totalPages>1}">
                <form:form onsubmit="return checkPrevious()" style="display: inline"
                           action="${pageContext.request.contextPath}/search/${currentPage-1}/${size}/${sort}/${searchType}/${searchParam}"
                           method="get">
                    <button type="submit" class="results-prevnext-btn"><i class="fa fa-chevron-left"
                                                                          id="previous-btn"></i></button>
                </form:form>
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <form:form onsubmit="return checkCurrent(${i-1})" style="display: inline"
                               action="${pageContext.request.contextPath}/search/${i-1}/${size}/${sort}/${searchType}/${searchParam}"
                               method="get">
                        <button type="submit" class="results-nav-btn">
                                ${i}
                        </button>
                    </form:form>
                </c:forEach>
                <form:form onsubmit="return checkNext()" style="display: inline"
                           action="${pageContext.request.contextPath}/search/${currentPage+1}/${size}/${sort}/${searchType}/${searchParam}"
                           method="get">
                    <button type="submit" class="results-prevnext-btn" id="next-btn"><i class="fa fa-chevron-right"></i>
                    </button>
                </form:form>
            </c:if>
        </div>
    </c:when>

    <c:otherwise>
        <h1 class="search-result-heading">Nije pronadjena nijedna knjiga po zadatom kriterijumu</h1>
    </c:otherwise>
</c:choose>

<footer class="web-footer">
    <div class="footer-icons">
        <i class="fa fa-instagram"></i>
        <i class="fa fa-facebook"></i>
        <i class="fa fa-linkedin"></i>
    </div>
    <a href="${pageContext.request.contextPath}/stores">Voliš miris knjiga? Poseti naše radnje!</a>
</footer>

<script>
    const isFirst =${isFirst};
    const isLast =${isLastPage};
    const currentPage =
    ${currentPage}

</script>
<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/SearchResultPageScript.js"></script>
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
