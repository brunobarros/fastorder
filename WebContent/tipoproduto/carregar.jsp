<%@ taglib prefix="ww" uri="/webwork"%>

<h3>Alterar Mesa</h3>

<form method="post" action="<ww:url action="atualizar" namespace="/mesa" includeParams="none" />">
	<table id="form">
		<tr>
			<td>Número da mesa:</td>
			<td>
				<input type="text" name="mesa.id" size="4" value="<ww:property value="mesa.id" />" />
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="button" class="button" value="Excluir" onclick="window.location = '<ww:url action="excluir" namespace="/mesa" includeParams="get" />'" />
				<input type="button" class="button" value="Cancelar" onclick="window.location = '<ww:url action="listar" namespace="/mesa" includeParams="none" />'" />
			</td>			
		</tr>
	</table>
</form>
