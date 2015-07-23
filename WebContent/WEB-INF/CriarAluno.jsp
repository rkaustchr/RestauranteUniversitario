<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Curso" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
<title>Criar Aluno</title>
</head>
<% ArrayList<Curso> cursosDisponiveis = (ArrayList<Curso>)request.getAttribute("cursosDisponiveis"); %>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
		<div class="conteudo">
			<h2>Criar Aluno</h2>
			<%@include file="messagePage.jsp" %>
			<form action="CriarAluno" method="post">
			<br />
			Nome : <input type="text" name ="nome" value = ""> <br />
			Matricula : <input type="text" name ="matricula" value = ""><br />
			Ano de Ingresso : <input type="text" name ="anoIgresso" value = ""><br />
			Sexo : <select name="sexo">
						<option value="MASCULINO">Masculino</option>
						<option value="FEMININO">Feminino</option>
					</select><br />
			Titulo : <select name="titulo">
						<option value="DOUTORADO">Doutorado</option>
						<option value="MESTRADO">Mestrado</option>
						<option value="ESPECIALIZACAO">Especialização</option>
					</select><br />
			CPF : <input type="text" name ="cpf" value = ""><br />
			Curso : <select name ="curso"> 
			<option value=""></option>
			<% for(Curso curso : cursosDisponiveis){ %>
				<option value="<%=curso.getSigla()%>"><%=curso.getNome()%></option>
			<% } %>
			</select> <br />
			<br>
			<br/>
			<input type="submit" name="acaoCriar" value="Criar">
			<input type="submit" name="acaoCriar" value="Cancelar">
			
			</form>
	</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>

</html>