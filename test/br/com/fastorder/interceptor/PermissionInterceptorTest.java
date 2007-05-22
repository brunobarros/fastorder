package br.com.fastorder.interceptor;

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.model.Usuario;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;

public class PermissionInterceptorTest {
	
	private PermissionInterceptor interceptor;
	
	private ActionInvocation actionInvocationMock;
	
	private Map sessionMock;
	
	private static final String NAMESPACE_TEST = "/produto";
	
	private static final String ACTION_TEST = "listar";

	@Before
	public void setUp() throws Exception {
		interceptor = new PermissionInterceptor();		
		
		actionInvocationMock = createMock(ActionInvocation.class);
		
		sessionMock = createMock(Map.class);
		
		Map context = new HashMap();
		context.put(ActionContext.SESSION, sessionMock);
		
		ActionContext.setContext(new ActionContext(context));
		
		interceptor.init();
	}

	@After
	public void tearDown() throws Exception {
		interceptor.destroy();
	}

	@Test
	public final void interceptSemUsuarioNaSessao() throws Exception {		
		ActionProxy actionProxyMock = createMock(ActionProxy.class);
		expect(actionProxyMock.getNamespace()).andReturn(NAMESPACE_TEST);
		expect(actionProxyMock.getActionName()).andReturn(ACTION_TEST);
		replay(actionProxyMock);		
		
		expect(actionInvocationMock.getProxy()).andReturn(actionProxyMock).times(2);
		replay(actionInvocationMock);
		
		expect(sessionMock.get("usuario")).andReturn(null);
		expect(sessionMock.put("namespace", NAMESPACE_TEST)).andReturn(null);
		expect(sessionMock.put("uri", ACTION_TEST)).andReturn(null);
		replay(sessionMock);
		
		assertEquals(Action.LOGIN, interceptor.intercept(actionInvocationMock));
		
		verify(sessionMock, actionInvocationMock);
	}
	
	@Test
	public final void interceptComUsuarioNaSessao() throws Exception {
		expect(sessionMock.get("usuario")).andReturn(new Usuario("diogo"));		
		replay(sessionMock);
		
		expect(actionInvocationMock.invoke()).andReturn(Action.SUCCESS);		
		replay(actionInvocationMock);
		
		assertEquals(Action.SUCCESS, interceptor.intercept(actionInvocationMock));
		
		verify(sessionMock, actionInvocationMock);
	}

}
