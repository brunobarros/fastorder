package br.com.fastorder.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7208556731515749523L;

	@Id
	private String login;
	
	private String senha;
	
	private String nome;

	public Usuario() {
		super();
	}
	
	public Usuario(String login) {
		super();
		this.login = login;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	    return (login != null ? login.hashCode() : 0);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Usuario usuario = (Usuario) o;

        if (login != null ? !login.equals(usuario.login) : usuario.login != null) return false;

        return true;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
