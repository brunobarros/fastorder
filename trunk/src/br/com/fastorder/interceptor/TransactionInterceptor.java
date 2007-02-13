package br.com.fastorder.interceptor;

import br.com.fastorder.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.interceptor.Interceptor;

public class TransactionInterceptor implements Interceptor {

	private static final long serialVersionUID = -8055083829915272761L;
	
	private HibernateSessionFactory sessionFactory;
	
	public void setSessionFactory(HibernateSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String result = ActionSupport.ERROR;
				
		try {
			sessionFactory.beginTransaction();
			result = actionInvocation.invoke();
			sessionFactory.commit();
		} catch (Exception e) {
			if (sessionFactory.hasTransaction()) {
				sessionFactory.rollback();
			}
			throw e;
		} finally {
			sessionFactory.closeSession();
		}
		
		return result;
	}

}
