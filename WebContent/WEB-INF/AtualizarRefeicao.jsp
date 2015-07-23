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
<title>SisRU - Atualizar Refeição</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<form action="AtualizarRefeicao" method="post">
				<%@include file="messagePage.jsp" %>
				<%  Refeicao refeicao = (Refeicao) request.getAttribute("refeicaoAntigo");%>
				<% try{ 
					String id = refeicao.getId();
					String descricao = refeicao.getDescricao(); 
					String opcaoVegan = refeicao.getOpcaoVegan();
				%>
					<h2>Atualizar refeição</h2>
					Descrição: <input type="text" name ="descricao" value = "<%=descricao%>"> <br />
					Opção Vegetariana: <input type="text" name ="opcaoVegan" value = "<%=opcaoVegan%>"> <br />
					<%
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
					%>
					Turno: <%=turno %> <br />
					<input type="hidden" name ="turno" value = "<%=refeicao.getTurno().toString()%>">
					<input type="hidden" name ="id" value = "<%=id%>">
					
					<input type="submit" name="acaoAtualizar" value="Atualizar">
					<input type="submit" name="acaoAtualizar" value="Cancelar">
				<% } catch (NullPointerException e)  { %>
					<input type="submit" name="acaoAtualizar" value="Voltar">
				<% } %>
			</form>
		</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>

</html>