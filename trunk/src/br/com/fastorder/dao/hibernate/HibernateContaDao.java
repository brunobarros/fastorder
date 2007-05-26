package br.com.fastorder.dao.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.fastorder.dao.ContaDao;
import br.com.fastorder.dao.DaoException;
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

	public Collection<Conta> listContasAbertas() throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Conta.class);
			
//			ProjectionList projectionList = Projections.projectionList();
//			
//			projectionList.add(Projections.property("id"));
//			projectionList.add(Projections.property("mesa"));
//			projectionList.add(Projections.property("dataAbertura"));
//			
//			criteria.setProjection(projectionList);
			
			criteria.add(Restrictions.isNull("dataFechamento"));
			
			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

}
