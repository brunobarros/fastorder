<%@ taglib prefix="ww" uri="/webwork"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" href="../css/style.css" type="text/css" />	
	<script type="text/javascript" src="../js/grid.js"></script>	
	<script type="text/javascript" src="../js/ajax.js"></script>
	<title>FastOrder - Contas</title>
</head>
<body onload="stripe('list', '#fff', '#edf3fe');">

	<h1>Fast Order</h1>
	
	<jsp:include page="../includes/menu.jsp" />

	<h3>Abrir nova conta</h3>
	
	<ww:actionmessage/>
	<ww:actionerror/>
	
	<form method="post" action="<ww:url action="cadastrar" namespace="/conta"  includeParams="none" />">
	<table id="form">
		<tr>
			<td>Número da mesa:</td>
			<td>
				<select name="conta.mesa.id">
					<ww:iterator value="mesas">
						<option value="<ww:property value="id" />"><ww:property value="id" /></option>
					</ww:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input class="button" type="submit" value="Abrir conta" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<ww:url action="listar" namespace="/conta"  includeParams="none" />'" />
			</td>
		</tr>
	</table>
	</form>
		
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>