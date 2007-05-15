package br.com.fastorder.action;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.model.Conta;

import com.opensymphony.xwork2.Action;

/**
 * @author Bruno
 * @since 154/05/2007
 *
 */
public class ContaActionTest {
	
	private ContaAction action;
	private ContaDao contaDaoMock;
	
	@Before
	public void setUp() throws Exception {
		contaDaoMock = createMock(ContaDao.class);
		
		action = new ContaAction();
		action.setContaDao(contaDaoMock);
	}
	
	@Test
	public void testUpdate() throws DaoException, ObjetoNaoEncontradoException {
		try {
			Conta conta = new Conta(Long.valueOf(2));
			conta.abrirConta();
			contaDaoMock.update(conta);
			
			replay(contaDaoMock);
			action.setConta(conta);
			
			assertEquals(Action.SUCCESS, action.update());
			assertEquals(1, action.getActionMessages().size());
			assertEquals(0, action.getActionErrors().size());
		} catch (Exception e) {
			fail("Não deveria lançar exceção: " + e.getMessage());
		}
	}

}
