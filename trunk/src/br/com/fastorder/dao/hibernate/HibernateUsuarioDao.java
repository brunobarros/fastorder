package br.com.fastorder.dao.hibernate;

import org.hibernate.SessionFactory;

import br.com.fastorder.dao.UsuarioDao;
import br.com.fastorder.model.Usuario;

public class HibernateUsuarioDao extends HibernateGenericDao<Usuario, String> implements UsuarioDao {

	private static final long serialVersionUID = -2882669096651249443L;
	
	public HibernateUsuarioDao(SessionFactory sessionFactory) {
		super(Usuario.class, sessionFactory);
	}	

}
