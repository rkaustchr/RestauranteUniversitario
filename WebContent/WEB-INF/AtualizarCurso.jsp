<%@ page import="entidades.Curso" %>
<%@ page import="entidades.Departamento" %>
<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizar curso</title>
</head>
<%@include file="messagePage.jsp" %>
<% Curso curso = (Curso)request.getAttribute("cursoAntigo");%>

<body>
	<form action="AtualizarCurso" method="post">
<% try{ 
	String nome = curso.getNome();
	String sigla = curso.getSigla(); %>
	Nome : <input type="text" name ="nome" value = "<%=nome%>">
	Sigla : <%=sigla%> <input type="hidden" name ="sigla" value = "<%=sigla%>">
	Departamento : 	<%=curso.getDepartamento().getSigla()%><br>
	<input type="hidden" name="departamento" value="<%=curso.getDepartamento().getSigla()%>" />
	<input type="submit" name="acaoAtualizar" value="Atualizar">
	<input type="submit" name="acaoAtualizar" value="Cancelar">
<% } catch (NullPointerException e)  { %>
	<input type="submit" name="acaoAtualizar" value="Voltar">
<% } %>
	</form>


</body>

</html>