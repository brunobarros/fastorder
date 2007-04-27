package br.com.fastorder.action;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.model.Mesa;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CreateIfNull;

/**
 * @author Casa
 *
 */
public class MesaAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7624878748802644236L;

	private static final int MAX_RESULTS = 10;
	
	private MesaDao mesaDao;
	
	private int total;
	
	private int currentItem;
	
	private Collection<Mesa> mesas;
	
	private Map<Integer, Integer> index;

	@CreateIfNull(value = true)
	private Mesa mesa;
	
	@Transactional
	public String list() throws DaoException {
		total = mesaDao.listAllPageCount();
		
		if (currentItem > total) {
			currentItem = 0;
		}
		
		mesas = mesaDao.listAll(currentItem, MAX_RESULTS);
		createIndex();
		return Action.SUCCESS;
	}

	private void createIndex() {
		index = new LinkedHashMap<Integer, Integer>();
		
		int count = 0;
		for (int i = 0; i < total; i += MAX_RESULTS) {
			index.put(++count, i);
		}		
	}
	
	@Transactional
	public String delete() throws DaoException {
		try {
			mesaDao.delete(mesa);
			addActionMessage("Mesa excluída com sucesso");
		} catch (Exception e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	@Transactional
	public String update() throws DaoException {
		try {
			mesaDao.update(mesa);
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		addActionMessage("Mesa atualizada com sucesso.");
		return Action.SUCCESS;
	}
	
	@Transactional
	public String insert() throws DaoException {
		mesaDao.save(mesa);
		addActionMessage("Mesa cadastrada com sucesso");
		return Action.SUCCESS;
	}
	
	@Transactional
	public String load() throws DaoException {
		try {
			mesa = mesaDao.get(mesa.getId());
		} catch (ObjetoNaoEncontradoException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
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
