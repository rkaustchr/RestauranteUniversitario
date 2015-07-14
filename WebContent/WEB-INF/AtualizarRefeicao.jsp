<%@ page import="entidades.Refeicao" %>
<%@ page import="entidades.Turno" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SisRU - Atualizar Refeição</title>
</head>
<%@include file="messagePage.jsp" %>
<%  Refeicao refeicao = (Refeicao) request.getAttribute("refeicaoAntigo");%>
<body>
	<form action="AtualizarRefeicao" method="post">
<% try{ 
	String id = refeicao.getId();
	String descricao = refeicao.getDescricao(); 
	String opcaoVegan = refeicao.getOpcaoVegan();
	String turno = refeicao.getTurno().toString();
%>
	Descrição: <input type="text" name ="descricao" value = "<%=descricao%>"> <br />
	Opção Vegetariana: <input type="text" name ="opcaoVegan" value = "<%=opcaoVegan%>"> <br />
	Turno: <%=turno %> <br />
	<input type="hidden" name ="turno" value = "<%=turno%>">
	<input type="hidden" name ="id" value = "<%=id%>">
	
	<input type="submit" name="acaoAtualizar" value="Atualizar">
	<input type="submit" name="acaoAtualizar" value="Cancelar">
<% } catch (NullPointerException e)  { %>
	<input type="submit" name="acaoAtualizar" value="Voltar">
<% } %>
	</form>


</body>

</html>