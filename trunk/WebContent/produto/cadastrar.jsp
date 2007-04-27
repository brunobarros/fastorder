<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<h3>Cadastrar Produto</h3>

<form method="post" action="<s:url action="cadastrar" namespace="/produto"  includeParams="none" />">
<table id="form">
	<tr>
		<td>Descrição:</td>
		<td><input type="text" name="produto.descricao" size="50" /></td>
	</tr>
	<tr>
		<td>Preço:</td>
		<td><input type="text" name="produto.preco" size="7" /></td>
	</tr>
	<tr>
		<td>Tipo:</td>
		<td>
			<select name="produto.tipo.id">
				<option value="0"></option>
				<s:iterator value="tiposProduto">
					<option value="<s:property value="id" />"><s:property value="descricao" /></option>
				</s:iterator>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input class="button" type="submit" value="Cadastrar" />
			<input type="button" class="button" value="Cancelar" onclick="window.location = '<s:url action="listar" namespace="/produto"  includeParams="none" />'" />
		</td>
	</tr>
</table>
</form>