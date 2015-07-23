<%@ page import="entidades.Consumidor" %>
<%@ page import="entidades.Aluno" %>
<%@ page import="entidades.Funcionario" %>
<%@ page import="entidades.Sexo" %>
<%@ page import="entidades.Titulo" %>
<%@ page import="entidades.CPF" %>
<%@ page import="entidades.Curso" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">  
	  <%@include file="css/estilo.css" %>  
	</style> 
	<title>SisRU - Ver Consumidor</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<h2>Ver Consumidor</h2>
			
			<%@include file="messagePage.jsp" %>
			<% Consumidor cons = (Consumidor)request.getAttribute("consumidorAntigo");%>
		
			<form action="VerConsumidor" method="post">
			<% 
				String nome = cons.getNome();
				int matricula = cons.getMatricula(); 
				String anoIngresso = cons.getAnoIngresso();
				String sexo = cons.getSexo().toString();
				String titulo = cons.getTitulo().toString();
				String cpf = cons.getCpf().toString();
				String tipo = "A";
				String departamento = null;
				String curso = null;
				try {
					curso = ((Aluno) cons).getCurso().getNome();
				} catch (Exception e)  { 
					tipo = "F";
					departamento = ((Funcionario) cons).getDepartamento().getNome();
				}
			%>
				Nome: <%=nome%> <br />
				Matricula: <%=matricula%> <br />
				Ano de Ingresso: <%=anoIngresso %> <br />
				Sexo: <%=sexo %> <br />
				Título: <%=titulo %> <br />
				CPF: <%=cpf %><br />
				<% if (tipo.equals("A")) { %>
				Curso: <%=curso %>
				<%} else { %>
				Departamento: <%=departamento %>
				<%} %><input type="hidden" name ="cpf" value = "<%=cpf%>"> <br/>
				<br>
			<input type="submit" name="acaoVer" value="Voltar">
			</form>
		</div>
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>


</body>

</html>