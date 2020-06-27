package com.hiberus.order.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 6138844321740796069L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(nullable = false, name = "idincrement")
	private Long idIncrement;
	
	@Column(nullable = false, name = "id")
	private Long id;
	
	@Column(nullable = false, name = "quantity")
	private Long quantity;
	
	@Column(nullable = false, name = "cost")
	private Long cost;
	
	@JoinColumn(name = "CLIENTIDPK", referencedColumnName = "CLIENTID")
	@ManyToOne
	private Client clientIdPK;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Client getClientIdPK() {
		return clientIdPK;
	}

	public void setClientIdPK(Client clientIdPK) {
		this.clientIdPK = clientIdPK;
	}
	
	public Long getIdIncrement() {
		return idIncrement;
	}

	public void setIdIncrement(Long idIncrement) {
		this.idIncrement = idIncrement;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idIncrement != null ? idIncrement.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Product)) {
			return false;
		}
		Product other = (Product) object;
		if ((this.idIncrement == null && other.idIncrement != null)
				|| (this.idIncrement != null && !this.idIncrement.equals(other.idIncrement))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Product[ idIncrement=" + idIncrement + " ]";
	}
	

}
