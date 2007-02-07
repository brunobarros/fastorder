<h3>Cadastrar Produto</h3>

<form method="post" action="produto.cadastrar.action">
<table id="form">
	<tr>
		<td>Descrição:</td>
		<td><input type="text" name="produto.descricao" /></td>
	</tr>
	<tr>
		<td>Preço:</td>
		<td><input type="text" name="produto.preco" /></td>
	</tr>
	<tr>
		<td>Tipo:</td>
		<td><input type="text" name="produto.tipo.id" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input class="button" type="submit" value="Cadastrar" />
			<input type="button" class="button" value="Cancelar" onclick="window.location = 'produto.listar.action'" />
		</td>
	</tr>
</table>
</form>
