<%@ page import="entidades.Departamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizar departamento</title>
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style>
</head>
<%@include file="messagePage.jsp" %>
<% Departamento dept = (Departamento)request.getAttribute("departamentoAntigo");%>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<form action="AtualizarDepartamento" method="post">
		<% try{ 
			String nome = dept.getNome();
			String sigla = dept.getSigla(); %>
			Nome : <input type="text" name ="nome" value = "<%=nome%>"> <br />
			Sigla : <%=sigla%> <input type="hidden" name ="sigla" value = "<%=sigla%>"> <br />
			<br>
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