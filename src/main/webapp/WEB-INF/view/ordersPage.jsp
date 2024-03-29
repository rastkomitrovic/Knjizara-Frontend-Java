<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 2/21/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Narudzbine</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
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
            <input type="text" id="search-field" placeholder="Pokušajte: Tolkin">
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

<c:choose>
    <c:when test="${!isEmpty}">
        <h1 class="search-result-heading">Pronadjeno je ukupno: ${totalNumberOfFoundElements}</h1>
        <section class="products-wrapper products-wrapper-search">
            <c:forEach items="${orders}" var="order">
                <div class="single-order">
                    <div class="single-order-overview">
                        <p class="overview-date">Datum: <fmt:formatDate value="${order.dateCreated}" pattern="dd-MM-yyyy"/></p>
                        <p class="overview-total">Vrednost: ${order.total}</p>
                        <button class="details-info-cta" style="margin-top: 0!important;" onclick="showDetails(${order.orderId})" id="order-btn-${order.orderId}">Prikaži</button>
                    </div>
                <div id="${order.orderId}" style="display: none;">
                    <c:forEach items="${order.orderItems}" var="item">
                        <div class="single-order-details" >
                            <div class="image-wrapper"}">
                                <img src="${item.book.images.get(0).imageUrl}" class="order-details-image"/>
                            </div>
                            <a href="${pageContext.request.contextPath}/p/${item.book.bookId}"
                               class="order-details-name">${item.book.bookName}</a>
                            <p class="order-details-quantity">Količina: ${item.quantity}</p>
                            <p class="order-details-price">Cena: ${item.book.price}</p>
                            <p class="order-details-total">Ukupno: ${item.book.price * item.quantity}</p>
                        </div>
                    </c:forEach>
                </div>

                </div>
            </c:forEach>
        </section>
        <div class="pages-navigation">
            <c:if test="${totalPages>1}">
                <form:form onsubmit="return checkPrevious()" style="display: inline"
                           action="${pageContext.request.contextPath}/orders/${currentPage-1}/${size}/${sort}"
                           method="get">
                    <button type="submit" class="results-prevnext-btn"><i class="fa fa-chevron-left"
                                                                          id="previous-btn"></i></button>
                </form:form>
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <form:form onsubmit="return checkCurrent(${i-1})" style="display: inline"
                               action="${pageContext.request.contextPath}/orders/${i-1}/${size}/${sort}"
                               method="get">
                        <c:choose>
                            <c:when test="${i-1 eq currentPage}">
                                <button disabled class="results-nav-btn-bold">
                                        ${i}
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="results-nav-btn">
                                        ${i}
                                </button>
                            </c:otherwise>
                        </c:choose>
                    </form:form>
                </c:forEach>
                <form:form onsubmit="return checkNext()" style="display: inline"
                           action="${pageContext.request.contextPath}/orders/${currentPage+1}/${size}/${sort}"
                           method="get">
                    <button type="submit" class="results-prevnext-btn" id="next-btn"><i class="fa fa-chevron-right"></i>
                    </button>
                </form:form>
            </c:if>
        </div>
    </c:when>

    <c:otherwise>
        <h1 class="search-result-heading">Nije pronadjena nijedna narudzbina za vas nalog</h1>
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
<script src="${pageContext.request.contextPath}/js/ordersPage.js"></script>
</body>
</html>
