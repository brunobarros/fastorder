package br.com.fastorder.action;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CreateIfNull;

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

	private String id;
	
	@Transactional
	public String list() throws DaoException {
		contas = contaDao.listContasAbertas();
		
		return Action.SUCCESS;
	}
	
	@Transactional
	public String prepare() throws DaoException {
		mesas = mesaDao.listAll();
		return Action.SUCCESS;
	}
	
	@Transactional
	public String insert() throws DaoException {
		conta.abrirConta();
		contaDao.save(conta);
		addActionMessage("Conta para a mesa " + conta.getMesa().getId() + " aberta com sucesso.");
		return Action.SUCCESS;
	}
	
	@Transactional
	public String update() throws DaoException {
		try {
			conta = contaDao.get(Long.valueOf(id));
			if (conta == null) throw new ObjetoNaoEncontradoException("Conta não existe.");  
			
			conta.fecharConta();
			contaDao.update(conta);
			addActionMessage("Conta da mesa " + conta.getMesa().getId() + " fechada com sucesso.");
			return Action.SUCCESS;
		} catch (Exception e) {
			addActionMessage(e.getMessage());
			return Action.ERROR;
		}
	}

	public Collection<Conta> getContas() {
		return contas;
	}

	public void setContaDao(ContaDao contaDAO) {
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

	public String getId() {
		return id;
	}

	public void setId(String contaId) {
		this.id = contaId;
	}
	
}
