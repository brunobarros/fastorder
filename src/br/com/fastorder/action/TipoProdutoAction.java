package br.com.fastorder.action;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CreateIfNull;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.TipoProdutoDao;
import br.com.fastorder.model.TipoProduto;

public class TipoProdutoAction extends ActionSupport {

	private static final long serialVersionUID = 204100898395787598L;

	@CreateIfNull(value = true)
	private TipoProduto tipoProduto;
	
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
	
	@Transactional
	public String list() throws DaoException {
		total = tipoProdutoDao.listAllPageCount();
		
		if (currentItem > total) {
			currentItem = 0;
		}
		
		tiposProduto = tipoProdutoDao.listAll(currentItem, MAX_RESULTS);
		createIndex();
		return Action.SUCCESS;
	}
	
	@Transactional
	public String load() throws DaoException {
		try {
			tipoProduto = tipoProdutoDao.get(tipoProduto.getId());
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	@Transactional
	public String insert() throws DaoException {
		tipoProduto = tipoProdutoDao.save(tipoProduto);
		addActionMessage("Tipo de produto cadastrado com sucesso");
		return Action.SUCCESS;
	}
	
	@Transactional
	public String update() throws DaoException {
		try {			
			tipoProdutoDao.update(tipoProduto);
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		addActionMessage("Tipo de produto atualizado com sucesso");
		return Action.SUCCESS;
	}
	
	@Transactional
	public String delete() throws DaoException {
		try {
			tipoProdutoDao.delete(tipoProduto);
			addActionMessage("Tipo de produto excluído com sucesso");
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
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

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}
