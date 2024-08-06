<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listagem de livros</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h2 {
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Listagem de livros</h2>
        <a href="${pageContext.request.contextPath}/books/new" class="btn btn-primary">Adicionar novo livro</a>
    </div>
    <c:choose>
        <c:when test="${not empty books}">
            <table class="table table-striped table-hover mt-3">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor(a)</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/edit?id=${book.id}" class="btn btn-sm btn-warning">Editar</a>
                            <a href="${pageContext.request.contextPath}/books/delete?id=${book.id}" class="btn btn-sm btn-danger" onclick="return confirm('Você tem certeza?')">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info mt-3" role="alert">
                Nenhum livro disponível. Clique em "adicionar novo livro" para criar um.
            </div>
        </c:otherwise>
    </c:choose>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
