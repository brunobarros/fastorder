<%@ taglib prefix="ww" uri="/webwork"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" href="../css/style.css" type="text/css" />	
	<title>FastOrder</title>
</head>
<body>
	
	<h1>Fast Order</h1>
	
	<form method="post" action="<ww:url action="entrar" namespace="/usuario"  includeParams="none" />">
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="usuario.login" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" /></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input class="button" type="submit" value="Conectar" /></td>
			</tr>						
		</table>
	</form>
	
	<ww:actionerror />
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>