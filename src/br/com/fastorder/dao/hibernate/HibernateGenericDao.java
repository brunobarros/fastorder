package br.com.fastorder.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.GenericDao;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public abstract class HibernateGenericDao<PersistentObject, PK extends Serializable>
		implements GenericDao<PersistentObject, PK>, Serializable {

	protected SessionFactory sessionFactory;

	protected Class objectClass;

	public HibernateGenericDao(Class objectClass, SessionFactory sessionFactory) {
		this.objectClass = objectClass;
		this.sessionFactory = sessionFactory;
	}

	public PersistentObject get(PK id) throws DaoException, ObjetoNaoEncontradoException {
		try {
			 PersistentObject persistentObject = (PersistentObject) sessionFactory.getCurrentSession().get(objectClass, id);
			 
			 if (persistentObject == null) {
				 throw new ObjetoNaoEncontradoException();
			 }
			 
			 return persistentObject;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public PersistentObject save(PersistentObject object) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(object);
			sessionFactory.getCurrentSession().flush();
			
			return object;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public void update(PersistentObject object) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(object);

		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public void delete(PersistentObject object) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(object);
			sessionFactory.getCurrentSession().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public int findByExamplePageCount(PersistentObject object) throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectClass);

			Example sample = Example.create(object);
			sample.enableLike();
			sample.excludeZeroes();

			criteria.add(sample);
			
			criteria.setProjection(Projections.rowCount());

			return (Integer) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public int listAllPageCount() throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectClass);
			
			criteria.setProjection(Projections.rowCount());
			
			return (Integer) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}		
	}

	public Collection<PersistentObject> findByExample(PersistentObject object)
			throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectClass);

			Example sample = Example.create(object);
			sample.enableLike();
			sample.excludeZeroes();

			criteria.add(sample);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public Collection<PersistentObject> findByExample(PersistentObject object,
			int firstResult, int maxResults) throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectClass);

			Example sample = Example.create(object);
			sample.enableLike();
			sample.excludeZeroes();

			criteria.add(sample);

			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public Collection<PersistentObject> listAll() throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectClass);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public Collection<PersistentObject> listAll(int firstResult, int maxResults)
			throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectClass);

			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

}
