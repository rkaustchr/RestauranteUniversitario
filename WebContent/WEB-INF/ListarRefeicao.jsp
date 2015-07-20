<%@page import="entidades.Refeicao"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Refeicao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
<title>SisRU - Gerenciamento de Refeições</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
		
			<form action="ListarRefeicao" method="post">
				<center>
					<h2>Listagem dos departamentos</h2>
					<input type="submit" name ="acaoListar" value = "Criar">
					<input type="submit" name ="acaoListar" value = "Atualizar">
					<input type="submit" name ="acaoListar" value = "Ver">
				<br />
				<br />
						
				<table width="80%">
				  <tr><th>op</<th><th>Turno</th><th>Descrição</th><th>Opção Vegetariana</th></tr>
				  <%
					  try{
						  ArrayList<Refeicao> listaRefeicao = (ArrayList<Refeicao>)request.getAttribute("listaRefeicoes");
						  int i;
						  for (i=0; i < listaRefeicao.size(); i++){
							  %> <tr align="center"> 
							  <td><input type='radio' name ='id' value = '<%=listaRefeicao.get(i).getId() %>'></td>
							  <td><%=listaRefeicao.get(i).getTurno().toString() %></td> 
							  <td><%=listaRefeicao.get(i).getDescricao() %></td>
							  <td><%=listaRefeicao.get(i).getOpcaoVegan() %></td>
							  </tr> <%
						  }
					  }catch(Exception e){ }
				  %>
				  
				</table>
				</center>
			</form>
		</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>
</html>