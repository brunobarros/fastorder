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

	public HibernateMesaDao(Session session) {
		super(Mesa.class, session);
	}

}
