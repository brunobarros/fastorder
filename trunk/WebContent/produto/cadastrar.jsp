<%@ taglib prefix="ww" uri="/webwork"%>
<h3>Cadastrar Produto</h3>

<form method="post" action="<ww:url action="cadastrar" namespace="/produto"  includeParams="none" />">
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
				<ww:iterator value="tiposProduto">
					<option value="<ww:property value="id" />"><ww:property value="descricao" /></option>
				</ww:iterator>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input class="button" type="submit" value="Cadastrar" />
			<input type="button" class="button" value="Cancelar" onclick="window.location = '<ww:url action="listar" namespace="/produto"  includeParams="none" />'" />
		</td>
	</tr>
</table>
</form>