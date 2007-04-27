package br.com.fastorder.model;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	private Conta conta;

	@Before
	public void setUp() throws Exception {
		conta = new Conta();
	}

	@Test
	public void testRegistrarPedido() {
		conta.abrirConta();
		assertTrue(conta.registrarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void testCancelarPedidoOK() {
		conta.abrirConta();
		assertTrue(conta.registrarPedido(new Pedido(Long.valueOf(1))));		
		assertTrue(conta.cancelarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void testCancelarPedidoFail() {
		conta.abrirConta();
		assertFalse(conta.cancelarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void testAbrirConta() {		
		conta.abrirConta();
		assertFalse(conta.isFechada());
	}
	
	@Test
	public void testFecharContaOk() {
		conta.abrirConta();
		conta.fecharConta();
		assertTrue(conta.isFechada());
	}
	
	@Test
	public void testFecharContaFail() {		
		try {
			conta.fecharConta();
			fail("Deveria ter lançado uma exception");
		} catch (IllegalStateException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetValor() {
		fail();
	}
	
	@Test
	public void testIsFechadaTrue() {
		conta.abrirConta();
		conta.fecharConta();
		assertTrue(conta.isFechada());
	}
	
	@Test
	public void testIsFechadaFalse() {
		assertFalse(conta.isFechada());
	}
	
	@Test
	public void testReabrirConta() {
		conta.abrirConta();
		conta.fecharConta();
		assertTrue(conta.isFechada());
		conta.reabrirConta();
		assertFalse(conta.isFechada());
	}
	
}
