<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Dodaj knjigu</title>
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

<section style="width: 90%; margin: 0 auto; display: flex; flex-direction: column; align-items: center; min-height: 70vh; font-size: 1.5rem">

    <form:form modelAttribute="book" cssClass="change-profile-info" action="/saveBook" method="post">
        <div class="form-control">
            <label for="newIsbn">ISBN: </label>
            <form:input path="isbn" id="newIsbn"/>
        </div>
        <div class="form-control">
            <label for="newBookName">Naziv knjige: </label>
            <form:input path="bookName" id="newBookName"/>
        </div>
        <div class="form-control">
            <label for="newBookDescription">Kratak opis: </label>
            <form:textarea path="description" id="newBookDescription" />
        </div>
        <div class="form-control">
            <label for="newPrice">Cena po komadu:</label>
            <form:input path="price" id="newPrice"/>
        </div>
        <div class="form-control">
            <label for="newStock">Kolicina na stanju:</label>
            <form:input path="stock" id="newStock"/>
        </div>
        <div class="form-control" id="images">
            <label for="newImages">Slike:</label>
            <div class="more-images">
                <form:input path="images" id="newImages"/>
            </div>

        </div>
        <button class="put-element-right" id="add-images-button">Dodaj još slika</button>
        <div class="form-control">
            <label for="language">Jezik:</label>
            <form:select path="language" id="language" items="${languages}"/>
        </div>

        <div style="display: flex; justify-content: center">
            <div class="genres-wrapper genres-wrapper-mod">
                <c:forEach items="${genres}" var="genre">
                    <li>
                        <form:checkbox cssClass="single-checkbox" path="genres" id="${genre.genreId}" value="${genre.genreId}"/>
                        <label for="${genre.genreId}">${genre.genreName}</label>
                    </li>
                    </c:forEach>
            </div>

            <div class="genres-wrapper genres-wrapper-mod">
                <c:forEach items="${authors}" var="author">
                    <li>
                        <form:checkbox cssClass="single-checkbox" path="authors" value="${author.authorId}" id="${author.authorId}"/>
                        <label for="${author.authorId}">${author.toString()}</label>
                    </li>

                </c:forEach>
            </div>
        </div>


        <div class="form-control">
            <label for="publisher">Izdavač: </label>
            <form:select path="publisher" items="${publishers}" itemLabel="publisherName" itemValue="publisherId"/>
        </div>


        <div class="form-buttons">
            <form:button type="submit" class="register-form-btn">Dodaj knjigu</form:button>
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
<script>
    let errorMessage="";
    errorMessage = `${errorMessage}`;
</script>
<script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
<script src="${pageContext.request.contextPath}/js/NewBookScript.js"></script>

</body>
</html>
