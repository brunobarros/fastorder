<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<!-- Refresh page after X seconds -->
	<meta http-equiv="refresh" content="10" />	
	<link rel="stylesheet" href="../css/style.css" type="text/css" />	
	<script type="text/javascript" src="../js/grid.js"></script>	
	<script type="text/javascript" src="../js/ajax.js"></script>
	<title>FastOrder - Contas</title>
</head>
<body onload="stripe('list', '#fff', '#edf3fe');">

	<h1>Fast Order</h1>
	
	<jsp:include page="../includes/menu.jsp" />
	
	<div id="actions" style="margin-bottom: 20px;">
	</div>
	
	<h3>Contas</h3>
	
	<ul style="list-style: none;">
		<li><input type="button" class="button" onclick="location.href='<s:url action="novo" namespace="/conta" includeParams="none" />';" value="Abrir nova conta" /></li>
	</ul>
	
	<h4>Contas abertas</h4>
	
	<s:actionmessage/>
	<s:actionerror/>
	
				<s:if test="contas.size() > 0">
					<div id="menu">
						<ul>
							<s:iterator value="contas">
								<li>
									<div style="width:275px; border: 1px solid #a0a0a0;">
										<b>Id:</b> <s:property value="id" /><br />
										<b>Mesa:</b> <s:property value="mesa.id" /><br />
										<b>Data de abertura:</b> <s:property value="dataAbertura" /><br />
										<b>Consumo:</b> R$ <s:property value="getValor()" /><br />
										<input type="button" value="Adicionar pedido" onclick="alert('Não implementado.')" /><br />
										<input type="button" value="Fechar conta" onclick="confirm('Deseja fechar esta conta? (Não implementado)');" /><br />
									</div>	<br />
								</li>
							</s:iterator>
						</ul>
					</div>
				</s:if>	
				<s:else>
					<tr>
						<td colspan="4">Nenhuma conta aberta.</td>
					</tr>
				</s:else>
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>