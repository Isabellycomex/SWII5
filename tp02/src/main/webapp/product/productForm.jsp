<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${product == null ? "Adicionar novo produto" : "Editar produto"}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>${product == null ? "Adicionar novo produto" : "Editar produto"}</h2>
    <form action="${product == null ? 'add-product' : 'update-product'}" method="post">
        <c:if test="${product != null}">
            <div class="form-group">
                <label for="id">ID</label>
                <input type="text" class="form-control" id="id" name="id" value="${product.id}" readonly>
            </div>
        </c:if>
        <div class="form-group">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" name="name" value="${product != null ? product.nome : ''}" required>
        </div>
        <div class="form-group">
            <label for="quantity">Unidade compra</label>
            <input type="number" class="form-control" id="quantity" name="quantity" value="${product != null ? product.unidadeCompra : ''}" required>
        </div>
        <div class="form-group">
            <label for="description">Descrição</label>
            <textarea class="form-control" id="description" name="description" rows="3" required>${product != null ? product.descricao : ''}</textarea>
        </div>
        <div class="form-group">
            <label for="monthlyExpectedQuantity">Quantidade prevista mês</label>
            <input type="number" class="form-control" id="monthlyExpectedQuantity" name="monthlyExpectedQuantity" step="0.01" value="${product != null ? product.qtdPrevistoMes : ''}" required>
        </div>
        <div class="form-group">
            <label for="maxBoughtPrice">Preço máximo comprado</label>
            <input type="number" class="form-control" id="maxBoughtPrice" name="maxBoughtPrice" step="0.01" value="${product != null ? product.precoMaxComprado : ''}" required>
        </div>
        <button type="submit" class="btn btn-primary">${product == null ? "Salvar" : "Editar"}</button>
        <a href="${pageContext.request.contextPath}/product" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
