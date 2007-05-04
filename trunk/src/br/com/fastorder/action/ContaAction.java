package br.com.fastorder.action;

import java.util.Collection;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CreateIfNull;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

/**
 * @author Casa
 *
 */
public class ContaAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3444352126525396355L;

	private Collection<Conta> contas;
	
	private ContaDao contaDao;

	private Collection<Mesa> mesas;

	private MesaDao mesaDao;

	@CreateIfNull(value = true)
	private Conta conta;
	
	@Transactional
	public String list() throws DaoException {
		Conta conta = new Conta((Date) null);		
		contas = contaDao.findByExample(conta);
		
		return Action.SUCCESS;
	}
	
	@Transactional
	public String prepare() throws DaoException {
		mesas = mesaDao.listAll();
		return Action.SUCCESS;
	}
	
	@Transactional
	public String insert() throws DaoException {
		conta = new Conta(conta, new Date());
		contaDao.save(conta);
		addActionMessage("Conta para a mesa " + conta.getMesa().getId() + " aberta com sucesso.");
		return Action.SUCCESS;
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
