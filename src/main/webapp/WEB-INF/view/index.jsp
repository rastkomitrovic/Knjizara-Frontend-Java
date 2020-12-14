<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>

        <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/style.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <title>Knjizara</title>
    </head>

    <body>
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

        <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/MainPage.js"></script>
    </body>
</html>

