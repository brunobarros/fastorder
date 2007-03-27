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
	
	<ww:form method="post" action="entrar" namespace="/usuario" validate="true">
		<ww:textfield label="Login" name="usuario.login" value="admin" />
		<ww:textfield label="Senha" name="senha" value="admin" />
		<ww:submit cssClass="button" value="Conectar" />
	</ww:form>
	
	<ww:actionerror />
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>