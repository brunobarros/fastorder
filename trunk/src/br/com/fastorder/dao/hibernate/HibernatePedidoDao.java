package br.com.fastorder.dao.hibernate;

import org.hibernate.Session;

import br.com.fastorder.dao.PedidoDao;
import br.com.fastorder.model.Pedido;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class HibernatePedidoDao extends HibernateGenericDao<Pedido, Long> implements PedidoDao {

	public HibernatePedidoDao(Session session) {
		super(Pedido.class, session);
	}

}
