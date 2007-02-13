package br.com.fastorder.action;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.UsuarioDao;
import br.com.fastorder.model.Usuario;
import br.com.fastorder.util.Md5;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 192628971961441443L;
	
	private Usuario usuario = new Usuario();
	
	private String senha;
	
	private UsuarioDao usuarioDao;
	
	public String login() throws DaoException {
		try {
			usuario = usuarioDao.get(usuario.getLogin());

			if (usuario == null) {
				addActionError("Login inválido");
				return ERROR;
			}//TODO arrumar a exception no dao

		} catch (ObjetoNaoEncontradoException e) {
			addActionError("Login inválido");
			return ERROR;
		}

		if (!usuario.getSenha().equals(senha)) {
			addActionError("Senha inválida");
			return ERROR;
		}

		ActionContext.getContext().getSession().put("usuario", usuario);
		
		return SUCCESS;
	}
	
	public String logoff() {
		ActionContext.getContext().getSession().remove("usuario");
		return SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setSenha(String senha) {
		this.senha = Md5.crypt(senha);
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
