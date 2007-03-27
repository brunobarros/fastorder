package br.com.fastorder.action;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

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
	
	public String list() throws DaoException {
		total = tipoProdutoDao.listAllPageCount();
		
		if (currentItem > total) {
			currentItem = 0;
		}
		
		tiposProduto = tipoProdutoDao.listAll(currentItem, MAX_RESULTS);
		createIndex();
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
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}	

	public TipoProduto getTipoProduto() {
		return tipoProduto;
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
