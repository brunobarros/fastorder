package br.com.fastorder.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKeyManyToMany;
import org.hibernate.validator.NotNull;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 8271122152199211270L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Date data;	
	
	@CollectionOfElements
	@MapKeyManyToMany(joinColumns = @JoinColumn(name="produto_id",unique = false)) 
	@Column(name = "qtd_produtos", nullable = false)	
	private Map<Produto, Integer> produtos = new HashMap<Produto, Integer>();
	
	@Lob
	private String observacoes;
	
	@NotNull
	@ManyToOne	
	private Conta conta;
	
	@NotNull
	@ManyToOne	
	private Usuario usuario;
	
	public Pedido() {
		super();
	}
	
	public Pedido(Long id) {
		this.id = id;
	}
	
	public BigDecimal getValor() {
		BigDecimal valor = BigDecimal.valueOf(0);
		
		for (Produto produto : produtos.keySet()) {
			BigDecimal quantidade = BigDecimal.valueOf(produtos.get(produto));
			
			valor.add(produto.getPreco().multiply(quantidade));
		}
		
		return valor;
	}
	
	public void registrar(Produto produto, Integer quantidade) {
		//TODO 
	}
	
	public void cancelar(Produto produto, Integer quantidade) {
		//TODO		
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

        final Pedido pedido = (Pedido) o;

        if (id != null ? !id.equals(pedido.id) : pedido.id != null) return false;

        return true;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
