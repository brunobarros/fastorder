package br.com.fastorder.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.GenericDao;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public abstract class HibernateGenericDao<PersistentObject, PK extends Serializable>
		implements GenericDao<PersistentObject, PK> {

	protected Session session;

	protected Class objectClass;

	public HibernateGenericDao(Class objectClass, Session session) {
		this.objectClass = objectClass;
		this.session = session;
	}

	public PersistentObject get(PK id) throws DaoException {
		try {
			return (PersistentObject) session.get(objectClass, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public PersistentObject save(PersistentObject object) throws DaoException {
		try {
			session.save(object);
			session.flush();

			return object;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public void update(PersistentObject object) throws DaoException {
		try {
			session.update(object);
			session.flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public void delete(PersistentObject object) throws DaoException {
		try {
			session.delete(object);
			session.flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public int findByExamplePageCount(PersistentObject object)
			throws DaoException {
		return findByExample(object).size();

	}

	public int listAllPageCount() throws DaoException {
		return listAll().size();
	}

	public Collection<PersistentObject> findByExample(PersistentObject object)
			throws DaoException {
		try {
			Criteria criteria = session.createCriteria(objectClass);

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
			Criteria criteria = session.createCriteria(objectClass);

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
			Criteria criteria = session.createCriteria(objectClass);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	public Collection<PersistentObject> listAll(int firstResult, int maxResults)
			throws DaoException {
		try {
			Criteria criteria = session.createCriteria(objectClass);

			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

}
