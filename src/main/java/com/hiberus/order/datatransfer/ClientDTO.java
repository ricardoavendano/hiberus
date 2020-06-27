package com.hiberus.order.datatransfer;

import java.util.Date;
import java.util.List;

public class ClientDTO {

	private Long clientId;
	private Date dateTime;
	private String direction;
	private Long totalPrice;
	private List<ProductDTO> productDTO;

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

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}

}
