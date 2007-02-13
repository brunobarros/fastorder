package br.com.fastorder.action;

import java.util.Collection;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.TipoProdutoDao;
import br.com.fastorder.model.TipoProduto;

import com.opensymphony.xwork.ActionSupport;

public class TipoProdutoAction extends ActionSupport {

	private static final long serialVersionUID = 204100898395787598L;

	private TipoProduto tipoProduto = new TipoProduto();
	
	private Collection<TipoProduto> tiposProduto;
	
	private TipoProdutoDao tipoProdutoDao;
	
	public String list() throws DaoException {
		tiposProduto = tipoProdutoDao.listAll();
		return SUCCESS;
	}
	
	public String load() throws DaoException {
		try {
			tipoProduto = tipoProdutoDao.get(tipoProduto.getId());
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}
	
	public String insert() throws DaoException {
		tipoProdutoDao.save(tipoProduto);
		addActionMessage("Tipo de produto cadastrado com sucesso");
		return SUCCESS;
	}
	
	public String update() throws DaoException {
		try {			
			tipoProdutoDao.update(tipoProduto);
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		addActionMessage("Tipo de produto atualizado com sucesso");
		return SUCCESS;
	}
	
	public String delete() throws DaoException {
		try {
			tipoProdutoDao.delete(tipoProduto);
			addActionMessage("Tipo de produto excluído com sucesso");
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}	

	/**
	 * @return the tipoProduto
	 */
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	/**
	 * @return the tiposProduto
	 */
	public Collection<TipoProduto> getTiposProduto() {
		return tiposProduto;
	}

	/**
	 * @param tipoProdutoDao the tipoProdutoDao to set
	 */
	public void setTipoProdutoDao(TipoProdutoDao tipoProdutoDao) {
		this.tipoProdutoDao = tipoProdutoDao;
	}

}
