package br.com.fastorder.model;

import static org.easymock.classextension.EasyMock.*;
import static junit.framework.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MesaTest {
	
	private Mesa mesa;
	
	private Conta contaMock;

	@Before
	public void setUp() throws Exception {
		contaMock = createMock(Conta.class);
		
		mesa = new Mesa();
		Set<Conta> contas = new HashSet<Conta>();
		contas.add(contaMock);
		
		mesa.setContas(contas);
	}
	
	@Test
	public void hasContaAbertaTrue() {
		expect(contaMock.isFechada()).andReturn(false);
		replay(contaMock);
		
		assertTrue(mesa.hasContaAberta());
	}
	
	@Test
	public void hasContaAbertaFalse() {
		expect(contaMock.isFechada()).andReturn(true);
		replay(contaMock);
		
		assertFalse(mesa.hasContaAberta());
	}	

}
