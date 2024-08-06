<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Menu</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    .container {
      margin-top: 50px;
      text-align: center;
    }
    .menu-item {
      margin: 20px 0;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Trabalho 03 - CRUD de livros</h2>
  <div class="menu-item">
    <a href="${pageContext.request.contextPath}/books" class="btn btn-primary btn-lg">Ir para listagem de livros</a>
  </div>
  <div class="menu-item">
    <a href="credits.jsp" class="btn btn-secondary btn-lg">Créditos</a>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>