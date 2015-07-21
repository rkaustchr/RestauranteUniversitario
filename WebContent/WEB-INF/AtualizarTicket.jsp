<%@ page import="entidades.Ticket" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style>
<title>SisRU - Atualizar Ticket</title>
</head>

<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
			<% Ticket ticket = (Ticket)request.getAttribute("ticketAntigo");%>
			<h2>Atualizar ticket</h2>
			<form action="AtualizarTicket" method="post">
			<% try{ 
				int id = ticket.getId();
				String refeicao = ticket.getRefeicao().getDescricao(); 
				boolean pago = ticket.isPago();
				String consumidor = ticket.getConsumidor().getNome();
			%>
			<input type="hidden" name ="id" value = "<%=id%>">
			Refeição: <%=refeicao%> <br />
			Consumidor: <%=consumidor%>  <br />
			Pago: <input type="checkbox" name="pago" value="1"  <%=(pago)?"checked":"" %>> <br />
			<br />
			
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