<%@ taglib prefix="ww" uri="/webwork"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<!-- Refresh page after 5 seconds -->
	<meta http-equiv="refresh" content="5" />	
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
	
	<ul style="list-style: none; padding: 0px;">
		<li style="display: inline;"><input type="button" class="button" onclick="load('<ww:url action="novo" namespace="/conta" includeParams="none" />', 'actions');" value="Abrir nova conta" /></li>
	</ul>
	
	<h4>Contas abertas</h4>
	
	<ww:actionmessage/>
	<ww:actionerror/>
	
				<ww:if test="contas.size() > 0">
					<div id="menu">
						<ul>
							<ww:iterator value="contas">
								<li>
									<div style="width:275px; border: 1px solid #a0a0a0;">
										<b>Id:</b> <ww:property value="id" /><br />
										<b>Mesa:</b> <ww:property value="mesa.id" /><br />
										<b>Data de abertura:</b> <ww:property value="dataAbertura" /><br />
										<b>Consumo:</b> R$ <ww:property value="getValor()" /><br />
										<input type="button" value="Adicionar pedido" /><br />
										<input type="button" value="Fechar conta" onclick="confirm('Deseja fechar esta conta? (Não implementado)');" /><br />
									</div>	<br />
								</li>
							</ww:iterator>
						</ul>
					</div>
				</ww:if>	
				<ww:else>
					<tr>
						<td colspan="4">Nenhuma conta aberta.</td>
					</tr>
				</ww:else>
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>