package br.com.fastorder.dao;

import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public interface ContaDao extends GenericDao<Conta, Long> {

	Conta getContaEmAberto(Mesa mesa) throws DaoException;
	
	boolean hasContaEmAberto(Mesa mesa) throws DaoException;
	
}
