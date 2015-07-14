<%@ page import="entidades.Refeicao" %>
<%@ page import="entidades.Turno" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SisRU - Ver Refeição</title>
</head>
<%@include file="messagePage.jsp" %>
<% Refeicao refeicao = (Refeicao)request.getAttribute("refeicaoAntigo");%>
<body>
	<form action="VerRefeicao" method="post">
<% try{ 
	String id = refeicao.getId();
	String descricao = refeicao.getDescricao();
	Turno turno = refeicao.getTurno(); 
	String opcaoVegan = refeicao.getOpcaoVegan();
%>
	Descrição: <%=descricao %> <br />
	Opção Vegetariana: <%=opcaoVegan%> <input type="hidden" name ="id" value = "<%=id%>"> <br />
	Horário: <%=  turno.toString() %> <br />
	<br>
<% } catch (NullPointerException e)  {  } %>
<input type="submit" name="acaoVer" value="Voltar">
	</form>


</body>

</html>