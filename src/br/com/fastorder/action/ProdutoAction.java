package br.com.fastorder.action;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.ProdutoDao;
import br.com.fastorder.dao.TipoProdutoDao;
import br.com.fastorder.model.Produto;
import br.com.fastorder.model.TipoProduto;

import com.opensymphony.xwork.ActionSupport;

/**
 * Action para manipula��o dos produtos.
 * 
 * @author Bruno
 * @since 06/02/2007
 */
public class ProdutoAction extends ActionSupport {

	private static final long serialVersionUID = 329097279668092591L;

	private Produto produto = new Produto();
	
	private Collection<Produto> produtos;
	
	private Collection<TipoProduto> tiposProduto;

	private ProdutoDao produtoDao;
	
	private TipoProdutoDao tipoProdutoDao;
	
	private Integer currentItem = 0;
	
	private final Integer MAX_RESULTS = 10;
	
	private Map<Integer, Integer> index;
	
	private Integer total;	
	
	private void createIndex() throws DaoException {				
		index = new LinkedHashMap<Integer, Integer>();
		
		int count = 0;
		for (int i = 0; i < total; i += MAX_RESULTS) {
			index.put(++count, i);
		}		
	}
	
	/**
	 * Action que lista todos os produtos.
	 * @return 
	 * @throws DaoException
	 */
	public String list() throws DaoException {
		total = produtoDao.listAllPageCount();
		
		if (currentItem > total) {
			currentItem = 0;
		}
		
		createIndex();
		
		produtos = produtoDao.listAll(currentItem, MAX_RESULTS);		
		return SUCCESS;
	}
	
	public String prepare() throws DaoException {
		tiposProduto = tipoProdutoDao.listAll();
		return SUCCESS;
	}
	
	public String load() throws DaoException {
		try {
			produto = produtoDao.get(produto.getId());
		} catch (ObjetoNaoEncontradoException e) {
			// TODO
			return ERROR;
		}
		
		prepare();
		
		return SUCCESS;
	}
	
	public String insert() throws DaoException {
		produtoDao.save(produto);
		
		addActionMessage("Produto cadastrado com sucesso");
		
		return SUCCESS;
	}
	
	public String update() throws DaoException {
		try {
			produtoDao.update(produto);
		} catch (ObjetoNaoEncontradoException e) {
			// TODO
		}
		
		addActionMessage("Produto atualizado com sucesso");
		
		return SUCCESS;
	}
	
	public String delete() throws DaoException {
		try {
			produtoDao.delete(produto);
		} catch (ObjetoNaoEncontradoException e) {
			// TODO
		}
		
		addActionMessage("Produto exclu�do com sucesso");
		
		return SUCCESS;
	}	

	public Collection<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public Collection<TipoProduto> getTiposProduto() {
		return tiposProduto;
	}

	public void setTipoProdutoDao(TipoProdutoDao tipoProdutoDao) {
		this.tipoProdutoDao = tipoProdutoDao;
	}

	public void setCurrentItem(Integer currentItem) {
		this.currentItem = currentItem;
	}
	
	public Integer getCurrentItem() {
		return currentItem;
	}

	public Map<Integer, Integer> getIndex() {
		return index;
	}
	
}
