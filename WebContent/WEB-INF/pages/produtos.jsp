<%@ taglib prefix="ww" uri="/webwork"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" type="text/css" />	
	<script type="text/javascript" src="js/grid.js"></script>	
	<script type="text/javascript" src="js/ajax.js"></script>
	<title>FastOrder - Produtos</title>
</head>
<body>

	<h1>Fast Order</h1>
	
	<jsp:include page="menu.jsp" />
	
	<h3>Produtos</h3>
	
	<div id="actions" style="margin-bottom: 20px;">
	</div>
	
	<ww:actionmessage/>
	<ww:actionerror/>
	
	<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
	<table id="list" cellspacing="0">
		<thead>
			<tr>
				<th style="width: 50px; text-align: center;">Id</th>
				<th>Tipo</th>	
				<th>Descrição</th>	
				<th>Preço (R$)</th>	
			</tr>
		</thead>
		<tbody>
			<ww:if test="produtos.size() > 0">
				<ww:iterator value="produtos">
					<tr>
						<td style="text-align: center;"><ww:property value="id" /></td>
						<td><ww:property value="tipo.descricao" /></td>
						<td><ww:property value="descricao" /></td>
						<td><ww:property value="preco" /></td>
					</tr>
				</ww:iterator>
			</ww:if>	
			<ww:else>
				<tr>
					<td colspan="4">Nenhum produto cadastrado</td>
				</tr>
			</ww:else>
		</tbody>
	</table>
	<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>

	<ul style="list-style: none; padding: 0px;">
		<li><input type="button" class="button" onclick="load('produto.novo.action', 'actions');" value="Novo produto" /></li>
	</ul>

</body>
</html>