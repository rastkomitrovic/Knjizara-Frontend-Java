<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.fon.knjizarafrontend.dto.BookDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: Rastko
  Date: 7/23/2020
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${bestReviewBooks}" var="book">
        <h1> ${book.bookName}</h1>
        <br>

        <h2>${book.price}</h2>
        <br>

        <p>Images</p>
        <br>
        <c:forEach items="${book.images}" var="image">
            <c:if test="${image.imageUrl ne null}">
                <img src="${image.imageUrl}">
            </c:if>
            <c:if test="${image.imageUrl ne null}">
                <img src="${image.imageEncoding}">
            </c:if>
            <br>
        </c:forEach>
        <br>

        <p>Genres</p>
        <br>
        <c:forEach items="${book.genres}" var="genre">
            <p>${genre.genreName}</p>
            <br>
        </c:forEach>
        <p>Authors</p>
        <br>
        <c:forEach items="${book.authors}" var="author">
            <p>${author.firstName}</p> &nbsp <p>${author.middleName}</p> &nbsp <p>${author.lastName}</p>
            <br>
        </c:forEach>
        <p>Comments</p>
        <br>
        <c:forEach items="${book.comments}" var="comment">
            <p>By:${comment.user.username}</p>
            <br>
            <p>Text:${comment.text}</p>
            <br>
            <p>Rating:${comment.rating}</p>
            <br>
        </c:forEach>
        <br>
        <p>Book overal rating:${book.rating}</p>
    </c:forEach>
</body>
</html>
