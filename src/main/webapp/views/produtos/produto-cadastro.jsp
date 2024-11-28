<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>manutenção de produtos</title>
	<link rel="stylesheet" type="text/css" href=".../css/estilos.css">
</head>
<body>

	<form action="${produtos == null ? 'novo' : 'update'}" method="post">
	
		<input type="hidden" name="idProduto" value="${produto.getIdProduto()}">
		descrição:<input type="text" name="nomeProduto" value="${produto.getNomeProduto()}">
		Quantidade:<input type="text" name="qtdProduto" value="${produto.getQtdProduto()}">
		Valor:<input type="text" name="valorProduto" value="${produto.getValorProduto()}">
	
		<input type="submit" value="salvar">
		
		<input type="button" value="cancelar" onclick="window.location.href='listar';">
		
	
	
	</form>

</body>
</html>