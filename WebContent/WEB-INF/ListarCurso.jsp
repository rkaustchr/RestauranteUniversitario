<%@ page import="java.util.ArrayList" %>
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
<title>SisRU - Listando Cursos</title>
</head>

<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">

			<%@include file="messagePage.jsp" %>
			<center>
			<form action="ListarCurso" method="post">
			<h2>Listando os cursos</h2>
				<input type="submit" name ="acaoListar" value = "Criar">
				<input type="submit" name ="acaoListar" value = "Atualizar">
				<input type="submit" name ="acaoListar" value = "Ver">
				<br />
				<br />
					<table width="80%">
					  <tr>
					    <th>Sigla</th>
					    <th>Nome</th>
					    <th>Departamento</th>
					  </tr>
					  
					  <%
						  try{
							  ArrayList<Curso> listaCurso = (ArrayList<Curso>)request.getAttribute("listaCursos");
							  int i;
							  for (i=0; i < listaCurso.size(); i++){
					  %>
						  <tr >
						    <td><input type="radio" name='sigla' value='<%=listaCurso.get(i).getSigla()%>'><%=listaCurso.get(i).getSigla()%></td>
						    <td><%=listaCurso.get(i).getNome()%></td>
						    <td><%=listaCurso.get(i).getDepartamento().getSigla()%></td>
						  </tr>
					  <%
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