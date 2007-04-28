package br.com.fastorder.action;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.TipoProdutoDao;
import br.com.fastorder.model.TipoProduto;

import com.opensymphony.xwork2.Action;

public class TipoProdutoActionTest {
	
	private TipoProdutoAction action;
	
	private TipoProdutoDao tipoProdutoDaoMock;

	@Before
	public void setUp() throws Exception {
		tipoProdutoDaoMock = createMock(TipoProdutoDao.class);
		
		action = new TipoProdutoAction();
		action.setTipoProdutoDao(tipoProdutoDaoMock);
	}

	@Test
	public final void testList() throws DaoException {
		Collection<TipoProduto> tiposProdutoMock = createMock(Collection.class);
		expect(tiposProdutoMock.size()).andReturn(12);
		
		replay(tiposProdutoMock);
		
		Integer currentItem = 0;		
		final Integer MAX_RESULTS = 10;	
		
		expect(tipoProdutoDaoMock.listAllPageCount()).andReturn(12);
		expect(tipoProdutoDaoMock.listAll(currentItem, MAX_RESULTS)).andReturn(tiposProdutoMock);
		
		replay(tipoProdutoDaoMock);
		
		assertEquals(Action.SUCCESS, action.list());
		assertEquals(2, action.getIndex().size()); //Duas páginas para MAX_RESULTS = 10
		assertEquals(12, action.getTiposProduto().size());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}

	@Test
	public final void testLoad() throws DaoException, ObjetoNaoEncontradoException {
		expect(tipoProdutoDaoMock.get(Long.valueOf(1))).andReturn(createMock(TipoProduto.class));
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto(Long.valueOf(1)));
		
		assertEquals(Action.SUCCESS, action.load());
		assertNotNull(action.getTipoProduto());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public final void testLoadObjetoNaoEncontrado() throws DaoException, ObjetoNaoEncontradoException {
		expect(tipoProdutoDaoMock.get(Long.valueOf(1))).andThrow(new ObjetoNaoEncontradoException());
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto(Long.valueOf(1)));
		
		assertEquals(Action.ERROR, action.load());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}	

	@Test
	public final void testInsert() throws DaoException {
		expect(tipoProdutoDaoMock.save(new TipoProduto())).andReturn(new TipoProduto(Long.valueOf(1)));
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto());
		
		assertEquals(Action.SUCCESS, action.insert());
		assertEquals(new TipoProduto(Long.valueOf(1)), action.getTipoProduto());
		assertEquals(1, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}

	@Test
	public final void testUpdate() throws DaoException, ObjetoNaoEncontradoException {
		tipoProdutoDaoMock.update(new TipoProduto(Long.valueOf(1)));
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto(Long.valueOf(1)));
		
		assertEquals(Action.SUCCESS, action.update());
		assertEquals(1, action.getActionMessages().size());		
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public final void testUpdateObjetoNaoEncontrado() throws DaoException, ObjetoNaoEncontradoException {
		tipoProdutoDaoMock.update(new TipoProduto(Long.valueOf(1)));
		expectLastCall().andThrow(new ObjetoNaoEncontradoException());
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto(Long.valueOf(1)));
		
		assertEquals(Action.ERROR, action.update());
		assertEquals(0, action.getActionMessages().size());		
		assertEquals(1, action.getActionErrors().size());
	}	

	@Test
	public final void testDelete() throws DaoException, ObjetoNaoEncontradoException {
		tipoProdutoDaoMock.delete(new TipoProduto(Long.valueOf(1)));
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto(Long.valueOf(1)));
		
		assertEquals(Action.SUCCESS, action.delete());
		assertEquals(1, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public final void testDeleteObjetoNaoEncontrado() throws DaoException, ObjetoNaoEncontradoException {
		tipoProdutoDaoMock.delete(new TipoProduto(Long.valueOf(1)));
		expectLastCall().andThrow(new ObjetoNaoEncontradoException());
		
		replay(tipoProdutoDaoMock);
		
		action.setTipoProduto(new TipoProduto(Long.valueOf(1)));
		
		assertEquals(Action.ERROR, action.delete());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(1, action.getActionErrors().size());
	}

}
