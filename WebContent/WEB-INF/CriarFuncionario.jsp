<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Departamento" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
<title>SisRU - Criar Funcionario</title>
</head>
<% ArrayList<Departamento> departamentosDisponiveis = (ArrayList<Departamento>)request.getAttribute("departamentosDisponiveis"); %>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<br />
			<br />
			<h2>Criar um novo Funcionário</h2>
			<%@include file="messagePage.jsp" %>
			<br />
			<form action="CriarFuncionario" method="post">
			Nome : <input type="text" name ="nome" value = ""> <br />
			Matricula : <input type="text" name ="matricula" value = ""> <br />
			Ano de Ingresso : <input type="text" name ="anoIgresso" value = ""> <br />
			Sexo : <select name="sexo">
						<option value="MASCULINO">Masculino</option>
						<option value="FEMININO">Feminino</option>
					</select> <br />
			Titulo : <select name="titulo">
						<option value="DOUTORADO">Doutorado</option>
						<option value="MESTRADO">Mestrado</option>
						<option value="ESPECIALIZACAO">Especialização</option>
					</select> <br />
			CPF : <input type="text" name ="cpf" value = ""> <br />
			Departamento : <select name ="departamento">
						<% for(Departamento dptoi : departamentosDisponiveis){ %>
							<option value="<%=dptoi.getSigla()%>"><%=dptoi.getNome()%></option>
						<% } %>
						</select> <br />
			<br>
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