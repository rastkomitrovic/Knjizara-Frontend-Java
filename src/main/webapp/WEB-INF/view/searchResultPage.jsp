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
    <ul class="navigation-left">
        <li class="navigation-element">
            <a>Autori</a>
        </li>
        <li class="navigation-element">
            <a>Knjige</a>
        </li>
        <li class="navigation-element">
            <a>Žanrovi</a>
        </li>
        <li class="navigation-element">
            <a>Prodavnice</a>
        </li>
        <li class="navigation-element">
            <a>O nama</a>
        </li>
        <li class="navigation-element">
            <a>Dodavanje korisnika</a>
        </li>
    </ul>
    <div class="navigation-right">
        <button class="toggle">
            <i class="glyphicon glyphicon-user user-icon"></i>
        </button>
        <section class="navigation-user-dropdown">
            <i class="glyphicon glyphicon-shopping-cart"></i>
            <i class="glyphicon glyphicon-wrench"></i>
        </section>
    </div>

</nav>


<c:choose>
    <c:when test="${!isEmpty}">
        <h1>Pronadjeno je ukupno: ${totalNumberOfFoundElements}</h1>
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
                        <p>${book.authors.get(0).firstName} ${book.authors.get(0).middleName} ${book.authors.get(0).lastName}
                        <c:if test="${book.authors.size()>1}">
                            i drugi
                        </c:if>
                        </p>
                    </h4>
                    <h6 class="product-card-isbn">${book.ISBN}</h6>
                    <div class="product-card-price-details">
                        <p class="product-card-price">${book.price}</p>
                        <button class="product-card-details">Detalji</button>
                    </div>
                </div>
            </c:forEach>
        </section>
        <div class="pages-navigation">
            <form:form onsubmit="return checkPrevious()" style="display: inline" action="${pageContext.request.contextPath}/search/${currentPage-1}/${size}/${sort}/${searchParam}" method="get">
                <button type="submit" class="results-prevnext-btn"><i class="fa fa-chevron-left" id="previous-btn"></i></button>
            </form:form>
            <c:forEach var="i" begin="1" end="${totalPages}">
                <form:form onsubmit="return checkCurrent(${i-1})" style="display: inline" action="${pageContext.request.contextPath}/search/${i-1}/${size}/${sort}/${searchParam}" method="get">
                    <button type="submit" class="results-nav-btn">
                            ${i}
                    </button>
                </form:form>
            </c:forEach>
            <form:form onsubmit="return checkNext()" style="display: inline" action="${pageContext.request.contextPath}/search/${currentPage+1}/${size}/${sort}/${searchParam}" method="get">
                <button type="submit" class="results-prevnext-btn" id="next-btn"><i class="fa fa-chevron-right"></i></button>
            </form:form>

        </div>
    </c:when>

    <c:otherwise>
        <h1 class="no-books-found">Nije pronadjena nijedna knjiga po zadatom kriterijumu</h1>
    </c:otherwise>
</c:choose>

<script>
    const isFirst=${isFirst};
    const isLast=${isLastPage};
    const currentPage=${currentPage}

</script>
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
