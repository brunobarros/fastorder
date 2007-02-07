<%@ taglib prefix="ww" uri="/webwork"%>

<div>
	<h2>Login</h2>
	
	<ww:form action="login.action" method="post" label="Login" theme="ajax">
	<table>
		<tr><td><ww:textfield name="login" label="Login" /></td></tr>
		<tr><td><ww:password name="senha" label="Senha" /></td></tr>
		<tr><td><ww:submit value="Entrar" /></td></tr>
	</table>	
	</ww:form>
</div>