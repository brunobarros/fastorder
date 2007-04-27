package br.com.fastorder.action;

import org.springframework.transaction.annotation.Transactional;

import br.com.fastorder.dao.DaoException;
import br.com.fastorder.dao.ObjetoNaoEncontradoException;
import br.com.fastorder.dao.UsuarioDao;
import br.com.fastorder.model.Usuario;
import br.com.fastorder.util.Md5;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CreateIfNull;

public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 192628971961441443L;
	
	private static final String REDIRECT = "redirect";
	
	@CreateIfNull(value = true)
	private Usuario usuario;
	
	private String senha;
	
	private String namespace;
	
	private String uri;
	
	private UsuarioDao usuarioDao;
	
	@Transactional
	public String login() throws DaoException {
		try {
			usuario = usuarioDao.get(usuario.getLogin());
		} catch (ObjetoNaoEncontradoException e) {
			addActionError("Login inválido");
			return Action.ERROR;
		}

		if (!usuario.getSenha().equals(senha)) {
			addActionError("Senha inválida");
			return Action.ERROR;
		}

		ActionContext.getContext().getSession().put("usuario", usuario);
		
		if (ActionContext.getContext().getSession().get("namespace") != null) {
			namespace = (String) ActionContext.getContext().getSession().get("namespace");
			uri = (String) ActionContext.getContext().getSession().get("uri");
			
			ActionContext.getContext().getSession().remove("namespace");
			ActionContext.getContext().getSession().remove("uri");
			
			return REDIRECT;
		}
		
		return Action.SUCCESS;
	}
	
	public String logoff() {
		ActionContext.getContext().getSession().remove("usuario");
		return Action.SUCCESS;
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

	public String getNamespace() {
		return namespace;
	}

	public String getUri() {
		return uri;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
