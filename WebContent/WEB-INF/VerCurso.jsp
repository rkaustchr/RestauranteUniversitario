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
<title>Ver curso</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
			<h2>Ver curso</h2>
			<% Curso curso = (Curso)request.getAttribute("cursoAntigo");%>
			<form action="VerCurso" method="post">
				<% try{ 
					String nome = curso.getNome();
					String sigla = curso.getSigla(); 
					String siglaDepartamento = curso.getDepartamento().getSigla();
				%>
					Nome : <%=nome%> <br />
					Sigla : <%=sigla%> <input type="hidden" name ="sigla" value = "<%=sigla%>"> <br />
					Departamento : <%=siglaDepartamento%>  <br />
					<br>
				<% } catch (NullPointerException e)  {  } %>
				<input type="submit" name="acaoVer" value="Voltar">
			</form>
			</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>

</html>