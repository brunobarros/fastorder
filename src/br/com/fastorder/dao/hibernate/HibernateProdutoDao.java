package br.com.fastorder.dao.hibernate;

import org.hibernate.SessionFactory;

import br.com.fastorder.dao.ProdutoDao;
import br.com.fastorder.model.Produto;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateProdutoDao extends HibernateGenericDao<Produto, Long> implements ProdutoDao {

	private static final long serialVersionUID = 5208691621404868354L;

	public HibernateProdutoDao(SessionFactory sessionFactory) {
		super(Produto.class, sessionFactory);
	}

}
