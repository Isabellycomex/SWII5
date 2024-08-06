<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulário de Livro</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>${book.id == null ? 'Adicionar Novo Livro' : 'Editar Livro'}</h2>
    <form action="${book == null ? 'add-book' : 'update-book'}" method="post">
        <input type="hidden" name="id" value="${book.id}" />
        <input type="hidden" name="action" value="${book.id == null ? 'insert' : 'update'}" />
        <div class="form-group">
            <label for="title">Título</label>
            <input type="text" class="form-control" id="title" name="title" value="${book.title}" required />
        </div>
        <div class="form-group">
            <label for="author">Autor(a)</label>
            <input type="text" class="form-control" id="author" name="author" value="${book.author}" required />
        </div>
        <div class="form-group">
            <label for="price">Preço</label>
            <input type="number" class="form-control" id="price" name="price" value="${book.price}" required />
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
        <a href="${pageContext.request.contextPath}/books/" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
