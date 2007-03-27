<%@ taglib prefix="ww" uri="/webwork"%>
	<div id="menu">
		<ul>
			<li><a href="<ww:url action="main" namespace="/usuario" includeParams="none" />">Principal</a></li>
			<!--<li><a href="<ww:url action="listar" namespace="/conta" includeParams="none" />">Contas</a></li>-->
			<li><a href="<ww:url action="listar" namespace="/produto" includeParams="none" />">Produto</a></li>
			<li><a href="<ww:url action="listar" namespace="/tipoproduto" includeParams="none" />">Tipo Produto</a></li>
			<li><a href="<ww:url action="listar" namespace="/mesa" includeParams="none" />">Mesa</a></li>
			<li><a href="<ww:url action="sair" namespace="/usuario" includeParams="none" />">Sair</a></li>
		</ul>
	</div>