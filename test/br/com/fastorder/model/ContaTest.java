package br.com.fastorder.model;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	private Conta conta;

	@Before
	public void setUp() throws Exception {
		conta = new Conta();
	}
	
	@After
	public void tearDown() throws Exception {
		conta = null;
	}
	
	@Test
	public void testRegistrarPedido() {
		conta.abrirConta();
		Assert.assertTrue(conta.registrarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void testCancelarPedidoOK() {
		conta.abrirConta();
		Assert.assertTrue(conta.registrarPedido(new Pedido(Long.valueOf(1))));		
		Assert.assertTrue(conta.cancelarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void testCancelarPedidoFail() {
		conta.abrirConta();
		Assert.assertFalse(conta.cancelarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void testAbrirConta() {		
		conta.abrirConta();
		Assert.assertFalse(conta.isFechada());
	}
	
	@Test
	public void testFecharContaOk() {
		conta.abrirConta();
		conta.fecharConta();
		Assert.assertTrue(conta.isFechada());
	}
	
	@Test
	public void testFecharContaFail() {		
		try {
			conta.fecharConta();
			Assert.fail("Deveria ter lançado uma exception");
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testGetValor() {
		Assert.fail();
	}
	
	@Test
	public void testIsFechadaTrue() {
		conta.abrirConta();
		conta.fecharConta();
		Assert.assertTrue(conta.isFechada());
	}
	
	@Test
	public void testIsFechadaFalse() {
		Assert.assertFalse(conta.isFechada());
	}
	
	@Test
	public void testReabrirConta() {
		conta.abrirConta();
		conta.fecharConta();
		Assert.assertTrue(conta.isFechada());
		conta.reabrirConta();
		Assert.assertFalse(conta.isFechada());
	}
	
}
