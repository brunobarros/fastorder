package br.com.fastorder.action;

import java.util.Collection;
import java.util.Date;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

import com.opensymphony.xwork.ActionSupport;

/**
 * @author Casa
 *
 */
public class ContaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Collection<Conta> contas;
	
	private ContaDao contaDao;

	private Collection<Mesa> mesas;

	private MesaDao mesaDao;

	private Conta conta;
	
	public String list() throws DaoException {
		Conta conta = new Conta( (Date)null );		
		contas = contaDao.findByExample(conta);
		
		return SUCCESS;
	}
	
	public String prepare() throws DaoException {
		mesas = mesaDao.listAll();
		return SUCCESS;
	}
	
	public String insert() throws DaoException {
		conta = new Conta(conta, new Date());
		contaDao.save(conta);
		addActionMessage("Conta para a mesa " + conta.getMesa().getId() + " aberta com sucesso.");
		return SUCCESS;
	}

	public Collection<Conta> getContas() {
		return contas;
	}

	public void setContaDAO(ContaDao contaDAO) {
		this.contaDao = contaDAO;
	}

	public void setMesaDao(MesaDao mesaDao) {
		this.mesaDao = mesaDao;
	}

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
