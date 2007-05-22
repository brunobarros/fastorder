package br.com.fastorder.action;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.UsuarioDao;
import br.com.fastorder.model.Usuario;
import br.com.fastorder.util.Md5;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UsuarioActionTest {
	
	private UsuarioAction action;
	
	private Map sessionMock;
	
	private UsuarioDao usuarioDaoMock;

	@Before
	public void setUp() throws Exception {
		usuarioDaoMock = createMock(UsuarioDao.class);
		sessionMock = createMock(Map.class);
		
		Map context = new HashMap();
		context.put(ActionContext.SESSION, sessionMock);		
		
		ActionContext.setContext(new ActionContext(context));
		
		action = new UsuarioAction();
	}

	@Test
	public final void loginOK() throws DaoException, ObjetoNaoEncontradoException {
		Usuario usuario = new Usuario();
		usuario.setNome("nome");
		usuario.setLogin("login");
		usuario.setSenha(Md5.crypt("senha"));
		
		expect(usuarioDaoMock.get("login")).andReturn(usuario);
		
		replay(usuarioDaoMock);
				
		action.setUsuarioDao(usuarioDaoMock);
		
		expect(sessionMock.put("usuario", usuario)).andReturn(usuario);
		expect(sessionMock.get("namespace")).andReturn(null);
		
		replay(sessionMock);
		
		Usuario usuarioForm = new Usuario("login");
		
		action.setUsuario(usuarioForm);
		action.setSenha("senha");

		assertEquals(Action.SUCCESS, action.login());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public final void loginLoginInvalido() throws DaoException, ObjetoNaoEncontradoException {				
		expect(usuarioDaoMock.get("login")).andThrow(new ObjetoNaoEncontradoException());
		
		replay(usuarioDaoMock);
				
		action.setUsuarioDao(usuarioDaoMock);
		
		replay(sessionMock);
		
		Usuario usuarioForm = new Usuario("login");
		
		action.setUsuario(usuarioForm);
		action.setSenha("senha");

		assertEquals(Action.ERROR, action.login());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}
	
	@Test
	public final void loginSenhaInvalida() throws DaoException, ObjetoNaoEncontradoException {		
		Usuario usuario = new Usuario();
		usuario.setNome("nome");
		usuario.setLogin("login");
		usuario.setSenha(Md5.crypt("senha errada"));
		
		expect(usuarioDaoMock.get("login")).andReturn(usuario);
		
		replay(usuarioDaoMock);
				
		action.setUsuarioDao(usuarioDaoMock);
		
		Usuario usuarioForm = new Usuario("login");
		
		action.setUsuario(usuarioForm);
		action.setSenha("senha");

		assertEquals(Action.ERROR, action.login());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}
	
	@Test
	public final void loginRedirectAfterPost() throws DaoException, ObjetoNaoEncontradoException {		
		Usuario usuario = new Usuario();
		usuario.setNome("nome");
		usuario.setLogin("login");
		usuario.setSenha(Md5.crypt("senha"));
		
		expect(usuarioDaoMock.get("login")).andReturn(usuario);
		
		replay(usuarioDaoMock);
				
		action.setUsuarioDao(usuarioDaoMock);
		
		expect(sessionMock.put("usuario", usuario)).andReturn(usuario);
		expect(sessionMock.get("namespace")).andReturn("/teste").times(2);
		expect(sessionMock.get("uri")).andReturn("teste.action");
		expect(sessionMock.remove("namespace")).andReturn(null);
		expect(sessionMock.remove("uri")).andReturn(null);
		
		replay(sessionMock);
		
		Usuario usuarioForm = new Usuario("login");
		
		action.setUsuario(usuarioForm);
		action.setSenha("senha");

		assertEquals("redirect", action.login());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}	

	@Test
	public final void logoff() {		
		expect(sessionMock.remove("usuario")).andReturn(new Usuario("teste"));
		
		replay(sessionMock);
		
		assertEquals(Action.SUCCESS, action.logoff());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}

}
