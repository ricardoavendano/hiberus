package com.hiberus.order.request.mapping;

import java.util.Date;
import java.util.List;

public class InvoiceRequestMapping {

	private Long clientId;
	private Date dateTime;
	private String direction;
	private List<ProductRequestMapping> productRequestMapping;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<ProductRequestMapping> getProductRequestMapping() {
		return productRequestMapping;
	}

	public void setProductRequestMapping(List<ProductRequestMapping> productRequestMapping) {
		this.productRequestMapping = productRequestMapping;
	}
}
