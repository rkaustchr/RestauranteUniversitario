<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SisRU - Status do Banco de Dados</title>
</head>
<body>
	Status do banco de dados: <%= request.getAttribute("dbstatus") %>
	<br />
	<br />
	<form action="DBStatus">
		<input type="submit" value="Resetar Bando de Dados" />
	</form>

</body>
</html>