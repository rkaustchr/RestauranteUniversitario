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
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
<title>Listando departamentos</title>
</head>

<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
		<br />
		<br />
			<center>
			<%@include file="messagePage.jsp" %>
			<form action="ListarDepartamento" method="post">
				
				<h2>Listagem dos departamentos</h2>
				<input type="submit" name ="acaoListar" value = "Criar">
				<input type="submit" name ="acaoListar" value = "Atualizar">
				<input type="submit" name ="acaoListar" value = "Ver">
				<br />
				<br />
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
						  <tr>
						    <td><input type="radio" name='sigla' value='<%=results.get(i).getSigla() %>'>
						    <%=results.get(i).getSigla() %></td>
						    <td><%=results.get(i).getNome()%></td>
						  </tr>
					  <%
							  }
						  }catch(Exception e){ }
					  %>
					</table>
				</center>
				<!-- <input type="submit" name ="acaoListar" value = "Remover"> -->
			</form>
		</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>

</html>