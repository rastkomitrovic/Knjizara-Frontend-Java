<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 1/2/2021
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Knjižara: O nama!</title>
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

<section class="about-us">
    <h1 class="about-us-header">O nama</h1>
    <p class="about-us-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur id velit lacinia,
        aliquet odio eget, porttitor justo. Suspendisse luctus mauris nec dolor luctus, convallis hendrerit justo
        vestibulum. Nam velit risus, ornare ut ligula ut, mollis egestas erat. Interdum et malesuada fames ac ante ipsum
        primis in faucibus. Ut nec tincidunt nunc. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
        per inceptos himenaeos. Suspendisse varius fermentum tortor, vitae dictum lorem lobortis at. Sed nec mollis
        neque. Sed tincidunt massa vitae nisi tincidunt hendrerit. Vestibulum commodo, dolor at lacinia tempus, purus
        arcu consectetur eros, ut gravida augue mi eget dui. Fusce tincidunt sapien mauris, id ultrices tortor mollis
        egestas. Quisque velit urna, interdum a turpis nec, gravida venenatis odio. Phasellus condimentum efficitur est.
        Mauris a bibendum diam, vitae interdum magna. Etiam bibendum congue tellus, vitae suscipit sem cursus
        ullamcorper. Nunc a nisi mollis, egestas erat in, ullamcorper odio.
    </p>
    <p class="about-us-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur id velit lacinia,
        aliquet odio eget, porttitor justo. Suspendisse luctus mauris nec dolor luctus, convallis hendrerit justo
        vestibulum. Nam velit risus, ornare ut ligula ut, mollis egestas erat. Interdum et malesuada fames ac ante ipsum
        primis in faucibus. Ut nec tincidunt nunc. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
        per inceptos himenaeos. Suspendisse varius fermentum tortor, vitae dictum lorem lobortis at. Sed nec mollis
        neque. Sed tincidunt massa vitae nisi tincidunt hendrerit. Vestibulum commodo, dolor at lacinia tempus, purus
        arcu consectetur eros, ut gravida augue mi eget dui. Fusce tincidunt sapien mauris, id ultrices tortor mollis
        egestas. Quisque velit urna, interdum a turpis nec, gravida venenatis odio. Phasellus condimentum efficitur est.
        Mauris a bibendum diam, vitae interdum magna. Etiam bibendum congue tellus, vitae suscipit sem cursus
        ullamcorper. Nunc a nisi mollis, egestas erat in, ullamcorper odio.
    </p>
    <p class="about-us-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur id velit lacinia,
        aliquet odio eget, porttitor justo. Suspendisse luctus mauris nec dolor luctus, convallis hendrerit justo
        vestibulum. Nam velit risus, ornare ut ligula ut, mollis egestas erat. Interdum et malesuada fames ac ante ipsum
        primis in faucibus. Ut nec tincidunt nunc. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
        per inceptos himenaeos. Suspendisse varius fermentum tortor, vitae dictum lorem lobortis at. Sed nec mollis
        neque. Sed tincidunt massa vitae nisi tincidunt hendrerit. Vestibulum commodo, dolor at lacinia tempus, purus
        arcu consectetur eros, ut gravida augue mi eget dui. Fusce tincidunt sapien mauris, id ultrices tortor mollis
        egestas. Quisque velit urna, interdum a turpis nec, gravida venenatis odio. Phasellus condimentum efficitur est.
        Mauris a bibendum diam, vitae interdum magna. Etiam bibendum congue tellus, vitae suscipit sem cursus
        ullamcorper. Nunc a nisi mollis, egestas erat in, ullamcorper odio.
    </p>
    <h1 class="about-us-header">Naš prostor</h1>
    <div class="gallery">
        <figure class="gallery__item gallery__item--1">
            <img src="https://images.pexels.com/photos/1370295/pexels-photo-1370295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="Gallery image 1" class="gallery__img">
        </figure>
        <figure class="gallery__item gallery__item--2">
            <img src="https://images.pexels.com/photos/1106468/pexels-photo-1106468.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="Gallery image 2" class="gallery__img">
        </figure>
        <figure class="gallery__item gallery__item--3">
            <img src="https://images.pexels.com/photos/1370298/pexels-photo-1370298.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="Gallery image 3" class="gallery__img">
        </figure>
        <figure class="gallery__item gallery__item--4">
            <img src="https://images.pexels.com/photos/351265/pexels-photo-351265.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="Gallery image 4" class="gallery__img">
        </figure>
        <figure class="gallery__item gallery__item--5">
            <img src="https://images.pexels.com/photos/2128249/pexels-photo-2128249.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="Gallery image 5" class="gallery__img">
        </figure>
        <figure class="gallery__item gallery__item--6">
            <img src="https://images.pexels.com/photos/1907785/pexels-photo-1907785.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="Gallery image 6" class="gallery__img">
        </figure>
    </div>
</section>

<footer class="web-footer">
    <div class="footer-icons">
        <i class="fa fa-instagram"></i>
        <i class="fa fa-facebook"></i>
        <i class="fa fa-linkedin"></i>
    </div>
    <a href="${pageContext.request.contextPath}/stores">Voliš miris knjiga? Poseti naše radnje!</a>
</footer>

</body>
</html>
