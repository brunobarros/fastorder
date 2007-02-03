package br.com.fastorder.dao.hibernate;

import org.hibernate.Session;

import br.com.fastorder.dao.TipoProdutoDao;
import br.com.fastorder.model.TipoProduto;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernateTipoProdutoDao extends HibernateGenericDao<TipoProduto, Long> implements TipoProdutoDao {

	private static final long serialVersionUID = 2583589619302855047L;

	public HibernateTipoProdutoDao(Session session) {
		super(TipoProduto.class, session);
	}

}
