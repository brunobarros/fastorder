<%@ taglib prefix="ww" uri="/webwork"%>
<h3>Alterar Tipo de Produto</h3>

<form method="post" action="<ww:url action="atualizar" namespace="/produto" includeParams="none" />">
	<table id="form">
		<tr>
			<td>Descrição:</td>
			<td>
				<input type="hidden" name="produto.id" value="<ww:property value="produto.id" />" />
				<input type="text" name="produto.descricao" size="50" value="<ww:property value="produto.descricao" />" />
			</td>
		</tr>
		<tr>
			<td>Preço:</td>
			<td><input type="text" name="produto.preco" size="7" value="<ww:text name="format.preco"><ww:param value="produto.preco" /></ww:text>" /></td>
		</tr>
		<tr>
			<td>Tipo:</td>
			<td>
				<select name="produto.tipo.id">
					<ww:iterator value="tiposProduto">
						<ww:if test="id == produto.tipo.id">
							<option selected="selected" value="<ww:property value="id" />"><ww:property value="descricao" /></option>
						</ww:if>
						<ww:else>
							<option value="<ww:property value="id" />"><ww:property value="descricao" /></option>
						</ww:else>
					</ww:iterator>
				</select>
			</td>
		</tr>		
		<tr>
			<td align="right" colspan="2">
				<input type="submit" class="button" value="Atualizar" />
				<input type="button" class="button" value="Excluir" onclick="window.location = '<ww:url action="excluir" namespace="/produto" includeParams="get" />'" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<ww:url action="listar" namespace="/produto" includeParams="none" />'" />
			</td>			
		</tr>
	</table>
</form>
