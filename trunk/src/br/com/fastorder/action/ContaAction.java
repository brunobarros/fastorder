package br.com.fastorder.action;

import java.util.Collection;
import java.util.Date;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.model.Conta;

import com.opensymphony.xwork.ActionSupport;

/**
 * @author Casa
 *
 */
public class ContaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Collection<Conta> contas;
	
	private ContaDao contaDAO;
	
	public String list() throws DaoException {
		Conta conta = new Conta( (Date)null );		
		contas = contaDAO.findByExample(conta);
		
		return SUCCESS;
	}

	public Collection<Conta> getContas() {
		return contas;
	}

	public void setContaDAO(ContaDao contaDAO) {
		this.contaDAO = contaDAO;
	}

}
