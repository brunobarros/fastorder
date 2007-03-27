package br.com.fastorder.action;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.model.Mesa;

import com.opensymphony.xwork.ActionSupport;

/**
 * @author Casa
 *
 */
public class MesaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private static final int MAX_RESULTS = 10;
	
	private MesaDao mesaDao;
	
	private int total;
	
	private int currentItem;
	
	private Collection<Mesa> mesas;
	
	private Map<Integer, Integer> index;

	private Mesa mesa;
	
	public String list() throws DaoException {
		total = mesaDao.listAllPageCount();
		
		if (currentItem > total) {
			currentItem = 0;
		}
		
		mesas = mesaDao.listAll(currentItem, MAX_RESULTS);
		createIndex();
		return SUCCESS;
	}

	private void createIndex() {
		index = new LinkedHashMap<Integer, Integer>();
		
		int count = 0;
		for (int i = 0; i < total; i += MAX_RESULTS) {
			index.put(++count, i);
		}		
	}
	
	public String delete() throws DaoException {
		try {
			mesaDao.delete(mesa);
			addActionMessage("Mesa excluída com sucesso");
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String update() throws DaoException {
		try {
			mesaDao.update(mesa);
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		addActionMessage("Mesa atualizada com sucesso.");
		return SUCCESS;
	}
	
	public String insert() throws DaoException {
		mesaDao.save(mesa);
		addActionMessage("Mesa cadastrada com sucesso");
		return SUCCESS;
	}
	
	public String load() throws DaoException {
		try {
			mesa = mesaDao.get(mesa.getId());
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}

	public int getCurrentItem() {
		return currentItem;
	}
	
	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}

	public Map<Integer, Integer> getIndex() {
		return index;
	}

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public int getTotal() {
		return total;
	}

	public void setMesaDao(MesaDao mesaDao) {
		this.mesaDao = mesaDao;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
