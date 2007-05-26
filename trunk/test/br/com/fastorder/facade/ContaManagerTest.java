package br.com.fastorder.facade;

import static org.easymock.classextension.EasyMock.*;
import static junit.framework.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

public class ContaManagerTest {
	
	private ContaManager contaManager;
	
	private ContaDao contaDaoMock;
	
	private MesaDao mesaDaoMock;

	@Before
	public void setUp() throws Exception {		
		contaDaoMock = createMock(ContaDao.class);
		mesaDaoMock = createMock(MesaDao.class);
		
		contaManager = new ContaManager();
		
		contaManager.setContaDao(contaDaoMock);
		contaManager.setMesaDao(mesaDaoMock);
	}
	
	@Test
	public void abrirContaSucesso() throws Exception {
		Mesa mesaMock = createMock(Mesa.class);
		expect(mesaMock.getId()).andReturn(Long.valueOf(1)).times(2);
		expect(mesaMock.hasContaAberta()).andReturn(false);
		replay(mesaMock);
		
		expect(mesaDaoMock.get(mesaMock.getId())).andReturn(mesaMock);
		replay(mesaDaoMock);
		
		Conta conta = new Conta(mesaMock);
		
		expect(contaDaoMock.save(conta)).andReturn(conta);
		replay(contaDaoMock);
		
		assertEquals(conta, contaManager.abrirConta(mesaMock));
	}
	
	@Test(expected = ManagerException.class)
	public void abrirContaComMesaOcupada() throws Exception {
		Mesa mesaMock = createMock(Mesa.class);
		expect(mesaMock.getId()).andReturn(Long.valueOf(1)).times(2);
		expect(mesaMock.hasContaAberta()).andReturn(true);
		replay(mesaMock);
		
		expect(mesaDaoMock.get(mesaMock.getId())).andReturn(mesaMock);
		replay(mesaDaoMock);
		
		contaManager.abrirConta(mesaMock);
	}
	
	@Test
	public void listarContasAbertas() throws ManagerException, DaoException {
		expect(contaDaoMock.listContasAbertas())
			.andReturn(Arrays.asList(new Conta[] {new Conta(Long.valueOf(1)), new Conta(Long.valueOf(2))})).times(2);
		replay(contaDaoMock);
		
		assertNotNull("Não deveria retornar null", contaManager.listarContasAbertas());
		assertFalse("Deveria retornar uma lista não vazia", contaManager.listarContasAbertas().isEmpty());
	}

}
