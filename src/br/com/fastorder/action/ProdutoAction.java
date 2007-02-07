package br.com.fastorder.action;

import java.util.Collection;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ProdutoDao;
import br.com.fastorder.model.Produto;

import com.opensymphony.xwork.ActionSupport;

/**
 * Action para manipulação dos produtos.
 * 
 * @author Bruno
 * @since 06/02/2007
 */
public class ProdutoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();
	
	private Collection<Produto> produtos;

	private ProdutoDao produtoDao;
	
	/**
	 * Action que lista todos os produtos.
	 * @return 
	 * @throws DaoException
	 */
	public String list() throws DaoException {
		produtos = produtoDao.listAll();		
		return SUCCESS;
	}
	
	public String insert() throws DaoException {
		produtoDao.save(produto);
		addActionMessage("Produto cadastrado com sucesso");
		return SUCCESS;
	}

	/**
	 * @return
	 */
	public Collection<Produto> getProdutos() {
		return this.produtos;
	}
	
	/**
	 * @param produtoDao the produtoDao to set
	 */
	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	/**
	 * @return
	 */
	public Produto getProduto() {
		return this.produto;
	}
	
	
}
