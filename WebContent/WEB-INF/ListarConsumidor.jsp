<%@ page import="java.util.Collection" %>
<%@ page import="entidades.Departamento" %>
<%@ page import="entidades.Consumidor" %>
<%@ page import="entidades.Aluno" %>
<%@ page import="entidades.Funcionario" %>
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
				<h2>Listagem dos consumidores</h2>
				<input type="submit" name ="acaoListar" value = "Atualizar">
				<input type="submit" name ="acaoListar" value = "Ver">
				<input type="submit" name ="acaoListar" value = "Criar Aluno">
				<input type="submit" name ="acaoListar" value = "Criar Funcionario">
				<br />
				<br />
					<table width="80%">
					  <tr>
					    <th></th><th>Nome</th><th>Matricula</th><th>Ano Ingresso</th><th>Sexo</th><th>CPF</th><th>Departamento</th><th>Curso</th>
					  </tr>
					  <%  try{
							  ArrayList<Consumidor> results = (ArrayList<Consumidor>) request.getAttribute("listaConsumidores");
								int i;
								for (i=0; i < results.size(); i++ ) { %>
								  <tr >
							  	<td><input type='radio' name ='cpf' value='<%=results.get(i).getCpf().toString() %>'></td>
							  	<td><%=results.get(i).getNome() %></td>
							  	<td><%=results.get(i).getMatricula() %></td>
							  	<td><%=results.get(i).getAnoIngresso() %></td>
							  	<td><%=results.get(i).getSexo().toString() %></td>
							  	<td><%=results.get(i).getCpf().toString() %></td>
							  	<td><% 
							  		try {
								  		Aluno a = (Aluno)results.get(i); %>
								  		<%=a.getCurso().getDepartamento().getSigla() %></td>
								  		<td><%=a.getCurso().getNome() %></td>
							  		<%} catch (Exception e) {
							  			Funcionario f = (Funcionario)results.get(i);%>
							  			<%=f.getDepartamento().getSigla() %>
							  			<td> - </td>
							  		<%}
							  		}
									%></tr>
					  <%
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