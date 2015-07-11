<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Consumidor" %>
<%@ page import="entidades.Aluno" %>
<%@ page import="entidades.Funcionario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando consumidores</title>
</head>

<body>

<%! public String[] getHeaders(){
		return new String[]{"","Nome","Matricula","Ano Ingresso", "Sexo","CPF", "Departamento","Curso" };
	}

%>

<%@include file="messagePage.jsp" %>

	<form action="ListarConsumidor" method="post">
		<input type="submit" name ="acaoListar" value = "Atualizar">
		<input type="submit" name ="acaoListar" value = "Ver">
		<input type="submit" name ="acaoListar" value = "Criar Aluno">
		<input type="submit" name ="acaoListar" value = "Criar Funcionario">
				
		<table width="100%">
		  <tr>
		  <% for (String headeri: getHeaders()){ %>
		  <th><%=headeri %></th>
		  <%}%>
		  </tr>
		  <%
			  try{
			  	ArrayList<Consumidor> results = (ArrayList<Consumidor>) request.getAttribute("listaConsumidores");
				int i;
				for (i=0; i < results.size(); i++ ) {
			  %>
			  	<tr align="center">
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
					%></tr> <%
			  }catch(Exception e){ }
		  %>
		</table>
	</form>
</body>

</html>