<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Ticket" %>
<%@ page import="entidades.Refeicao" %>
<%@ page import="entidades.Consumidor" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SisRu - Criar ticket</title>
<style type="text/css">  
  <%@include file="css/estilo.css" %>  
</style> 
</head>
<%@include file="messagePage.jsp" %>
<% ArrayList<Ticket> ticketsDisponiveis = (ArrayList<Ticket>)request.getAttribute("ticketsDisponiveis"); %>
<% ArrayList<Refeicao> refeicoesDisponiveis = (ArrayList<Refeicao>)request.getAttribute("refeicoesDisponiveis"); %>
<% ArrayList<Consumidor> consumidoresDisponiveis = (ArrayList<Consumidor>)request.getAttribute("consumidoresDisponiveis"); %>

<body>
	<div class="tudo">
		<div class="topo">
			<%@include file="topo.jsp" %>
		</div>
			
		<div class="conteudo">
			<h2>Criar novo ticket</h2>
			<form action="CriarTicket" method="post">
				Refeição : <select name ="idRefeicao" selected="1"> 
				<% for(Refeicao refeicao : refeicoesDisponiveis){ %>
					<option value="<%=refeicao.getId()%>"><%=refeicao.getDescricao()%></option>
				<% } %>
				</select> <br />
				Consumidor : <select name ="cpfConsumidor" selected="1"> 
				<% for(Consumidor consumidor : consumidoresDisponiveis){ %>
					<option value="<%=consumidor.getCpf()%>"><%=consumidor.getNome()%></option>
				<% } %>
				</select> <br />
				Pago : <input type="checkbox" name="pago" value="1"> <br />
				<br>
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