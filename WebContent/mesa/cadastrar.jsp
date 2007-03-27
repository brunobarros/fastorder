<%@ taglib prefix="ww" uri="/webwork"%>
<h3>Cadastrar Mesa</h3>

<form method="post" action="<ww:url action="cadastrar" namespace="/mesa" includeParams="none" />">
<table id="form">
	<tr>
		<td>Número da mesa:</td>
		<td><input type="text" name="mesa.id" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input class="button" type="submit" value="Cadastrar" /></td>
	</tr>
</table>
</form>
