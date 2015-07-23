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
<title>SisRU - Ver ticket</title>
</head>
<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
		<div class="conteudo">
			<%@include file="messagePage.jsp" %>
			<h2>Ver ticket</h2>
			<% Ticket ticket = (Ticket)request.getAttribute("ticketAntigo");%>
			<form action="VerTicket" method="post">
				<% try{ 
					// int id, Refeicao refeicao, boolean pago, Consumidor consumidor
					int id = ticket.getId();
					String refeicao = ticket.getRefeicao().getDescricao(); 
					boolean pago = ticket.isPago();
					String consumidor = ticket.getConsumidor().getNome();
				%>
					<input type="hidden" name ="sigla" value = "<%=id%>">
					Refeição: <%=refeicao%> <br />
					Consumidor: <%=consumidor%>  <br />
					Pago: <% if ( pago == true ) { %>
						    		<img src="https://cdn2.iconfinder.com/data/icons/function_icon_set/accepted_48.png" alt="Pago" width="16" height="16"/>
						    	<% } else { %>
									<img src="https://cdn2.iconfinder.com/data/icons/function_icon_set/cancel_48.png" alt="Não Pago" width="16" height="16"/>
								<% } %>   <br />
					<br>
				<% } catch (NullPointerException e)  {  } %>
				<input type="submit" name="acaoVer" value="Voltar">
			</form>
			</div>
		
		<div class="rodape">
			<%@include file="rodape.jsp" %>
		</div>
	</div>
</body>

</html>