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
	public void registrarPedido() {
		conta.abrirConta();
		assertTrue(conta.registrarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void cancelarPedidoOK() {
		conta.abrirConta();
		assertTrue(conta.registrarPedido(new Pedido(Long.valueOf(1))));		
		assertTrue(conta.cancelarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void cancelarPedidoFail() {
		conta.abrirConta();
		assertFalse(conta.cancelarPedido(new Pedido(Long.valueOf(1))));
	}
	
	@Test
	public void abrirConta() {		
		conta.abrirConta();
		assertFalse(conta.isFechada());
	}
	
	@Test
	public void fecharContaOk() {
		conta.abrirConta();
		conta.fecharConta();
		assertTrue(conta.isFechada());
	}
	
	@Test(expected = IllegalStateException.class)
	public void fecharContaFail() {
		conta.fecharConta();
	}
	
	@Test
	public void isFechadaTrue() {
		conta.abrirConta();
		conta.fecharConta();
		assertTrue(conta.isFechada());
	}
	
	@Test
	public void isFechadaFalse() {
		assertFalse(conta.isFechada());
	}
	
	@Test
	public void reabrirConta() {
		conta.abrirConta();
		conta.fecharConta();
		assertTrue(conta.isFechada());
		conta.reabrirConta();
		assertFalse(conta.isFechada());
	}
	
}
