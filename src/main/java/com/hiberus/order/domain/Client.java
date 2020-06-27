package com.hiberus.order.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable{

	private static final long serialVersionUID = -6719486215167820280L;

	@Id
	@Column(nullable = false, name = "clientid")
	private Long clientId;
	
	@Column(nullable = false, name = "datatime")
	private Date dataTime;
	
	@Column(nullable = false, name = "direction")
	private String direction;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Product> productList;
	
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (clientId != null ? clientId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Client)) {
			return false;
		}
		Client other = (Client) object;
		if ((this.clientId == null && other.clientId != null)
				|| (this.clientId != null && !this.clientId.equals(other.clientId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Client[ clientId=" + clientId + " ]";
	}
}
