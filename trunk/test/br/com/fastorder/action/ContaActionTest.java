package br.com.fastorder.action;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.facade.ContaManager;
import br.com.fastorder.facade.ManagerException;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

import com.opensymphony.xwork2.Action;

/**
 * @author Bruno
 * @since 154/05/2007
 *
 */
public class ContaActionTest {
	
	private ContaAction action;
	
	private ContaManager contaManagerMock;
	
	@Before
	public void setUp() throws Exception {
		action = new ContaAction();
		contaManagerMock = createMock(ContaManager.class);
		action.setContaManager(contaManagerMock);
	}
	
	@Test
	public void abrirConta() throws ManagerException {
		Mesa mesaMock = createMock(Mesa.class);
		expect(mesaMock.getId()).andReturn(Long.valueOf(1));
		replay(mesaMock);
		
		Conta conta = new Conta(mesaMock);
		expect(contaManagerMock.abrirConta(mesaMock)).andReturn(conta);
		replay(contaManagerMock);
		
		action.setMesa(mesaMock);
		
		assertEquals("Retorno da action difere do esperado", Action.SUCCESS, action.insert());
		assertEquals("Não deveria retornar mensagens de erro", 0, action.getActionErrors().size());
		assertEquals("Deveria retornar uma mensagem", 1, action.getActionMessages().size());
	}
	
	@Test
	public void abrirContaComMesaOcupada() throws ManagerException {
		Mesa mesaMock = createMock(Mesa.class);
		expect(mesaMock.getId()).andReturn(Long.valueOf(1));
		replay(mesaMock);
				
		expect(contaManagerMock.abrirConta(mesaMock)).andThrow(new ManagerException());
		replay(contaManagerMock);
		
		action.setMesa(mesaMock);		
		
		assertEquals("Retorno da action difere do esperado", Action.ERROR, action.insert());
		assertEquals("Deveria retornar mensagens de erro", 1, action.getActionErrors().size());
		assertEquals("Não deveria retornar uma mensagem", 0, action.getActionMessages().size());
	}
	
	@Test
	public void listarAbertasSucesso() throws ManagerException {
		expect(contaManagerMock.listarContasAbertas())
			.andReturn(Arrays.asList(new Conta[] {new Conta(Long.valueOf(1)), new Conta(Long.valueOf(2))}));
		replay(contaManagerMock);
		
		assertEquals("Retorno da action difere do esperado", Action.SUCCESS, action.list());
		assertEquals("Não deveria retornar mensagens de erro", 0, action.getActionErrors().size());
		assertEquals("Não deveria retornar uma mensagem", 0, action.getActionMessages().size());
	}
	
	@Test
	public void listarAbertasErro() throws ManagerException {
		expect(contaManagerMock.listarContasAbertas()).andThrow(new ManagerException());
		replay(contaManagerMock);
		
		assertEquals("Retorno da action difere do esperado", Action.ERROR, action.list());
		assertEquals("Deveria retornar mensagens de erro", 1, action.getActionErrors().size());
		assertEquals("Não deveria retornar uma mensagem", 0, action.getActionMessages().size());
	}

}
