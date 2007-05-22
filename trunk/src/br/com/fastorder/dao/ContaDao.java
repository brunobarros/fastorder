package br.com.fastorder.dao;

import java.util.Collection;

import br.com.fastorder.model.Conta;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public interface ContaDao extends GenericDao<Conta, Long> {
	
	Collection<Conta> listContasAbertas() throws DaoException;
	
}
