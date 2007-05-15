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
	<title>FastOrder - Mesas</title>
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
	
	<p>Mesas</p>
	
	<b class="c">
	<b class="c3"></b>
	<b class="c2"><b></b></b>
	<b class="c1"><b></b></b>
	</b>
	
	</div>
	
	<s:actionmessage/>
	<s:actionerror/>
	
	<table id="list" cellspacing="0" style="width: 150px;">
		<thead>
			<tr>
				<th>Número da mesa</th>
			</tr>
		</thead>
		<tbody>
			<s:if test="mesas.size() > 0">
				<s:iterator value="mesas">
					<tr onclick="load('<s:url action="carregar" namespace="/mesa" includeParams="none" />?mesa.id=<s:property value="id" />', 'actions');">
						<td style="text-align: center;"><s:property value="id" /></td>
					</tr>
				</s:iterator>
			</s:if>	
			<s:else>
				<tr>
					<td>Nenhuma mesa cadastrada</td>
				</tr>
			</s:else>
		</tbody>				
	</table>
	
	<s:if test="index.size() > 1">
		<p>
			<s:iterator value="index">
				<s:if test="value == currentItem"><s:property value="key" />&nbsp;</s:if>
				<s:else><a href="<s:url action="listar" namespace="/mesa" includeParams="none" />?currentItem=<s:property value="value" />"><s:property value="key" /></a>&nbsp;</s:else>
			</s:iterator>
		</p>
	</s:if>
		
	<ul style="list-style: none; padding: 0px;">
		<li style="display: inline;"><input type="button" class="button" onclick="load('<s:url action="novo" namespace="/mesa" includeParams="none" />', 'actions');" value="Nova Mesa" /></li>
	</ul>

	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>