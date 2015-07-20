<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Departamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Funcionario</title>
</head>
<%@include file="messagePage.jsp" %>
<% ArrayList<Departamento> departamentosDisponiveis = (ArrayList<Departamento>)request.getAttribute("departamentosDisponiveis"); %>
<body>
	<form action="CriarFuncionario" method="post">
	Nome : <input type="text" name ="nome" value = "">
	Matricula : <input type="text" name ="matricula" value = "">
	Ano de Ingresso : <input type="text" name ="anoIgresso" value = "">
	Sexo : <select name="sexo">
				<option value="MASCULINO">Masculino</option>
				<option value="FEMINO">Feminino</option>
			</select>
	Titulo : <select name="titulo">
				<option value="DOUTORADO">Doutorado</option>
				<option value="MESTRADO">Mestrado</option>
				<option value="ESPECIALIZACAO">Especialização</option>
			</select>
	CPF : <input type="text" name ="cpf" value = "">
	Departamento : <select name ="departamento"> 
				<option value=""></option>
				<% for(Departamento dptoi : departamentosDisponiveis){ %>
					<option value="<%=dptoi.getSigla()%>"><%=dptoi.getNome()%></option>
				<% } %>
				</select> <br />
	<br>
	<input type="submit" name="acaoCriar" value="Criar">
	<input type="submit" name="acaoCriar" value="Cancelar">
	</form>
</body>

</html>