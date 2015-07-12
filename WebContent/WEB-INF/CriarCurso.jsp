<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Departamento" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar curso</title>
</head>
<%@include file="messagePage.jsp" %>
<% ArrayList<Departamento> departamentosDisponiveis = (ArrayList<Departamento>)request.getAttribute("departamentosDisponiveis"); %>

<body>
	<form action="CriarCurso" method="post">
	Nome : <input type="text" name ="nome" value = "">
	Sigla : <input type="text" name ="sigla" value = "">
	Departamento : <select name ="departamento">
	<option value=""></option>
	<% for(Departamento dptoi : departamentosDisponiveis){ %>
		<option value="<%=dptoi.getSigla()%>"><%=dptoi.getNome()%></option>
	<% } %>
	</select>
	<br>
	<input type="submit" name="acaoCriar" value="Criar">
	<input type="submit" name="acaoCriar" value="Cancelar">
	</form>
</body>

</html>