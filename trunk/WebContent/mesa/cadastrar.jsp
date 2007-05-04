<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h3>Cadastrar Mesa</h3>

<form method="post" action="<s:url action="cadastrar" namespace="/mesa" includeParams="none" />">
<table id="form">
	<tr>
		<td>Número da mesa:</td>
		<td><input type="text" name="mesa.id" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input class="button" type="submit" value="Cadastrar" /></td>
	</tr>
</table>
</form>
