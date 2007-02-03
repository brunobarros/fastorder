package br.com.fastorder.dao.hibernate;

import org.hibernate.Session;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
import br.com.fastorder.model.Conta;
import br.com.fastorder.model.Mesa;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateContaDao extends HibernateGenericDao<Conta, Long> implements ContaDao {

	public HibernateContaDao(Session session) {
		super(Conta.class, session);
	}

	public Conta getContaEmAberto(Mesa mesa) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasContaEmAberto(Mesa mesa) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
