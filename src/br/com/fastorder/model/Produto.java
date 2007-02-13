package br.com.fastorder.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * 
 * 
 * @author Diogo Cabral de Almeida
 *
 */
@Entity
@Table(name="produto")
public class Produto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2102810726486346413L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	private BigDecimal preco;
	
	@ManyToOne
	private TipoProduto tipo;
	
	public Produto() {
		super();
	}
	
	public Produto(Long id) {
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

        final Produto produto = (Produto) o;

        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;

        return true;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}

	public TipoProduto getTipo() {
		return tipo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

}
