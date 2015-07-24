<%@ page import="java.util.ArrayList" %>
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
<title>SisRU - Listando Tickets</title>
</head>

<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">

			<%@include file="messagePage.jsp" %>
			<form action="ListarTicket" method="post">
			<center>
			<h2>Listando os tickets</h2>
				<input type="submit" name ="acaoListar" value = "Criar">
				<input type="submit" name ="acaoListar" value = "Atualizar">
				<input type="submit" name ="acaoListar" value = "Ver">
				<br />
				<br />
					<table width="80%">
					  <tr>
					    <th></th>
					    <th>Refeição</th>
					    <th>Consumidor</th>
					    <th>Valor</th>
					    <th>Pago</th>
					  </tr>
					  
					  <%
						  try{
							  ArrayList<Ticket> listaTickets = (ArrayList<Ticket>)request.getAttribute("listaTickets");
							  int i;
							  for (i=0; i < listaTickets.size(); i++){
					  %>
						  <tr >
						    <td><input type="radio" name='id' value='<%=listaTickets.get(i).getId()%>'></td>
						    <td><%=listaTickets.get(i).getRefeicao().getDescricao()%></td>
						    <td><%=listaTickets.get(i).getConsumidor().getNome() %></td>
						    <td>R$ <%=listaTickets.get(i).getPreco() %>0</td>
						    <td align="center">
						    	<% if ( listaTickets.get(i).isPago() == true ) { %>
						    		<img src="https://cdn2.iconfinder.com/data/icons/function_icon_set/accepted_48.png" alt="Pago" width="16" height="16"/>
						    	<% } else { %>
									<img src="https://cdn2.iconfinder.com/data/icons/function_icon_set/cancel_48.png" alt="Não Pago" width="16" height="16"/>
								<% } %> 
							</td>
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