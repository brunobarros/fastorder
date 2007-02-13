<%@ taglib prefix="ww" uri="/webwork"%>

<h3>Alterar Tipo de Produto</h3>

<form method="post" action="<ww:url action="atualizar" namespace="/tipoproduto" includeParams="none" />">
	<table id="form">
		<tr>
			<td>Descrição:</td>
			<td>
				<input type="hidden" name="tipoProduto.id" value="<ww:property value="tipoProduto.id" />" />
				<input type="text" name="tipoProduto.descricao" value="<ww:property value="tipoProduto.descricao" />" />
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="submit" class="button" value="Atualizar" />
				<input type="button" class="button" value="Excluir" onclick="window.location = '<ww:url action="excluir" namespace="/tipoproduto" includeParams="get" />'" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<ww:url action="listar" namespace="/tipoproduto" includeParams="none" />'" />
			</td>			
		</tr>
	</table>
</form>
