package br.com.fastorder.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
@Entity
@Table(name="mesa")
public class Mesa implements Serializable {

	private static final long serialVersionUID = 5740773344204107444L;

	@Id	
	private Long id;
	
	@OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL)
	private Set<Conta> contas = new HashSet<Conta>();
	
	public Mesa() {
		super();
	}
	
	public Mesa(Long id) {
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

        final Mesa mesa = (Mesa) o;

        if (id != null ? !id.equals(mesa.id) : mesa.id != null) return false;

        return true;
	}

}
