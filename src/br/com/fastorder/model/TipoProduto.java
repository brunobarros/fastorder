package br.com.fastorder.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
@Entity
@Table(name="tipo_produto")
public class TipoProduto implements Serializable {
	
	private static final long serialVersionUID = -2319575271713947181L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
	private Set<Produto> produtos = new HashSet<Produto>();
	
	public TipoProduto() {
		super();
	}
	
	public TipoProduto(Long id) {
		super();
		this.id = id;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		 return (id != null ? id.hashCode() : 0);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final TipoProduto tipoProduto = (TipoProduto) o;

        if (id != null ? !id.equals(tipoProduto.id) : tipoProduto.id != null) return false;

        return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{TipoProduto id=[%s] descricao=[%s]}", id, descricao);
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the produtos
	 */
	public Set<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
