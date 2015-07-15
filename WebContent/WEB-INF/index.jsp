<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
<title>SisRU - Home</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
		
		<div class="conteudo">
			<h1>Sistema de Gerenciamento do Restaurante Universitário</h1>
			
			<h2>Menu:</h2>
			<a href="ListarConsumidor">Gerenciar Consumidor</a> <br />
			<a href="ListarTicket">x Gerenciar Tickets</a> <br />
			<a href="ListarRefeicao">x Gerenciar Refeições</a> <br />
			<hr /> <br />
			<a href="ListarDepartamento">Gerenciar Departamento</a> <br />
			<a href="ListarCurso">Gerenciar Curso</a> <br />
		</div>
	
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>
</html>