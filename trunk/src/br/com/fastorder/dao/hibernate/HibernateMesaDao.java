package br.com.fastorder.dao.hibernate;

import org.hibernate.Session;

import br.com.fastorder.dao.MesaDao;
import br.com.fastorder.model.Mesa;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateMesaDao extends HibernateGenericDao<Mesa, Long> implements MesaDao {

	private static final long serialVersionUID = 8424249316922792058L;

	public HibernateMesaDao(Session session) {
		super(Mesa.class, session);
	}

}
