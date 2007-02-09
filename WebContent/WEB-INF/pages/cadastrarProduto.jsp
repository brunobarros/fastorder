<h3>Cadastrar Produto</h3>

<form method="post" action="produto.cadastrar.action">
<table id="form">
	<tr>
		<td>Descrição:</td>
		<td><input type="text" name="produto.descricao" size="50" /></td>
	</tr>
	<tr>
		<td>Preço (R$):</td>
		<td><input type="text" name="produto.preco" size="7" /></td>
	</tr>
	<tr>
		<td>Tipo:</td>
		<td><input type="text" name="produto.tipo.id" size="4" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input class="button" type="submit" value="Cadastrar" />
			<input type="button" class="button" value="Cancelar" onclick="window.location = 'produto.listar.action'" />
		</td>
	</tr>
</table>
</form>