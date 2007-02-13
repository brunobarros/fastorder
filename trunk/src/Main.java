import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.UsuarioDao;
import br.com.fastorder.dao.hibernate.HibernateUsuarioDao;
import br.com.fastorder.hibernate.HibernateSessionFactory;
import br.com.fastorder.model.Administrador;
import br.com.fastorder.model.Usuario;
import br.com.fastorder.util.Md5;


public class Main {

	public static void main(String[] args) {
		HibernateSessionFactory session = new HibernateSessionFactory();
		UsuarioDao dao = new HibernateUsuarioDao(session.getSession());
		session.beginTransaction();
		
		Usuario admin = new Administrador();
		admin.setLogin("admin");
		admin.setSenha(Md5.crypt("admin"));
		admin.setNome("Administrador");		
		
		try {
			dao.save(admin);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		session.commit();
		session.closeSession();
	}
}
