<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Aluno</title>
</head>
<%@include file="messagePage.jsp" %>
<body>
	<form action="CriarAluno" method="post">
	Nome : <input type="text" name ="nome" value = "">
	Matricula : <input type="text" name ="matricula" value = "">
	Ano de Ingresso : <input type="text" name ="anoIgresso" value = "">
	Sexo : <select name="sexo">
				<option value="masculino">Masculino</option>
				<option value="feminino">Feminino</option>
			</select>
	Titulo : <select name="titulo">
				<option value="doutorado">Doutorado</option>
				<option value="mestrado">Mestrado</option>
				<option value="especializacao">Especialização</option>
			</select>
	CPF : <input type="text" name ="cpf" value = "">
	
	<br>
	<input type="submit" name="acaoCriar" value="Criar">
	<input type="submit" name="acaoCriar" value="Cancelar">
	</form>
</body>

</html>