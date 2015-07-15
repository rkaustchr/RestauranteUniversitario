<%@ page import="java.util.Collection" %>
<%@ page import="entidades.Departamento" %>
<%@ page import="entidades.Departamento" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Listando departamentos</title>
</head>

<body>

<%@include file="messagePage.jsp" %>

	<form action="ListarDepartamento" method="post">
		<table width="80%">
		  <tr>
		    <th>Sigla</th>
		    <th>Nome</th>
		  </tr>
		  
		  <%
			  try{
				  ArrayList<Departamento> results = (ArrayList<Departamento>) request.getAttribute("listaDepartamentos");
					int i;
					for (i=0; i < results.size(); i++ ) {
		  %>
			  <tr align="center">
			    <td><input type="radio" name='sigla' value='<%=results.get(i).getSigla() %>'>
			    <%=results.get(i).getSigla() %></td>
			    <td><%=results.get(i).getNome()%></td>
			  </tr>
		  <%
				  }
			  }catch(Exception e){ }
		  %>
		</table>

		<input type="submit" name ="acaoListar" value = "Criar">
		<input type="submit" name ="acaoListar" value = "Atualizar">
		<input type="submit" name ="acaoListar" value = "Ver">
		<!-- <input type="submit" name ="acaoListar" value = "Remover"> -->
	</form>
</body>

</html>