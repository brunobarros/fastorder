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
	<title>FastOrder - Produtos</title>
</head>
<body onload="stripe('list', '#fff', '#edf3fe');">

	<h1>Fast Order</h1>
	
	<jsp:include page="../includes/menu.jsp" />
	
	<div id="actions" style="margin-bottom: 20px;">
	</div>
	
	<div id="navigation">

	<b class="c">
	<b class="c1"><b></b></b>
	<b class="c2"><b></b></b>
	<b class="c3"></b>
	</b>
	
	<p>Produtos</p>
	
	<b class="c">
	<b class="c3"></b>
	<b class="c2"><b></b></b>
	<b class="c1"><b></b></b>
	</b>
	
	</div>
	
	<s:actionmessage/>
	<s:actionerror/>
	
	<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
	<table id="list" cellspacing="0">
		<thead>
			<tr>
				<th style="width: 50px; text-align: center;">Id</th>
				<th>Tipo</th>				
				<th>Descri��o</th>	
				<th>Pre�o</th>	
			</tr>
		</thead>
		<tbody>
			<s:if test="produtos.size() > 0">
				<s:iterator value="produtos">
					<tr onclick="load('<s:url action="carregar" namespace="/produto" includeParams="none" />?produto.id=<s:property value="id" />', 'actions');">
						<td style="text-align: center;"><s:property value="id" /></td>
						<td><s:property value="tipo.descricao" /></td>							
						<td><s:property value="descricao" /></td>
						<td>R$ <s:text name="format.preco"><s:param name="value" value="preco" /></s:text></td>
					</tr>
				</s:iterator>
			</s:if>	
			<s:else>
				<tr>
					<td colspan="4">Nenhum produto cadastrado</td>
				</tr>
			</s:else>
		</tbody>
	</table>
	<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>
	
	<s:if test="index.size() > 1">
		<p>
			<s:iterator value="index">
				<s:if test="value == currentItem"><s:property value="key" />&nbsp;</s:if>
				<s:else><a href="<s:url action="listar" namespace="/produto" includeParams="none" />?currentItem=<s:property value="value" />"><s:property value="key" /></a>&nbsp;</s:else>
			</s:iterator>
		</p>
	</s:if>

	<ul style="list-style: none; padding: 0px;">
		<li style="display: inline;"><input type="button" class="button" onclick="load('<s:url action="novo" namespace="/produto" includeParams="none" />', 'actions');" value="Novo Produto" /></li>
		<li style="display: inline;"><input type="button" class="button" value="Buscar" /></li>
	</ul>

	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>