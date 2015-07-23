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
<title>SisRU - Atualizar Consumidor</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
			<% Consumidor consumidor = (Consumidor)request.getAttribute("consumidorAntigo");%>
			<h2>Atualizar consumidor</h2>
			<form action="AtualizarConsumidor" method="post">
			<%  
				String nome = consumidor.getNome();
				int matricula = consumidor.getMatricula();
				String anoIngresso = consumidor.getAnoIngresso(); 
				String sexo = consumidor.getSexo().toString();
				Titulo titulo = consumidor.getTitulo();
				CPF cpf = consumidor.getCpf();
			%>
			Nome : <input type="text" name ="nome" value = "<%=nome%>"> <br />
			Matricula : <input type="text" name ="matricula" value = "<%=matricula%>"> <br />
			Ano de Ingresso : <input type="text" name ="anoIngresso" value = "<%=anoIngresso%>"> <br />
			Sexo : <select name="sexo">
						<option value="MASCULINO" <%= (sexo.equals("MASCULINO"))? "selected" : "" %>>Masculino</option>
						<option value="FEMININO" <%= (sexo.equals("FEMININO"))? "selected" : "" %>>Feminino</option>
					</select><br />
			Titulo : <%=titulo%> <br />
			CPF : <%=cpf%> <input type="hidden" name ="cpf" value="<%=cpf%>"> <br />
			<% try {
				  Curso curso = ((Aluno) consumidor).getCurso(); 
			%>
		  		Curso: <%=curso.getNome() %><br />
		  		<input type="hidden" name ="tipo" value = "A">
	  		<%} catch (Exception e) {
	  			Departamento departamento = ((Funcionario) consumidor).getDepartamento();%>
	  			Departamento: <%=departamento.getNome() %><br />
	  			<input type="hidden" name ="tipo" value = "F">
	  		<%}%>
			<input type="submit" name="acaoAtualizar" value="Atualizar">
			<input type="submit" name="acaoAtualizar" value="Cancelar">
			<input type="submit" name="acaoAtualizar" value="Voltar">			
			</form>
		</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	
	</div>
</body>
</html>