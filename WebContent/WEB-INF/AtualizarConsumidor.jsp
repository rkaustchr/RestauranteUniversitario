<%@ page import="entidades.Consumidor" %>
<%@ page import="entidades.Departamento" %>
<%@ page import="entidades.Funcionario" %>
<%@ page import="entidades.Curso" %>
<%@ page import="entidades.Aluno" %>
<%@ page import="entidades.Titulo" %>
<%@ page import="entidades.Sexo" %>
<%@ page import="entidades.CPF" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style>
<title>Atualizar Consumidor</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
			<% Consumidor consumidor = (Consumidor)request.getAttribute("consumidorAntigo");%>
			<h2>Atualizar curso</h2>
			<form action="AtualizarConsumidor" method="post">
			<% try{ 
			String nome = consumidor.getNome();
			int matricula = consumidor.getMatricula();
			String anoIngresso = consumidor.getAnoIngresso(); 
			Sexo sexo = consumidor.getSexo();
			Titulo titulo = consumidor.getTitulo();
			CPF cpf = consumidor.getCpf();%>
			Nome : <input type="text" name ="nome" value = "<%=nome%>"> <br />
			Matricula : <%=matricula%> <input type="hidden" name ="matricula" value = "<%=matricula%>"> <br />
			Ano de Ingresso : <%=anoIngresso%> <input type="hidden" name ="anoIngresso" value = "<%=anoIngresso%>"> <br />
			Sexo : <%=sexo%> <input type="hidden" name ="sexo" value = "<%=sexo%>"> <br />
			Titulo : <%=titulo%> <input type="hidden" name ="titulo" value = "<%=titulo%>"> <br />
			CPF : <%=cpf%> <input type="hidden" name ="cpf" value = "<%=cpf%>"> <br />
			<% try {
				  		Curso curso = ((Aluno) consumidor).getCurso(); %>
			  		 - <input type="hidden" name ="tipo" value = "A">
			  		<%=curso.getNome() %><br />
		  		<%} catch (Exception e) {
		  			Departamento departamento = ((Funcionario) consumidor).getDepartamento();%>
		  			- <input type="hidden" name ="tipo" value = "F">
		  			<%=departamento.getNome() %>
		  			<td> - </td>
		  		<%}%>
			<input type="submit" name="acaoAtualizar" value="Atualizar">
			<input type="submit" name="acaoAtualizar" value="Cancelar">
			<% } catch (NullPointerException e)  { %>
			<input type="submit" name="acaoAtualizar" value="Voltar">
			<% } %>
			</form>
		</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	
	</div>
</body>
</html>