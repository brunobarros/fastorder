<%@ taglib prefix="s" uri="/struts-tags"%>
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
	
	<s:actionmessage/>
	<s:actionerror/>
	
	<form method="post" action="<s:url action="cadastrar" namespace="/conta"  includeParams="none" />">
	<table id="form">
		<tr>
			<td>Número da mesa:</td>
			<td>
				<select name="conta.mesa.id">
					<s:iterator value="mesas">
						<option value="<s:property value="id" />"><s:property value="id" /></option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input class="button" type="submit" value="Abrir conta" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<s:url action="listar" namespace="/conta"  includeParams="none" />'" />
			</td>
		</tr>
	</table>
	</form>
		
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>