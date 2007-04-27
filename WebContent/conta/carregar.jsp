<%@ taglib prefix="s" uri="/struts-tags"%>
<h3>Alterar Tipo de Produto</h3>

<form method="post" action="<s:url action="atualizar" namespace="/produto" includeParams="none" />">
	<table id="form">
		<tr>
			<td>Descrição:</td>
			<td>
				<input type="hidden" name="produto.id" value="<s:property value="produto.id" />" />
				<input type="text" name="produto.descricao" size="50" value="<s:property value="produto.descricao" />" />
			</td>
		</tr>
		<tr>
			<td>Preço:</td>
			<td><input type="text" name="produto.preco" size="7" value="<s:property value="produto.preco" />" /></td>
		</tr>
		<tr>
			<td>Tipo:</td>
			<td>
				<select name="produto.tipo.id">
					<s:iterator value="tiposProduto">
						<s:if test="id == produto.tipo.id">
							<option selected="selected" value="<s:property value="id" />"><s:property value="descricao" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="id" />"><s:property value="descricao" /></option>
						</s:else>
					</s:iterator>
				</select>
			</td>
		</tr>		
		<tr>
			<td align="right" colspan="2">
				<input type="submit" class="button" value="Atualizar" />
				<input type="button" class="button" value="Excluir" onclick="window.location = '<s:url action="excluir" namespace="/produto" includeParams="get" />'" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<s:url action="listar" namespace="/produto" includeParams="none" />'" />
			</td>			
		</tr>
	</table>
</form>
