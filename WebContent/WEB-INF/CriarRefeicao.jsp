<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SisRU - Criar Refeição</title>
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<h2>Criar nova refeição</h2>
			<form action="CriarRefeicao" method="post">
			Descrição : <input type="text" name ="descricao" value = ""> </br>
			Opção Vegetariana : <input type="text" name ="opcaoVegan" value = ""> </br>
			Turno : <select name="turno">
						<option value="MANHA">Dejejum</option>
						<option value="TARDE">Almoço</option>
						<option value="NOITE">Jantar</option>
					</select> <br />
			<br />
			<input type="submit" name="acaoCriar" value="Criar">
			<input type="submit" name="acaoCriar" value="Cancelar">
			</form>
		</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>
</html>