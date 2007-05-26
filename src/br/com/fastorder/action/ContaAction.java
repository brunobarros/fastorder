package br.com.fastorder.action;

import java.util.Collection;

import br.com.fastorder.facade.ContaManager;
import br.com.fastorder.facade.ManagerException;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

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

	private Collection<Mesa> mesas;

	@CreateIfNull(value = true)
	private Conta conta;
	
	@CreateIfNull(value = true)
	private Mesa mesa;
	
	private ContaManager contaManager;

	public String insert() {
		try {
			conta = contaManager.abrirConta(mesa);
			
			addActionMessage(String.format("Conta para a mesa %s aberta com sucesso.", conta.getMesa().getId()));
		} catch (ManagerException e) {
			addActionError("Não foi possível abrir a conta, mesa já possui uma conta aberta.");
			
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String list() {
		try {
			contas = contaManager.listarContasAbertas();			
		} catch (ManagerException e) {
			addActionError(e.getMessage());
			
			return ERROR;
		}
		
		return SUCCESS;
	}

	public Collection<Conta> getContas() {
		return contas;
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

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public void setContaManager(ContaManager contaManager) {
		this.contaManager = contaManager;
	}
	
}
