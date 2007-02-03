package br.com.fastorder.dao.hibernate;

import org.hibernate.Session;

import br.com.fastorder.dao.ProdutoDao;
import br.com.fastorder.model.Produto;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateProdutoDao extends HibernateGenericDao<Produto, Long> implements ProdutoDao {

	public HibernateProdutoDao(Session session) {
		super(Produto.class, session);
	}

}
