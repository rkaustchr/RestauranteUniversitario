<%@ page import="entidades.Refeicao" %>
<%@ page import="entidades.Turno" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
<title>SisRU - Ver Refeição</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
			<% Refeicao refeicao = (Refeicao)request.getAttribute("refeicaoAntigo");%>
				<h2>Ver refeição</h2>
				<form action="VerRefeicao" method="post">
				<% try{ 
					String id = refeicao.getId();
					String descricao = refeicao.getDescricao();
					String turno = "";
					switch ( refeicao.getTurno().toString() ) {
						case "MANHA" :
							turno = "Desjejum";
							break;
						case "TARDE" :
							turno = "Almoço";
							break;
						case "NOITE" :
							turno = "Jantar";
							break;
					}
					String opcaoVegan = refeicao.getOpcaoVegan();
				%>
					Descrição: <%=descricao %> <br />
					Opção Vegetariana: <%=opcaoVegan%> <input type="hidden" name ="id" value = "<%=id%>"> <br />
					Horário: <%=turno%> <br />
					<br>
				<% } catch (NullPointerException e)  {  } %>
				<input type="submit" name="acaoVer" value="Voltar">
			</form>


</body>

</html>