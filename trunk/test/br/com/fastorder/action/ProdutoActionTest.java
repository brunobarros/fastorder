package br.com.fastorder.action;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.ProdutoDao;
import br.com.fastorder.dao.TipoProdutoDao;
import br.com.fastorder.model.Produto;
import br.com.fastorder.model.TipoProduto;

import com.opensymphony.xwork2.Action;

public class ProdutoActionTest {
	
	private ProdutoAction action;
	
	private ProdutoDao produtoDaoMock;

	@Before
	public void setUp() throws Exception {
		produtoDaoMock = createMock(ProdutoDao.class);
		
		action = new ProdutoAction();
		action.setProdutoDao(produtoDaoMock);
	}

	@Test
	public final void testList() throws DaoException {
		Collection<Produto> produtosMock = createMock(Collection.class);
		expect(produtosMock.size()).andReturn(7);
		
		replay(produtosMock);		
		
		Integer current = 0;		
		final Integer MAX_RESULTS = 10;
		
		expect(produtoDaoMock.listAllPageCount()).andReturn(7);
		expect(produtoDaoMock.listAll(current, MAX_RESULTS)).andReturn(produtosMock);
		
		replay(produtoDaoMock);
		
		assertEquals(Action.SUCCESS, action.list());
		assertEquals(7, action.getProdutos().size());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}

	@Test
	public final void testPrepare() throws DaoException {
		Collection<TipoProduto> tiposProdutoMock = createMock(Collection.class);
		expect(tiposProdutoMock.size()).andReturn(3);
		
		replay(tiposProdutoMock);
		
		TipoProdutoDao tipoProdutoDaoMock = createMock(TipoProdutoDao.class);
		expect(tipoProdutoDaoMock.listAll()).andReturn(tiposProdutoMock);
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProdutoDao(tipoProdutoDaoMock);
		
		assertEquals(Action.SUCCESS, action.prepare());
		assertEquals(3, action.getTiposProduto().size());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}

	@Test
	public final void testLoad() throws DaoException, ObjetoNaoEncontradoException {
		Collection<TipoProduto> tiposProdutoMock = createMock(Collection.class);
		expect(tiposProdutoMock.size()).andReturn(3);
		
		replay(tiposProdutoMock);
		
		TipoProdutoDao tipoProdutoDaoMock = createMock(TipoProdutoDao.class);
		expect(tipoProdutoDaoMock.listAll()).andReturn(tiposProdutoMock);
		
		replay(tipoProdutoDaoMock);
		
		expect(produtoDaoMock.get(Long.valueOf(1))).andReturn(new Produto(Long.valueOf(1)));
		
		replay(produtoDaoMock);
		
		action.setTipoProdutoDao(tipoProdutoDaoMock);
		
		action.setProduto(new Produto(Long.valueOf(1)));
		
		assertEquals(Action.SUCCESS, action.load());
		assertEquals(new Produto(Long.valueOf(1)), action.getProduto());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());		
	}
	
	@Test
	public final void testLoadObjetoNaoEncontrado() throws DaoException, ObjetoNaoEncontradoException {
		expect(produtoDaoMock.get(Long.valueOf(1))).andThrow(new ObjetoNaoEncontradoException());
		
		replay(produtoDaoMock);
		
		action.setProduto(new Produto(Long.valueOf(1)));
		
		assertEquals(Action.ERROR, action.load());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}

	@Test
	public final void testInsert() throws DaoException {
		expect(produtoDaoMock.save(new Produto())).andReturn(new Produto(Long.valueOf(1)));
		
		replay(produtoDaoMock);
		
		action.setProduto(new Produto());
		
		assertEquals(Action.SUCCESS, action.insert());
		assertEquals(1, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}

	@Test
	public final void testUpdate() throws DaoException, ObjetoNaoEncontradoException {
		produtoDaoMock.update(new Produto(Long.valueOf(1)));
		
		replay(produtoDaoMock);
		
		action.setProduto(new Produto(Long.valueOf(1)));
		
		assertEquals(Action.SUCCESS, action.update());
		assertEquals(1, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public final void testUpdateObjetoNaoEncontrado() throws DaoException, ObjetoNaoEncontradoException {
		produtoDaoMock.update(new Produto(Long.valueOf(1)));
		expectLastCall().andThrow(new ObjetoNaoEncontradoException());
		
		replay(produtoDaoMock);
		
		action.setProduto(new Produto(Long.valueOf(1)));
		
		assertEquals(Action.ERROR, action.update());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}	

	@Test
	public final void testDelete() throws DaoException, ObjetoNaoEncontradoException {
		produtoDaoMock.delete(new Produto(Long.valueOf(1)));
		
		replay(produtoDaoMock);
		
		action.setProduto(new Produto(Long.valueOf(1)));
		
		assertEquals(Action.SUCCESS, action.delete());
		assertEquals(1, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public final void testDeleteObjetoNaoEncontrado() throws DaoException, ObjetoNaoEncontradoException {
		produtoDaoMock.delete(new Produto(Long.valueOf(1)));
		expectLastCall().andThrow(new ObjetoNaoEncontradoException());
		
		replay(produtoDaoMock);
		
		action.setProduto(new Produto(Long.valueOf(1)));
		
		assertEquals(Action.ERROR, action.delete());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}	

}
