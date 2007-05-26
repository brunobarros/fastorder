package br.com.fastorder.facade;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

public class ContaManager {
	
	private ContaDao contaDao;
	
	private MesaDao mesaDao;
	
	@Transactional
	public Conta abrirConta(Mesa mesa) throws ManagerException {
		try {
			mesa = mesaDao.get(mesa.getId());
			
			if (!mesa.hasContaAberta()) {
				Conta conta = new Conta(mesa);
				conta.abrirConta();
				
				return contaDao.save(conta);
			}
			throw new IllegalStateException("Não foi possível abrir a conta, mesa já possui uma conta aberta.");		
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}
	
	@Transactional
	public Collection<Conta> listarContasAbertas() throws ManagerException {
		try {
			return contaDao.listContasAbertas();
		} catch (DaoException e) {
			throw new ManagerException(e);
		}
	}	

	public void setContaDao(ContaDao contaDao) {
		this.contaDao = contaDao;
	}

	public void setMesaDao(MesaDao mesaDao) {
		this.mesaDao = mesaDao;
	}

}
