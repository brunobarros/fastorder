package br.com.fastorder.dao.hibernate;

import org.hibernate.SessionFactory;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.model.Conta;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateContaDao extends HibernateGenericDao<Conta, Long> implements ContaDao {

	private static final long serialVersionUID = 5043717230839340682L;

	public HibernateContaDao(SessionFactory sessionFactory) {
		super(Conta.class, sessionFactory);
	}

}
