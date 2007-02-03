<%@ taglib prefix="ww" uri="/webwork"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" href="css/style.css" type="text/css" />	
	<script type="text/javascript" src="js/grid.js"></script>	
	<script type="text/javascript" src="js/ajax.js"></script>	
	<title>FastOrder</title>
</head>
<body onload="stripe('list', '#fff', '#edf3fe');">

	<h1>Fast Order</h1>
	
	<jsp:include page="menu.jsp" />
	
	<div id="actions" style="margin-bottom: 20px;">
	</div>
	
	<h3>Tipos de Produto</h3>
	
	<ww:actionmessage/>
	<ww:actionerror/>
	
	<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
	<table id="list" cellspacing="0">
		<thead>
			<tr>
				<th style="width: 50px; text-align: center;">Id</th>
				<th>Descri��o</th>	
			</tr>
		</thead>
		<tbody>
			<ww:if test="tiposProduto.size() > 0">
				<ww:iterator value="tiposProduto">
					<tr onclick="load('tipoProduto.carregar.action?tipoProduto.id=<ww:property value="id" />', 'actions');">
						<td style="text-align: center;"><ww:property value="id" /></td>
						<td><ww:property value="descricao" /></td>
					</tr>
				</ww:iterator>
			</ww:if>	
			<ww:else>
				<tr>
					<td colspan="2">Nenhum tipo cadastrado</td>
				</tr>
			</ww:else>
		</tbody>				
	</table>
	<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>
	
	<ul style="list-style: none; padding: 0px;">
		<li><input type="button" class="button" onclick="load('tipoProduto.novo.action', 'actions');" value="Novo" /></li>
	</ul>

</body>
</html>