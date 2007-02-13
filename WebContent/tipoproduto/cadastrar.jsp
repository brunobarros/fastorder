<%@ taglib prefix="ww" uri="/webwork"%>
<h3>Cadastrar Tipo de Produto</h3>

<form method="post" action="<ww:url action="cadastrar" namespace="/tipoproduto" includeParams="none" />">
<table id="form">
	<tr>
		<td>Descrição:</td>
		<td><input type="text" name="tipoProduto.descricao" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input class="button" type="submit" value="Cadastrar" /></td>
	</tr>
</table>
</form>
