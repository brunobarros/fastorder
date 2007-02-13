package br.com.fastorder.hibernate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateSessionFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8852110623931290107L;

	/**
	 * Session Factory.
	 */
	private static final SessionFactory sessionFactory;
	
	/**
	 * Session Thread.
	 */
	private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
	
	/**
	 * Transaction Thread.
	 */
	private static ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
	
	/**
	 * Configuration.
	 */
	private static final Configuration cfg;
	
	static {
		cfg = new AnnotationConfiguration();
		cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
	}
	
	/**
	 * 
	 * @return
	 */
	public Session getSession() {
		Session s = (Session) threadSession.get();
	
		try {
			if (s == null) {
				s = sessionFactory.openSession();
				threadSession.set(s);
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		
		return s;
	}

	/**
	 * 
	 *
	 */
	public void closeSession() {
		try {
			Session s = (Session) threadSession.get();
			threadSession.set(null);
			if (s != null && s.isOpen())
				s.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 *
	 */
	public void beginTransaction() {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if (tx == null) {
				tx = getSession().beginTransaction();
				threadTransaction.set(tx);
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 *
	 */
	public void commit() {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if ( tx != null && !tx.wasCommitted()
					&& !tx.wasRolledBack() )
				tx.commit();
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollback();
		}
	}
	
	/**
	 * 
	 *
	 */
	public void rollback() {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			threadTransaction.set(null);
			if ( tx != null && !tx.wasCommitted()
					&& !tx.wasRolledBack() ) {
				tx.rollback();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasTransaction() {
		Transaction tx = (Transaction) threadTransaction.get();		
		return tx != null && tx.isActive();
	}	
	
	/**
	 * 
	 * @return
	 */
	public Configuration getConfiguration() {
		return cfg;
	}

}
