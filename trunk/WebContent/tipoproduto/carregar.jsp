<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h3>Alterar Tipo de Produto</h3>

<form method="post" action="<s:url action="atualizar" namespace="/tipoproduto" includeParams="none" />">
	<table id="form">
		<tr>
			<td>Descrição:</td>
			<td>
				<input type="hidden" name="tipoProduto.id" value="<s:property value="tipoProduto.id" />" />
				<input type="text" name="tipoProduto.descricao" value="<s:property value="tipoProduto.descricao" />" />
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="submit" class="button" value="Atualizar" />
				<input type="button" class="button" value="Excluir" onclick="window.location = '<s:url action="excluir" namespace="/tipoproduto" includeParams="get" />'" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<s:url action="listar" namespace="/tipoproduto" includeParams="none" />'" />
			</td>			
		</tr>
	</table>
</form>
