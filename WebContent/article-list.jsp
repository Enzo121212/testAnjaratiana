<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
<html>
<head>
    <title>Liste des Articles</title>
</head>
<body>
    <h1>Liste des Articles</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom de l'Article</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="article" items="${articles}">
            <tr>
                <td>${article.id}</td>
                <td>${article.article}</td>
                <td>
                    <a href="articles?action=edit&id=${article.id}">Modifier</a>
                    <a href="articles?action=delete&id=${article.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Ajouter/Modifier un Article</h2>

    <form action="articles" method="post">
        <input type="hidden" name="action" value="${article.id == null ? 'create' : 'update'}">
        <input type="hidden" name="id" value="${article.id}">
        Nom de l'Article: <input type="text" name="articleName" value="${article.article}">
        <input type="submit" value="${article.id == null ? 'Ajouter' : 'Modifier'}" >
    </form>
</body>
</html>
    