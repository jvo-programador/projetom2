<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>lista de produtos</title>
	<link rel="stylesheet" type="text/css" href=".../css/estilos.css">
</head>
<body>


	<jsp:include page="../../includes/menu.jsp" />
	<h2>lista de produtos</h2>
	<table border="1" cellspacing="0" cellpadding="5">
		<thead>
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>quantidade</th>
			<th>valor</th>
		</tr>
		</thead>
		
		<tbody>
			<c:forEach var="produto" items="${listaProdutos}">
				<tr>
				<td>${produto.idProduto}</td>
				<td>${produto.nomeProduto}</td>
				<td>${produto.qtdProduto}</td>
				<td>${produto.valorProduto}</td>
					<td>
						<a href="editar?id=${produtos.idProduto}">editar</a>
						<a href="excluir?id=${produtos.idProduto}">excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	
	<a href="cadastro">novo produto</a>
	
	<jsp:include page="../../includes/footer.jsp" />

</body>
</html>