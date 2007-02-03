package br.com.fastorder.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
@Entity
@Table(name="conta")
public class Conta implements Serializable {
	
	private static final long serialVersionUID = 8685538507663921321L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
	@NotNull
	@ManyToOne
	private Mesa mesa;
	
	@NotNull
	private Date dataAbertura;
	
	private Date dataFechamento;
	
	public Conta() {
		super();
	}
	
	public Conta(Long id) {
		super();
		this.id = id;
	}	
	
	public Conta(Mesa mesa) {
		super();
		this.mesa = mesa;
	}	
	
	public boolean registrarPedido(Pedido pedido) {
		if (wasAberta()) {
			if (!isFechada()) {
				pedido.setData(new Date());
				pedido.setConta(this);
	
				return pedidos.add(pedido);
			}
			
			throw new IllegalStateException("Pedido não foi registrado. A conta já foi fechada.");
		}
		throw new IllegalStateException("Pedido não foi registrado. A conta ainda não foi aberta.");
	}
	
	public boolean cancelarPedido(Pedido pedido) {
		if (wasAberta()) {
			if (!isFechada()) {
				return pedidos.remove(pedido);
			}
			
			throw new IllegalStateException("Pedido não foi cancelado. A conta já foi fechada.");
		}
		
		throw new IllegalStateException("Pedido não foi cancelado. A conta ainda não foi aberta.");		
	}
	
	public BigDecimal getValor() {
		BigDecimal valor = BigDecimal.valueOf(0);
		
		for (Pedido pedido : this.pedidos) {
			valor.add(pedido.getValor());
		}
		
		return valor;
	}
	
	public void abrirConta() {
		if (!wasAberta()) {
			this.dataAbertura = new Date();
		} else {
			throw new IllegalStateException("A conta já está aberta");
		}
	}
	
	public void fecharConta() {
		if (wasAberta()) {
			if (!isFechada()) {
				this.dataFechamento = new Date();
			} else {
				throw new IllegalStateException("A conta já está fechada");
			}
		} else {
			throw new IllegalStateException("A conta não foi aberta");
		}
	}
	
	public void reabrirConta() {
		if (isFechada() && wasAberta()) {
			this.dataFechamento = null;
		}		
	}
	
	public boolean isFechada() {
		return (dataFechamento != null);
	}
	
	public boolean wasAberta() {
		return (dataAbertura != null);
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

        final Conta conta = (Conta) o;

        if (id != null ? !id.equals(conta.id) : conta.id != null) return false;

        return true;
	}

}
