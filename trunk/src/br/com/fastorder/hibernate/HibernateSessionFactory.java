package br.com.fastorder.hibernate;

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
public class HibernateSessionFactory {

	/**
	 * Session Factory.
	 */
	private final SessionFactory sessionFactory;
	
	/**
	 * Session Thread.
	 */
	private final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
	
	/**
	 * Transaction Thread.
	 */
	private final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
	
	/**
	 * Configuration.
	 */
	private final Configuration cfg;
	
	/**
	 * 
	 *
	 */
	public HibernateSessionFactory() {
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
