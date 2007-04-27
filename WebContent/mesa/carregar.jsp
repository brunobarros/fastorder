<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h3>Alterar Mesa</h3>

<form method="post" action="<s:url action="atualizar" namespace="/mesa" includeParams="none" />">
	<table id="form">
		<tr>
			<td>Número da mesa:</td>
			<td>
				<input type="text" name="mesa.id" size="4" value="<s:property value="mesa.id" />" />
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="button" class="button" value="Excluir" onclick="window.location = '<s:url action="excluir" namespace="/mesa" includeParams="get" />'" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<s:url action="listar" namespace="/mesa" includeParams="none" />'" />
			</td>			
		</tr>
	</table>
</form>
