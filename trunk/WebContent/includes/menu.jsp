<%@ taglib prefix="s" uri="/struts-tags"%>
	<div id="menu">
		<ul>
			<li><a href="<s:url action="main" namespace="/usuario" includeParams="none" />">Principal</a></li>
			<li><a href="<s:url action="listar" namespace="/conta" includeParams="none" />">Contas</a></li>
			<li><a href="<s:url action="listar" namespace="/produto" includeParams="none" />">Produto</a></li>
			<li><a href="<s:url action="listar" namespace="/tipoproduto" includeParams="none" />">Tipo Produto</a></li>
			<li><a href="<s:url action="listar" namespace="/mesa" includeParams="none" />">Mesa</a></li>
			<li><a href="<s:url action="sair" namespace="/usuario" includeParams="none" />">Sair</a></li>
		</ul>
	</div>